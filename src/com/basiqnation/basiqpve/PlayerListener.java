package com.basiqnation.basiqpve;

import java.sql.SQLException;

import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

public class PlayerListener implements Listener {
	public static BasiqPVE plugin;

	public PlayerListener(BasiqPVE instance) {
		plugin = instance;
	}

	
	@EventHandler(priority = EventPriority.NORMAL)
	public void onPlayerDamaged(final EntityDamageEvent event) throws SQLException {
		Entity entity = event.getEntity();
		DamageCause sender = event.getCause();
		DamageCause[] attack = sender.values();
		if (entity instanceof Player){
			if(((Player) entity).hasPermission("basiqpve.pve")){
					event.setCancelled(true);
				}
			}
		}
	}
