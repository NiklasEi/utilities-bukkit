package me.nikl.inventories;

import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

/**
 * @author Niklas Eicker
 */
public interface Button {
    boolean onClick(InventoryClickEvent event);
    Inventory getParent();
    int getSlot();
    ItemStack getIcon();
}
