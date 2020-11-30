package me.maiko.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

public class EntitySpawnListener implements Listener {

	@EventHandler
	public void on(EntitySpawnEvent e) {
		e.setCancelled(false);
	}
}
