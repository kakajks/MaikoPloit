package me.maiko.modules.player.good;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

import me.maiko.main.Main;
import me.maiko.module.Module;

public class Gm_Mod extends Module{

	
	public Gm_Mod() {
		super("Gm");
	}

	@Override
	public void onCommand(String[] args, Player p) {
		if (args.length == 3) {
			Player t = Bukkit.getPlayer(args[1]);
			int c = Integer.parseInt(args[2]);
			if (t.isOnline()) {

				if (c == 1) {
					t.setGameMode(GameMode.CREATIVE);

					p.sendMessage(Main.Prefix
							+ "Du hast den Spielmodus dieses Spielers auf Kreativ geäandert!");
				} else if (c == 0) {
					t.setGameMode(GameMode.SURVIVAL);
					p.sendMessage(Main.Prefix
							+ "Du hast den Spielmodus dieses Spielers auf Überleben geäandert!");

				} else if (c == 2) {

					t.setGameMode(GameMode.ADVENTURE);
					p.sendMessage(Main.Prefix
							+ "Du hast den Spielmodus dieses Spielers auf Abenteuer geäandert!");
				} else if (c == 3) {
					t.setGameMode(GameMode.SPECTATOR);
					p.sendMessage(Main.Prefix
							+ "Du hast den Spielmodus dieses Spielers auf Zuschauer geäandert!");
				} else {

				}

			} else {
				p.sendMessage(Main.Prefix + "Dieser Spieler ist nicht Online!");

			}

		} else {
			p.sendMessage(Main.Prefix + "Nutze _gm <Player> <0-3>");

		}
	}
}
