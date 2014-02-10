package es.themin.empires.Listeners;

import java.util.ArrayList;
import java.util.Arrays;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import es.themin.empires.empires;
import es.themin.empires.enums.CoreType;
import es.themin.empires.util.UtilManager;
import es.themin.empires.util.testing.Recipes;

public class CraftListener implements Listener{
	
	private empires myPlugin;
	public CraftListener(empires plugin) {
		this.myPlugin = plugin;
	}
	
	@EventHandler
	public void onPlayerCraft(CraftItemEvent event) {
		Player player = (Player) event.getView().getPlayer();
		ItemStack amp = new ItemStack(Material.BRICK, 1);
		ItemMeta meta2 = amp.getItemMeta();
	    meta2.setDisplayName(ChatColor.ITALIC + "Amplifier");
	    meta2.setLore(Arrays.asList(ChatColor.GREEN + "This", "is very special", "Use it wisely."));
	    amp.setItemMeta(meta2);
	    player.sendMessage("Crafted");
	    player.sendMessage(event.getRecipe().toString());
	    player.sendMessage(Recipes.amplifierRecipe().toString());
	    ShapelessRecipe sr = null;
	    if (event.getRecipe().toString().contains("CraftShapelessRecipe")) {
	    	sr = (ShapelessRecipe) event.getRecipe();
	    	player.sendMessage("Recipe is shapeless");
	    	if (sr.getIngredientList() == Recipes.amplifierRecipe().getIngredientList()) {
				player.sendMessage("craft attempt");
				ItemStack myItem = new ItemStack(Material.FLINT);
				ItemMeta myMeta = myItem.getItemMeta();
				myMeta.setDisplayName("Core Shard");
				
				ArrayList<String> myLore = new ArrayList<String>();
				myLore.add(ChatColor.GREEN + "A faint glow eminates from within");
				
				myMeta.setLore(myLore);
				
				myItem.setItemMeta(myMeta);
				player.sendMessage("Crafted");
				if (!(event.getInventory().contains(myItem)) || !(myPlugin.getEmpireplayers().containsKey(player.getName())) || !(myPlugin.getEmpireplayers().get(player.getName()).hasCoreOfType(CoreType.BASE))||getDiffernceBetween(player.getLocation().getBlockX(), myPlugin.getEmpireplayers().get(player.getName()).getCoreOfType(CoreType.BASE).getLocation().getBlockX()) > 2|| getDiffernceBetween(player.getLocation().getBlockZ(), myPlugin.getEmpireplayers().get(player.getName()).getCoreOfType(CoreType.BASE).getLocation().getBlockZ()) > 2) {
					event.setCancelled(true);
					event.setCurrentItem(null);
					player.sendMessage(ChatColor.RED + "To craft an amplifier you must place a true shard in your Base core's crafting table");
				}
			}
	    }
		
	}

	public int getDiffernceBetween(int i1, int i2) {
		if (i1>i2) return i1 - i2;
		if (i1<i2) return i2 - i1;
		if (i1==i2) return 0;
		return 0;
		
	}

}
