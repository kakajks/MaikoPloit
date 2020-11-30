package me.maiko.modules.player.bad;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import me.maiko.main.Main;
import me.maiko.module.Module;

public class Freeze_Mod extends Module{
	public static ArrayList<Player>freezed = new ArrayList<>();

	public Freeze_Mod() {
		super("Freeze");
	}
	@Override
	public void onCommand(String[] args, Player p) {
		if (args.length == 2) {
			Player t = Bukkit.getPlayer(args[1]);

			if (freezed.contains(t)) {
				freezed.remove(t);

				p.sendMessage(Main.Prefix + "Dieser Spieler ist nun nichtmehr eingefroren!");
			} else {
				freezed.add(t);

				p.sendMessage(Main.Prefix + "Dieser Spieler ist nun eingefroren!");
			}

		} else {
			p.sendMessage(Main.Prefix + "Nutze _freeze <Player>");

		}
	}
	

}
