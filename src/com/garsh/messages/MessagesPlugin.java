package com.garsh.messages;

import com.garsh.messages.commands.MessagesCMD;
import com.garsh.messages.events.DeathEvent;
import com.garsh.messages.events.JoinQuitEvent;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class MessagesPlugin extends JavaPlugin{

	// This onEnable just contains better ways of doing everything you had done.
	@Override
	public void onEnable() {
		getConfig().options().copyDefaults(true);
		saveConfig();

		getServer().getPluginManager().registerEvents(new DeathEvent(), this);
		getServer().getPluginManager().registerEvents(new JoinQuitEvent(), this);

		// This is an addition which just reloads the configuration file. It's really qutie simple.
		getCommand("messages").setExecutor(new MessagesCMD());
	}

	// The same color code translate method you had, but in the main class, as there is no reason to have an entire Utils class for one function.
	public String colorize(String input) {
		return ChatColor.translateAlternateColorCodes('&', input);
	}

}
