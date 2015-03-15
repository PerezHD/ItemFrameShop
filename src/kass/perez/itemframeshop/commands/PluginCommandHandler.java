package kass.perez.itemframeshop.commands;

import kass.perez.itemframeshop.Plugin;
import kass.perez.itemframeshop.handlers.Permissions;
import kass.perez.itemframeshop.utils.Util;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class PluginCommandHandler implements CommandExecutor {
	
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
					Plugin.getInstance().reloadConfig();
					Plugin.getInstance().storage.reloadFile();
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
		Util.send(sender, "&e&m----------------------------------------");
	}
}
