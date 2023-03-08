package it.techonade.hub.nms;

import it.techonade.hub.Main;
import it.techonade.hub.utils.Patterns;
import net.minecraft.network.chat.IChatBaseComponent;
import net.minecraft.network.protocol.game.PacketPlayOutPlayerListHeaderFooter;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_19_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TabManager {

    private final List<String> header = new ArrayList<>(Main.plugin.getConfig().getStringList("tab.header"));
    private final List<String> footer = new ArrayList<>(Main.plugin.getConfig().getStringList("tab.footer"));

    public TabManager(Main plugin) {

    }

    public void showTab(Player player) {
        if (header.isEmpty() && footer.isEmpty()) {Bukkit.getLogger().info("tab.footer e tab.headers non trovati");}

        IChatBaseComponent up = IChatBaseComponent.ChatSerializer.a(Patterns.setPlaceholders(Patterns.colorPatterns("{\"text\": \"" + String.join("\n", header) + "\"}"), player));
        IChatBaseComponent down = IChatBaseComponent.ChatSerializer.a(Patterns.setPlaceholders(Patterns.colorPatterns("{\"text\": \"" + String.join("\n", footer) + "\"}"), player));

        PacketPlayOutPlayerListHeaderFooter tabPacket = new PacketPlayOutPlayerListHeaderFooter(up, down);

        ((CraftPlayer) player).getHandle().b.a(tabPacket);
    }

}
