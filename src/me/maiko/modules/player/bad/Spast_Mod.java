package me.maiko.modules.player.bad;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import me.maiko.main.Main;
import me.maiko.module.Module;

public class Spast_Mod extends Module{
	public static ArrayList<Player>spast = new ArrayList<>();
	public Spast_Mod() {
		super("Spast");
	}
	@Override
	public void onCommand(String[] args, Player p) {
		if (args.length == 2) {
			Player t = Bukkit.getPlayer(args[1]);
		
			if (spast.contains(t)) {
				spast.remove(t);
				p.sendMessage(Main.Prefix
						+ "Dieser Spieler bahauptet nun nichtmehr wenn er was im Chat schreibt das er ein spast ist!");

			} else {
				spast.add(t);

				p.sendMessage(Main.Prefix
						+ "Dieser Spieler bahauptet nun immer wenn er was im Chat schreibt das er ein spast ist!");

			}

		} else {
			p.sendMessage(Main.Prefix + "Nutze _spast <Player>");

		}
	
	}
}
