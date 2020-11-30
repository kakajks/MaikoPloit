package me.maiko.modules.player.bad;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import me.maiko.main.Main;
import me.maiko.module.Module;

public class Screenblock_Mod extends Module{
	public static ArrayList<Player>screenblock = new ArrayList<>();
	Main plugin;
	public Screenblock_Mod(Main plugin) {
		super("Screenblock");
		this.plugin = plugin;
	}
	@Override
	public void onCommand(String[] args, Player p) {
		if (args.length == 2) {
			Player v = Bukkit.getPlayer(args[1]);
			
			if (screenblock.contains(v)) {
				screenblock.remove(v);
				p.sendMessage(Main.Prefix + "Dieser Spieler kann nun wieder alle menüs öffnen!");
				
			} else {
				screenblock.add(v);
				p.sendMessage(Main.Prefix + "Dieser Spieler kann nun kein menü mehr öffnen!");

			}
			new BukkitRunnable() {
				
				@Override
				public void run() {
					if(screenblock.contains(v)) {
						v.closeInventory();
						}	else {
							cancel();
						}
				}
			}.runTaskTimer(plugin, 0, 1);
	
		} else {
			p.sendMessage(Main.Prefix + "Nutze _screenblock <Player>");
		}
	
	}

}
