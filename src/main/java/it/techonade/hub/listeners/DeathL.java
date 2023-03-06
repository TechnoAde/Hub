package it.techonade.hub.listeners;

import it.techonade.hub.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class DeathL implements Listener {

    public DeathL(Main plugin) {plugin.getServer().getPluginManager().registerEvents(this, plugin);}

    @EventHandler
    public void onDeath(EntityDamageEvent e) {if(e.getCause().equals(EntityDamageEvent.DamageCause.FALL)) {e.setCancelled(true);}}

    @EventHandler
    public void lessHunger(FoodLevelChangeEvent e) {Player p = (Player) e.getEntity();e.setFoodLevel(p.getFoodLevel());}

}
