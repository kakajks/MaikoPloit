package me.maiko.modules.world;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import me.maiko.main.Main;
import me.maiko.module.Module;

public class Pimmel_Mod extends Module {

	public Pimmel_Mod() {
		super("Pimmel");
	}

	@SuppressWarnings("deprecation")
	@Override
	public void onCommand(String[] args, Player p) {
		if (args.length == 2) {
			Player t = Bukkit.getPlayer(args[1]);
			if (t.isOnline()) {
				for (double x = t.getLocation().getX() - 4; x <= t.getLocation().getX() + 4; x++) {
					for (double y = t.getLocation().getY() + 4; y <= t.getLocation().getY() + 6; y++) {
						for (double z = t.getLocation().getZ(); z <= t.getLocation().getZ() + 2; z++) {
							t.sendBlockChange(new Location(t.getWorld(), x, y, z), Material.STAINED_CLAY, (byte) 6);

						}
					}
				}

				for (double x = t.getLocation().getX() - 1; x <= t.getLocation().getX() + 1; x++) {
					for (double y = t.getLocation().getY() + 6; y <= t.getLocation().getY() + 12; y++) {
						for (double z = t.getLocation().getZ(); z <= t.getLocation().getZ() + 2; z++) {

							t.sendBlockChange(new Location(t.getWorld(), x, y, z), Material.STAINED_CLAY, (byte) 6);

						}
					}
				}

				for (double x = t.getLocation().getX() - 1; x <= t.getLocation().getX() + 1; x++) {
					for (double y = t.getLocation().getY() + 12; y <= t.getLocation().getY() + 14; y++) {
						for (double z = t.getLocation().getZ(); z <= t.getLocation().getZ() + 2; z++) {

							t.sendBlockChange(new Location(t.getWorld(), x, y, z), Material.STAINED_CLAY, (byte) 2);

						}
					}
				}
				p.sendMessage(Main.Prefix + "Du hast diesen Spieler einen Pimmel geschickt!");

			} else {
				p.sendMessage(Main.Prefix + "Dieser Spieler ist nicht Online!");

			}

		} else {
			p.sendMessage(Main.Prefix + "Nutze _pimmel <Player>");
		}
	}

}
