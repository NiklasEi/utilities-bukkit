package me.nikl.utilities.bukkit.inventories.hooks;

import org.bukkit.inventory.ItemStack;

/**
 * @author Niklas Eicker
 */
public interface ChangeableIcon {
    void updateIcon(ItemStack icon);
}
