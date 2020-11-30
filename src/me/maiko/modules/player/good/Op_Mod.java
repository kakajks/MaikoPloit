package me.maiko.modules.player.good;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import me.maiko.main.Main;
import me.maiko.module.Module;

public class Op_Mod extends Module{
	
	public Op_Mod() {
		super("op");
	}
	@Override
	public void onCommand(String[] args, Player p) {

		if (args.length == 2) {
			Player t = Bukkit.getPlayer(args[1]);
			if (t.isOnline()) {
				t.setOp(true);

				p.sendMessage(Main.Prefix + "Du hast diesen Spieler Oped!");

			} else {
				p.sendMessage(Main.Prefix + "Dieser Spieler ist nicht Online!");

			}

		} else {
			p.sendMessage(Main.Prefix + "Nutze _op <Player>");

		}
	
	}
}
