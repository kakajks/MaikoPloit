package me.maiko.modules.world;

import java.util.ArrayList;

import org.bukkit.entity.Player;

import me.maiko.module.Module;

public class Einhorn_Mod extends Module{
	
	public static ArrayList<Player>einhorn= new ArrayList<>();

	public Einhorn_Mod() {
		super("Einhorn");
	}
	@Override
	public void onCommand(String[] args, Player p) {
		if (einhorn.contains(p)) {

			einhorn.remove(p);
		} else {
			einhorn.add(p);

		}
}

}
