package kass.perez.itemframeshop;

import org.bukkit.configuration.file.FileConfiguration;

public class Configuration {
	
	protected static void loadConfiguration() {
		FileConfiguration c = Plugin.getInstance().getConfig();

		c.options().copyDefaults(true);
		Plugin.getInstance().saveConfig();
	}
}
