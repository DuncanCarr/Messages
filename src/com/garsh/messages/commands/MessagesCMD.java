package com.garsh.messages.commands;

import com.garsh.messages.MessagesPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class MessagesCMD implements CommandExecutor {

    private final MessagesPlugin plugin = JavaPlugin.getPlugin(MessagesPlugin.class);

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender.hasPermission("messages.reload")) {
            plugin.saveConfig();
            plugin.reloadConfig();
            commandSender.sendMessage(plugin.colorize("&aSuccessfully reloaded the configuration file!"));
        } else {
            commandSender.sendMessage(plugin.colorize("&cYou do not have permission to use this command!"));
        }

        return true;
    }
}
