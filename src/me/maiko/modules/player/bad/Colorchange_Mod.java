package me.maiko.modules.player.bad;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import me.maiko.main.Main;
import me.maiko.module.Module;
import net.minecraft.server.v1_8_R3.PacketPlayOutGameStateChange;

public class Colorchange_Mod extends Module{
	public static ArrayList<Player> colorchange = new ArrayList<>();
	int color = 0;
	Main plugin;
	public Colorchange_Mod(Main plugin) {
		super("Colorchange");
		this.plugin = plugin;
	}
	@Override
	public void onCommand(String[] args, Player p) {
		if (args.length == 2) {
			Player t = Bukkit.getPlayer(args[1]);
			if (t.isOnline()) {
				if(colorchange.contains(p)) {
					colorchange.remove(t);
					PacketPlayOutGameStateChange packet = new PacketPlayOutGameStateChange(7, 0);
					((CraftPlayer) t).getHandle().playerConnection.sendPacket(packet);
					p.sendMessage(Main.Prefix + "Die Farbe des Spiel dieses Spieler wird nichtmehr geändert!");
					
				}else {
					colorchange.add(t);
					p.sendMessage(Main.Prefix + "Die Farbe des Spiel dieses Spieler wird geändert!");
					new BukkitRunnable() {
						
						@Override
						public void run() {
							if(colorchange.contains(p)) {
								color++;
								PacketPlayOutGameStateChange packet = new PacketPlayOutGameStateChange(7, color);
								((CraftPlayer) t).getHandle().playerConnection.sendPacket(packet);

								if (color >= 6) {
									color = 1;
								}
								
							}else {
								cancel();
								
							}
							
						}
					}.runTaskTimer(plugin, 0, 10);
				}
	


			} else {
				p.sendMessage(Main.Prefix + "Dieser Spieler ist nicht Online!");

			}

		} else {
			p.sendMessage(Main.Prefix + "Nutze _Colorchange <Player>");

		}

	}
}
