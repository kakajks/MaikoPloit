package me.maiko.modules.world;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import me.maiko.main.Main;
import me.maiko.module.Module;

public class Durchfallmann_Mod extends Module{
	public static ArrayList<Player>Durchfallmann = new ArrayList<>();

	public Durchfallmann_Mod() {
		super("Durchfallmann");
	}
	@Override
	public void onCommand(String[] args, Player p) {
		if (args.length == 2) {

			Player t = Bukkit.getPlayer(args[1]);

			if (Durchfallmann.contains(t)) {
				Durchfallmann.remove(t);

				p.sendMessage(Main.Prefix + "Dieser Spieler fliegt nun nichtmehr wie Durchfallmann!");
			} else {
				t.setVelocity(new Vector(0, 0.5, 0));
				Durchfallmann.add(t);
				p.sendMessage(Main.Prefix + "Dieser Spieler fliegt nun wie Durchfallmann!");
				t.sendMessage(Main.Prefix + "Du bist nun Durchfallmann!");

			}

		} else {
			p.sendMessage(Main.Prefix + "Nutze _durchfallmann <Player>");

		}
	}
		
}
