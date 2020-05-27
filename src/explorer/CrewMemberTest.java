package explorer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CrewMemberTest {

	@Test
	public void updateHealthTest() {
		Tank tankTest = new Tank();
		tankTest.setHealth(50);
		tankTest.updateHealth(50);
		assertEquals(99, tankTest.getHealth());
	}
	
	@Test
	public void updateHungerTest() {
		Explorer explorerTest = new Explorer();
		explorerTest.setHunger(29);
		explorerTest.updateHunger(-30);
		assertEquals(0, explorerTest.getHunger());
	}
	
	@Test
	public void updateTirednessTest() {
		Chef chefTest = new Chef();
		chefTest.updateTiredness(50);
		chefTest.updateTiredness(51);
		assertEquals(100, chefTest.getTiredness());
	}
	
	@Test
	public void isDiseasedTest() {
	Doctor doctorTest = new Doctor();
	doctorTest.setDiseased(true);
	assertEquals(true, doctorTest.isDiseased());
	}
	
}
