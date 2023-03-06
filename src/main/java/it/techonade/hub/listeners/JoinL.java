package it.techonade.hub.listeners;

import it.techonade.hub.Main;
import it.techonade.hub.items.ItemsL;
import it.techonade.hub.nms.BookPacket;
import it.techonade.hub.utils.Patterns;
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
        if(plugin.getConfig().getString("messages.joinbc") != null || !plugin.getConfig().getString("messages.joinbc").equals("")) Bukkit.broadcastMessage(Patterns.colorPatterns(plugin.getConfig().getString("messages.joinbc").replaceAll("%player%",e.getPlayer().getName()))); else Bukkit.getLogger().info("messages.joinbc non è stato definito");
        if(plugin.getConfig().getString("messages.privatemsg") != null) plugin.getConfig().getStringList("messages.privatemsg").forEach(t -> e.getPlayer().sendMessage(t));
        e.getPlayer().getInventory().setItem(8, ItemsL.PLAYER_SHOWED.getItem());
        e.getPlayer().getInventory().setItem(6, ItemsL.ENDERBUTT.getItem());
        Bukkit.getOnlinePlayers().stream().parallel().filter(p -> p.getInventory().contains(ItemsL.PLAYER_HIDED.getItem())).forEach(p -> p.hidePlayer(plugin,e.getPlayer()));
        Bukkit.getOnlinePlayers().stream().parallel().filter(p -> p.getInventory().contains(ItemsL.PLAYER_SHOWED.getItem())).forEach(p -> p.showPlayer(plugin,e.getPlayer()));
    }

    @EventHandler
    public void bookEditBlock(PlayerEditBookEvent e) {
        e.setCancelled(true);
    }

}
