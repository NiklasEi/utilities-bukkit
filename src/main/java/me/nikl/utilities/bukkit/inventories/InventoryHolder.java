package me.nikl.utilities.bukkit.inventories;

import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;

/**
 * @author Niklas Eicker
 *
 * Custom holder for easy handling of events in the inventory
 */
public interface InventoryHolder extends org.bukkit.inventory.InventoryHolder {

    /**
     * Handle a click in the inventory
     *
     * @param event ClickEvent
     */
    void onInventoryClick(InventoryClickEvent event);

    /**
     * Handle an InventoryCloseEvent
     *
     * @param event CloseEvent
     */
    void onInventoryClose(InventoryCloseEvent event);
}
