package Trubby.co.th.chest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import Trubby.co.th.GTA;

public class ChestManager {

	public Random ran = new Random();
	public List<GTAChest> chestlist = new ArrayList<>();
	public List<GTAItem> itemlist = new ArrayList<>();
	
	@SuppressWarnings("deprecation")
	public void breakChest(final Chest chest){
		
		final Location loc = chest.getLocation();
		final byte data = chest.getBlock().getData();
		
		final GTAChest gtachest = new GTAChest(loc, data);
		chestlist.add(gtachest);
		chest.getBlock().setType(Material.AIR);
		chest.getWorld().playEffect(chest.getLocation(), Effect.STEP_SOUND, 54);
		
		Bukkit.getScheduler().scheduleSyncDelayedTask(GTA.instance, new Runnable() {
			
			@Override
			public void run() {
				loc.getBlock().setType(Material.CHEST);
				Block block = loc.getBlock();
				block.setData(data);
				
				fillChest((Chest)block.getState());
				
				chestlist.remove(gtachest);
			}
		}, 20L);
	}
	
	@SuppressWarnings("deprecation")
	public void forceRestoreAllChest(){
		for(GTAChest chest : chestlist){
			chest.loc.getBlock().setType(Material.CHEST);
			Block block = chest.loc.getBlock();
			block.setData(chest.data);
			
			fillChest((Chest)block.getState());
		}
	}
	
	public void fillChest(Chest chest){
		Bukkit.broadcastMessage("yeah");
		Inventory inv = chest.getInventory();
		Bukkit.broadcastMessage("" + inv.getContents().length);
		Bukkit.broadcastMessage("" + ran.nextInt(5) + 1);
		while (inv.firstEmpty() < ran.nextInt(5) + 1) {
			Bukkit.broadcastMessage("yeah2");
			GTAItem gtaitem = itemlist.get(ran.nextInt(itemlist.size()));
			if(ran.nextInt(100) + 1 <= gtaitem.getChance()){
				ItemStack is = gtaitem.getItem();
				is.setAmount(ran.nextInt(gtaitem.getAmount() + 1));
				inv.addItem(is);
			}
		}
	}
	
}
