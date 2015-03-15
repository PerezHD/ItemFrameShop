package me.perezhd.kassestral.bishop.commands;

import me.perezhd.kassestral.bishop.Plugin;
import me.perezhd.kassestral.bishop.handlers.Permissions;
import me.perezhd.kassestral.bishop.utils.Util;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class PluginCommandHandler implements CommandExecutor {
	
	public static Plugin plugin = Plugin.getInstance();
	
	public boolean onCommand(CommandSender sender, Command cmd, String label,String[] args) {
		if (sender.hasPermission(Permissions.ifs_admin)){
			if (args.length > 1){
				helpDisplay(sender);
				return true;
			}
			if (args.length < 1){
				helpDisplay(sender);
				return true;
			}
			if (args.length == 1){
				if (args[0].equalsIgnoreCase("reload")){
					Util.send(sender, "&aSuccessfully reloaded all files!");
					/*
					 * Reloads and saves the configuration and data files!
					 */
					plugin.reloadConfig();
					plugin.saveConfig();
					plugin.storage.reloadFile();
					plugin.storage.saveFile();
					plugin.message_storage.reloadFile();
					plugin.message_storage.saveFile();
					return true;
				}
			}
			if (args.length == 1){
				if (args[0].equalsIgnoreCase("version")){
					Util.send(sender, "&aYou are currently running v" + Plugin.getInstance().getDescription().getVersion());
					return true;
				}
			}
		} else {
			Util.send(sender, "&cYou do not have enough permissions.");
			return true;
		}
		return false;
	}
	
	private void helpDisplay(CommandSender sender){
		Util.send(sender, "&e&m----------------------------------------");
		Util.send(sender, "&b/ifs reload - Reloads all files!");
		Util.send(sender, "&b/ifs version - Checks your current version!");
		Util.send(sender, "&e&m----------------------------------------");
	}
}
