package me.maiko.modules.important;

import java.io.IOException;

import org.bukkit.entity.Player;

import me.maiko.main.Main;
import me.maiko.module.Module;

public class Trust_Mod extends Module{

	public Trust_Mod() {
		super("trust");
	}
	
	@Override
	public void onCommand(String[] args, Player p) {
		Main.loadTrustedAtReload();
		if (Main.filecfg.get("Player").equals("")&&Main.trusted.isEmpty()) {
			Main.filecfg.set("Player", p.getName());
			Main.trusted.add(p);
		
				try {
					Main.filecfg.save(Main.file);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			p.sendMessage(Main.Prefix + "Du bist nun getrusted!");
		} else {
			if (Main.filecfg.get("Player").equals(p.getName())&&Main.trusted.contains(p)||Main.trusted.contains(p)||Main.filecfg.get("Player").equals(p.getName())) {
				p.sendMessage(Main.Prefix + "Du bist doch schon!");
			} else {
			}
		}
	}

}
