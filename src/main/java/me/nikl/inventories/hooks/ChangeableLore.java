package me.nikl.inventories.hooks;

import java.util.List;

/**
 * @author Niklas Eicker
 */
public interface ChangeableLore {
    void updateLore(List<String> lore);
}
