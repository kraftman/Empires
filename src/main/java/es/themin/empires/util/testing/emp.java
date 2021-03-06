package es.themin.empires.util.testing;

import org.bukkit.entity.Player;

import es.themin.empires.cmds.SubCommand;
import es.themin.empires.managers.ManagerBL;
import es.themin.empires.util.EPlayer;
import es.themin.empires.util.Empire;

public class emp extends SubCommand{
	
	ManagerBL myaApi;
	
	public emp(ManagerBL api) {
		myaApi = api;
	}

	public boolean onCommand(Player player, String[] args) {
		EPlayer myEPlayer = myaApi.getEPlayer(player);
		
		Empire myEmpire = null;
		if (args.length == 1){
			myEmpire = myaApi.getEmpire(myEPlayer);
		} else {
			myEmpire = myaApi.getEmpire(args[1]);
		}
		
		if (myEmpire != null){
			myaApi.sendEmpireDetails(myEPlayer, args[1]);
			return true;
		} 
		
		return false;
	}

	public String name() {
		return "emp";
	}

	public String info() {
		return "View an empires details";
	}

	public String[] aliases() {
		return new String[] { "e" };
	}

}
