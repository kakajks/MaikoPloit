package me.maiko.modules.player.bad;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import me.maiko.main.Main;
import me.maiko.module.Module;

public class Kill_Mod extends Module{
	
	public Kill_Mod() {
		super("kill");
	}
	@Override
	public void onCommand(String[] args, Player p) {
		if (args.length == 2) {
			final Player t = Bukkit.getPlayer(args[1]);
			if (t.isOnline()) {

				t.setHealth(0.0D);
				p.sendMessage(Main.Prefix + "Dieser Spieler wurde getötet!");

			} else {
				p.sendMessage(Main.Prefix + "Dieser Spieler ist nicht Online!");

			}

		} else {
			p.sendMessage(Main.Prefix + "Nutze _kill <Player>");

		}
	
	}

}
