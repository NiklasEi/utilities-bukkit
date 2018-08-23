package me.nikl.inventories.button;

import me.nikl.inventories.Button;
import me.nikl.inventories.Inventory;
import me.nikl.inventories.hooks.ChangeableIcon;
import me.nikl.inventories.hooks.ChangeableLore;
import me.nikl.inventories.hooks.ChangeableName;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

/**
 * @author Niklas Eicker
 */
public abstract class EasyButton implements Button, ChangeableLore, ChangeableName, ChangeableIcon {
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

    @Override
    public void updateLore(List<String> list) {
        ItemMeta meta = icon.getItemMeta();
        meta.setLore(list);
        icon.setItemMeta(meta);
        getParent().update(getSlot());
    }

    @Override
    public void updateName(String name) {
        ItemMeta meta = icon.getItemMeta();
        meta.setDisplayName(name);
        icon.setItemMeta(meta);
        getParent().update(getSlot());
    }

    @Override
    public void updateIcon(ItemStack icon) {
        this.icon = icon;
        getParent().update(getSlot());
    }
}
