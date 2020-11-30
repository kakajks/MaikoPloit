package me.maiko.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType.SlotType;

import me.maiko.main.Main;
import me.maiko.utils.Effekte;

public class InventoryClickListener implements Listener{
	
	@EventHandler
	public void on(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().contains("§cEffekte")) {
			e.setCancelled(true);
			if (e.getSlotType() == SlotType.OUTSIDE) {
				e.setCancelled(true);
			}
			if (e.getSlot() == 0) {
				Main.changeEffekt(p, Effekte.FLAMME);
			}
			if (e.getSlot() == 1) {
				Main.changeEffekt(p, Effekte.VULKAN);
			}
			if (e.getSlot() == 2) {
				Main.changeEffekt(p, Effekte.PORTAL);
			}
			if (e.getSlot() == 3) {
				Main.changeEffekt(p, Effekte.HERZ);
			}
			if (e.getSlot() == 4) {
				Main.changeEffekt(p, Effekte.WOLKEN);
			}
			if (e.getSlot() == 5) {
				Main.changeEffekt(p, Effekte.WASSER);
			}
			if (e.getSlot() == 6) {
				Main.changeEffekt(p, Effekte.EXPLOSION);
			}
			if (e.getSlot() == 7) {
				Main.changeEffekt(p, Effekte.NOTEN);
			}
			if (e.getSlot() == 8) {
				Main.changeEffekt(p, Effekte.EyeOfEnder);

			}
			if (e.getSlot() == 9) {
				Main.changeEffekt(p, Effekte.SCHNEE);
			}
			if (e.getSlot() == 10) {
				Main.changeEffekt(p, Effekte.FEUER);
			}
			if (e.getSlot() == 11) {
				Main.changeEffekt(p, Effekte.REGEN);
			}
			if (e.getSlot() == 26) {
				Main.effekt.remove(p.getName());
			}

		}
	}

}
