package me.nikl.utilities.bukkit.inventories;

import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

/**
 * @author Niklas Eicker
 */
public interface Button {

    /**
     * Method called when button is clicked
     * @param event ClickEvent of the click
     * @return success
     */
    boolean onClick(InventoryClickEvent event);

    /**
     * Method called before the button is rendered.
     *
     * Here the icon, or slot can be changed, before the button
     * is placed in the Inventory.
     */
    void onPreRender();

    /**
     * Method called after the button was rendered.
     *
     * This method can be used to update the lore,
     * or any other property of the button, that can be
     * changed via a hook.
     */
    void onAfterRender();

    /**
     * Return the inventory that holds the button.
     * @return parent {@link Inventory}
     */
    Inventory getParent();

    /**
     * Set the inventory that holds the button.
     * @param  parent {@link Inventory}
     */
    void setParent(Inventory parent);

    /**
     * Get the slot the button is placed in.
     * @return the button's slot
     */
    int getSlot();

    /**
     * Set the slot the button is placed in.
     * @param slot Inventory slot
     */
    void setSlot(int slot);

    /**
     * Get the {@link ItemStack} that represents the button in the Inventory.
     * @return the button's icon
     */
    ItemStack getIcon();
}
