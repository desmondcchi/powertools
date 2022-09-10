package me.desmondcchi.powertools.commands;

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
	
	public Powertool(Plugin plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("powertool") || label.equalsIgnoreCase("pt")) {
			Player player = (Player) sender;
			if (sender instanceof Player) {
				if (args.length == 0) {
					ItemStack item = player.getInventory().getItemInMainHand();
					String itemName = item.getType().name();
					
					plugin.getConfig().set(player.getUniqueId().toString() + "." + itemName, null);
					plugin.saveConfig();
					
					player.spigot().sendMessage(ChatMessageType.ACTION_BAR, 
							new TextComponent(ChatColor.GOLD + "Powertool reset!"));
					
					return true;
				}
				else {
					ItemStack item = player.getInventory().getItemInMainHand();
					String itemName = item.getType().name();
					
					String powertoolCommand = "";
					for (int i = 0; i < args.length; ++i) {
						powertoolCommand += args[i];
						
						if (i != args.length - 1) {
							powertoolCommand += " ";
						}
					}
					
					plugin.getConfig().set(player.getUniqueId().toString() + "." + itemName, powertoolCommand);
					plugin.saveConfig();
					
					player.spigot().sendMessage(ChatMessageType.ACTION_BAR,
							new TextComponent(ChatColor.AQUA + "Powertool set!"));
				}
			}
		}
		return true;
	}
}
