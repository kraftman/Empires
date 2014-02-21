package es.themin.empires.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.meta.ItemMeta;

import es.themin.empires.empires;
import es.themin.empires.managers.PlayerManager;
import es.themin.empires.managers.WorldManager;
import es.themin.empires.schematics.Schematic;
import es.themin.empires.schematics.mob.Schematic_Mob_10;
import es.themin.empires.util.EPlayer;

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
		Player player = event.loadEPlayer();
		EPlayer myEPlayer = Players.loadEPlayer(player);
		ItemMeta im = event.getItemInHand().getItemMeta();
		Material placed = event.getBlockPlaced().getType();
		if (placed == Material.BEACON) {
			if (im.getDisplayName().equalsIgnoreCase("base core")) {
				/*if (myEPlayer == null) {
					player.sendMessage(MsgManager.notinemp);
					event.setCancelled(true);
				}
				Empire myEmpire = myEPlayer.getEmpire();
				if (myEmpire == null) {
					player.sendMessage(MsgManager.notinemp);
					event.setCancelled(true);
				}
				Core myCore = new Core(myPlugin, myPlugin.Cores.nextUnusedCoreId(), CoreType.BASE, event.getBlock().getLocation(), 1, myEmpire);
				myEmpire.addCore(myCore);
				World world = player.getWorld();
				UUID uuid = world.getUID();
				myCore.build2();
				EWorld cw = Worlds.getWorld(uuid);
				cw.addCore(myCore);*/
				Schematic schem = new Schematic_Mob_10();
				schem.pasteFromCentre(event.getBlock().getLocation());
			}
		}
			
		
	}

}
