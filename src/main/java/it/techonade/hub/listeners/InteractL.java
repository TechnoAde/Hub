package it.techonade.hub.listeners;

import it.techonade.hub.Main;
import it.techonade.hub.items.ItemsL;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
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
                if(e.getItem().equals(ItemsL.PLAYER_SHOWED.getItem())) {
                    e.getPlayer().getInventory().setItem(8, ItemsL.PLAYER_HIDED.getItem());
                    for(Player p : Bukkit.getOnlinePlayers()) {p.hidePlayer(Main.getInstance(), p);}
                } else {
                    e.getPlayer().getInventory().setItem(8, ItemsL.PLAYER_SHOWED.getItem());
                    for(Player p : Bukkit.getOnlinePlayers()) {p.showPlayer(Main.getInstance(), p);}
                }
            }
        }
    }

    @EventHandler
    public void itemOnInv(InventoryClickEvent e) {
        e.setCancelled(true);
    }

}
