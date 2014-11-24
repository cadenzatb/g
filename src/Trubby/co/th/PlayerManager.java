package Trubby.co.th;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class PlayerManager {

	HashMap<String, GTAPlayer> playerlist = new HashMap<String, GTAPlayer>();
	HashMap<String, Long> wantedlist = new HashMap<>();
	
	/**
	 * 1 = 3 min.
	 * 2 = 6 min.
	 * 3 = 9 min.
	 * 4 = 12 min.
	 * 5 = 15 min.
	 */
	
	public void addPlayer(Player p){
		playerlist.put(p.getName(), new GTAPlayer(p));
	}
	
	public void removePlayer(Player p){
		playerlist.remove(p.getName());
	}
	
	public void addWanted(Player p){
		wantedlist.put(p.getName(), System.currentTimeMillis());
	}
	
	public void removeWanted(Player p){
		wantedlist.remove(p.getName());
	}
	
	public void removeWanted(String str){
		wantedlist.remove(str);
	}
	
	public GTAPlayer getGTAplayer(String str) {
		Iterator<?> it = playerlist.entrySet().iterator();
		while (it.hasNext()) {
			@SuppressWarnings("rawtypes")
			Map.Entry pairs = (Map.Entry) it.next();
			if (pairs.getKey().equals(str)) {
				return (GTAPlayer) pairs.getValue();
			}
		}
		return null;
	}
	
	@SuppressWarnings("rawtypes")
	public void wantedTask() {
		Iterator<?> it = wantedlist.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pairs = (Map.Entry) it.next();
			
			GTAPlayer p = getGTAplayer((String)pairs.getKey());
			if(p == null) return;
			
			if (System.currentTimeMillis() - (long) pairs.getValue() > getWantedTime((int)p.getWanted())) {
				removeWanted((String) pairs.getKey());
				p.setWanted(0.0f);
				p.updateScoreboard();

				Bukkit.getPlayer("" + p.getName()).sendMessage(ChatColor.GREEN + "You have escaped from the cops. You're free now!.");
			}
		}
	}
	
	public void test(){
		Bukkit.broadcastMessage("" + System.currentTimeMillis());
	}
	
	public long getWantedTime(int wanted){
		switch (wanted) {
		case 1: return 18000;
		case 2: return 360000;
		case 3: return 540000;
		case 4: return 720000;
		case 5: return 900000;
		default: return 0;
		}
	}
	
}
