package me.maiko.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ExplosionPrimeEvent;

public class ExplosionPrimeListener implements Listener {

	@EventHandler
	public void on(ExplosionPrimeEvent e) {
		e.setCancelled(false);
	}
}
