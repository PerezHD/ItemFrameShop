package me.perezhd.kassestral.bishop.files;

import me.perezhd.kassestral.bishop.Plugin;

import org.bukkit.configuration.file.FileConfiguration;

public class Configuration {
	
	
	public static void loadConfiguration() {
		FileConfiguration c = Plugin.getInstance().getConfig();

		c.options().copyDefaults(true);
		Plugin.getInstance().saveConfig();
	}

}
