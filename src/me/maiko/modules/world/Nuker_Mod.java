package me.maiko.modules.world;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import me.maiko.main.Main;
import me.maiko.module.Module;

public class Nuker_Mod extends Module{
	public static ArrayList<Player>Nuker = new ArrayList<>();

	public Nuker_Mod() {
		super("Nuker");
	}
	@Override
	public void onCommand(String[] args, Player p) {
		if (args.length == 2) {
			Player t = Bukkit.getPlayer(args[1]);
			if (!Nuker.contains(t)) {
				Nuker.add(t);

				p.sendMessage(Main.Prefix + "Du hast Nuker bei diesem Spieler aktiviert!");
			} else {
				Nuker.remove(t);
				p.sendMessage(Main.Prefix + "Du hast Nuker bei diesem Spieler deaktiviert!");

			}

		} else {
			p.sendMessage(Main.Prefix + "Nutze _nuker <Player>");

		}
}
}
