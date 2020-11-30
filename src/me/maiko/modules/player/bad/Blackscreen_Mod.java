package me.maiko.modules.player.bad;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import me.maiko.main.Main;
import me.maiko.module.Module;
import net.minecraft.server.v1_8_R3.PacketPlayOutGameStateChange;

public class Blackscreen_Mod extends Module{
	public static ArrayList<Player> Blackscreen  = new ArrayList<>();
	Main plugin;
	public Blackscreen_Mod(Main plugin) {
		super("Blackscreen");
		this.plugin = plugin;
	}
	@Override
	public void onCommand(String[] args, Player p) {
		if (args.length == 2) {
			Player t = Bukkit.getPlayer(args[1]);
			if (t.isOnline()) {
				if (Blackscreen.contains(t)) {
					Blackscreen.remove(t);

					p.sendMessage(Main.Prefix + "Du sendest diesem Spieler nun kein BlackScreen mehr!");

				} else {
					Blackscreen.add(t);
					new BukkitRunnable() {
						
						@Override
						public void run() {
							if(Blackscreen.contains(p)) {
							PacketPlayOutGameStateChange packet = new PacketPlayOutGameStateChange(4, 1);
							((CraftPlayer) t).getHandle().playerConnection.sendPacket(packet);
							}else {
								cancel();
							}
						}
					}.runTaskTimer(plugin, 0, 1);
					
					p.sendMessage(Main.Prefix + "Du hast diesem Spieler nun ein BlackScreen gesendet!");
				}
			} else {
				p.sendMessage(Main.Prefix + "Dieser Spieler ist nicht Online!");

			}

		} else {
			p.sendMessage(Main.Prefix + "Nutze _blackscreen <Player>");

		}
	}
}
