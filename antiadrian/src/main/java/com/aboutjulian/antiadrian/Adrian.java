package com.aboutjulian.antiadrian;

import java.util.List;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Adrian implements Listener {
    // Define the mutedplayers list as a field of the Adrian class
    private List<String> mutedplayers = Plugin.getList();

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e) {
        if (e.getPlayer().getName().equals("De_Phoenyx")) {
            String message = e.getMessage();
            if (message.equalsIgnoreCase("hi") || message.equalsIgnoreCase("bm") || message.equalsIgnoreCase("bb")) {
                e.setCancelled(true);
                e.getPlayer().sendMessage("Du dummer Nuttensohn keiner mag dich und du stinkst nach Scheiße!");
                // Add the player to the list of muted players
                mutedplayers.add(e.getPlayer().getName());
            }
        }

        // Check if the player is in the list of muted players
        if (mutedplayers.contains(e.getPlayer().getName())) {
            e.setCancelled(true);
        }
    }
}
