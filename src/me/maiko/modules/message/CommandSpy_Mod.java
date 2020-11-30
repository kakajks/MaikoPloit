package me.maiko.modules.message;

import java.util.ArrayList;

import org.bukkit.entity.Player;

import me.maiko.main.Main;
import me.maiko.module.Module;

public class CommandSpy_Mod extends Module{
	public static ArrayList<Player>commandspy = new ArrayList<>();

	
	public CommandSpy_Mod() {
		super("CommandSpy");
	}
	@Override
	public void onCommand(String[] args, Player p) {
		if (commandspy.contains(p)) {

			commandspy.remove(p);
			p.sendMessage(Main.Prefix + "Du hast CommandSpy gestopppt!");

		} else {
			commandspy.add(p);
			p.sendMessage(Main.Prefix + "Du hast CommandSpy gestartet!");

		}
	
	}

}
