package me.maiko.modules.world;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.maiko.main.Main;
import me.maiko.module.Module;

public class Clientsidebrush_Mod extends Module{
	public static HashMap<Player, Player>clientsidebrusher = new HashMap<>();
	public static HashMap<Player, Integer>clientsidebr = new HashMap<>();
	public static ArrayList<Player>clientsidechatbrush = new ArrayList<>();
	public Clientsidebrush_Mod() {
		super("Clientsidebrush");
		
	}
	@Override
	public void onCommand(String[] args, Player p) {
		if (args.length == 2) {
			
			if (clientsidebrusher.containsKey(p)) {
				clientsidebrusher.remove(p);
				if (clientsidebr.containsKey(p)) {
					clientsidebr.remove(p);
				}
				if (clientsidechatbrush.contains(p)) {
					clientsidechatbrush.remove(p);
				}
				if (p.getInventory().getItem(0).getType() == Material.IRON_HOE) {
					p.getInventory().setItem(0, new ItemStack(Material.AIR));
				}
				p.sendMessage(Main.Prefix + "Du kannst brush nun nichtmehr nutzen!");

			} else {
				Player t = Bukkit.getPlayer(args[1]);
				clientsidebrusher.put(p, t);

				ItemStack is = new ItemStack(Material.IRON_HOE);
				ItemMeta im = is.getItemMeta();
				im.setDisplayName("§5Brusher");
				is.setAmount(1);
				is.setItemMeta(im);
				p.getInventory().setItem(0, is);
				p.sendMessage(Main.Prefix + "Du kannst nun brush nutzen!");

			}

		} else {
			p.sendMessage(Main.Prefix + "Nutze _clientsidebrush <Player>");
		}
	
	}

}
