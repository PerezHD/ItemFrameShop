package kass.perez.itemframeshop.hooks;

import java.util.logging.Level;

import kass.perez.itemframeshop.Plugin;
import kass.perez.itemframeshop.utils.Util;

import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;

import net.milkbowl.vault.economy.Economy;

public class VaultHook {
	
	private Plugin plugin;

	public VaultHook(Plugin instance) {
		plugin = instance;
	}
	
    public static Economy econ = null;
	
	public void hook(){
		if (!setupEconomy() ) {
            Util.log(Level.WARNING, String.format("[%s] - Disabled due to no Vault dependency found!", plugin.getDescription().getName()));
            Bukkit.getServer().getPluginManager().disablePlugin(plugin);
            return;
        }
	}
	
    private boolean setupEconomy() {
        if (Bukkit.getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = Bukkit.getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }
}
