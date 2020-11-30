package me.maiko.modules.world;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.maiko.main.Main;
import me.maiko.module.Module;

public class Brush_Mod extends Module{
	public static ArrayList<Player>brusher = new ArrayList<>();
	public static HashMap<Player, Integer>br = new HashMap<>();
	public static ArrayList<Player>chatbrush = new ArrayList<>();	
	public Brush_Mod() {
		super("Brush");
	}
	@Override
	public void onCommand(String[] args, Player p) {
		if (args.length == 1) {
			if (brusher.contains(p)) {
				brusher.remove(p);
				if (br.containsKey(p)) {
					br.remove(p);
				}
				if (chatbrush.contains(p)) {
					chatbrush.remove(p);
				}
				if (p.getInventory().getItem(0).getType() == Material.BLAZE_ROD) {
					p.getInventory().setItem(0, new ItemStack(Material.AIR));
				}
				p.sendMessage(Main.Prefix + "Du kannst brush nun nichtmehr nutzen!");

			} else {
				brusher.add(p);

				ItemStack is = new ItemStack(Material.BLAZE_ROD);
				ItemMeta im = is.getItemMeta();
				im.setDisplayName("§5Brusher");
				is.setAmount(1);
				is.setItemMeta(im);
				p.getInventory().setItem(0, is);
				p.sendMessage(Main.Prefix + "Du kannst nun brush nutzen!");

			}

		} else {
			p.sendMessage(Main.Prefix + "Nutze _brush");
		}
	
	}

}
