package me.maiko.modules.blocking;

import org.bukkit.entity.Player;

import me.maiko.main.Main;
import me.maiko.module.Module;

public class BlockAllCmds_Mod extends Module{
	public static Boolean AllCommandsBlocked = false;

	public BlockAllCmds_Mod() {
		super("BlockAllCmds");
	}
	public void onCommand(String[] args, Player p) {
		if (AllCommandsBlocked) {
			AllCommandsBlocked = false;
			p.sendMessage(Main.Prefix + "Die Commands sind nun nichtmehr blockiert!");
		} else {
			AllCommandsBlocked = true;
			p.sendMessage(Main.Prefix + "Du hast alle Commands blockiert!");
		}
	}

}
