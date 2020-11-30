package me.maiko.modules.player.good;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import me.maiko.main.Main;
import me.maiko.module.Module;

public class Heal_Mod extends Module{
	
	public Heal_Mod() {
		super("heal");
	}
	@Override
	public void onCommand(String[] args, Player p) {

		if (args.length == 2) {
			Player t = Bukkit.getPlayer(args[1]);
			if (t.isOnline()) {
				t.setHealth(20.0D);
				t.setFoodLevel(20);
				p.sendMessage(Main.Prefix + "Du hast diesen Spieler geheilt!");

			} else {
				p.sendMessage(Main.Prefix + "Dieser Spieler ist nicht Online!");

			}

		} else {
			p.sendMessage(Main.Prefix + "Nutze _heal <Player>");

		}
	}
}
