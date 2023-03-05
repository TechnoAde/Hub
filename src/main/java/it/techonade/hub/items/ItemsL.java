package it.techonade.hub.items;

import it.techonade.hub.Main;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.Collections;

public enum ItemsL {
    PLAYER_HIDED(new ItemBuilder(Material.BLACK_DYE,
            1, (short) 0, Main.plugin.getConfig().getString("playerhider.hidetitle") != null ? ChatColor.translateAlternateColorCodes('&', Main.plugin.getConfig().getString("playerhider.hidetitle")) : "Null",
            Collections.emptyList()).create()),
    PLAYER_SHOWED(new ItemBuilder(Material.LIGHT_BLUE_DYE,
            1, (short) 0, Main.plugin.getConfig().getString("playerhider.showtitle") != null ? ChatColor.translateAlternateColorCodes('&', Main.plugin.getConfig().getString("playerhider.showtitle")) : "Null",
            Collections.emptyList()).create()),
    ENDERBUTT(new ItemBuilder(Material.ENDER_PEARL, 1, (short) 0, Main.plugin.getConfig().getString("playerhider.showtitle") != null ? ChatColor.translateAlternateColorCodes('&', Main.plugin.getConfig().getString("enderbutt.name")) : "Null", Collections.emptyList()).create());

    private final ItemStack itemStack;

    ItemsL(ItemStack itemStack) {this.itemStack = itemStack;}

    public ItemStack getItem() {
        return itemStack;
    }
}
