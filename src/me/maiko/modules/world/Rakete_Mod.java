package me.maiko.modules.world;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import me.maiko.main.Main;
import me.maiko.module.Module;

public class Rakete_Mod extends Module {
	public static ArrayList<Player>raktete = new ArrayList<>();

	public Rakete_Mod() {
		super("Rakete");
	}

	@Override
	public void onCommand(String[] args, Player p) {
		if (args.length == 2) {
			Player t = Bukkit.getPlayer(args[1]);
			if (t.isOnline()) {
				if (raktete.contains(t)) {
					raktete.remove(t);
					p.sendMessage(Main.Prefix + "Du hast die Rakete für diesen Spieler beendet!");

				} else {
					raktete.add(t);
					p.sendMessage(Main.Prefix + "Du hast die Rakete für diesen Spieler gestartet!");

				}

			} else {
				p.sendMessage(Main.Prefix + "Dieser Spieler ist nicht Online!");

			}

		} else {
			p.sendMessage(Main.Prefix + "Nutze _rakete <Player>");

		}

	}
}
