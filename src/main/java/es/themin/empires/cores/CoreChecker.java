package es.themin.empires.cores;

import org.bukkit.block.Block;

import es.themin.empires.enums.CoreType;

public class CoreChecker {
	
	public boolean blockIsPartOfCore(Block b) {
		return false;
		
	}
	public boolean blockIsPartOfCore(Block b, CoreType type) {
		return false;
		
	}
	private boolean checkForBasic(Block b) {
		CoreType type = CoreType.BASE;
		return false;
	}
	public boolean doesJennerLikeTities(){
		return true;
	}

}