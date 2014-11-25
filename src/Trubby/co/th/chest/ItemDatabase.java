package Trubby.co.th.chest;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import Trubby.co.th.GTA;
import Trubby.co.th.Utils.ItemsUtil;

public class ItemDatabase {

	public ItemDatabase(){
		ChestManager cm = GTA.getChestManager();
		
		/**
		 *   AMMOs 
		 */
		
		ItemStack ammo_pistol = new ItemsUtil(Material.SULPHUR).name(ChatColor.RED + "Pistol Ammo").build();
		ItemStack ammo_assault = new ItemsUtil(Material.CLAY_BALL).name(ChatColor.DARK_GREEN + "Assault Ammo").build();
		ItemStack ammo_sniper = new ItemsUtil(Material.MELON_SEEDS).name(ChatColor.GOLD + "Sniper Ammo").build();
		ItemStack ammo_shotgun = new ItemsUtil(Material.PUMPKIN_SEEDS).name(ChatColor.DARK_AQUA + "Shotgun Shell").build();
		
		cm.itemlist.add(new GTAItem(ammo_pistol, 8, 50));
		cm.itemlist.add(new GTAItem(ammo_assault, 30, 50));
		cm.itemlist.add(new GTAItem(ammo_sniper, 5, 50));
		cm.itemlist.add(new GTAItem(ammo_shotgun, 6, 50));
		
		ItemStack gun_assault1 = GTA.crackshot.generateWeapon("assault1");
		
		cm.itemlist.add(new GTAItem(gun_assault1, 1, 100));
		
		Bukkit.broadcastMessage(""+cm.itemlist);
	}
	
}
