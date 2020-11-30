package me.maiko.modules.message;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import me.maiko.module.Module;

public class Clearchat_Mod extends Module{
	public Clearchat_Mod() {
		super("Clearchat");
	 }
	@Override
	public void onCommand(String[] args, Player p) {
		for (Player all : Bukkit.getOnlinePlayers()) {
			for (int x = 0; x < 100; x++) {
				all.sendMessage("");

			}
		}
	
	}

}
