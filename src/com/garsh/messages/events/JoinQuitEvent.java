package com.garsh.messages.events;

import com.garsh.messages.MessagesPlugin;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class JoinQuitEvent implements Listener {
	
	private final MessagesPlugin plugin = JavaPlugin.getPlugin(MessagesPlugin.class);

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		// This is good. We want a player variable as we will be referencing this multiple times, and it will make it much simpler!
		Player p = e.getPlayer();

		// Assign a boolean variable to each of these values to make access easier.
		boolean sendFirstJoin = plugin.getConfig().getBoolean("SEND_FIRST_JOIN");
		boolean sendJoin = plugin.getConfig().getBoolean("SEND_JOIN");

		// if(sendFirstJoin == true) {}, but simpler
		if (sendFirstJoin) {
			// Loop through all online players
			for (Player online : Bukkit.getOnlinePlayers()) {
				online.sendMessage(plugin.colorize(plugin.getConfig().getString("FIRST_JOIN_MESSAGE").replace("{PLAYER}", p.getName())));
			}
		}

		// if(sendJoin == true) {}, but simpler
		if (sendJoin) {
			// Loop through all online players
			for (Player online : Bukkit.getOnlinePlayers()) {
				online.sendMessage(plugin.colorize(plugin.getConfig().getString("JOIN_MESSAGE").replace("{PLAYER}", p.getName())));
			}
		}
	}

	// These events are part of different constructors, so you can have the same variables.
	// This essentially works the same as the above one, so look at it's comments for information.
	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		Player p = e.getPlayer();

        boolean sendQuit = plugin.getConfig().getBoolean("SEND_QUIT");

        if (sendQuit) {
        	for (Player online : Bukkit.getOnlinePlayers()) {
        		online.sendMessage(plugin.colorize(plugin.getConfig().getString("QUIT_MESSAGE").replace("{PLAYER}", p.getName())));
			}
		}
	}
}
