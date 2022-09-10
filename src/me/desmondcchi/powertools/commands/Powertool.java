package me.desmondcchi.powertools.commands;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;

public class Powertool implements CommandExecutor {
	private Plugin plugin;
	private Map<Material, String> powertools = new HashMap<Material,String>();
	
	public Powertool(Plugin plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("powertool") || label.equalsIgnoreCase("pt")) {
			Player player = (Player) sender;
			if (sender instanceof Player) {
				if (args.length == 0) {
					player.spigot().sendMessage(ChatMessageType.ACTION_BAR, 
							new TextComponent(ChatColor.GOLD + "Powertool reset!"));
					ItemStack item = player.getItemInHand();
					String itemName = item.getItemMeta().getDisplayName();
					
					plugin.getConfig().set(player.getUniqueId().toString() + "." + itemName, null);
					
					return true;
				}
				else {
					
				}
			}
		}
		return true;
	}
}
