package es.themin.empires.Listeners;

import java.util.UUID;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.meta.ItemMeta;

import es.themin.empires.empires;
import es.themin.empires.cores.Core;
import es.themin.empires.enums.CoreType;
import es.themin.empires.managers.PlayerManager;
import es.themin.empires.managers.WorldManager;
import es.themin.empires.util.EPlayer;
import es.themin.empires.util.EWorld;
import es.themin.empires.util.Empire;
import es.themin.empires.util.MsgManager;

public class Event_BlockPlace implements Listener{
	public String plprefix;
	private empires myPlugin;
	private WorldManager Worlds;
	private PlayerManager Players;
	
	public Event_BlockPlace(empires plugin) {
		myPlugin = plugin;
		plprefix = plugin.plprefix;
		Players = plugin.Players;
	}
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent event) {
		Player player = event.getPlayer();
		player.sendMessage("blockplace");
		EPlayer myCorePlayer = Players.getPlayer(player.getUniqueId());
		ItemMeta im = event.getItemInHand().getItemMeta();
		Material placed = event.getBlockPlaced().getType();
		if (placed == Material.BEACON) {
			if (im.getDisplayName().equalsIgnoreCase("base core")) {
				player.sendMessage("ItemCorrect");
				if (myCorePlayer == null) {
					player.sendMessage(MsgManager.notinemp);
					event.setCancelled(true);
				}
				Empire myEmpire = myCorePlayer.getEmpire();
				if (myEmpire == null) {
					player.sendMessage(MsgManager.notinemp);
					event.setCancelled(true);
				}
				Core myCore = new Core(myPlugin, myPlugin.Cores.nextUnusedCoreId(), CoreType.BASE, event.getBlock().getLocation(), 1, myEmpire);
				myEmpire.addCore(myCore);
				World world = player.getWorld();
				UUID uuid = world.getUID();
				myCore.build2();
				EWorld cw = Worlds.getWorlds().get(uuid);
				cw.addCore(myCore);
				
			}
		}
			
		
	}

}
