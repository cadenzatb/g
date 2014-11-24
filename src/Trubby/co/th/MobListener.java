package Trubby.co.th;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTargetEvent;

public class MobListener implements Listener{

	@EventHandler
	public void onTargetSelect(EntityTargetEvent e){
		if(e.getEntityType() == EntityType.PIG_ZOMBIE){
			if(e.getTarget() instanceof Player){
				Player p = (Player) e.getTarget();
				if(!GTA.getPlayerManager().wantedlist.containsKey(p.getName())){
					e.setCancelled(true);
				}
			}
		}
	}

	
}
