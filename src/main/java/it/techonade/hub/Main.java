package it.techonade.hub;

import it.techonade.hub.listeners.DeathL;
import it.techonade.hub.listeners.InteractL;
import it.techonade.hub.listeners.JoinL;
import it.techonade.hub.listeners.ProjectileL;
import it.techonade.hub.nms.BookPacket;
import it.techonade.hub.nms.TabManager;
import it.techonade.hub.utils.AutoMessage;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    public static Main plugin;
    private final BookPacket bookPacket = new BookPacket(this);
    public TabManager tab;

    @Override
    public void onEnable() {
        plugin = this;
        configSetup();
        setupListeners();
        registerTasks();
    }
    private void registerTasks(){
        AutoMessage.AutoMessageU();
    }
    private void setupListeners(){
        tab = new TabManager(this);
        new JoinL(this, bookPacket);
        new InteractL(this);
        new ProjectileL(this);
        new DeathL(this);
    }

    private void configSetup(){
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
        reloadConfig();
    }
    
}
