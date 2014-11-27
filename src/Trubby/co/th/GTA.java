package Trubby.co.th;

import java.sql.SQLException;
import java.sql.Statement;

import net.milkbowl.vault.economy.Economy;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.block.BlockState;
import org.bukkit.block.Chest;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.ScoreboardManager;

import Trubby.co.th.SQL.SqlManager;
import Trubby.co.th.chest.ChestListener;
import Trubby.co.th.chest.ChestManager;
import Trubby.co.th.chest.ItemDatabase;

import com.shampaggon.crackshot.CSUtility;

public class GTA extends JavaPlugin{
	
	public static GTA instance;
	public static ScoreboardManager sbm = Bukkit.getScoreboardManager();
	public static PlayerManager pmg = new PlayerManager();
	public static ChestManager cmg = new ChestManager();
	public static SqlManager sql = new SqlManager();
	
	public static Economy economy = null;
	public static CSUtility crackshot = new CSUtility(); 
	
	@Override
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(new PlayerListener(), this);
		Bukkit.getPluginManager().registerEvents(new MobListener(), this);
		Bukkit.getPluginManager().registerEvents(new ChestListener(), this);
		
		instance = this;
		
		getSql().openConnection();
		
		setupEconomy();
		
		for(Player p : Bukkit.getOnlinePlayers()){
			getPlayerManager().addPlayer(p);
		}
		
		runWantedTask();
		new ItemDatabase();
	}
	
	@Override
	public void onDisable() {
		for(Player p : Bukkit.getOnlinePlayers()){
			getPlayerManager().removePlayer(p);
		}
		
		getChestManager().forceRestoreAllChest();
		
		getSql().closeConnection();
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		
		if(label.equalsIgnoreCase("setup")){
			try {
				Statement statement = sql.connection.createStatement();
				statement.executeUpdate("CREATE TABLE Gta(Name varchar(16), Kill int, Death int);");
				statement.close();
				sender.sendMessage("setup!");
			} catch (SQLException e) {
				Bukkit.broadcastMessage("3");
				e.printStackTrace();
			}
			sender.sendMessage("yeah!");
		}
		
		if(!(sender instanceof Player))return false;
		
		if(label.equals("test")){
			Player p = (Player) sender;
			/*PigZombie pigzombie = (PigZombie) MobsUtil.spawnMob(p.getLocation(), EntityType.PIG_ZOMBIE, 1, 0.0, 0.0, 0.0);
			pigzombie.setAngry(true);
			
			getPlayerManager().addWanted(p);*/
			int i = 0;
			for(Chunk c : p.getWorld().getLoadedChunks()){
				for(BlockState b : c.getTileEntities()){
					if(b instanceof Chest){
						Chest chest = (Chest) b;
						getChestManager().breakChest(chest);;
						i++;
					}
				}
			}
			p.sendMessage(""+i);
		}else if(label.equalsIgnoreCase("connect")){
			Player p = (Player) sender;
			/*try {
				Statement statement = sql.connection.createStatement();
				statement.executeUpdate("CREATE TABLE GTA(Name varchar(16),Kill int,Death int);");
				statement.close();
				p.sendMessage(ChatColor.GREEN + "connected!");
			} catch (SQLException e) {
			}*/
			
			Statement statement;
			try {
				statement = GTA.getSql().connection.createStatement();
				statement.executeUpdate("INSERT INTO GTA (`Name`,`Kill`,`Death`) VALUES ('" + p.getName() + "', '0', '0')");
				statement.close();
				
				p.sendMessage("awd");
			} catch (SQLException e) {
				e.printStackTrace();
			}
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
	
	public static SqlManager getSql() {
		return sql;
	}
	
	//TASK
	public void runWantedTask(){
		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			
			@Override
			public void run() {
				getPlayerManager().wantedTask();
			}
		}, 0, 100);
	}
	
	//API
	private boolean setupEconomy()
    {
        RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
        if (economyProvider != null) {
            economy = economyProvider.getProvider();
        }
        return (economy != null);
    }
	
}
