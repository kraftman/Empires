package es.themin.empires.util.testing;

import org.bukkit.entity.Player;

import es.themin.empires.Debug;
import es.themin.empires.cmds.SubCommand;
import es.themin.empires.cores.CoreFactory;
import es.themin.empires.cores.ICore;
import es.themin.empires.enums.CoreType;
import es.themin.empires.managers.ManagerBL;
import es.themin.empires.util.EPlayer;

public class generatebasecore extends SubCommand{

	private ManagerBL myApi = null;
	
	public generatebasecore(ManagerBL api) {
		myApi = api;
	}

	public boolean onCommand(Player player, String[] args) {
		EPlayer myEPlayer = myApi.getEPlayer(player);
		
		ICore myCore = CoreFactory.CreateCore(myEPlayer.getEmpireUUID(), myEPlayer.getLocation(), CoreType.BASE);
		Debug.Console("after creation: "+myCore.getPlaceType().toString());
		
		myApi.generateCore(myEPlayer, myCore);
		
		return false;
		
	}

	public String name() {
		return "generatebasecore";
	}

	public String info() {
		return "generates a core";
	}

	public String[] aliases() {
		return new String[] {"genbase" , "gbc" , "genbasecore", "generatebase"};
	}

}
