package me.maiko.modules.player.bad;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import me.maiko.main.Main;
import me.maiko.module.Module;
import net.minecraft.server.v1_8_R3.PacketPlayOutGameStateChange;

public class DemoScreen_Mod extends Module{
	
	public DemoScreen_Mod() {
		super("Demoscreen");
	}
	@Override
	public void onCommand(String[] args, Player p) {
		if (args.length == 2) {
			Player t = Bukkit.getPlayer(args[1]);
			if (t.isOnline()) {
				PacketPlayOutGameStateChange packet = new PacketPlayOutGameStateChange(5, (float) 0);
				((CraftPlayer) t).getHandle().playerConnection.sendPacket(packet);
				p.sendMessage(Main.Prefix + "Du hast diesem Spieler ein DemoScreen geschickt!");

			} else {
				p.sendMessage(Main.Prefix + "Dieser Spieler ist nicht Online!");

			}

		} else {
			p.sendMessage(Main.Prefix + "Nutze _demoscreen <Player>");

		}

	}
}
