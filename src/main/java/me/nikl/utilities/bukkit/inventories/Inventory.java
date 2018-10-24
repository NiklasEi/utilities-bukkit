package me.nikl.utilities.bukkit.inventories;

import org.bukkit.entity.Player;

/**
 * @author Niklas Eicker
 */
public interface Inventory extends InventoryHolder {
    void open(Player player);
    boolean isOpen(Player player);
    void addButtons(Button button, Button... buttons);
    void addButton(int slot, Button button);
    void update(int slot);
    org.bukkit.inventory.Inventory getBukkitInventory();
    void clear();
}
