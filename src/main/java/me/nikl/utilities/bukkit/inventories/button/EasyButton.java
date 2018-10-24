package me.nikl.utilities.bukkit.inventories.button;

import me.nikl.utilities.bukkit.inventories.Button;
import me.nikl.utilities.bukkit.inventories.Inventory;
import me.nikl.utilities.bukkit.inventories.hooks.ChangeableIcon;
import me.nikl.utilities.bukkit.inventories.hooks.ChangeableLore;
import me.nikl.utilities.bukkit.inventories.hooks.ChangeableName;
import org.bukkit.Bukkit;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

/**
 * @author Niklas Eicker
 */
public abstract class EasyButton implements Button, ChangeableLore, ChangeableName, ChangeableIcon {
    protected ItemStack icon;
    private Inventory parent;
    private int slot;

    public EasyButton() {}

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
        Bukkit.getLogger().info("update lore: " + list.toString());
        ItemMeta meta = icon.getItemMeta();
        meta.setLore(list);
        icon.setItemMeta(meta);
        getParent().update(getSlot());
    }

    @Override
    public void updateName(String name) {
        Bukkit.getLogger().info("update name: " + name);
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
