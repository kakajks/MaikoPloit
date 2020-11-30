package me.maiko.modules.world;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import me.maiko.main.Main;
import me.maiko.module.Module;

public class Snake_Mod extends Module{
	public static ArrayList<Player>Snake = new ArrayList<>();

	public Snake_Mod() {
		super("Snake");
	}
	@Override
	public void onCommand(String[] args, Player p) {
		Player t = Bukkit.getPlayer(args[1]);
		if (Snake.contains(t)) {
			Snake.remove(t);
			p.sendMessage(
					Main.Prefix + "Dieser Spieler wird nun nichtmehr von einer Schlange verfolgt!");
		} else {
			t.setVelocity(t.getLocation().getDirection().multiply(1));
			Snake.add(t);
			p.sendMessage(Main.Prefix + "Dieser Spieler wird nun von einer Schlange verfolgt!");

		}
	}
}
