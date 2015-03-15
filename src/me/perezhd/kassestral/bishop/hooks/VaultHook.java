package me.perezhd.kassestral.bishop.hooks;

import java.text.DecimalFormat;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;

import me.perezhd.kassestral.bishop.Plugin;
import me.perezhd.kassestral.bishop.utils.Util;
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
    
    public String commas(double amount){
    	DecimalFormat formatter = new DecimalFormat("#,###.00");
    	String number = formatter.format(amount);
    	return number;
    }
}
