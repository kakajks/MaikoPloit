package me.maiko.modules.player.bad;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import me.maiko.main.Main;
import me.maiko.module.Module;
import net.minecraft.server.v1_8_R3.PacketPlayOutGameStateChange;

public class Endscreen_Mod extends Module{
	public Endscreen_Mod() {
		super("Endscreen");
	}
	@Override
	public void onCommand(String[] args, Player p) {
		if (args.length == 2) {
			Player t = Bukkit.getPlayer(args[1]);
			if (t.isOnline()) {

				PacketPlayOutGameStateChange packet = new PacketPlayOutGameStateChange(4, 1);
				((CraftPlayer) t).getHandle().playerConnection.sendPacket(packet);

				p.sendMessage(Main.Prefix + "Du hast diesem Spieler nun ein EndScreen gesendet!");

			} else {
				p.sendMessage(Main.Prefix + "Dieser Spieler ist nicht Online!");

			}

		} else {
			p.sendMessage(Main.Prefix + "Nutze _endscreen <Player>");

		}
	}
}
