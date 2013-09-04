package Alohacraft.MoreCraftables.Main;

import org.bukkit.ChatColor;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.Recipe;



public class PermissionsListener implements Listener {

	private Main plugin;

	//This is your constructor, it's called when you first create the class instance
	public PermissionsListener(Main plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void Craft(CraftItemEvent event) {
		Recipe r = event.getRecipe();
		for (HumanEntity pl : event.getViewers()) {
			Player p = (Player)pl;
			if (plugin.me.containsKey(r)) {
				if (!p.hasPermission("morecraft.mobegg." + plugin.me.get(r))) {
					p.sendMessage(ChatColor.RED + "You don't have permission to make this..");
					event.setCancelled(true);
			} else if (plugin.is.containsKey(r)) {
				if (!p.hasPermission("morecraft.items." + plugin.is.get(r))) {
					p.sendMessage(ChatColor.RED + "You don't have permission to make this..");
					event.setCancelled(true);
			} else if (plugin.bs.containsKey(r)) {
				if (!p.hasPermission("morecraft.blocks." + plugin.bs.get(r))) {
					p.sendMessage(ChatColor.RED + "You don't have permission to make this..");
					event.setCancelled(true);
			} else if (plugin.ar.containsKey(r)) {
				if (!p.hasPermission("morecraft.armor." + plugin.ar.get(r))) {
					p.sendMessage(ChatColor.RED + "You don't have permission to make this..");
					event.setCancelled(true);
			} else if (plugin.ts.containsKey(r)) {
				if (!p.hasPermission("morecraft.tools." + plugin.ts.get(r))) {
					p.sendMessage(ChatColor.RED + "You don't have permission to make this..");
					event.setCancelled(true);
			}
			}
			}
			}
			}
			}
		}
	}
}