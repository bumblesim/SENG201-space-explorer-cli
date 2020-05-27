package explorer;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class AdventureTest {

	@Test
	public void newPlanetTest() {
		Adventure adventureTest = new Adventure();
		adventureTest.planet.shop.genShop();
		ArrayList<Item> oldShop = adventureTest.planet.shop.getShopInventory();
		adventureTest.newPlanet();
		ArrayList<Item> newShop = adventureTest.planet.shop.getShopInventory();
		assertFalse(oldShop == newShop);
		}
	
	@Test
	public void setNumberOfPartsTest() {
		Adventure adventureTest = new Adventure();
		adventureTest.setNumberOfParts();
		assertEquals(0, adventureTest.getCurrentDays() * 2/3);
		}
	}


