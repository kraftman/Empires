package es.themin.empires;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import es.themin.empires.Listeners.BlockListener;
import es.themin.empires.Listeners.Login_Quit;
import es.themin.empires.util.SettingsManager;
import es.themin.empires.util.UtilManager;
import es.themin.empires.util.testing.UtilityTesting;
 
public final class empires extends JavaPlugin {
 
	public boolean myTestBoolFunction(){
		boolean myBool = true;
		
		return myBool;
		
	}
	public String plprefix = ("[" + ChatColor.LIGHT_PURPLE + "Empires" + ChatColor.WHITE + "] ");
	
	@Override
    public void onEnable(){
        PluginManager pm = this.getServer().getPluginManager();
        //PluginDescriptionFile desc = this.getDescription();
		getLogger().info("onEnable has been invoked!");
		SettingsManager.getInstance().setup(this);
		getCommands();
		pm.registerEvents(new Login_Quit(this), this);
		pm.registerEvents(new BlockListener(this), this);
		UtilManager.loadEmpires();
		UtilityTesting.setUp();
    }
 
    @Override
    public void onDisable() {
        // TODO Insert logic to be performed when the plugin is disabled
		UtilManager.saveEmpires();
		SettingsManager.getInstance().saveAll();
    }
    
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
    	if(cmd.getName().equalsIgnoreCase("basic")){ // If the player typed /basic then do the following...
    		// doSomething
    		getLogger().info("your crap plugin works!");
    		return true;
    	} //If this has happened the function will return true. 
            // If this hasn't happened the a value of false will be returned.
    	return false; 
    }
    
    public void getCommands() {
    	UtilityTesting utiltest = new UtilityTesting();
		utiltest.setUp();
		getCommand("utiltest").setExecutor(utiltest);
    }
}
