package es.themin.empires.managers;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import es.themin.empires.EmpiresDAL;
import es.themin.empires.util.CorePlayer;
import es.themin.empires.util.Empire;

public class PlayerManager implements Manager {

	private HashMap<UUID, CorePlayer> players;
	
    private EmpiresDAL EmpiresDAL;
	
	public PlayerManager( EmpiresDAL myEmpiresDAL, HashMap<UUID, CorePlayer> players) {
	    this.players = players;
	    this.EmpiresDAL = myEmpiresDAL;
	}
	

    
    public void save(){
    	EmpiresDAL.savePlayers(players);
    }

    public  void save(File datafile) {
    	EmpiresDAL.savePlayers(players, datafile);
    }
    
    public void load(){
    	
    	for (Player player : Bukkit.getOnlinePlayers()) {
    		if (!playerExists(player.getUniqueId())){
    			CorePlayer myCorePlayer = new CorePlayer(player);
    			addPlayer(myCorePlayer);
    		}
    		
//    		if (playerdata.get(player.getUniqueId() + ".empire") != null) {
//    			int empireID = playerdata.getInt(player.getUniqueId() + ".empire");
//    			if (empire != null){
//    				CorePlayer myCorePlayer = new CorePlayer(player);
//        			addPlayer(myCorePlayer);
//        			player.sendMessage(myPlugin.plprefix + ChatColor.GREEN + "You were found to be in an empire");
//    			}
//    		}
    	}
    }

    public  void reload() {
        //playerdata = YamlConfiguration.loadConfiguration(pfile);
    }

	
	public CorePlayer getPlayer(String playerName){
		for (CorePlayer myCorePlayer : this.players.values()){
			if (myCorePlayer.getName().toLowerCase() == playerName.toLowerCase()){
				return myCorePlayer;
			}
		}
		return null;
	}
	
	public CorePlayer getPlayer(UUID myUUID){
		return players.get(myUUID);
	}
	
	public void addPlayer(CorePlayer myCorePlayer){
		players.put(myCorePlayer.getUUID(), myCorePlayer);
	}
	
    
    
    public HashMap<UUID, CorePlayer> getPlayers() {
		return players;
	}


	public boolean playerExists(UUID uniqueId) {
		if (players.get(uniqueId) != null)
			return true;
		else
			return false;
	}




	
}