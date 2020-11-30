package me.maiko.modules.player.good;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

import me.maiko.main.Main;
import me.maiko.module.Module;

public class Effekte_Mod extends Module{
	
	public Effekte_Mod() {
		super("Effekte");
	}
	@Override
	public void onCommand(String[] args, Player p) {
		if (args.length == 1) {
			
			loadeffekteinv();
			p.openInventory(invEffekte);
			p.playSound(p.getLocation(), Sound.LEVEL_UP, 2f, 3f);
			p.sendMessage(Main.Prefix + "Du kannst nun einen Effekt wählen!");

		} else {
			p.sendMessage(Main.Prefix + "Nutze _effekte");
		}
	}
	
	public static Inventory invEffekte = Bukkit.createInventory(null, InventoryType.CHEST, "§cEffekte");
	public static void loadeffekteinv() {

		for (int x = 0; x < (27); x++) {
			invEffekte.setItem(x, Main.createItem(Material.STAINED_GLASS_PANE, "§4", null, 1, 15));
		}
		invEffekte.setItem(0, Main.createItem(Material.BLAZE_POWDER, "§eFeuer", null, 1, 0));
		invEffekte.setItem(1, Main.createItem(Material.BLAZE_POWDER, "§eVulkan", null, 1, 0));
		invEffekte.setItem(2, Main.createItem(Material.BLAZE_POWDER, "§ePortal", null, 1, 0));
		invEffekte.setItem(3, Main.createItem(Material.BLAZE_POWDER, "§eHerz", null, 1, 0));
		invEffekte.setItem(4, Main.createItem(Material.BLAZE_POWDER, "§eWolken", null, 1, 0));

		invEffekte.setItem(5, Main.createItem(Material.BLAZE_POWDER, "§eWasser", null, 1, 0));
		invEffekte.setItem(6, Main.createItem(Material.BLAZE_POWDER, "§eExplosion", null, 1, 0));
		invEffekte.setItem(7, Main.createItem(Material.BLAZE_POWDER, "§eNoten", null, 1, 0));
		invEffekte.setItem(8, Main.createItem(Material.BLAZE_POWDER, "§eEyeOfEnder", null, 1, 0));
		invEffekte.setItem(9, Main.createItem(Material.BLAZE_POWDER, "§eSchnee", null, 1, 0));
		invEffekte.setItem(10, Main.createItem(Material.BLAZE_POWDER, "§eFeuer mit Rauch", null, 1, 0));
		invEffekte.setItem(11, Main.createItem(Material.BLAZE_POWDER, "§eRegen", null, 1, 0));

		invEffekte.setItem(26, Main.createItem(Material.BARRIER, "§4Entfernen", null, 1, 0));
	}


	
	
}
