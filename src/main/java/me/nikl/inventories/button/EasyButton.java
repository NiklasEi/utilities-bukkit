package me.nikl.inventories.button;

import me.nikl.inventories.Button;
import me.nikl.inventories.Inventory;
import org.apache.commons.lang.Validate;
import org.bukkit.inventory.ItemStack;

/**
 * @author Niklas Eicker
 */
public abstract class EasyButton implements Button {
    private ItemStack icon;
    private Inventory parent;
    private int slot;

    public EasyButton(Inventory inventory, int slot, ItemStack icon) {
        Validate.notNull(icon, "The icon cannot be null");
        Validate.notNull(inventory, "The inventory cannot be null");
        Validate.isTrue(slot < inventory.getBukkitInventory().getSize(), "The slot " + slot + " is outside the inventory (size " + inventory.getBukkitInventory().getSize() + ")");
        inventory.addButtons(this);
    }

    @Override
    public Inventory getParent() {
        return parent;
    }

    @Override
    public int getSlot() {
        return slot;
    }

    @Override
    public ItemStack getIcon() {
        return icon;
    }
}
