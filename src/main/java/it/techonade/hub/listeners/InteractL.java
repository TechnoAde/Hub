package it.techonade.hub.listeners;

import it.techonade.hub.Main;
import it.techonade.hub.items.ItemsL;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class InteractL implements Listener {

    @EventHandler
    public void itemHeldInteract(PlayerInteractEvent e) {
        if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            if(e.getItem() != null) {
                if(e.getItem().hasItemMeta() && e.getItem().getItemMeta().hasDisplayName()) {
                    if(e.getItem().getItemMeta().getDisplayName().equals(Main.plugin.getConfig().getString("playerhider.showtitle"))) {
                        e.getPlayer().getInventory().setItem(8, ItemsL.PLAYER_HIDED.getItem());
                        Bukkit.getOnlinePlayers().stream().filter(p -> !p.equals(e.getPlayer())).forEach(e.getPlayer()::hidePlayer);
                    } else if(e.getItem().getItemMeta().getDisplayName().equals(Main.plugin.getConfig().getString("playerhider.hidetitle"))) {
                        e.getPlayer().getInventory().setItem(8, ItemsL.PLAYER_SHOWED.getItem());
                        Bukkit.getOnlinePlayers().stream().filter(p -> !p.equals(e.getPlayer())).forEach(e.getPlayer()::showPlayer);
                    }
                }
            }
        }
    }

    @EventHandler
    public void itemOnInv(InventoryClickEvent e) {
        e.setCancelled(true);
    }

}
