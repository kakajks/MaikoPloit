package me.maiko.modules.player.good;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import me.maiko.main.Main;
import me.maiko.module.Module;

public class Fly_Mod extends Module{
	
	public Fly_Mod() {
		super("Fly");
	}
	
	@Override
	public void onCommand(String[] args, Player p) {
		if (args.length == 2) {
			Player t = Bukkit.getPlayer(args[1]);

			if (t.isOnline()) {
				if (t.getAllowFlight()) {
					if (t.isFlying()) {
						t.setFlying(false);
					}
					t.setAllowFlight(false);
					p.sendMessage(Main.Prefix + "Dieser Spieler kann nun nichtmehr fliegen!");
				} else {

					t.setAllowFlight(true);
					if (!t.isFlying()) {
						t.setFlying(true);
					}
					p.sendMessage(Main.Prefix + "Dieser Spieler kann nun fliegen!");
				}
			} else {

				p.sendMessage(Main.Prefix + "Dieser Spieler ist nicht Online!");
			}

		} else {
			p.sendMessage(Main.Prefix + "Nutze _fly <Player>");
		}
	
	}
}
