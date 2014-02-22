package es.themin.empires.managers;

import java.io.File;
import java.util.HashMap;
import java.util.UUID;

import com.jolbox.bonecp.BoneCP;

import es.themin.empires.EmpiresDAL;
import es.themin.empires.empires;
import es.themin.empires.cores.Core;
import es.themin.empires.util.EPlayer;
import es.themin.empires.util.Empire;

public class ManagerFactory {

	File playerFile = null;
    File empireFile = null;
	
	
	
	
	public static PlayerManager CreatePlayerManager(EmpiresDAL myEmpiresDAL){
        HashMap<UUID, EPlayer> players = new HashMap<UUID, EPlayer>();
        PlayerManager myPlayerManager = new PlayerManager(myEmpiresDAL, players);
	    return myPlayerManager;
	    
	}
	
	public static EmpireManager CreateEmpireManager(EmpiresDAL myEmpiresDAL){
		HashMap<UUID,Empire> empires = new HashMap<UUID,Empire>();
        EmpireManager MyEmpireManager = new EmpireManager(myEmpiresDAL, empires);
		return MyEmpireManager;
	}

	public static CoreManager CreateCoreManager(EmpiresDAL myEmpiresDAL) {
		HashMap<UUID, Core> cores = new HashMap<UUID,Core>();
		CoreManager myCoreManager = new  CoreManager(myEmpiresDAL, cores);
		return myCoreManager;
	}


	public WorldManager CreateWorldManager() {
		return new WorldManager();
	}


	public WarManager CreateWarManager(empires empires) {
		return new WarManager(empires);
	}
	
	public static SettingsManager CreateSettingsManager(EmpiresDAL myEmpiresDAL){
		HashMap<String, String> settings = new HashMap<String,String>();
		SettingsManager mySettingsManager = new  SettingsManager(myEmpiresDAL, settings);
		return mySettingsManager;
	}
	
	
	public static ManagerAPI createManagerAPI(BoneCP connectionPool){
		
		EmpiresDAL myEmpiresDAL = new EmpiresDAL(connectionPool);
		
		PlayerManager myPlayerManager = CreatePlayerManager(myEmpiresDAL);
		CoreManager myCoreManager = CreateCoreManager(myEmpiresDAL);
		EmpireManager myEmpireManager = CreateEmpireManager(myEmpiresDAL);
		SettingsManager mySettingsManager = CreateSettingsManager(myEmpiresDAL);
		
		
		return new ManagerAPI(myCoreManager, myPlayerManager,myEmpireManager, mySettingsManager);
		
	}
}
















