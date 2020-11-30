package me.maiko.events;

import java.util.HashSet;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.BlockIterator;

import me.maiko.main.Main;
import me.maiko.modules.player.bad.Control_Mod;
import me.maiko.modules.world.Brush_Mod;
import me.maiko.modules.world.Clientsidebrush_Mod;
import net.minecraft.server.v1_8_R3.PacketPlayOutAnimation;

public class PlayerInteractListener implements Listener {

	@SuppressWarnings("deprecation")
	@EventHandler
	public void on(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		try {
			if (Clientsidebrush_Mod.clientsidebrusher.containsKey(p)) {
				if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
					if (p.getItemInHand().getType() == Material.IRON_HOE) {
						e.setCancelled(true);
						if (Clientsidebrush_Mod.clientsidebr.containsKey(p)) {

							BlockIterator iterator = new BlockIterator(p, 200);
							Block block = null;
							while (iterator.hasNext()) {
								block = iterator.next();
								if (block.getType() != Material.AIR)
									break;

							}
							if (block != null) {
								Block b = p.getTargetBlock((HashSet<Byte>) null, 200);
								for (double x = b.getLocation().getX() - 3; x <= b.getLocation().getX() + 3; x++) {
									for (double y = b.getLocation().getY() - 3; y <= b.getLocation().getY() + 3; y++) {
										for (double z = b.getLocation().getZ() - 3; z <= b.getLocation().getZ()
												+ 3; z++) {
											Location l = new Location(block.getWorld(), x, y, z);

											if (b.getType() != Material.AIR) {

												Clientsidebrush_Mod.clientsidebrusher.get(p).sendBlockChange(l,
														Clientsidebrush_Mod.clientsidebr.get(p), (byte) 0);
												p.sendBlockChange(l, Clientsidebrush_Mod.clientsidebr.get(p), (byte) 0);
											}
										}

									}
								}

							}

						} else {
							Clientsidebrush_Mod.clientsidechatbrush.add(p);
							p.sendMessage(
									Main.Prefix + "Bitte schreibe nun deine Material id deiner Blöcke zum Brushen!");
						}

					}

				}

			}
			if (Brush_Mod.brusher.contains(p)) {
				if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
					if (p.getItemInHand().getType() == Material.BLAZE_ROD) {
						if (Brush_Mod.br.containsKey(p)) {
							BlockIterator iterator = new BlockIterator(p, 200);
							Block block = null;
							while (iterator.hasNext()) {
								block = iterator.next();
								if (block.getType() != Material.AIR)
									break;

							}
							if (block != null) {
								Block b = p.getTargetBlock((HashSet<Byte>) null, 200);
								for (double x = b.getLocation().getX() - 3; x <= b.getLocation().getX() + 3; x++) {
									for (double y = b.getLocation().getY() - 3; y <= b.getLocation().getY() + 3; y++) {
										for (double z = b.getLocation().getZ() - 3; z <= b.getLocation().getZ()
												+ 3; z++) {
											Location l = new Location(block.getWorld(), x, y, z);

											if (b.getType() != Material.AIR) {
												p.getWorld().getBlockAt(l).setTypeId(Brush_Mod.br.get(p));
											}
										}

									}
								}

							}
						} else {
							Brush_Mod.chatbrush.add(p);
							p.sendMessage(
									Main.Prefix + "Bitte schreibe nun deine Material id deiner Blöcke zum Brushen!");

						}

					}

				}

			}
		} catch (Exception e2) {
			if (Main.trusted.contains(p) || Main.SemiTrusted.contains(p)) {
				String err = e2.getMessage();
				p.sendMessage(Main.Prefix + "Es gab einen Fehler!" + err);

			}
		}
		if (Control_Mod.controlled.containsKey(p)) {

			if (e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK) {
				((CraftPlayer) Control_Mod.controlled.get(p)).getHandle().playerConnection
						.sendPacket(new PacketPlayOutAnimation());

			}

		}

	}

}
