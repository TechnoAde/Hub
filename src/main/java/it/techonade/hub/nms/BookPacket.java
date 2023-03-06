package it.techonade.hub.nms;

import it.techonade.hub.Main;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

import java.util.Objects;
import java.util.stream.Collectors;

public class BookPacket {

    private final Main plugin;

    public BookPacket(Main plugin) {
        this.plugin = plugin;
    }

    public void openBook(Player p) {
        ItemStack book = new ItemStack(Material.WRITTEN_BOOK, 1);
        BookMeta meta = (BookMeta) book.getItemMeta();
        if (meta != null) {
            meta.setAuthor("ciccio");
            meta.setTitle(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.getConfig().getString("book.title"))));
            meta.setPages(plugin.getConfig().getStringList("book.text").stream().map(s -> org.bukkit.ChatColor.translateAlternateColorCodes('&', s)).collect(Collectors.toList()));
        }
        book.setItemMeta(meta);
        p.openBook(book);
    }

}
