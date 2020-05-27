package explorer;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class ActionTest {

	@Test
	public void checkActionsTest() {
		Tank tankTest = new Tank();
		Action actionTest = new Action();
		tankTest.setActionsRemaining(0);
		assertEquals(false, actionTest.checkActions(tankTest));
	}
	
	@Test
	public void repairShipTest() {
		Adventure adventureTest = new Adventure();
		Tank tankTest = new Tank();
		Action actionTest = new Action();
		actionTest.repairShip(adventureTest, tankTest);
		assertEquals(58, adventureTest.ship.getShieldLevel());
	}
	
	@Test
	public void repairShipMaxTest() {
		Adventure adventureTest = new Adventure();
		Tank tankTest = new Tank();
		Action actionTest = new Action();
		adventureTest.ship.setShieldLevel(99);
		actionTest.repairShip(adventureTest, tankTest);
		assertEquals(100, adventureTest.ship.getShieldLevel());
	}
	
	@Test
	public void sleepCrewTest() {
		ArrayList<CrewMember> chosenCrew = new ArrayList<CrewMember>();
		chosenCrew.add(new Tank());
		chosenCrew.get(0).updateTiredness(50);
		chosenCrew.add(new Explorer());
		chosenCrew.add(new Chef());
		Action actionTest = new Action();
		actionTest.sleepCrew(chosenCrew, chosenCrew.get(0));
		assertEquals(10, chosenCrew.get(0).getTiredness());
	}
	
	@Test
	public void sleepCrewDoctorTest() {
		ArrayList<CrewMember> chosenCrew = new ArrayList<CrewMember>();
		chosenCrew.add(new Tank());
		chosenCrew.add(new Explorer());
		chosenCrew.get(1).updateTiredness(50);
		chosenCrew.add(new Doctor());
		Action actionTest = new Action();
		actionTest.sleepCrew(chosenCrew, chosenCrew.get(1));
		assertEquals(0, chosenCrew.get(1).getTiredness());
	}
}
