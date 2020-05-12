package me.garsh1.Test;

import org.bukkit.plugin.java.JavaPlugin;

import me.garsh1.Test.Join.DeathMessage;
import me.garsh1.Test.Join.Join;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		saveDefaultConfig();
		
		new Join(this);
		new DeathMessage(this);
	}

}
