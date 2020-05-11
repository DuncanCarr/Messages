package me.garsh1.Test.Join;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.garsh1.Test.Main;
import me.garsh1.Test.Utils.Utils;

public class Join implements Listener {
	
	private static Main plugin;
	
	@SuppressWarnings("static-access")
	public Join(Main plugin) {
		this.plugin = plugin;
	
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}

        @EventHandler
        public void onJoin(PlayerJoinEvent e) {
        	Player p = e.getPlayer();
        	
        	if (!p.hasPlayedBefore()) {
        		e.setJoinMessage(Utils.chat(plugin.getConfig().getString("FirstJoin_Message").replace("<player>", p.getName()))); 
        	} else {
        		e.setJoinMessage(Utils.chat(plugin.getConfig().getString("Join_Message").replace("<player>", p.getName())));
        	}
        }
 }
