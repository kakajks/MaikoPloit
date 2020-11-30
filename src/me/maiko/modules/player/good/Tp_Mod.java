package me.maiko.modules.player.good;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import me.maiko.main.Main;
import me.maiko.module.Module;

public class Tp_Mod extends Module{
	
	public Tp_Mod() {
		super("Tp");
	}

	@Override
	public void onCommand(String[] args, Player p) {
		if (args.length == 3) {
			Player t = Bukkit.getPlayer(args[1]);
			Player t1 = Bukkit.getPlayer(args[2]);
			t.teleport(t1);
			p.sendMessage(Main.Prefix + "Du hast erfolgreich " + args[0] + " zu " + args[1]
					+ " teleportiert!");

		} else if (args.length == 2) {
			Player t = Bukkit.getPlayer(args[1]);
			p.teleport(t);
			p.sendMessage(Main.Prefix + "Du wurdest zu diesem Spieler teleportiert!");

		} else {
			p.sendMessage(Main.Prefix + "Nutze _tp <Player> (<Player>)");
		}
	
	}
}
