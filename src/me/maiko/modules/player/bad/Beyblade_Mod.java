package me.maiko.modules.player.bad;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import me.maiko.main.Main;
import me.maiko.module.Module;

public class Beyblade_Mod extends Module{
	Main plugin;
	public static ArrayList<Player>Beyblade = new ArrayList<>();
	public Beyblade_Mod(Main plugin) {
		super("beyblade");
		this.plugin = plugin;	
	}
	int beyblade = 0;
	int yaw;	@Override
	public void onCommand(String[] args, Player p) {
		if (args.length == 2) {
			Player t = Bukkit.getPlayer(args[1]);
			if (t.isOnline()) {
				if(Beyblade.contains(t)) {
					Beyblade.remove(p);
					p.sendMessage(Main.Prefix + "Dieser Spieler ist nun kein BayBlade mehr!");

					
				}else {
					Beyblade.add(p);
					p.sendMessage(Main.Prefix + "Dieser Spieler wurde nun zu einem BayBlade!");
					t.getLocation().setPitch(0);
					new BukkitRunnable() {
						
						@Override
						public void run() {
							if(Beyblade.contains(p)) {
								yaw+=10;
								Location loc = new Location(t.getWorld(), t.getLocation().getX(),
										t.getLocation().getY(), t.getLocation().getZ(),
										t.getLocation().getYaw(), t.getLocation().getPitch());
								loc.setYaw(yaw);
								loc.setPitch(0);
								t.teleport(loc);	
							}else {
								cancel();
							}
							
						}
					}.runTaskTimer(plugin, 0, 1);
						
				}
				
				
	

			} else {
				p.sendMessage(Main.Prefix + "Dieser Spieler ist nicht Online!");

			}

		} else {
			p.sendMessage(Main.Prefix + "Nutze _beyblade <Player>");

		}
	
	}
}
