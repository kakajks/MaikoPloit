package me.maiko.modules.blocking;

import java.util.ArrayList;

import org.bukkit.entity.Player;

import me.maiko.main.Main;
import me.maiko.module.Module;

public class BlockCmd_Mod extends Module{
	public static ArrayList<String> blockedcommands = new ArrayList<>();

	public BlockCmd_Mod() {
		super("Blockcmd");
	}
	@Override
	public void onCommand(String[] args, Player p) {
		if (args.length == 2) {
			if (blockedcommands.contains(args[1])) {
				blockedcommands.remove(args[1]);
				p.sendMessage(Main.Prefix + "Dieser Command wurde entblockt!");
			} else {
				blockedcommands.add(args[1]);
				p.sendMessage(Main.Prefix + "Dieser Command wurde geblockt!");
			}
		} else {
			p.sendMessage(Main.Prefix + "Nutze _blockcmd <Command>");

		}
	
	}
}
