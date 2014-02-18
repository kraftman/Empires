package es.themin.empires.cmds;

import java.util.ArrayList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import es.themin.empires.CoreManager;
import es.themin.empires.empires;
import es.themin.empires.cores.Core;
import es.themin.empires.enums.CoreType;
import es.themin.empires.managers.PlayerManager;
import es.themin.empires.util.EPlayer;

public class HomeCommand implements CommandExecutor{
	
	
	private empires plugin;
	private PlayerManager Players;
	private CoreManager Cores;
	
	public HomeCommand(empires plugin) {
		this.plugin = plugin;
		Players = plugin.Players;
		this.Cores = plugin.Cores;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		Player player = (Player) sender;
		EPlayer myCorePlayer = Players.getPlayer(player.getUniqueId());
		
		
		ArrayList<Core> myCores = Cores.getEmpireCores(myCorePlayer.getEmpire());
		
		Core BaseCore = null;
		
		if (myCores == null){
			player.sendMessage("You have no cores, oh dear");
		}
		
		for (Core myCore : myCores){
			if (myCore.getType() == CoreType.BASE){
				BaseCore = myCore;
				break;
			}			
		}
		
		if (BaseCore == null){
			player.sendMessage("you have no base core! oh dear.");
			return true;
		}
		
		player.teleport(BaseCore.getLocation());
		
		
		return true;
	}
	

}
