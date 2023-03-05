package it.techonade.hub.listeners;

import it.techonade.hub.Main;
import it.techonade.hub.items.ItemsL;
import it.techonade.hub.nms.BookPacket;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEditBookEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinL implements Listener {

    private final Main plugin;
    private final BookPacket bookPacket;

    public JoinL(Main plugin, BookPacket bookPacket) {
        this.plugin = plugin;
        this.bookPacket = bookPacket;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void joinA(PlayerJoinEvent e) {
        bookPacket.openBook(e.getPlayer());
        if(plugin.getConfig().getString("message.joinbc") != null) Bukkit.broadcastMessage(plugin.getConfig().getString("message.joinbc")); else Bukkit.getLogger().info("message.joinbc non è stato definito");
        if(plugin.getConfig().getString("message.privatemsg") != null) plugin.getConfig().getStringList("message.privatemsg").forEach(t -> e.getPlayer().sendMessage(t));
        e.getPlayer().getInventory().setItem(8, ItemsL.PLAYER_SHOWED.getItem());
    }

    @EventHandler
    public void bookEditBlock(PlayerEditBookEvent e) {
        e.setCancelled(true);
    }

}
