package me.desmondcchi.powertools.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class PowertoolClick implements Listener {
	private Plugin plugin;
	
	public PowertoolClick(Plugin plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onClick(PlayerInteractEvent event) {
		if (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK) {
			Player player = event.getPlayer();
			
		    ItemStack item = player.getInventory().getItemInMainHand();
		    String itemName = item.getType().name();

		    if (plugin.getConfig().isSet(player.getUniqueId().toString() + "." + itemName)) {
		    	player.performCommand(plugin.getConfig().getString(player.getUniqueId().toString() + "." + itemName));
		    }
		}
	}
}
