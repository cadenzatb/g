package Trubby.co.th;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;

import Trubby.co.th.Utils.MobsUtil;

public class PlayerListener implements Listener{

	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		GTA.getPlayerManager().addPlayer(e.getPlayer());
	}
	
	@EventHandler
	public void onLeave(PlayerQuitEvent e){
		GTA.getPlayerManager().removePlayer(e.getPlayer());
	}
	
	@EventHandler
	public void onDeath(PlayerDeathEvent e){
		Player death = e.getEntity();
		e.setDeathMessage(null);
		if(death.getKiller() instanceof Player){
			//KILLER
			Player killer = death.getKiller();
			
			GTAPlayer p = GTA.getPlayerManager().getGTAplayer(killer.getName());
			p.setKill(p.getKill() + 1);
			GTA.getPlayerManager().addWanted(killer, 1.0f);
			
			//killer.sendMessage(ChatColor.RED + "You killed " + ChatColor.YELLOW + death.getName() + "." + ChatColor.RED + " You will be chase by cops.");
			
			MobsUtil.spawnPigman(killer.getLocation(), (int) p.getWanted());
			
			//DEATH
			GTAPlayer deathp = GTA.getPlayerManager().getGTAplayer(death.getName());
			deathp.setDeath(deathp.getDeath() + 1);
			
			//death.sendMessage(ChatColor.RED + "You were killed by " + ChatColor.YELLOW + killer.getName() + ".");
			
			//BROADCAST
			ItemStack is = killer.getItemInHand();
			if(is.getType() == Material.WOOD_SPADE || is.getType() == Material.STONE_SPADE || is.getType() == Material.IRON_SPADE || is.getType() == Material.GOLD_SPADE || is.getType() == Material.DIAMOND_SPADE){
				Bukkit.broadcastMessage(ChatColor.GREEN + killer.getName() + " " + ChatColor.WHITE + GTA.getStringManager().getGunIcon("pistol") + ChatColor.RED + " " + ChatColor.STRIKETHROUGH + death.getName());
			}else if(is.getType() == Material.WOOD_HOE || is.getType() == Material.STONE_HOE || is.getType() == Material.IRON_HOE || is.getType() == Material.GOLD_HOE || is.getType() == Material.DIAMOND_HOE){
				Bukkit.broadcastMessage(ChatColor.GREEN + killer.getName() + " " + ChatColor.WHITE + GTA.getStringManager().getGunIcon("shotgun") + ChatColor.RED + " " + ChatColor.STRIKETHROUGH + death.getName());
			}else if(is.getType() == Material.WOOD_PICKAXE || is.getType() == Material.STONE_PICKAXE || is.getType() == Material.IRON_PICKAXE || is.getType() == Material.GOLD_PICKAXE || is.getType() == Material.DIAMOND_PICKAXE){
				Bukkit.broadcastMessage(ChatColor.GREEN + killer.getName() + " " + ChatColor.WHITE + GTA.getStringManager().getGunIcon("assault") + ChatColor.RED + " " + ChatColor.STRIKETHROUGH + death.getName());
			}else if(is.getType() == Material.WOOD_AXE || is.getType() == Material.STONE_AXE || is.getType() == Material.IRON_AXE || is.getType() == Material.GOLD_AXE || is.getType() == Material.DIAMOND_AXE){
				Bukkit.broadcastMessage(ChatColor.GREEN + killer.getName() + " " + ChatColor.WHITE + GTA.getStringManager().getGunIcon("sniper") + ChatColor.RED + " " + ChatColor.STRIKETHROUGH + death.getName());
			}else{
				Bukkit.broadcastMessage(ChatColor.GREEN + killer.getName() + " " + ChatColor.WHITE + GTA.getStringManager().getGunIcon("melee") + ChatColor.RED + " " + ChatColor.STRIKETHROUGH + death.getName());
			}
			
			//ECONOMY
			stealMoney(killer, death, deathp.getWanted());
			
			p.updateScoreboard();
			deathp.updateScoreboard();
				
		}else{
			return;
		}
	}
	
	public void stealMoney(Player stealer, Player stealed, float wanted){
		double stealed_money = GTA.economy.getBalance(stealed.getName());
		double amount = 0;
		if(wanted >= 5f){
			amount = (int) (stealed_money/100) * 60;
			GTA.economy.withdrawPlayer(stealed.getName(), amount);
			GTA.economy.depositPlayer(stealer.getName(), amount);
		}else if(wanted >= 4.0f){
			amount = (int) (stealed_money/100) * 40;
			GTA.economy.withdrawPlayer(stealed.getName(), amount);
			GTA.economy.depositPlayer(stealer.getName(), amount);
		}else if(wanted >= 3.0f){
			amount = (int) (stealed_money/100) * 30;
			GTA.economy.withdrawPlayer(stealed.getName(), amount);
			GTA.economy.depositPlayer(stealer.getName(), amount);
		}else if(wanted >= 2.0f){
			amount = (int) (stealed_money/100) * 20;
			GTA.economy.withdrawPlayer(stealed.getName(), amount);
			GTA.economy.depositPlayer(stealer.getName(), amount);
		}else if(wanted >= 1.0f){
			amount = (int) (stealed_money/100) * 15;
			GTA.economy.withdrawPlayer(stealed.getName(), amount);
			GTA.economy.depositPlayer(stealer.getName(), amount);
		}else if(wanted >= 0f){
			amount = (int) (stealed_money/100) * 10;
			GTA.economy.withdrawPlayer(stealed.getName(), amount);
			GTA.economy.depositPlayer(stealer.getName(), amount);
		}
		
		stealer.sendMessage(ChatColor.GREEN + "You stolen " + ChatColor.YELLOW + amount + "$" + ChatColor.GREEN + " from " + stealed.getName());
		stealed.sendMessage(ChatColor.RED + stealer.getName() + " take " + ChatColor.YELLOW + amount + "$" + ChatColor.RED + " from you.");
	}
	
	@EventHandler
	public void onFoodlevelchange(FoodLevelChangeEvent e){
		if(e.getEntity().getWorld().getName().equalsIgnoreCase("gtalobby")){
			e.setCancelled(true);
		}
	}
}
