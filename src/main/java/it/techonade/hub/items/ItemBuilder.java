package it.techonade.hub.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;
import java.util.stream.Collectors;

public class ItemBuilder {

    private final Material material;
    private final short id;
    private final int amount;
    private final String title;
    private final List<String> lore;

    public ItemBuilder(Material material, int amount, short id, String title, List<String> lore) {
        this.material = material;
        this.id = id;
        this.amount = amount;
        this.title = title;
        this.lore = lore;
    }

    public ItemStack create() {
        ItemStack itemStack = new ItemStack(material, amount, id);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', title));
        itemMeta.setLore(lore.stream().map(s -> ChatColor.translateAlternateColorCodes('&', s)).collect(Collectors.toList()));
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

}
