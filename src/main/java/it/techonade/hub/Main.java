package it.techonade.hub;

import it.techonade.hub.listeners.JoinL;
import it.techonade.hub.nms.BookPacket;
import it.techonade.hub.utils.AutoMessage;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    public static Main plugin;
    private final BookPacket bookPacket = new BookPacket(this);

    @Override
    public void onEnable() {
        plugin = this;
        new JoinL(this, bookPacket);
        AutoMessage.AutoMessageU();
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
    }

    public static Main getInstance() {
        return plugin;
    }
    
}
