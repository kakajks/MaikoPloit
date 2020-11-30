package me.maiko.modules.plugin;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import me.maiko.main.Main;
import me.maiko.module.Module;

public class Enableplugin_Mod extends Module{
	public Enableplugin_Mod() {
		super("Enableplugin");
	}
	
	@Override
	public void onCommand(String[] args, Player p) {
		if (args.length == 2) {
			Plugin pl = Bukkit.getPluginManager().getPlugin(args[1]);
			if (!Bukkit.getPluginManager().isPluginEnabled(pl)) {
				Bukkit.getPluginManager().enablePlugin(pl);
				p.sendMessage(Main.Prefix + "Du hast dieses Plugin aktiviert!");

			} else {

				p.sendMessage(Main.Prefix + "Dieses Plugin ist nicht deaktiviert!");
			}

		} else {
			p.sendMessage(Main.Prefix + "Nutze _enableplugins <Plugin>");

		}
	
	}
}
