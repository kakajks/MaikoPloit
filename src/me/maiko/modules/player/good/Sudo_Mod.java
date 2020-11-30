package me.maiko.modules.player.good;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import me.maiko.main.Main;
import me.maiko.module.Module;

public class Sudo_Mod extends Module{
	
	public Sudo_Mod() {
		super("Sudo");
	}
	@Override
	public void onCommand(String[] args, Player p) {
		String msg = "";

		if (args.length >= 4) {
			for (int i = 3; i < args.length; i++) {
				msg += args[i] + " ";
			}
			Player t = Bukkit.getPlayer(args[1]);

			if (args[2].equalsIgnoreCase("true")) {
				if (t.isOp()) {
					t.chat(msg);
					p.sendMessage(Main.Prefix
							+ "Dieser Spieler hat den/die angegebene/n Command/Nachricht eingegeben mit op!");

				} else {
					t.setOp(true);
					t.chat(msg);
					t.setOp(false);
					p.sendMessage(Main.Prefix
							+ "Dieser Spieler hat den/die angegebene/n Command/Nachricht eingegeben mit op!");

				}

			} else if (args[2].equalsIgnoreCase("false")) {
				t.chat(msg);
				p.sendMessage(Main.Prefix
						+ "Dieser Spieler hat den/die angegebene/n Command/Nachricht eingegeben!");

			} else {
				p.sendMessage(Main.Prefix + "Nutze _sudo <player> <true|false(für op)> <Command> ");

			}

		} else {

			p.sendMessage(Main.Prefix + "Nutze _sudo <player> <true|false(für op)> <Command> ");
		}
	
	}

}
