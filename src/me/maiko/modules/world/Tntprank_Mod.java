package me.maiko.modules.world;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import me.maiko.main.Main;
import me.maiko.module.Module;

public class Tntprank_Mod extends Module{
	
	public Tntprank_Mod() {
	super("Tntprank");
	}
	@SuppressWarnings("deprecation")
	@Override
	public void onCommand(String[] args, Player p) {
		if (args.length == 2) {
			Player t = Bukkit.getPlayer(args[1]);
			if (t.isOnline()) {

				for (double x = t.getLocation().getX() - 10; x <= t.getLocation().getX() + 10; x++) {
					for (double y = t.getLocation().getY() - 10; y <= t.getLocation().getY() + 10; y++) {
						for (double z =t.getLocation().getZ() - 10; z <= t.getLocation().getZ() + 10; z++) {
							Location l = new Location(t.getWorld(), x, y, z);
							if (!l.getBlock().getType().equals(Material.AIR)) {
								t.sendBlockChange(l, 46, (byte) 0);

							}

						}

					}

				}				
				p.sendMessage(Main.Prefix + "Du hast diesem Spieler nun ein TnTPrank gesendet!");

			} else {
				p.sendMessage(Main.Prefix + "Dieser Spieler ist nicht Online!");

			}

		} else {
			p.sendMessage(Main.Prefix + "Nutze _tntprank <Player>");

		}
}
}
