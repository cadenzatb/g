package Trubby.co.th;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

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
		if(death.getKiller() instanceof Player){
			//KILLER
			Player killer = death.getKiller();
			
			GTAPlayer p = GTA.getPlayerManager().getGTAplayer(killer.getName());
			p.setWanted(p.getWanted() + 1.0f);
			p.setKill(p.getKill() + 1);
			GTA.getPlayerManager().addWanted(killer);
			p.updateScoreboard();
			
			killer.sendMessage(ChatColor.RED + "You killed " + ChatColor.YELLOW + death.getName() + "." + ChatColor.RED + " You will be chase by cops.");
			
			MobsUtil.spawnPigman(killer.getLocation(), (int) p.getWanted());
			
			//DEATH
			GTAPlayer deathp = GTA.getPlayerManager().getGTAplayer(death.getName());
			deathp.setDeath(deathp.getDeath() + 1);
			deathp.updateScoreboard();
			
			death.sendMessage(ChatColor.RED + "You were killed by " + ChatColor.YELLOW + killer.getName() + ".");
		}else{
			return;
		}
	}
}
