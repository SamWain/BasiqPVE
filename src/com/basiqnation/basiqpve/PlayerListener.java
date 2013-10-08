package com.basiqnation.basiqpve;

import java.sql.SQLException;

import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class PlayerListener implements Listener {
	public static BasiqPVE plugin;

	public PlayerListener(BasiqPVE instance) {
		plugin = instance;
	}

	@EventHandler(priority = EventPriority.NORMAL)
	public void onEntityDamaged(final EntityDamageByEntityEvent event)
			throws SQLException {
		if ((event.getDamager() instanceof Player)
				&& (event.getEntity() instanceof Player)) {

			Player damager = (Player) event.getDamager();
			Player damagee = (Player) event.getEntity();
			if (damager.hasPermission("basiqpve.pve")
					|| damagee.hasPermission("basiqpve.pve")) {
				event.setCancelled(true);
				
			}
			if(damager.hasPermission("basiqpve.pve")){
				damager.sendMessage("You cannot damage other players");
			}
			if(damagee.hasPermission("basiqpve.pve")){
				damager.sendMessage("You cannot damage PVE players");
			}
		}

	}
}
