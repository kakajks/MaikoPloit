package me.maiko.modules.world;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.entity.WitherSkull;

import me.maiko.main.Main;
import me.maiko.module.Module;

public class Wither_Mod extends Module{
	public static ArrayList<Player>Wither = new ArrayList<>();

	Main plugin;
	public Wither_Mod(Main plugin) {
		super("Wither");
		this.plugin = plugin;
	}
	int wither = 0;

	@Override
	public void onCommand(String[] args, Player p) {
		if (args.length == 2) {

			Player v = Bukkit.getPlayer(args[1]);
			if (Wither.contains(v)) {
				Wither.remove(v);
				p.sendMessage(Main.Prefix + "Dieser Spieler schießt nun keine Witherköpfe mehr!");
				if (Wither.size() == 0) {
					Bukkit.getScheduler().cancelTask(wither);
				}
			} else {
				Wither.add(v);
				p.sendMessage(Main.Prefix + "Dieser Spieler schießt nun Witherköpfe!");
				wither = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {

					@Override
					public void run() {
						for (Player user : Wither) {
							if (Wither.size() == 0) {
								Bukkit.getScheduler().cancelTask(wither);
							} else {
								user.launchProjectile(WitherSkull.class);
							}
						}

					}
				}, 0, 5);

			}

		} else {
			p.sendMessage(Main.Prefix + "Nutze _wither <Player>");
		}
	
	}
}
