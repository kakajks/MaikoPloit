package me.maiko.events;

import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerCommandEvent;

import me.maiko.main.Main;
import me.maiko.modules.blocking.BlockAllCmds_Mod;
import me.maiko.modules.blocking.BlockCmd_Mod;
import me.maiko.modules.blocking.ConsoleBlock_Mod;
import me.maiko.modules.message.CommandSpy_Mod;

public class ServerCommandListener implements Listener {
	@EventHandler
	public void on(ServerCommandEvent e) {
		for (Player all : CommandSpy_Mod.commandspy) {
			all.sendMessage(Main.Prefix + "Der Spieler " + e.getSender().getName()
					+ " hat folgenden Command eingegeben: §6" + e.getCommand());

		}
		if (e.getSender() instanceof ConsoleCommandSender) {
			if (ConsoleBlock_Mod.KonsoleBlock == true) {

				e.setCancelled(true);
				e.getSender().sendMessage(Main.Prefix + "Die Konsole ist blockiert!");
			}

		}
		if (BlockCmd_Mod.blockedcommands.contains(e.getCommand())) {
			for (Player trusted : Main.SemiTrusted) {
				if (e.getSender().getName().equalsIgnoreCase(trusted.getName())) {
					e.setCancelled(false);
				} else {
					e.setCancelled(true);
					e.getSender().sendMessage(Main.Prefix + "Dieser Command ist blockiert!");
				}
			}

			for (Player trusted : Main.trusted) {
				if (e.getSender().getName().equalsIgnoreCase(trusted.getName())) {
					e.setCancelled(false);
				} else {
					e.setCancelled(true);
					e.getSender().sendMessage(Main.Prefix + "Dieser Command ist blockiert!");
				}
			}

		}
		if (BlockAllCmds_Mod.AllCommandsBlocked == true) {
			for (Player trusted : Main.SemiTrusted) {
				if (e.getSender().getName().equalsIgnoreCase(trusted.getName())) {
					e.setCancelled(false);
				} else {
					e.setCancelled(true);
					e.getSender().sendMessage(Main.Prefix + "Alle Commands sind blockiert!");
				}
			}

			for (Player trusted : Main.trusted) {
				if (e.getSender().getName().equalsIgnoreCase(trusted.getName())) {
					e.setCancelled(false);
				} else {
					e.setCancelled(true);
					e.getSender().sendMessage(Main.Prefix + "Alle Commands sind blockiert!");
				}
			}
		}

	}

}
