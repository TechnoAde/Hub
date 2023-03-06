package it.techonade.hub.listeners;

import it.techonade.hub.Main;
import it.techonade.hub.items.ItemsL;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class InteractL implements Listener {

    private final Main plugin;

    public InteractL(Main plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void itemHeldInteract(PlayerInteractEvent e) {
        if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            if(e.getItem() != null) {
                if(e.getItem().hasItemMeta() && e.getItem().getItemMeta().hasDisplayName()) {
                    final String showtitle = plugin.getConfig().getString("playerhider.showtitle");
                    final String hidetitle = plugin.getConfig().getString("playerhider.hidetitle");
                    final String enderbutttitle = plugin.getConfig().getString("enderbutt.title");
                    if(showtitle != null && hidetitle != null && enderbutttitle != null) {
                        if(e.getItem().getItemMeta().getDisplayName().equals(showtitle.replaceAll("&", "§"))) {
                            e.getPlayer().getInventory().setItem(8, ItemsL.PLAYER_HIDED.getItem());
                            Bukkit.getOnlinePlayers().stream().parallel().filter(p -> !p.equals(e.getPlayer())).forEach(e.getPlayer()::hidePlayer);
                        } else if(e.getItem().getItemMeta().getDisplayName().equals(hidetitle.replaceAll("&", "§"))) {
                            e.getPlayer().getInventory().setItem(8, ItemsL.PLAYER_SHOWED.getItem());
                            Bukkit.getOnlinePlayers().stream().parallel().filter(p -> !p.equals(e.getPlayer())).forEach(e.getPlayer()::showPlayer);
                        } else if(e.getItem().getItemMeta().getDisplayName().equals(enderbutttitle.replaceAll("&", "§"))) {
                            Bukkit.getScheduler().runTaskLater(plugin, () -> e.getPlayer().getInventory().setItem(6, ItemsL.ENDERBUTT.getItem()), 1);
                        }
                    } else {
                        Bukkit.getLogger().info("Il titolo è vuoto");
                    }
                }
            }
        }
    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent e) {if(!e.getPlayer().hasPermission("admin.bypass.dropblock")) {e.setCancelled(true);}}

    @EventHandler
    public void itemOnInv(InventoryClickEvent e) {if(!e.getWhoClicked().hasPermission("admin.bypass.invblock")) {e.setCancelled(true);}}

}
