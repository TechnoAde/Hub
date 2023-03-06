package it.techonade.hub.listeners;

import it.techonade.hub.Main;
import it.techonade.hub.utils.Patterns;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Sound;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.spigotmc.event.entity.EntityDismountEvent;

public class ProjectileL implements Listener {

    public ProjectileL(Main plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void pLaunch(EntitySpawnEvent e) {
        if(e.getEntity() instanceof Projectile && e.getEntity() instanceof EnderPearl) {
            final Projectile projectile = (Projectile) e.getEntity();
            final Player shooter = (Player) projectile.getShooter();
            if(shooter != null) {
                if(!shooter.isInsideVehicle()) {
                    projectile.addPassenger(shooter);
                } else {
                    shooter.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(Patterns.colorPatterns(Main.plugin.getConfig().getString("enderbutt.alreadyFlying"))));
                    shooter.playSound(shooter, Sound.ENTITY_VILLAGER_NO, 0.5F, 1F);
                }
            }
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
