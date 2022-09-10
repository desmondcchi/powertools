package me.desmondcchi.powertools;

import org.bukkit.plugin.java.JavaPlugin;

import me.desmondcchi.powertools.commands.Powertool;

public class Main extends JavaPlugin {
	@Override
	public void onEnable() {
		this.getCommand("powertool").setExecutor(new Powertool(this));
	}
	
	@Override
	public void onDisable() {
		
	}
}
