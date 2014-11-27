package Trubby.co.th.SQL;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.bukkit.Bukkit;

import Trubby.co.th.GTA;

public class SqlManager {

	//public MySQL sql = new MySQL(GTA.instance, "localhost", "3306", "MC", "root", "46502");
	public MySQL sql = new MySQL(GTA.instance, "localhost", "3306", "MC", "root", "0897449075");
	public Connection connection = null;
	
	public void createTable(){
		Bukkit.broadcastMessage("1");
		//Create table
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate("CREATE TABLE GTA(Name varchar(16),Kill int,Death int);");
			statement.close();
			Bukkit.broadcastMessage("2");
		} catch (SQLException e) {
			System.out.println("[GTA]table already exist.");
			Bukkit.broadcastMessage("3");
		}
	}
	
	public void openConnection(){
		try {
			connection = sql.openConnection();
		} catch (ClassNotFoundException e) {
		} catch (SQLException e) {
		}
	}
	
	public void closeConnection(){
		try {
			sql.closeConnection();
		} catch (SQLException e) {
		}
	}
	
}
