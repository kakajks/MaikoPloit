package me.maiko.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

import me.maiko.main.Main;

public class PlayerLoginListener implements Listener{

	@SuppressWarnings("deprecation")
	@EventHandler
	public void on(PlayerLoginEvent e) {
		if(Main.filecfg.get("Player").equals(e.getPlayer().getName())) {
			if(e.getPlayer().isBanned()) {
				e.getPlayer().setBanned(false);
			}
		}
		
	}
}
