package it.techonade.hub.items;

import it.techonade.hub.Main;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.Collections;

public enum ItemsL {
    PLAYER_HIDED(new ItemBuilder(Material.RED_STAINED_GLASS_PANE, 1, (short) 0, Main.getInstance().getConfig().getString("playerhider.showtitle"), Collections.emptyList()).create()),
    PLAYER_SHOWED(new ItemBuilder(Material.RED_STAINED_GLASS_PANE, 1, (short) 0, Main.getInstance().getConfig().getString("playerhider.hidetitle"), Collections.emptyList()).create());

    private final ItemStack itemStack;

    ItemsL(ItemStack itemStack) {this.itemStack = itemStack;}

    public ItemStack getItem() {
        return itemStack;
    }
}
