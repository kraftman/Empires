package es.themin.empires.listeners;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockBurnEvent;

import es.themin.empires.managers.ManagerBL;

public class BlockListener implements Listener {

	private ManagerBL myApi = null;
	
	public BlockListener(ManagerBL myAPI){
		myApi = myAPI;
	}
	private static HashMap<Block, Material> burnt = new HashMap<Block, Material>();
	private static HashMap<Block, Byte> burntdata = new HashMap<Block, Byte>();
	private static HashMap<Block, Material> recentlyfixed = new HashMap<Block, Material>();
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent event){
//		we need to think about the regeneration mechanic
//		one option is to store every break and place an enemy makes
//      and then slowly revert depending on rate
//      will need to add a property to the empire for blocks placed and blocks broken by enemies
	}
	
	@EventHandler
	public void onBlockBurn(BlockBurnEvent event) {
//		Random r = new Random();
//		final Block b = event.getBlock();
//		final Material m = b.getType();
//		if(recentlyfixed.containsKey(b)) {
//			event.setCancelled(true);
//		}else if (SettingsManager.getConfig().getString("regeneration.enable").equalsIgnoreCase("true") && SettingsManager.getConfig().getString("regeneration.burn.enable").equalsIgnoreCase("true")) {
//			burnt.put(b,m);
//			burntdata.put(b, b.getData());
//			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
//
//				@Override
//				public void run() {
//					if (b.getType() == Material.AIR || b.getType() == Material.FIRE) {
//						int x1 = b.getX() - 2;
//						int y1 = b.getY() - 2;
//						int z1 = b.getZ() - 2;
//						int x2 = b.getX() + 2;
//						int y2 = b.getY() + 2;
//						int z2 = b.getZ() + 2;
//						for (int xPoint = x1; xPoint < x2 ; xPoint++) {
//							for (int yPoint = y1; yPoint < y2 ; yPoint++) {
//								for (int zPoint = z1 ; zPoint < z2 ; zPoint++) {
//									Block target = b.getWorld().getBlockAt(xPoint, yPoint, zPoint);
//									if (target.getType() == Material.FIRE) b.setType(Material.AIR);
//								}
//							}
//						}
//						b.setType(m);
//						b.setData(burntdata.get(b));
//						recentlyfixed.put(b, m);
//						Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
//
//							@Override
//							public void run() {
//								recentlyfixed.remove(b);
//								
//							}
//							
//						}, 800L);
//						burnt.remove(b);
//						burntdata.remove(b);
//					}
//					
//				}
//				
//			}, SettingsManager.getConfig().getInt("regeneration.burn.delay") * 20 + r.nextInt(600));
//		}
	}
	/*@EventHandler
	public void onBlockExplode(BlockExplodeEvent event) {
		
	}*/
	//for disable
	public static void fixBurns(){
		Bukkit.getServer().getScheduler().cancelAllTasks();
		for (Block b : burnt.keySet()) {
			if (b.getType() == Material.AIR || b.getType() == Material.FIRE) {
				b.setType(burnt.get(b));
				b.setData(burntdata.get(b));
			}
		}
	}
}




