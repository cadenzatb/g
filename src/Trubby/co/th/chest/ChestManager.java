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
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import Trubby.co.th.GTA;

public class ChestManager {

	public Random ran = new Random();
	public List<GTAChest> chestlist = new ArrayList<>();
	public List<GTAItem> itemlist = new ArrayList<>();
	public List<GTAItem> gunlist = new ArrayList<>();
	public List<GTAItem> armourlist = new ArrayList<>();
	
	public long chest_delay = 6000L;
	
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
		}, chest_delay);
	}
	
	@SuppressWarnings("deprecation")
	public void breakChest(final Chest chest,long delay){
		
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
		}, delay);
	}
	
	@SuppressWarnings("deprecation")
	public void breakChest(final Chest chest,Player p){
		
		final Location loc = chest.getLocation();
		final byte data = chest.getBlock().getData();
		
		final GTAChest gtachest = new GTAChest(loc, data);
		chestlist.add(gtachest);
		chest.getBlock().setType(Material.AIR);
		chest.getWorld().playEffect(chest.getLocation(), Effect.STEP_SOUND, 54);
		
		GTA.getPlayerManager().addMoney(p, ran.nextInt(3) + 1);
		
		Bukkit.getScheduler().scheduleSyncDelayedTask(GTA.instance, new Runnable() {
			
			@Override
			public void run() {
				loc.getBlock().setType(Material.CHEST);
				Block block = loc.getBlock();
				block.setData(data);
				
				fillChest((Chest)block.getState());
				
				chestlist.remove(gtachest);
			}
		}, chest_delay);
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
		Inventory inv = chest.getInventory();
		
		//MIST. fill
		int i = 0;
		for(GTAItem gtaitem : GTA.getChestManager().itemlist){
			if(ran.nextInt(100) + 1 <= gtaitem.getChance()){
				ItemStack is = gtaitem.getItem();
				//random amount
				if(gtaitem.getAmount() != 1){
					is.setAmount(ran.nextInt(gtaitem.getAmount()) +1);
				}
				
				if(is.getAmount() != 0){
					inv.addItem(is);
				}
				
			}
			i++;
		}
		
		//GUNS fill
		/*int gun = 0;
		for (int j = 0; j < 6; j++) {
			if(gun > 0)break;
			
			GTAItem gtaitem = gunlist.get(ran.nextInt(gunlist.size()));
			if(ran.nextInt(1000) + 1 <= gtaitem.getChance()){
				inv.addItem(gtaitem.getItem());
				gun++;
			}
		}*/
		
		int gun = 0;
		if(ran.nextInt(4) == 1){ //15%
			for (GTAItem gtaitem : gunlist) {
				if(gun > 0)break;
				
				if(ran.nextInt(1000) + 1 <= gtaitem.getChance()){
					inv.addItem(gtaitem.getItem());
					gun++;
				}
			}
		}
		
		System.out.println("Chest fill count : " + i + " / Has gun : " + gun);
		
		//Armour fill
		if(ran.nextInt(3) == 1){ //18%
			for(GTAItem gtaitem : armourlist){
				if(ran.nextInt(100) + 1 <= gtaitem.getChance()){
					inv.addItem(gtaitem.getItem());
					break;
				}
			}
		}
	}
	
	public void setChest_delay(long chest_delay) {
		this.chest_delay = chest_delay;
	}
}
