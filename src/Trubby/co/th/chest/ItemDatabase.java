package Trubby.co.th.chest;

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
		ItemStack ammo_shotgun = new ItemsUtil(Material.PUMPKIN_SEEDS).name(ChatColor.BLUE + "Shotgun Shell").build();
		
		cm.itemlist.add(new GTAItem(ammo_pistol, 8, 50));
		cm.itemlist.add(new GTAItem(ammo_assault, 30, 50));
		cm.itemlist.add(new GTAItem(ammo_sniper, 5, 50));
		cm.itemlist.add(new GTAItem(ammo_shotgun, 6, 50));
		
		ItemStack gun_pistol1 = GTA.crackshot.generateWeapon("Pistol1");
		
		ItemStack gun_assault1 = GTA.crackshot.generateWeapon("Assault1");
		/*ItemStack gun_assault2 = GTA.crackshot.generateWeapon("assault2");
		ItemStack gun_assault3 = GTA.crackshot.generateWeapon("assault3");
		ItemStack gun_assault4 = GTA.crackshot.generateWeapon("assault4");
		ItemStack gun_assault5 = GTA.crackshot.generateWeapon("assault5");*/
		
		ItemStack gun_sniper1 = GTA.crackshot.generateWeapon("Sniper1");
		ItemStack gun_shotgun1 = GTA.crackshot.generateWeapon("Shotgun1");
		
		
		cm.itemlist.add(new GTAItem(gun_pistol1, 1, 20));
		cm.itemlist.add(new GTAItem(gun_assault1, 1, 20));
		cm.itemlist.add(new GTAItem(gun_sniper1, 1, 20));
		cm.itemlist.add(new GTAItem(gun_shotgun1, 1, 20));
		
	}
	
}
