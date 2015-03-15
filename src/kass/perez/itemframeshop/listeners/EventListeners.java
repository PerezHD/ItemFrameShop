package kass.perez.itemframeshop.listeners;

import kass.perez.itemframeshop.Plugin;

import org.bukkit.ChatColor;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class EventListeners implements Listener {
	
	@EventHandler
	public void onShopCreate(SignChangeEvent e) {
		Player p = e.getPlayer();
		
		if (e.getLine(0).equalsIgnoreCase("[shop]")){
			e.setLine(0, Plugin.getInstance().getConfig().getString("shop.line.1"));
			e.setLine(1, );
		}
	}
	
	@EventHandler
	public void onItemFramePlace(PlayerInteractEntityEvent e){
		Player p = e.getPlayer();
		ItemFrame itemf = (ItemFrame) e.getRightClicked();
		if (e.getRightClicked() instanceof ItemFrame){
			itemf);
		}
	}
}
