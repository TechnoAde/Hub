package it.techonade.hub.items;

import it.techonade.hub.Main;
import it.techonade.hub.utils.Patterns;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.Collections;
import java.util.Objects;

public enum ItemsL {
    PLAYER_HIDED(new ItemBuilder(Material.BLACK_DYE,
            1, (short) 0, Patterns.colorPatterns(Objects.requireNonNull(Main.plugin.getConfig().getString("playerhider.hidetitle"))), Collections.emptyList()).create()),
    PLAYER_SHOWED(new ItemBuilder(Material.LIGHT_BLUE_DYE,
            1, (short) 0, Patterns.colorPatterns(Objects.requireNonNull(Main.plugin.getConfig().getString("playerhider.showtitle"))), Collections.emptyList()).create()),
    ENDERBUTT(new ItemBuilder(Material.ENDER_PEARL, 1, (short) 0, Patterns.colorPatterns(Objects.requireNonNull(Main.plugin.getConfig().getString("enderbutt.title"))), Collections.emptyList()).create());

    private final ItemStack itemStack;

    ItemsL(ItemStack itemStack) {this.itemStack = itemStack;}

    public ItemStack getItem() {
        return itemStack;
    }
}
