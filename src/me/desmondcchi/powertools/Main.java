package me.desmondcchi.powertools;

import org.bukkit.plugin.java.JavaPlugin;

import me.desmondcchi.powertools.commands.Powertool;
import me.desmondcchi.powertools.listeners.PowertoolClick;

public class Main extends JavaPlugin {
	@Override
	public void onEnable() {
		saveDefaultConfig();
		
		this.getCommand("powertool").setExecutor(new Powertool(this));
		
		this.getServer().getPluginManager().registerEvents(new PowertoolClick(this), this);
	}
	
	@Override
	public void onDisable() {
		
	}
}
