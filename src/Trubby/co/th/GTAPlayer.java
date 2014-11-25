package Trubby.co.th;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

import Trubby.co.th.Utils.ScoreboardUtils;

public class GTAPlayer {

	public String name;

	public int kill = 0;
	public int death = 0;
	public float kdr = 0.0f;
	public float wanted = 0.0f;
	//score board
	public ScoreboardUtils sbu;
	public Scoreboard sb;
	public Objective ob;
	
	@SuppressWarnings("deprecation")
	public GTAPlayer(Player p){
		name = p.getName();
		
		//set up scoreboard
		sbu = new ScoreboardUtils(ChatColor.RED + "" + ChatColor.BOLD + "GTA");
		sbu.add(ChatColor.AQUA + "Kills");
		sbu.add(""+kill);
		sbu.add(ChatColor.AQUA + "Deaths");
		sbu.add(""+death);
		sbu.add(ChatColor.AQUA + "K/D Ratio");
		sbu.add(""+kdr);
		sbu.add(ChatColor.AQUA + "Money");
		sbu.add(ChatColor.GOLD + "" + GTA.economy.getBalance(name));
		sbu.add(ChatColor.AQUA + "Wanted");
		sbu.add(""+wanted);
		sbu.build();
		
		sb = sbu.getScoreboard();
		ob = sb.getObjective("GTA");
		
		p.setScoreboard(sb);
	}
	
	@SuppressWarnings("deprecation")
	public void updateScoreboard(){
		ob.unregister();
		sbu.reset();
		sbu.add(ChatColor.AQUA + "Kills");
		sbu.add(""+kill);
		sbu.add(ChatColor.AQUA + "Deaths");
		sbu.add(""+death);
		sbu.add(ChatColor.AQUA + "K/D Ratio");
		sbu.add(""+kdr);
		sbu.add(ChatColor.AQUA + "Money");
		sbu.add(ChatColor.GOLD + "" + GTA.economy.getBalance(name));
		sbu.add(ChatColor.AQUA + "Wanted");
		sbu.add(""+wanted);
		sbu.update();
		ob = sb.getObjective("GTA");
		
	}
	
	/** 
	 *     GETTER AND SETTER 
	 */
	
	public String getName() {
		return name;
	}
	
	public int getKill() {
		return kill;
	}
	
	public void setKill(int kill) {
		this.kill = kill;
		updateKdr();
	}

	public int getDeath() {
		return death;
	}

	public void setDeath(int death) {
		this.death = death;
		updateKdr();
	}

	public float getKdr() {
		return kdr;
	}

	public void setKdr(float kdr) {
		this.kdr = kdr;
	}
	
	public void updateKdr() {
		
		if(death == 0){
			kdr = kill;
			return;
		}
		
		float calkdr = (float) (kill/death) * 100;
		int intkdr = (int) calkdr/100;
		this.kdr = intkdr;
	}

	public float getWanted() {
		return wanted;
	}

	public void setWanted(float wanted) {
		this.wanted = wanted;
	}

	public Scoreboard getSb() {
		return sb;
	}

	public Objective getOb() {
		return ob;
	}
}
