package me.nikl.inventories.button;

import me.nikl.inventories.Button;
import me.nikl.inventories.Inventory;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

/**
 * @author Niklas Eicker
 */
public abstract class EasyButton implements Button {
    protected ItemStack icon = new ItemStack(Material.BIRCH_BUTTON);
    private Inventory parent;
    private int slot;

    public EasyButton() {};

    public EasyButton(ItemStack icon) {
        this.icon = icon;
    }

    @Override
    public Inventory getParent() {
        return parent;
    }

    @Override
    public void setParent(Inventory parent) {
        this.parent = parent;
    }

    @Override
    public int getSlot() {
        return slot;
    }

    @Override
    public void setSlot(int slot) {
        this.slot = slot;
    }

    @Override
    public ItemStack getIcon() {
        return icon;
    }
}
