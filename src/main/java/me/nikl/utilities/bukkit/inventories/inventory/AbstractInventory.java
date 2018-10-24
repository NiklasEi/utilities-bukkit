package me.nikl.utilities.bukkit.inventories.inventory;

import me.nikl.utilities.bukkit.inventories.Inventory;
import me.nikl.utilities.bukkit.inventories.InventoryListener;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.Plugin;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Niklas Eicker
 */
public abstract class AbstractInventory implements Inventory {
    private static Map<String, Set<Inventory>> inventoryGroups = new HashMap<>();
    private static Map<String, InventoryListener> listeners = new HashMap<>();

    public static boolean isInGroup(String groupID, Player player) {
        if (!inventoryGroups.keySet().contains(groupID)) return false;
        for (Inventory inventory : inventoryGroups.get(groupID)) {
            if (inventory.isOpen(player)) return true;
        }
        return false;
    }

    public static Inventory getInventoryFromGroup(String groupID, Player player) {
        if (!inventoryGroups.keySet().contains(groupID)) throw new IllegalArgumentException("Unknown groupID '" + groupID + "'");
        for (Inventory inventory : inventoryGroups.get(groupID)) {
            if (inventory.isOpen(player)) return inventory;
        }
        throw new IllegalArgumentException("Player is not user in group " + groupID);
    }

    public static void registerGroup(Plugin plugin) {
        registerGroup(plugin, plugin.getName());
    }

    public static void registerGroup(Plugin plugin, String groupID) {
        InventoryListener previous = listeners.get(groupID);
        if (previous != null) HandlerList.unregisterAll(previous);
        listeners.put(groupID, new InventoryListener(plugin));
        registerGroup(groupID);
    }

    private static void registerGroup(String groupID) {
        inventoryGroups.put(groupID, new HashSet<>());
    }

    protected void registerInventory(Inventory inventory, String groupID) {
        if (!inventoryGroups.keySet().contains(groupID)) throw new IllegalArgumentException("Group " + groupID + " is not registered!");
        inventoryGroups.get(groupID).add(inventory);
    }

    /**
     * Get all inventories belonging to a group
     * @param groupID group identifier
     * @return collection of Inventories
     */
    public Set<Inventory> getGroup(String groupID) {
        Set<Inventory> toReturn = inventoryGroups.get(groupID);
        if (toReturn == null) throw new IllegalArgumentException("Unknown group " + groupID);
        return toReturn;
    }
}
