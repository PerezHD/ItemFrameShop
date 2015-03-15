package kass.perez.itemframeshop.utils;

import java.util.logging.Level;

import kass.perez.itemframeshop.Plugin;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.FireworkMeta;

public class Util {
	
	
	public static void send(Player player, String message){
		player.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
	}
	
	public static void log(Level level, String log){
		Plugin.getInstance().getLogger().info(level + "[ItemFrameShop] " + log);
	}
	
    public static void regenFirework(Location shootLocation, Player player) {
        Firework firework = player.getWorld().spawn(shootLocation, Firework.class);
        FireworkMeta fireworkmeta = firework.getFireworkMeta();
                 
        FireworkEffect effect = FireworkEffect.builder().withColor(Color.BLUE.mixColors(Color.YELLOW.mixColors(Color.GREEN))).with(Type.BALL_LARGE).withFade(Color.PURPLE).build();
        fireworkmeta.addEffects(effect);
        fireworkmeta.setPower(1);     
        firework.setFireworkMeta(fireworkmeta);
    }
}
