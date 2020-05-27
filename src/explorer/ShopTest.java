package explorer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ShopTest {

	@Test
	void updateShopTest() {
		Shop shopTest = new Shop();
		shopTest.genShop();
		int beforeShopSize = shopTest.getShopInventory().size();
		shopTest.getShopInventory().get(0).setQuantity(0);
		shopTest.updateShop(); 
		assertEquals(beforeShopSize - 1, shopTest.getShopInventory().size());
	}
}
