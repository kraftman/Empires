package es.themin.empires.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;

import es.themin.empires.cores.ICore;

public class EPlayer {

	private UUID UUID;
	private UUID empireUUID;
	private String name;
	private Player player;
	private long firstSeen;
	private long lastSeen;
	private Boolean isInEmpireChat = false;
	private long lastLocationCheck = 0;
	
	private Location lastLocation;
	private String lastLocationName;
	private HashMap<UUID,ICore> inCores;
	
	
	
	
	public HashMap<UUID,ICore> getInCores() {
		return inCores;
	}

	public void setInCores(HashMap<UUID,ICore> inCores) {
		this.inCores = inCores;
	}

	public long getLastLocationCheck() {
		return lastLocationCheck;
	}

	public void setLastLocationCheck(long lastLocationCheck) {
		this.lastLocationCheck = lastLocationCheck;
	}

	public Location getLastLocation() {
		return lastLocation;
	}

	public void setLastLocation(Location myLocation) {
		this.lastLocation = myLocation;
	}


	public long getLastSeen() {
		return lastSeen;
	}

	public void setLastSeen(long lastSeen) {
		this.lastSeen = lastSeen;
	}

	public long getFirstSeen() {
		return firstSeen;
	}

	public void setFirstSeen(long timeNow) {
		this.firstSeen = timeNow;
	}

	public UUID getUUID() {
		return UUID;
	}

	public String getLastLocationName() {
		return lastLocationName;
	}

	public void setLastLocationName(String lastLocationName) {
		this.lastLocationName = lastLocationName;
	}

	public void setUUID(UUID uUID) {
		UUID = uUID;
	}


	
	public UUID getEmpireUUID() {
		return empireUUID;
	}

	public void setEmpireUUID(UUID empireUUID) {
		this.empireUUID = empireUUID;
	}

	public EPlayer(UUID mUUID, String playerName) {
		UUID = mUUID;
		name = playerName;
	}

	public EPlayer(Player player) {
		UUID = player.getUniqueId();
		name = player.getName();
		lastLocation = player.getLocation();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public boolean isAtWarWith(EPlayer Enemy){
		//return this.empire.isAtWarWith(Enemy.getEmpire());
		return false;
	}
	
	public Location getLocation(){
		return player.getLocation();
	}
	
//
	public Player loadEPlayer() {
		for(Player p : Bukkit.getServer().getOnlinePlayers()){
            if(p.getUniqueId().equals(this.getUUID())){
                return p;
            }
        }
            return null;
	}

	public void setPlayer(Player myPlayer) {
		player = myPlayer;
		
	}
	
	public void sendMessage(String myMessage){
		player.sendMessage(myMessage);
	}

	public boolean isInEmpire() {
		if (this.empireUUID == null)
			return false;
		
		return true;
	}

	public boolean isOwner(Empire empire) {
		return empire.getOwnerUUID() == this.getUUID();
	}

	public boolean isInEmpireChat() {
		return isInEmpireChat;
	}
	
	public void setInEmpireChat(Boolean isInEmpireChat){
		this.isInEmpireChat = isInEmpireChat;
	}

	public void setScoreboard(Scoreboard sb) {
		player.setScoreboard(sb);
	}

	public String getDisplayName() {
		return player.getDisplayName();
	}

	public World getWorld() {
		return player.getWorld();
	}
	
	
//	public boolean canPlayerAttack(Player myPlayer) {
//		Empire playerEmpire = Players.loadEPlayer(myPlayer.getUniqueId()).getEmpire();
//		if (!this.isProtected()){
//			if (this.isAtWar()){
//				if (playerEmpire == this.getEnemyEmpire()){
//					return true;
//				}
//				else {
//					myPlayer.sendMessage("This war is not yours to fight!");
//					return false;
//				}
//				
//			} else if (playerEmpire.isProtected){
//				myPlayer.sendMessage("You cannot attack an empire until yours is rebuilt!");
//				return false;
//			}
//		} else {
//			myPlayer.sendMessage("There is no honor in attack this fallen empire");
//			return false;
//		}
//		return false;
//	}
}
