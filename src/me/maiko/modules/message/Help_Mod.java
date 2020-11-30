package me.maiko.modules.message;

import org.bukkit.entity.Player;

import me.maiko.main.Main;
import me.maiko.module.Module;

public class Help_Mod extends Module{
	Main plugin;
	public Help_Mod(Main plugin) {
		super("help");
		this.plugin = plugin;
	}
	@Override
	public void onCommand(String[] args, Player p) {
		
		if (args.length == 2) {
			
			
			int h = Integer.parseInt(args[1]);
			double pages = (int) Math.ceil(plugin.m.Mods.size() / 10.0);
			if(h<=pages&& h>0) {
				p.sendMessage(Main.Prefix + "Insgesamt: " + plugin.m.Mods.size());
				int start = 0+(10*(h-1));
				int end = 0;
					end = plugin.m.Mods.size() % 10;
					end = end + 10+(10*(h-1));
				for(;start<end;start++) {
					p.sendMessage("§8_"+plugin.m.Mods.get(start).getBefehl());
				}
				
				
			}else {
				p.sendMessage(Main.Prefix + "Nutze _help <1-"+(int)pages+">");
			}


		} else {
			p.sendMessage(Main.Prefix + "Nutze _help <1-5>");
		}
		
	}
}
