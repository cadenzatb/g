package Trubby.co.th.chest;

import org.bukkit.Material;
import org.bukkit.block.Chest;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;

import Trubby.co.th.GTA;

public class ChestListener implements Listener{

	@EventHandler
	public void onCloseChest(InventoryCloseEvent e){
		if(e.getInventory().getType() == InventoryType.CHEST){
			Chest chest = (Chest) e.getInventory().getHolder();
			GTA.getChestManager().breakChest(chest);
		}
	}
	
	@EventHandler
	public void onClickChest(PlayerInteractEvent e){
		if(e.getAction() == Action.LEFT_CLICK_BLOCK){
			if(e.getClickedBlock().getType() == Material.CHEST){
				GTA.getChestManager().breakChest((Chest)e.getClickedBlock().getState());
			}
		}
	}
	
}
