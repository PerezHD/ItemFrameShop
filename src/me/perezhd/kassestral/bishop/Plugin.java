package me.perezhd.kassestral.bishop;

import java.util.logging.Level;

import me.perezhd.kassestral.bishop.commands.PluginCommandHandler;
import me.perezhd.kassestral.bishop.files.DataStorage;
import me.perezhd.kassestral.bishop.files.MessageStorage;
import me.perezhd.kassestral.bishop.hooks.VaultHook;
import me.perezhd.kassestral.bishop.listeners.EventListeners;
import me.perezhd.kassestral.bishop.listeners.PlayerListeners;
import me.perezhd.kassestral.bishop.utils.Util;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Plugin extends JavaPlugin {
	
	public static Plugin plugin;
	
	public DataStorage storage = new DataStorage();
	public MessageStorage message_storage = new MessageStorage();
	public VaultHook vault = new VaultHook(this);

	@Override
	public void onEnable() {
		plugin = this;
		Util.log(Level.INFO, "----------------------------");
		Util.log(Level.INFO, "ItemFrameShop v" + getDescription().getVersion() + " is enabling!");
		Util.log(Level.INFO, "By " + getDescription().getAuthors());
		Util.log(Level.INFO, "----------------------------");
		registerCommands();
		registerEvents();
		
		/*
		 * Loads the main files in the dataFolder.
		 */
		storage.setupFile();
		message_storage.setupFile();
		/*
		 * Hooks
		 */
		
		vault.hook();
	}

	public void onDisable() {
		plugin = null;
		Util.log(Level.INFO, "----------------------------");
		Util.log(Level.INFO, "ItemFrameShop v" + getDescription().getVersion() + " is disabling!");
		Util.log(Level.INFO, "By " + getDescription().getAuthors());
		Util.log(Level.INFO, "----------------------------");
	}

	public void registerCommands() {
		getCommand("ifs").setExecutor(new PluginCommandHandler());
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
