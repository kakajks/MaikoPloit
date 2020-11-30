package me.maiko.module;

import org.bukkit.entity.Player;

public abstract class Module {

	
	private String befehl;
	
	public Module(String befehl) {
		this.befehl = befehl;
	}
	public void setBefehl(String befehl) {
		this.befehl = befehl;
	}

	public String getBefehl() {
		return befehl;
	}
	
//Events	
	public abstract void onCommand(String[] args, Player p);

	
}
