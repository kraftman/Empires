package es.themin.empires;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.ArrayList;

import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;

import es.themin.empires.managers.EmpireManager;
import es.themin.empires.util.Empire;

public class EmpireManagerTest {

	
	
//	@Before
//	public void setupEnvironment(){
//		
//	}
//	
//	@Test
//	public void createNewEmpire(){
//		
//		empires myPlugin = new empires();
//		
//		
//	}
	
	@Test
	public void GetEmpiresTest(){
		
        EmpiresDAL myempiresDAL = PowerMockito.mock(EmpiresDAL.class);
        ArrayList<Empire> empires = new ArrayList<Empire>();
        
        EmpireManager MyEmpireManager = new EmpireManager(myempiresDAL, empires);
        
		assertTrue(MyEmpireManager.getEmpires() == empires);
		
	}
	
	@Test
	public void LoadEmpiresTest(){
		
        EmpiresDAL myempiresDAL = PowerMockito.mock(EmpiresDAL.class);
        ArrayList<Empire> empires = new ArrayList<Empire>();
        
        EmpireManager MyEmpireManager = new EmpireManager(myempiresDAL, empires);
        MyEmpireManager.load();
		Mockito.verify(myempiresDAL).loadEmpires();
		
	}
	
	@Test
	public void SaveEmpiresTest(){
		
        EmpiresDAL myempiresDAL = PowerMockito.mock(EmpiresDAL.class);
        ArrayList<Empire> empires = new ArrayList<Empire>();
        
        EmpireManager MyEmpireManager = new EmpireManager(myempiresDAL, empires);
        MyEmpireManager.save();
		Mockito.verify(myempiresDAL).saveEmpires(empires);
		
	}
	
	@Test
	public void SaveEmpiresToFileTest(){
		
        EmpiresDAL myempiresDAL = PowerMockito.mock(EmpiresDAL.class);
        ArrayList<Empire> empires = new ArrayList<Empire>();
        
        EmpireManager MyEmpireManager = new EmpireManager(myempiresDAL, empires);
        
        File myFile = Mockito.mock(File.class);
        
        MyEmpireManager.save(myFile);
		Mockito.verify(myempiresDAL).saveEmpires(empires, myFile);
		
	}
	
	
	@Test
	public void AddEmpireTest(){
		
        EmpiresDAL myempiresDAL = PowerMockito.mock(EmpiresDAL.class);
        
        @SuppressWarnings( "unchecked" )
        ArrayList<Empire> empires = PowerMockito.mock(ArrayList.class);
        
        EmpireManager MyEmpireManager = new EmpireManager(myempiresDAL, empires);
        
        Empire myEmpire = Mockito.mock(Empire.class);
        
        MyEmpireManager.addEmpire(myEmpire);
        
        Mockito.verify(empires).add(myEmpire);
		
	}
	
	@Test
	public void GetNextUnusedEmpireIDTest(){
		
        EmpiresDAL myempiresDAL = PowerMockito.mock(EmpiresDAL.class);
        ArrayList<Empire> empires = new ArrayList<Empire>();
        
        EmpireManager MyEmpireManager = new EmpireManager(myempiresDAL, empires);
        
        Empire myEmpire = Mockito.mock(Empire.class);
        
        assertTrue(MyEmpireManager.getUnusedEmpireID() == 0);
        MyEmpireManager.addEmpire(myEmpire);
        assertTrue(MyEmpireManager.getUnusedEmpireID() == 1);
        
		
	}
	
	@Test
	public void RemoveEmpireTest(){
		
        EmpiresDAL myempiresDAL = PowerMockito.mock(EmpiresDAL.class);
        @SuppressWarnings( "unchecked" )
        ArrayList<Empire> empires = PowerMockito.mock(ArrayList.class);
        
        EmpireManager MyEmpireManager = new EmpireManager(myempiresDAL, empires);
        
        Empire myEmpire = Mockito.mock(Empire.class);
        
        MyEmpireManager.addEmpire(myEmpire);
        
        MyEmpireManager.removeEmpire(myEmpire);
        
        Mockito.verify(empires).remove(myEmpire.getID());
        Mockito.verify(myempiresDAL).removeEmpire(myEmpire);
        
	}
	
	@Test
	public void GetEmpireByNameTest(){
		
        EmpiresDAL myempiresDAL = PowerMockito.mock(EmpiresDAL.class);
        ArrayList<Empire> empires = new ArrayList<Empire>();
        
        EmpireManager MyEmpireManager = new EmpireManager(myempiresDAL, empires);
        
        Empire myEmpire = Mockito.mock(Empire.class);
        String EmpireName = "KraftPire";
        
        Mockito.when(myEmpire.getName()).thenReturn(EmpireName);
        
        MyEmpireManager.addEmpire(myEmpire);
        
        assertTrue(MyEmpireManager.getEmpireWithName(EmpireName) == myEmpire);
	}
	
	@Test
	public void GetEmpireByIDTest(){
		
        EmpiresDAL myempiresDAL = PowerMockito.mock(EmpiresDAL.class);
        ArrayList<Empire> empires = new ArrayList<Empire>();
        
        EmpireManager MyEmpireManager = new EmpireManager(myempiresDAL, empires);
        
        Empire myEmpire = Mockito.mock(Empire.class);
        
        MyEmpireManager.addEmpire(myEmpire);
        
        assertTrue(MyEmpireManager.getEmpireWithID(0) == myEmpire);
	}
	
	@Test
	public void EmpireNameValidationTest(){
		
        EmpiresDAL myempiresDAL = PowerMockito.mock(EmpiresDAL.class);
        ArrayList<Empire> empires = new ArrayList<Empire>();
        
        EmpireManager MyEmpireManager = new EmpireManager(myempiresDAL, empires);
        
        Empire myEmpire = Mockito.mock(Empire.class);
        String EmpireName = "KraftPire";
        
        Mockito.when(myEmpire.getName()).thenReturn(EmpireName);
        
        assertTrue(MyEmpireManager.isValidName(EmpireName));
        MyEmpireManager.addEmpire(myEmpire);
        
        assertFalse(MyEmpireManager.isValidName(EmpireName));
        assertFalse(MyEmpireManager.isValidName(""));
	}
	
	
	
}




















