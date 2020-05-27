package explorer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ShipTest {
	
	@Test
	void updateShieldLevelTest() {
		Ship shipTest = new Ship();
		shipTest.setShieldLevel(100);
		shipTest.updateShieldLevel();
		assertEquals(70, shipTest.getShieldLevel());
		
	}

	@Test
	void checkInventoryTest() {
		Ship shipTest = new Ship();
		shipTest.updateInventory(new Food("Shrimp", 8, 53, "Some nicely cooked shrimp.", 15, 30));
		shipTest.getInventory().get(0).setQuantity(0);
		shipTest.updateInventory();
		assertEquals(0, shipTest.getInventory().size());
	}
	
	@Test
	void updateInventoryTest() {
		Ship shipTest = new Ship();
		shipTest.updateInventory(new Food("Shrimp", 8, 53, "Some nicely cooked shrimp.", 15, 30));
		assertEquals(1, shipTest.getInventory().size());
	}

}
