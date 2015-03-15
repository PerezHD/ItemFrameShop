package kass.perez.itemframeshop.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerListeners implements Listener {
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e){
		Player p = e.getPlayer();
		Action action = e.getAction();
		
		/*
		 * When a player right clicks a shop sign.
		 */
		if ()
	}
}
