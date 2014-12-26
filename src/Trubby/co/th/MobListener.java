package Trubby.co.th;

import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.event.hanging.HangingBreakByEntityEvent;

public class MobListener implements Listener{

	@EventHandler
	public void onTargetSelect(EntityTargetEvent e){
		if(e.getEntityType() == EntityType.PIG_ZOMBIE){
			if(e.getTarget() instanceof Player){
				Player p = (Player) e.getTarget();
				if(!GTA.getWantedManager().wantedlist.containsKey(p.getName())){
					e.setCancelled(true);
				}
			}
		}
	}
	
	@EventHandler
	public void onKillCops(EntityDeathEvent e){
		if(e.getEntityType() == EntityType.PIG_ZOMBIE){
			LivingEntity le = e.getEntity();
			if(le.getKiller() instanceof Player){
				Player p = le.getKiller();
				GTA.getPlayerManager().addWanted(p, 0.5f);
				
				GTA.economy.depositPlayer(p.getName(), 2);
				GTAPlayer gtap = GTA.getPlayerManager().getGTAplayer(p.getName());
				gtap.updateScoreboard();
				
				p.sendMessage("You earn " + ChatColor.GREEN + "1$ " + ChatColor.RESET + "from killing a policeman.");
			}
		}
	}
	
	@EventHandler
	public void onHangBreak(HangingBreakByEntityEvent e){
		if(e.getRemover() instanceof Player){
			Player p = (Player) e.getRemover();
			if(!p.isOp()){
				e.setCancelled(true);
			}
			return;
		}
		
		else{
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onHangInteract(EntityDamageByEntityEvent e){
		if(e.getEntity() instanceof ItemFrame){
			e.setCancelled(true);
		}
	}
}
