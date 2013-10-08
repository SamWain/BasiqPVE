package com.basiqnation.basiqpve;


import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;


public class BasiqPVE extends JavaPlugin {
	
	
	
	private void startListeners() {
		getServer().getPluginManager().registerEvents(new PlayerListener(this),
				this);
	}
	
	@Override
	public void onEnable() {
		startListeners();
	}
}
