package kass.perez.itemframeshop;

import java.util.logging.Level;

import kass.perez.itemframeshop.listeners.EventListeners;
import kass.perez.itemframeshop.listeners.PlayerListeners;
import kass.perez.itemframeshop.utils.Util;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Plugin extends JavaPlugin {
	
	public static Plugin plugin;
	
	public DataStorage storage = new DataStorage();

	@Override
	public void onEnable() {
		plugin = this;
		Util.log(Level.INFO, "----------------------------");
		Util.log(Level.INFO, "Bishop v" + getDescription().getVersion() + " is enabling!");
		Util.log(Level.INFO, "By " + getDescription().getAuthors());
		Util.log(Level.INFO, "----------------------------");
		registerCommands();
		registerEvents();
		
		storage.setupFile();
	}

	public void onDisable() {
		plugin = null;
		Util.log(Level.INFO, "----------------------------");
		Util.log(Level.INFO, "Bishop v" + getDescription().getVersion() + " is disabling!");
		Util.log(Level.INFO, "By " + getDescription().getAuthors());
		Util.log(Level.INFO, "----------------------------");
	}

	public void registerCommands() {
		
	}

	public void registerEvents() {
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new EventListeners(), this);
		pm.registerEvents(new PlayerListeners(), this);
	}

	public static Plugin getInstance() {
		return plugin;
	}
}
