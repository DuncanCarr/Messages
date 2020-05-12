package com.garsh.messages.events;

import com.garsh.messages.MessagesPlugin;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class DeathEvent implements Listener {

		// References MessagesPlugin (Main) class without having to call anything in the constructor.
	    private final MessagesPlugin plugin = JavaPlugin.getPlugin(MessagesPlugin.class);
        
        @EventHandler
        public void onPlayerDeath(PlayerDeathEvent e) {
        	// Checking if the killer was a player isn't necessary, but you should check to see if the killer is null. Killer already returns a variable of the type Player.
        	if (e.getEntity().getKiller() != null) {

        		// Assign a boolean variable to be able to easily check if they want to send the death message.
        		boolean message = plugin.getConfig().getBoolean("SEND_DEATH_MESSAGE");

        		// You can simplify booleans to look like this. This means if message == true, but it's much shorter.
        		if (message) {
					// Use {} for configuration variables. You don't want to query for the message unless the server actually wants the message sent!
					String deathMessage = plugin.getConfig().getString("DEATH_MESSAGE").replace("{DIED}", e.getEntity().getName().replace("{KILLER}", e.getEntity().getKiller().getName()));

					// Loop through all online players, and send them a message.
        			for (Player online : Bukkit.getOnlinePlayers()) {
        				online.sendMessage(plugin.colorize(deathMessage));
					}
				}
        	}
		}
}
