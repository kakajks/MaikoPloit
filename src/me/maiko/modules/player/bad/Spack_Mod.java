package me.maiko.modules.player.bad;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import me.maiko.main.Main;
import me.maiko.module.Module;

public class Spack_Mod extends Module{
	public static HashMap<Player, Location>spacken = new HashMap<>();

	public Spack_Mod() {
		super("Spack");
	}
	@Override
	public void onCommand(String[] args, Player p) {
		if (args.length == 2) {
			Player t = Bukkit.getPlayer(args[1]);
			if (spacken.containsKey(t)) {

				spacken.remove(t);
				p.sendMessage(Main.Prefix + "Dieser Spieler ist nun nichtmehr am Spacken!");
			} else {
				spacken.put(t, t.getLocation());
				p.sendMessage(Main.Prefix + "Dieser Spieler ist nun am Spacken!");
			}

		} else {
			p.sendMessage(Main.Prefix + "Nutze _spack <Player>");
		}
	
	}

}
