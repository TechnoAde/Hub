package it.techonade.hub.utils;

import it.techonade.hub.Main;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;

public class AutoMessage {

    private static final int MESSAGE_DELAY_SECONDS = 180;
    private static final List<String> MESSAGES = new ArrayList<>(Main.plugin.getConfig().getStringList("messages.repetemessages"));

    public static void AutoMessageU() {
        if(MESSAGES.isEmpty()) {return;}
        new BukkitRunnable() {
            int index = 0;
            @Override
            public void run() {
                Bukkit.broadcastMessage(MESSAGES.get(index));
                index++;
                if (index == MESSAGES.size()) {
                    index = 0;
                }
            }
        }.runTaskTimerAsynchronously(Main.plugin, MESSAGE_DELAY_SECONDS * 20L, MESSAGE_DELAY_SECONDS * 20L);
    }
}
