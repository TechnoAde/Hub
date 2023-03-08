package it.techonade.hub.utils;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Patterns {

    public static String colorPatterns(String msg) {
        return ChatColor.translateAlternateColorCodes('&',msg);
    }

    public static String hexSupport(String msg) {return null; /* TODO */}

    public static String setPlaceholders(String msg, Player player) {
        msg = PlaceholderAPI.setPlaceholders(player, msg);
        return msg;
    }

}
