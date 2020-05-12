package me.garsh1.Test.Join;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import me.garsh1.Test.Main;
import me.garsh1.Test.Utils.Utils;

public class DeathMessage implements Listener {
	
	    private static Main plugin;

		@SuppressWarnings("static-access")
		public DeathMessage (Main plugin) {
        	this.plugin = plugin;
        	
        	Bukkit.getPluginManager().registerEvents(this, plugin);
        }
        
        @EventHandler
        public void onPlayerDeath(PlayerDeathEvent e) {
        	if (e.getEntity().getKiller() instanceof Player) {
        		Player killer = e.getEntity().getKiller();
        		Player p = e.getEntity();
        		Boolean a = plugin.getConfig().getBoolean("Send_Killer_Message");
        		Boolean b = plugin.getConfig().getBoolean("Send_Death_Message");
        		if (p != killer) {
        		if (a == true) {
        		killer.sendMessage(Utils.chat(plugin.getConfig().getString("Killer_Message").replace("<DeadPlayer>", p.getDisplayName())));
        		}
        		if (b == true) {
        		p.sendMessage(Utils.chat(plugin.getConfig().getString("Death_Message").replace("<Killer>", killer.getDisplayName())));
        		}
        		}
        	}
        	return;
        }
}
