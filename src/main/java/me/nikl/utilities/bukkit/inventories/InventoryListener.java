package me.nikl.utilities.bukkit.inventories;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.plugin.Plugin;

/**
 * @author Niklas Eicker
 */
public class InventoryListener implements Listener {
    private Plugin plugin;

    public InventoryListener(Plugin plugin) {
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        org.bukkit.inventory.Inventory inventory = event.getInventory();
        if (inventory == null) return;
        if (!(inventory.getHolder() instanceof InventoryHolder)) return;
        event.setCancelled(true);
        ((InventoryHolder)inventory.getHolder()).onInventoryClick(event);
    }

    @EventHandler
    public void onClose(InventoryCloseEvent event) {
        org.bukkit.inventory.Inventory inventory = event.getInventory();
        if (inventory == null) return;
        if (!(inventory.getHolder() instanceof InventoryHolder)) return;
        ((InventoryHolder)inventory.getHolder()).onInventoryClose(event);
    }
}
