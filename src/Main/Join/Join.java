package Main.Join;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

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
        @EventHandler
        public void onQuit(PlayerQuitEvent f) {
        	Player p2 = f.getPlayer();
        	Boolean a = plugin.getConfig().getBoolean("Send_Quit_Message");
			
        	if (a == true) {
        		f.setQuitMessage(Utils.chat(plugin.getConfig().getString("Quit_Message").replace("<player>", p2.getName()))); 
        	} else {
        		f.setQuitMessage("");
        	}
        	        
        	}
 	}
