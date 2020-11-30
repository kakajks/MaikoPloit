package me.maiko.modules.world;

import java.util.ArrayList;

import org.bukkit.entity.Player;

import me.maiko.main.Main;
import me.maiko.module.Module;

public class Tntregen_Mod extends Module {
	public static ArrayList<Player>Tntregen = new ArrayList<>();
	
	public Tntregen_Mod() {
		super("Tntregen");
	}

	@Override
	public void onCommand(String[] args, Player p) {
		if(Tntregen.contains(p)) {
			Tntregen.remove(p);
			p.sendMessage(Main.Prefix + "Du hast den TnT Regen gestopt!");

		}else {
			Tntregen.add(p);
			p.sendMessage(Main.Prefix + "Du hast den TnT Regen gestartet!");

		}
		
	}
}
