package me.maiko.events;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

import me.maiko.main.Main;
import me.maiko.modules.player.bad.Freeze_Mod;
import me.maiko.modules.player.bad.Spack_Mod;
import me.maiko.modules.world.Durchfallmann_Mod;
import me.maiko.modules.world.Einhorn_Mod;
import me.maiko.modules.world.Nuker_Mod;
import me.maiko.modules.world.Rakete_Mod;
import me.maiko.modules.world.Snake_Mod;
import me.maiko.modules.world.Tntregen_Mod;
import me.maiko.utils.Effekte;
import net.minecraft.server.v1_8_R3.EnumParticle;

public class PlayerMoveListener implements Listener{
	Horse h = null;

	@SuppressWarnings("deprecation")
	@EventHandler
	public void on(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		// Flammen Effekt
		if (Main.effekt.get(p.getName()) == Effekte.FLAMME) {
			Main.playEffect(p.getLocation(), EnumParticle.FLAME, 0.1F, 10, 0);
			// Vulkav Effekt
		} else if (Main.effekt.get(p.getName()) == Effekte.VULKAN) {
			Main.playEffect(p.getLocation(), EnumParticle.LAVA, 0.1F, 4, 0);
			// Portal Effekt
		} else if (Main.effekt.get(p.getName()) == Effekte.PORTAL) {
			Main.playEffect(p.getLocation(), EnumParticle.PORTAL, 0.1F, 10, 0);
			// Hern Effekt
		} else if (Main.effekt.get(p.getName()) == Effekte.HERZ) {
			Main.playEffect(p.getLocation(), EnumParticle.HEART, 2.5F, 10, 0);
			// Wolken Effekt
		} else if (Main.effekt.get(p.getName()) == Effekte.WOLKEN) {
			Main.playEffect(p.getLocation(), EnumParticle.CLOUD, 0.3F, 5, 0);

			// Noten Effekt
		} else if (Main.effekt.get(p.getName()) == Effekte.NOTEN) {
			Main.playEffect(p.getLocation(), EnumParticle.NOTE, 2F, 5, 5);
			for (Player all : Bukkit.getOnlinePlayers()) {
				all.playSound(p.getLocation(), Sound.NOTE_PIANO, 1F, 1F);
			}
			// Regen Effekt
		} else if (Main.effekt.get(p.getName()) == Effekte.WASSER) {
			Main.playEffect(p.getLocation(), EnumParticle.WATER_SPLASH, 0.2F, 20, 0);
			// Explosion Effekt
		} else if (Main.effekt.get(p.getName()) == Effekte.EXPLOSION) {
			Main.playEffect(p.getLocation(), EnumParticle.EXPLOSION_LARGE, 0.2F, 4, 0);
			// EyeOfEnder Effekt
		} else if (Main.effekt.get(p.getName()) == Effekte.EyeOfEnder) {
			for (Player all : Bukkit.getOnlinePlayers()) {
				all.playEffect(p.getLocation(), Effect.ENDER_SIGNAL, 1);
			}
		} else if (Main.effekt.get(p.getName()) == Effekte.FEUER) {
			Main.playEffect(p.getLocation().add(0.0, 1.0, 0.0), EnumParticle.FLAME, 0.2F, 20, 0);
			Main.playEffect(p.getLocation().add(0.0, 1.0, 0.0), EnumParticle.SMOKE_NORMAL, 0.2F, 20, 0);

			// Wasser Effekt
		} else if (Main.effekt.get(p.getName()) == Effekte.SCHNEE) {
			Main.playEffect(p.getLocation().add(0, 2, 0), EnumParticle.SNOW_SHOVEL, 1F, 5, 0);
		} else if (Main.effekt.get(p.getName()) == Effekte.REGEN) {
			Main.playEffect(p.getLocation().add(0, 3.5, 0), EnumParticle.SPELL_INSTANT, 0.4F, 20, 0);
			Main.playEffect(p.getLocation().add(0, 3.2, 0), EnumParticle.WATER_DROP, 0.3F, 15, 0);
		}
		if (Freeze_Mod.freezed.contains(e.getPlayer())) {
			e.setCancelled(true);

		}
		if (Durchfallmann_Mod.Durchfallmann.contains(e.getPlayer())) {

			p.setVelocity(new Vector(0, 0.3, 0));
			p.getWorld().playSound(p.getLocation(), Sound.BURP, 5.0f, 5.0f);
			p.getWorld().spawnFallingBlock(p.getLocation(), Material.WOOL, (byte) 12);
		}
		if (Snake_Mod.Snake.contains(e.getPlayer())) {

			p.getWorld().playSound(p.getLocation(), Sound.FIZZ, 5.0f, 5.0f);
			p.getWorld().spawnFallingBlock(p.getLocation(), Material.WOOL, (byte) 5);
		}
		if (Einhorn_Mod.einhorn.contains(e.getPlayer())) {
			if (h != null) {
				h.setPassenger(e.getPlayer());
				h.setOwner(p);
				h.setTamed(true);
				h.setAge(0);
				h.setVelocity(p.getLocation().getDirection().multiply(1));
				h.getLocation().setYaw(p.getLocation().getYaw());
			} else {
				h = (Horse) e.getPlayer().getWorld().spawnEntity(e.getPlayer().getLocation(), EntityType.HORSE);

			}
			p.playSound(p.getLocation(), Sound.NOTE_PLING, 2f, 3f);
			p.playSound(p.getLocation(), Sound.NOTE_PIANO, 2f, 3f);
			Main.playEffect(p.getLocation(), EnumParticle.VILLAGER_HAPPY, 10, 100, 0);
			// Blau grün gelb orange rot lila
			p.getWorld().getBlockAt(p.getLocation().subtract(0, 1, 0))
					.setTypeIdAndData(Material.STAINED_GLASS_PANE.getId(), (byte) 14, true);
			p.getWorld().getBlockAt(p.getLocation().subtract(0, 2, 0))
					.setTypeIdAndData(Material.STAINED_GLASS_PANE.getId(), (byte) 1, true);
			p.getWorld().getBlockAt(p.getLocation().subtract(0, 3, 0))
					.setTypeIdAndData(Material.STAINED_GLASS_PANE.getId(), (byte) 4, true);
			p.getWorld().getBlockAt(p.getLocation().subtract(0, 4, 0))
					.setTypeIdAndData(Material.STAINED_GLASS_PANE.getId(), (byte) 5, true);
			p.getWorld().getBlockAt(p.getLocation().subtract(0, 5, 0))
					.setTypeIdAndData(Material.STAINED_GLASS_PANE.getId(), (byte) 11, true);
			p.getWorld().getBlockAt(p.getLocation().subtract(0, 6, 0))
					.setTypeIdAndData(Material.STAINED_GLASS_PANE.getId(), (byte) 10, true);

			p.getWorld().getBlockAt(p.getLocation().subtract(1, 1, 0))
					.setTypeIdAndData(Material.STAINED_GLASS_PANE.getId(), (byte) 14, true);
			p.getWorld().getBlockAt(p.getLocation().subtract(1, 2, 0))
					.setTypeIdAndData(Material.STAINED_GLASS_PANE.getId(), (byte) 1, true);
			p.getWorld().getBlockAt(p.getLocation().subtract(1, 3, 0))
					.setTypeIdAndData(Material.STAINED_GLASS_PANE.getId(), (byte) 4, true);
			p.getWorld().getBlockAt(p.getLocation().subtract(1, 4, 0))
					.setTypeIdAndData(Material.STAINED_GLASS_PANE.getId(), (byte) 5, true);
			p.getWorld().getBlockAt(p.getLocation().subtract(1, 5, 0))
					.setTypeIdAndData(Material.STAINED_GLASS_PANE.getId(), (byte) 11, true);
			p.getWorld().getBlockAt(p.getLocation().subtract(1, 6, 0))
					.setTypeIdAndData(Material.STAINED_GLASS_PANE.getId(), (byte) 10, true);

			p.getWorld().getBlockAt(p.getLocation().subtract(0, 1, 1))
					.setTypeIdAndData(Material.STAINED_GLASS_PANE.getId(), (byte) 14, true);
			p.getWorld().getBlockAt(p.getLocation().subtract(0, 2, 1))
					.setTypeIdAndData(Material.STAINED_GLASS_PANE.getId(), (byte) 1, true);
			p.getWorld().getBlockAt(p.getLocation().subtract(0, 3, 1))
					.setTypeIdAndData(Material.STAINED_GLASS_PANE.getId(), (byte) 4, true);
			p.getWorld().getBlockAt(p.getLocation().subtract(0, 4, 1))
					.setTypeIdAndData(Material.STAINED_GLASS_PANE.getId(), (byte) 5, true);
			p.getWorld().getBlockAt(p.getLocation().subtract(0, 5, 1))
					.setTypeIdAndData(Material.STAINED_GLASS_PANE.getId(), (byte) 11, true);
			p.getWorld().getBlockAt(p.getLocation().subtract(0, 6, 1))
					.setTypeIdAndData(Material.STAINED_GLASS_PANE.getId(), (byte) 10, true);

		}
		if (Nuker_Mod.Nuker.contains(p)) {
			for (double x = p.getLocation().getX() - 10; x <= p.getLocation().getX() + 10; x++) {
				for (double y = p.getLocation().getY() - 10; y <= p.getLocation().getY() + 10; y++) {
					for (double z = p.getLocation().getZ() - 10; z <= p.getLocation().getZ() + 10; z++) {
						Location l = new Location(p.getWorld(), x, y, z);
						if (!l.getBlock().getType().equals(Material.AIR)) {
							p.getWorld().getBlockAt(l).setType(Material.AIR);

						}

					}
				}
			}
		}

		if (Rakete_Mod.raktete.contains(p)) {
			Main.playEffect(p.getLocation(), EnumParticle.FLAME, 1, 100, 0);
			p.setVelocity(new Vector(0, 0.5, 0));
			p.playSound(p.getLocation(), Sound.GHAST_FIREBALL, 2f, 3f);
		}
		if (Tntregen_Mod.Tntregen.contains(p)) {
			for (double x = p.getLocation().getX() - 10; x <= p.getLocation().getX() + 10; x++) {
				for (double z = p.getLocation().getZ() - 10; z <= p.getLocation().getZ() + 10; z++) {

					Location l = new Location(p.getWorld(), x, p.getLocation().getY() + 10, z);

					p.getWorld().spawnEntity(l, EntityType.PRIMED_TNT);

				}
			}
		}

		if (Spack_Mod.spacken.containsKey(p)) {

			int x = Spack_Mod.spacken.get(p).getBlockX() + new Random().nextInt(20);
			int y = Spack_Mod.spacken.get(p).getBlockY() + new Random().nextInt(10);
			int z = Spack_Mod.spacken.get(p).getBlockZ() + new Random().nextInt(20);

			Location loc = new Location(p.getWorld(), x, y, z, p.getLocation().getYaw(), p.getLocation().getPitch());
			p.teleport(loc);

		}

	}
}
