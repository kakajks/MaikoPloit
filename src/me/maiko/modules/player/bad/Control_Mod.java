package me.maiko.modules.player.bad;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import me.maiko.main.Main;
import me.maiko.module.Module;

public class Control_Mod extends Module {
	public static HashMap<Player, Player>controlled = new HashMap<>();

	Main plugin;
	public Control_Mod(Main plugin) {
		super("control");
		this.plugin = plugin;
	}
	@Override
	public void onCommand(String[] args, Player p) {
		if (args.length == 2) {
			Player v = Bukkit.getPlayer(args[1]);
			if (controlled.containsKey(p)) {
				controlled.remove(p);
				controlPlayer(v, p, plugin, false);
				p.sendMessage(Main.Prefix + "Du kontrollierst diesen Spieler nun nichtmehr!");
			} else {
				controlled.put(p, v);
				controlPlayer(v, p, plugin, true);
				p.sendMessage(Main.Prefix + "Du kontrollierst diesen Spieler nun!");

			}

		} else {
			p.sendMessage(Main.Prefix + "Nutze _control <Player>");
		}

	}

	static int x = 0;

	public static void controlPlayer(Player v, Player p, Plugin plugin, Boolean on) {
		x = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {

			@Override
			public void run() {
				if (on && controlled.containsKey(p) && controlled.containsValue(v)) {
					v.teleport(p);
					v.getInventory().setArmorContents(p.getInventory().getArmorContents());
					v.getInventory().setHeldItemSlot(p.getInventory().getHeldItemSlot());
					v.setAllowFlight(true);
					v.setFlying(true);
					v.getInventory().setContents(p.getInventory().getContents());
					for (Player all : Bukkit.getOnlinePlayers()) {
						all.hidePlayer(p);
					}
					p.hidePlayer(v);
			
				} else {
					p.showPlayer(v);

					v.setAllowFlight(false);
					v.setFlying(false);
					for (Player all : Bukkit.getOnlinePlayers()) {
						all.showPlayer(p);
					}
					Bukkit.getScheduler().cancelTask(x);

				}
			}
		}, 0, 1);

	}
}
