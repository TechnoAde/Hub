package it.techonade.hub.listeners;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class ProjectileL implements Listener {

    @EventHandler
    public void pLaunch(EntitySpawnEvent e) {
        if(e.getEntity() instanceof Projectile && e.getEntity() instanceof EnderPearl) {
            final Projectile projectile = (Projectile) e.getEntity();
            final Player shooter = (Player) projectile.getShooter();
            if(shooter != null) {projectile.setPassenger(shooter);}
        }
    }

}
