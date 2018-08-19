package me.nikl.inventories;

import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

/**
 * @author Niklas Eicker
 */
public interface Button {
    boolean onClick(InventoryClickEvent event);
    Inventory getParent();
    void setParent(Inventory parent);
    int getSlot();
    void setSlot(int slot);
    ItemStack getIcon();
}
