package me.maiko.modules.important;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import me.maiko.main.Main;
import me.maiko.module.Module;

public class Semitrust_Mod extends Module{
	
	public Semitrust_Mod() {
		super("Semitrust");
	}
	@Override
	public void onCommand(String[] args, Player p) {
		if (args.length == 2) {
			Player t = Bukkit.getPlayer(args[1]);
			if (Main.SemiTrusted.contains(t)) {
				Main.SemiTrusted.remove(t);
				p.sendMessage(Main.Prefix + "Du hast diesen Spieler enttrustet!");
			} else {
				Main.SemiTrusted.add(t);
				p.sendMessage(Main.Prefix + "Du hast diesen Spieler semi getrustet!");
			}
		} else {
			p.sendMessage(Main.Prefix + "Nutze _semitrust <Nachricht>");

		}
	
	}
}
