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
		
		cm.itemlist.add(new GTAItem(ammo_pistol, 8, 30));
		cm.itemlist.add(new GTAItem(ammo_assault, 24, 30));
		cm.itemlist.add(new GTAItem(ammo_sniper, 5, 30));
		cm.itemlist.add(new GTAItem(ammo_shotgun, 6, 30));
		
		ItemStack minecart = new ItemsUtil(Material.MINECART).name(ChatColor.RED + "Car").build();
		cm.itemlist.add(new GTAItem(minecart, 1, 25));
		
		//Melee
		ItemStack melee1 = GTA.crackshot.generateWeapon("Melee1");
		ItemStack melee2 = GTA.crackshot.generateWeapon("Melee2");
		ItemStack melee3 = GTA.crackshot.generateWeapon("Melee3");
		cm.itemlist.add(new GTAItem(melee1, 1, 25));
		cm.itemlist.add(new GTAItem(melee2, 1, 15));
		cm.itemlist.add(new GTAItem(melee3, 1, 5));
		
		/**
		 *   Guns
		 */
		ItemStack gun_pistol1 = GTA.crackshot.generateWeapon("Pistol1");
		ItemStack gun_pistol2 = GTA.crackshot.generateWeapon("Pistol2");
		ItemStack gun_pistol3 = GTA.crackshot.generateWeapon("Pistol3");
		ItemStack gun_pistol4 = GTA.crackshot.generateWeapon("Pistol4");
		ItemStack gun_pistol5 = GTA.crackshot.generateWeapon("Pistol5");
		cm.gunlist.add(new GTAItem(gun_pistol1, 1, 300));
		cm.gunlist.add(new GTAItem(gun_pistol2, 1, 150));
		cm.gunlist.add(new GTAItem(gun_pistol3, 1, 50));
		cm.gunlist.add(new GTAItem(gun_pistol4, 1, 10));
		cm.gunlist.add(new GTAItem(gun_pistol5, 1, 5));
		
		ItemStack gun_assault1 = GTA.crackshot.generateWeapon("Assault1");
		ItemStack gun_assault2 = GTA.crackshot.generateWeapon("Assault2");
		ItemStack gun_assault3 = GTA.crackshot.generateWeapon("Assault3");
		ItemStack gun_assault4 = GTA.crackshot.generateWeapon("Assault4");
		ItemStack gun_assault5 = GTA.crackshot.generateWeapon("Assault5");
		cm.gunlist.add(new GTAItem(gun_assault1, 1, 300));
		cm.gunlist.add(new GTAItem(gun_assault2, 1, 150));
		cm.gunlist.add(new GTAItem(gun_assault3, 1, 50));
		cm.gunlist.add(new GTAItem(gun_assault4, 1, 10));
		cm.gunlist.add(new GTAItem(gun_assault5, 1, 5));
		
		ItemStack gun_sniper1 = GTA.crackshot.generateWeapon("Sniper1");
		ItemStack gun_sniper2 = GTA.crackshot.generateWeapon("Sniper2");
		ItemStack gun_sniper3 = GTA.crackshot.generateWeapon("Sniper3");
		ItemStack gun_sniper4 = GTA.crackshot.generateWeapon("Sniper4");
		ItemStack gun_sniper5 = GTA.crackshot.generateWeapon("Sniper5");
		cm.gunlist.add(new GTAItem(gun_sniper1, 1, 300));
		cm.gunlist.add(new GTAItem(gun_sniper2, 1, 150));
		cm.gunlist.add(new GTAItem(gun_sniper3, 1, 50));
		cm.gunlist.add(new GTAItem(gun_sniper4, 1, 10));
		cm.gunlist.add(new GTAItem(gun_sniper5, 1, 5));
		
		ItemStack gun_shotgun1 = GTA.crackshot.generateWeapon("Shotgun1");
		ItemStack gun_shotgun2 = GTA.crackshot.generateWeapon("Shotgun2");
		ItemStack gun_shotgun3 = GTA.crackshot.generateWeapon("Shotgun3");
		ItemStack gun_shotgun4 = GTA.crackshot.generateWeapon("Shotgun4");
		ItemStack gun_shotgun5 = GTA.crackshot.generateWeapon("Shotgun5");
		cm.gunlist.add(new GTAItem(gun_shotgun1, 1, 300));
		cm.gunlist.add(new GTAItem(gun_shotgun2, 1, 150));
		cm.gunlist.add(new GTAItem(gun_shotgun3, 1, 50));
		cm.gunlist.add(new GTAItem(gun_shotgun4, 1, 10));
		cm.gunlist.add(new GTAItem(gun_shotgun5, 1, 5));
		
		/**
		 *   Foods
		 */
		
		ItemStack apple = new ItemStack(Material.APPLE);
		ItemStack soup = new ItemStack(Material.MUSHROOM_SOUP);
		ItemStack bread = new ItemStack(Material.BREAD);
		
		ItemStack raw_pork = new ItemStack(Material.PORK);
		ItemStack raw_chicken = new ItemStack(Material.RAW_CHICKEN);
		ItemStack raw_fish = new ItemStack(Material.RAW_FISH);
		ItemStack raw_beef = new ItemStack(Material.RAW_BEEF);
		
		ItemStack coal = new ItemStack(Material.COAL);
		
		cm.itemlist.add(new GTAItem(apple, 3, 10));
		cm.itemlist.add(new GTAItem(soup, 1, 10));
		cm.itemlist.add(new GTAItem(bread, 3, 10));
		
		cm.itemlist.add(new GTAItem(raw_pork, 3, 10));
		cm.itemlist.add(new GTAItem(raw_chicken, 3, 10));
		cm.itemlist.add(new GTAItem(raw_fish, 3, 10));
		cm.itemlist.add(new GTAItem(raw_beef, 3, 10));
		
		cm.itemlist.add(new GTAItem(coal, 3, 15));
		
		/**
		 *    Armors
		 */
		
		ItemStack l_hel = new ItemStack(Material.LEATHER_HELMET);
		ItemStack l_che = new ItemStack(Material.LEATHER_CHESTPLATE);
		ItemStack l_leg = new ItemStack(Material.LEATHER_LEGGINGS);
		ItemStack l_boo = new ItemStack(Material.LEATHER_BOOTS);
		
		cm.itemlist.add(new GTAItem(l_hel, 1, 10));
		cm.itemlist.add(new GTAItem(l_che, 1, 10));
		cm.itemlist.add(new GTAItem(l_leg, 1, 10));
		cm.itemlist.add(new GTAItem(l_boo, 1, 10));
		
		ItemStack g_hel = new ItemStack(Material.GOLD_HELMET);
		ItemStack g_che = new ItemStack(Material.GOLD_CHESTPLATE);
		ItemStack g_leg = new ItemStack(Material.GOLD_LEGGINGS);
		ItemStack g_boo = new ItemStack(Material.GOLD_BOOTS);
		
		cm.itemlist.add(new GTAItem(g_hel, 1, 8));
		cm.itemlist.add(new GTAItem(g_che, 1, 8));
		cm.itemlist.add(new GTAItem(g_leg, 1, 8));
		cm.itemlist.add(new GTAItem(g_boo, 1, 8));
		
		ItemStack c_hel = new ItemStack(Material.CHAINMAIL_HELMET);
		ItemStack c_che = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
		ItemStack c_leg = new ItemStack(Material.CHAINMAIL_LEGGINGS);
		ItemStack c_boo = new ItemStack(Material.CHAINMAIL_BOOTS);
		
		cm.itemlist.add(new GTAItem(c_hel, 1, 4));
		cm.itemlist.add(new GTAItem(c_che, 1, 4));
		cm.itemlist.add(new GTAItem(c_leg, 1, 4));
		cm.itemlist.add(new GTAItem(c_boo, 1, 4));
		
		ItemStack i_hel = new ItemStack(Material.IRON_HELMET);
		ItemStack i_che = new ItemStack(Material.IRON_CHESTPLATE);
		ItemStack i_leg = new ItemStack(Material.IRON_LEGGINGS);
		ItemStack i_boo = new ItemStack(Material.IRON_BOOTS);
		
		cm.itemlist.add(new GTAItem(i_hel, 1, 2));
		cm.itemlist.add(new GTAItem(i_che, 1, 2));
		cm.itemlist.add(new GTAItem(i_leg, 1, 2));
		cm.itemlist.add(new GTAItem(i_boo, 1, 2));
	}
	
}
