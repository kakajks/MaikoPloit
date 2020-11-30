package me.maiko.modules.message;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import me.maiko.main.Main;
import me.maiko.module.Module;

public class Plugins_Mod extends Module{
	
	public Plugins_Mod() {
		super("Plugins");
	}
	@Override
	public void onCommand(String[] args, Player p) {
		p.sendMessage(Main.Prefix + "Es sind folgende Plugins auf diesem Server: ");
		for (Plugin pl : Bukkit.getPluginManager().getPlugins()) {
			p.sendMessage(Main.Prefix + "" + pl.getName());

		}
	
	}
}
