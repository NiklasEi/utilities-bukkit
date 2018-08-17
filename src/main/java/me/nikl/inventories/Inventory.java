package me.nikl.inventories;

import org.bukkit.entity.Player;

/**
 * @author Niklas Eicker
 */
public interface Inventory extends InventoryHolder {
    void open(Player player);
    boolean isOpen(Player player);
    void addButtons(Button... button);
    org.bukkit.inventory.Inventory getBukkitInventory();
}
