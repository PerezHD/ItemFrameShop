package me.perezhd.kassestral.bishop.listeners;

import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class EventListeners implements Listener {
	
	@EventHandler
	public void onRightClick(PlayerInteractEntityEvent e){
		Player player = e.getPlayer();
		ItemFrame itemframe = (ItemFrame) e.getRightClicked();
		if (e.getRightClicked() instanceof ItemFrame){
			// Maybe open an inventory to setting it.
		}
	}
}
