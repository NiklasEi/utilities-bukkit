package me.nikl.inventories.inventory;

import me.nikl.inventories.Button;
import me.nikl.inventories.Inventory;
import org.apache.commons.lang.Validate;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryType;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Niklas Eicker
 */
public class EasyInventory extends AbstractInventory {
    private org.bukkit.inventory.Inventory bukkitInventory;
    private Set<Player> users = new HashSet<>();
    private Map<Integer, Button> buttons = new HashMap<>();

    public EasyInventory(String groupID, InventoryType inventoryType) {
        this(groupID, inventoryType, "");
    }

    public EasyInventory(String groupID, InventoryType inventoryType, String title) {
        Validate.notNull(inventoryType, "The inventory type cannot be null");
        Validate.notNull(title, "The title cannot be null");
        this.bukkitInventory = Bukkit.createInventory(this, inventoryType, title);
        registerInventory(this, groupID);
    }

    public EasyInventory(String groupID, int size) {
        this(groupID, size, "");
    }

    public EasyInventory(String groupID, int size, String title) {
        Validate.isTrue(size > 0, "Inventory size has to be larger then 0");
        Validate.notNull(title, "The title cannot be null");
        this.bukkitInventory = Bukkit.createInventory(this, size, title);
        registerInventory(this, groupID);
    }

    @Override
    public void open(Player player) {
        users.add(player);
        player.openInventory(bukkitInventory);
    }

    @Override
    public boolean isOpen(Player player) {
        return users.contains(player);
    }

    @Override
    public void addButtons(Button... buttons) {
        for (Button button : buttons) {
            bukkitInventory.setItem(button.getSlot(), button.getIcon());
            this.buttons.put(button.getSlot(), button);
        }
    }

    @Override
    public org.bukkit.inventory.Inventory getBukkitInventory() {
        return bukkitInventory;
    }

    @Override
    public void onInventoryClick(InventoryClickEvent event) {
        Button button;
        if ((button = buttons.get(event.getSlot())) == null) return;
        button.onClick(event);
    }

    @Override
    public void onInventoryClose(InventoryCloseEvent event) {
        users.remove((Player)event.getPlayer());
    }

    @Override
    public org.bukkit.inventory.Inventory getInventory() {
        return null;
    }
}
