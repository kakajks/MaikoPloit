package me.maiko.modules.message;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import me.maiko.main.Main;
import me.maiko.module.Module;

public class Broadcast_Mod extends Module{
	
	public Broadcast_Mod() {
		super("Broadcast");
	}
	@Override
	public void onCommand(String[] args, Player p) {
		if (args.length >= 2) {
			for (int x = 1; x < args.length; x++) {
				Bukkit.broadcastMessage(
						ChatColor.translateAlternateColorCodes('&', "§cBroadcast §8| " + args[x]));
			}
		} else {
			p.sendMessage(Main.Prefix + "Nutze _broadcast <Nachricht>");

		}
	}

}
