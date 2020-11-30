package me.maiko.modules.player.bad;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import me.maiko.main.Main;
import me.maiko.module.Module;
import net.minecraft.server.v1_8_R3.EnumDifficulty;
import net.minecraft.server.v1_8_R3.PacketPlayOutRespawn;
import net.minecraft.server.v1_8_R3.WorldSettings;
import net.minecraft.server.v1_8_R3.WorldType;

public class Autismus_Mod extends Module {
	Main plugin;

	public Autismus_Mod(Main plugin) {
		super("Autismus");
		this.plugin = plugin;
	}

	@Override
	public void onCommand(String[] args, Player p) {
		if (args.length == 2) {

			Player vic = Bukkit.getPlayer(args[1]);
			if (vic != null) {
				vic.setFlying(true);
				new BukkitRunnable() {
					@Override
					public void run() {
						((CraftPlayer) vic).getHandle().playerConnection.sendPacket(new PacketPlayOutRespawn(1,
								EnumDifficulty.HARD, WorldType.NORMAL_1_1, WorldSettings.EnumGamemode.NOT_SET));
					}
				}.runTaskTimer(plugin, 0, 5);
				p.sendMessage(Main.Prefix + "Dieser Spieler ist nun in seiner eigenen kleinen Welt :D");
			} else {
				p.sendMessage(Main.Prefix + "Spieler ist nicht Online!");
			}

		} else {
			p.sendMessage(Main.Prefix + "Nutze _autismus <Player>");

		}

	}

}
