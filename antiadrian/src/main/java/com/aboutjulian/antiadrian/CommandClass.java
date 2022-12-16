package com.aboutjulian.antiadrian;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandClass implements CommandExecutor {

    List<String> TmutedPlayers = Plugin.getList();

    

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            // Check if the player has the aa.admin permission or is an admin
            if (player.hasPermission("aa.admin") || player.isOp()) {
                // Check if the player typed /aa remove <username>
                if (command.getName().equals("aa") && args.length == 2 && args[0].equals("remove")) {
                    // Remove the player from the list of muted players
                    TmutedPlayers.remove(args[1]);
                    player.sendMessage("Removed " + args[1] + " from the list of muted players");
                    return true;
                }

                if (command.getName().equals("aa") && args.length == 2 && args[0].equals("add")) {
                    TmutedPlayers.add(args[1]);
                    player.sendMessage("Added " + args[1] + " to the list of muted players");
                }
            }
        }
        return false;
    }

}
