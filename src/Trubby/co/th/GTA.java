package Trubby.co.th;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.PigZombie;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.ScoreboardManager;

import Trubby.co.th.Utils.MobsUtil;
import Trubby.co.th.chest.ChestListener;
import Trubby.co.th.chest.ChestManager;
import Trubby.co.th.chest.ItemDatabase;

public class GTA extends JavaPlugin{
	
	public static GTA instance;
	public static ScoreboardManager sbm = Bukkit.getScoreboardManager();
	public static PlayerManager pmg = new PlayerManager();
	public static ChestManager cmg = new ChestManager();
	private ItemDatabase itemData = new ItemDatabase();
	
	@Override
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(new PlayerListener(), this);
		Bukkit.getPluginManager().registerEvents(new MobListener(), this);
		Bukkit.getPluginManager().registerEvents(new ChestListener(), this);
		
		instance = this;
		
		for(Player p : Bukkit.getOnlinePlayers()){
			getPlayerManager().addPlayer(p);
		}
		
		runWantedTask();
		itemData.init();
	}
	
	@Override
	public void onDisable() {
		for(Player p : Bukkit.getOnlinePlayers()){
			getPlayerManager().removePlayer(p);
		}
		
		getChestManager().forceRestoreAllChest();
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		
		if(!(sender instanceof Player))return false;
		
		if(label.equals("test")){
			Player p = (Player) sender;
			PigZombie pigzombie = (PigZombie) MobsUtil.spawnMob(p.getLocation(), EntityType.PIG_ZOMBIE, 1, 0.0, 0.0, 0.0);
			pigzombie.setAngry(true);
			
			getPlayerManager().addWanted(p);
		}
		
		return false;
	}
	
	
	//GETTER
	public static ScoreboardManager getScoreboardManager() {
		return sbm;
	}

	public static ChestManager getChestManager() {
		return cmg;
	}

	public static PlayerManager getPlayerManager(){
		return pmg;
	}
	
	public void runWantedTask(){
		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			
			@Override
			public void run() {
				getPlayerManager().wantedTask();
			}
		}, 0, 100);
	}
	
}
