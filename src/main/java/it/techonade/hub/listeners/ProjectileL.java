package it.techonade.hub.listeners;

import it.techonade.hub.Main;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.spigotmc.event.entity.EntityDismountEvent;

public class ProjectileL implements Listener {

    private final Main plugin;

    public ProjectileL(Main plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void pLaunch(EntitySpawnEvent e) {
        if(e.getEntity() instanceof Projectile && e.getEntity() instanceof EnderPearl) {
            final Projectile projectile = (Projectile) e.getEntity();
            final Player shooter = (Player) projectile.getShooter();
            if(shooter != null) {projectile.setPassenger(shooter);}
        }
    }

    @EventHandler
    public void pDismount(EntityDismountEvent e) {
        if(e.getDismounted() instanceof Projectile && e.getDismounted() instanceof EnderPearl) {
            EnderPearl enderPearl = (EnderPearl) e.getDismounted();
            enderPearl.remove();
        }
    }

}
