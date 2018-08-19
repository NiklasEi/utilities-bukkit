package me.nikl.inventories.button;

import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

/**
 * @author Niklas Eicker
 */
public class EmptyIconButton extends EasyButton {

    public EmptyIconButton(ItemStack icon) {
        super(icon);
    }

    @Override
    public boolean onClick(InventoryClickEvent event) {
        return true;
    }
}
