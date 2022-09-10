package me.desmondcchi.powertools.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.Plugin;

public class PowertoolClick implements Listener {
	private Plugin plugin;
	
	public PowertoolClick(Plugin plugin) {
		this.plugin = plugin;
	}
	@EventHandler
	public void onClick(PlayerInteractEvent event) {
		Player player = event.getPlayer();
	}
}
