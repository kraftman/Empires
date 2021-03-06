package es.themin.empires.managers;

import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import es.themin.empires.EmpiresDAL;
import es.themin.empires.cores.ICore;
import es.themin.empires.enums.CoreType;
import es.themin.empires.util.Empire;

public class CoreManager implements IManager{

	private ConcurrentHashMap<UUID,ICore> cores = new ConcurrentHashMap<UUID,ICore>();
	private EmpiresDAL empiresDAL = null;
	
	
	public CoreManager(EmpiresDAL myEmpiresDAL, ConcurrentHashMap<UUID, ICore> myCores) {
		empiresDAL = myEmpiresDAL;
		cores = myCores;
	}
	
	public void addCore(ICore myCore) {
		this.cores.put(myCore.getUUID(), myCore);
		empiresDAL.createOrUpdateCore(myCore);
	}
	
	public void removeCore(ICore c){
		cores.remove(c);
		empiresDAL.deleteCore(c);
	}
	
	public int numberOfCores(){
		return cores.size();
	}
	
	public int getExp(UUID empireUUID) {
		int xp = 0;
		for (ICore core : cores.values()) {
			xp = xp + core.getLevel() * 2;
		}
		return xp;
	}	
	
	public HashMap<UUID,ICore> getEmpireCores(UUID empireUUID) {
		HashMap<UUID,ICore> empireCores = new HashMap<UUID,ICore>();
		
		for (ICore myCore : cores.values()){
			if (myCore.getEmpireUUID().equals(empireUUID)){
				empireCores.put(myCore.getUUID(), myCore);
			}
		}
		return empireCores;
	}
	
	public int getCoreCount(Empire empire) {
		return getEmpireCores(empire.getUUID()).size();
	}

	@Override
	public void save() {
		empiresDAL.createOrUpdateCores(cores);
		
	}

	@Override
	public void load() {
		cores = empiresDAL.loadCores();		
	}

	public HashMap<UUID, ICore> getEmpireCores(UUID uuid, CoreType type) {

		HashMap<UUID, ICore> myCores = getEmpireCores(uuid);
		HashMap<UUID, ICore> filteredCores = new HashMap<UUID, ICore>();
		for (ICore myCore : myCores.values()){
			if (myCore.getType() == type){
				filteredCores.put(myCore.getUUID(), myCore);
			}
		}		
		return filteredCores;
	}

	public ConcurrentHashMap<UUID, ICore> getCores() {
		return cores;
	}
}


//reimplement the below if needed

//public boolean empireHasCoreOfType(Empire empire, CoreType base) {
//// TODO Auto-generated method stub
//return false;
//}
//
//public Object empireGetCoreOfType(Empire empire, CoreType base) {
//// TODO Auto-generated method stub
//return null;
//}

//public void Delete(Core myCore) {
//cores.remove(myCore);
////this.destroy();
////this.getEmpire().removeCore(this);
////if (Cores.containsCoreWithId(this.Id)) {
////	int i = Cores.getCores().indexOf(this);
////	Cores.getCores().remove(i);
////}
//
//}

//public Core getCoreOfType(CoreType type) {
//for (Core core : cores.values()) {
//	if (core.getType() == type) {
//		return core;
//	}
//}
//return null;
//}
//public boolean hasCoreOfType(CoreType type) {
//for (Core core : cores.values()) {
//	if (core.getType() == type) {
//		return true;
//	}
//}
//return false;
//}
//public  boolean containsCoreWithID(UUID ID) {
//	return cores.get(ID) != null ? true : false;
//}

//public  Core getCoreWithLocation(Location l) {
//for (Core core : cores.values()) {
//	if (core.getLocation() == l) return core;
//}
//return null;
//}
