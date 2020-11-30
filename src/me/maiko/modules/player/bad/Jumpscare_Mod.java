package me.maiko.modules.player.bad;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import me.maiko.main.Main;
import me.maiko.module.Module;

public class Jumpscare_Mod extends Module{
	int jumpscare = 0;
	int end = 0;
	Main plugin;
	public Jumpscare_Mod(Main plugin) {
		super("Jumpscare");
		this.plugin = plugin;
	}
	@Override
	public void onCommand(String[] args, Player p) {
		if (args.length == 2) {
			Player t = Bukkit.getPlayer(args[1]);
			if (t.isOnline()) {

				end = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {

					@Override
					public void run() {
						if (jumpscare != 50) {

						
									t.getInventory().setHelmet(new ItemStack(Material.AIR));		
							new BukkitRunnable() {
								
								@Override
								public void run() {
									
									jumpscare++;
									t.getInventory().setHelmet(new ItemStack(Material.PUMPKIN));
									t.playSound(t.getLocation(), Sound.ENDERMAN_DEATH, 1.0F, 2.0F);
									t.playSound(t.getLocation(), Sound.BAT_DEATH, 1.0F, 1.0F);

								}
							}.runTaskLater(plugin, 2);
			
						} else {
							jumpscare = 0;
							Bukkit.getScheduler().cancelTask(end);
							t.getInventory().setHelmet(null);
						}

					}
				}, 0, 3);
				p.sendMessage(Main.Prefix + "Du hast diesem Spieler nun ein JumpScare gesendet!");

			} else {
				p.sendMessage(Main.Prefix + "Dieser Spieler ist nicht Online!");

			}

		} else {
			p.sendMessage(Main.Prefix + "Nutze _jumpscare <Player>");

		}
	}

}
