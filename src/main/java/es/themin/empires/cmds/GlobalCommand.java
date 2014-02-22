package es.themin.empires.cmds;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import es.themin.empires.cmds.empire.ChatCommand;
import es.themin.empires.managers.ManagerAPI;

public class GlobalCommand implements CommandExecutor{
	
	private final GlobalCommand gc = this;
	private ManagerAPI myAPI = null;
	public GlobalCommand(ManagerAPI api) {
		myAPI = api;
	}
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		final Player player = (Player) sender;
		if (commandLabel.equalsIgnoreCase("all")) {
			if (ChatCommand.empirechatplayers.contains(player)) ChatCommand.empirechatplayers.remove(player);
			player.performCommand("global");	
			
		}
		return false;
	}

}
