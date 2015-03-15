package src.me.perezhd.kassestral.bishop;

import me.perezhd.kassestral.bishop.Plugin;

import org.bukkit.configuration.file.FileConfiguration;

public class Configuration {
	
	protected static void loadConfiguration() {
		FileConfiguration c = Plugin.getInstance().getConfig();

		c.options().copyDefaults(true);
		Plugin.getInstance().saveConfig();
	}
}
