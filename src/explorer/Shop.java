package explorer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Shop {
	private Scanner scan = new Scanner(System.in);
	
	private ArrayList<Item> shopInventory = new ArrayList<Item>();

	public void genShop() {
		Item shrimp = new Food("Shrimp", 8, 53, "Some nicely cooked shrimp.", 15, 30);
		Item stew = new Food("Stew", 9, 62, "It's a meat and potato stew.", 45, 35);
		Item trout = new Food("Trout", 10, 74, "Some nicely cooked trout.", 60, 30);
		Item tunaPotato = new Food("Tuna Potato", 12, 86, "A baked potato with tuna and sweetcorn.", 70, 40);
		Item chocolateCake = new Food("Chocolate Cake", 8, 115, "This looks very tasty.", 25, 75);
		Item shark = new Food("Shark", 20, 194, "I'd better be careful eating this.", 80, 40);
		
		Item antidote = new Medical("Antidote", 50, 400, "Cures the space plague.");
		Item bandAid = new Medical("Band-Aid", 25, 100, "Slows down damage from space plague.");
		
		shopInventory.add(shrimp); shopInventory.add(stew); shopInventory.add(trout); shopInventory.add(tunaPotato); shopInventory.add(chocolateCake); shopInventory.add(shark);
		
		shopInventory.add(bandAid); shopInventory.add(antidote);
		
		for (int i = 0; i < 15; i++) {
			int rngShop = (int) (Math.random() * 100);
			if (rngShop < 11) {
				shopInventory.get(0).increaseQuantity();
			} else if (rngShop < 21) {
				shopInventory.get(1).increaseQuantity();
				} else if (rngShop < 41) {
				shopInventory.get(2).increaseQuantity();
			} else if (rngShop < 66) {
				shopInventory.get(3).increaseQuantity();
			} else if (rngShop < 76) {
				shopInventory.get(4).increaseQuantity();
			} else if (rngShop < 86) {
				shopInventory.get(5).increaseQuantity();
			} else if (rngShop < 94) {
				shopInventory.get(6).increaseQuantity();
			} else {
				shopInventory.get(7).increaseQuantity();
			}
			
		}
	}
	
	
	// checks for 0 quantity and removes
	public void updateShop() {
		for (int i = 0; i < shopInventory.size(); i++) {
			if (shopInventory.get(i).getQuantity() == 0) {
				shopInventory.remove(i);
			}
		}
	}
	
	public void buy(Ship ship) {
		System.out.println("=============================================");
    	System.out.println("=| BUY |=====================================");
		ArrayList<String> validArg = new ArrayList<String>();
		for (int i = 0; i < shopInventory.size(); i++) {
			System.out.print("=| " + (i + 1) + ": ");
			shopInventory.get(i).buyDetails();
			validArg.add(Integer.toString(i + 1));
		}
		validArg.add(Integer.toString(shopInventory.size() + 1));
		System.out.println("=| " + (shopInventory.size() + 1) + ": Return");
		System.out.println("=========================================================");
		System.out.println("=| You have " + ship.getGoldPieces() + " gold pieces.");
		System.out.print("=| Please select an option.. ");
		String keyStroke = scan.next();
		while (validArg.contains(keyStroke) == false) {
			System.out.println("Invalid entry. Please try again.");
			for (int i = 0; i < shopInventory.size(); i++) {
				System.out.print("=|" + (i + 1) + ": ");
				shopInventory.get(i).buyDetails();
			}
			System.out.println("=| " + (shopInventory.size() + 1) + ": Return");
			System.out.println("=========================================================");
			System.out.println("=| You have " + ship.getGoldPieces() + " gold pieces.");
			System.out.print("=| Please select an option.. ");
			keyStroke = scan.next();
		}
		
		int newStroke = Integer.parseInt(keyStroke) - 1;
		if (newStroke == shopInventory.size()) {
			return;
		} else {
			System.out.println("=========================================================");
			if (ship.getGoldPieces() >= shopInventory.get(newStroke).getCost()) {
				ship.updateInventory(shopInventory.get(newStroke));
				System.out.println("=========================================================");
				ship.setGoldPieces(ship.getGoldPieces() - shopInventory.get(newStroke).getCost());
				shopInventory.get(newStroke).decreaseQuantity();
			} else {
				System.out.println("=| Sorry, you don't have enough gold pieces. ");
				System.out.println("=========================================================");
			} 
			
			updateShop();
			buy(ship);
		} 
	}
	
	public void sell(Adventure adventure) {
		System.out.println("=============================================");
    	System.out.println("=| SELL |====================================");
		ArrayList<String> validArg = new ArrayList<String>();
		ArrayList<Item> yourInventory = adventure.ship.getInventory();
		if (yourInventory.size() == 0) {
			System.out.println("=| You haven't got anything to sell. Returning to base.");
		} else {
			for (int i = 0; i < yourInventory.size(); i++) {
				System.out.print("=| " + (i + 1) + ": ");
				yourInventory.get(i).sellDetails();
				validArg.add(Integer.toString(i + 1));
			}
			validArg.add(Integer.toString(yourInventory.size() + 1));
			System.out.println("=| " + (yourInventory.size() + 1) + ": Return.");
			System.out.println("=========================================================");
			System.out.println("=| You have " + adventure.ship.getGoldPieces() + " gold pieces.");
			System.out.print("=| Please select an option.. ");
			String keyStroke = scan.next();
			
			while (validArg.contains(keyStroke) == false) {
				System.out.println("Invalid entry. Please try again.");
				System.out.println("=========================================================");
				for (int i = 0; i < yourInventory.size(); i++) {
					System.out.print("=| " + (i + 1) + ": ");
					yourInventory.get(i).sellDetails();
				}
				System.out.println("=| " + (yourInventory.size() + 1) + ": Return.");
				System.out.println("=========================================================");
				System.out.println("=| You have " + adventure.ship.getGoldPieces() + " gold pieces.");
				System.out.print("=| Please select an option.. ");
				keyStroke = scan.next();
				
			}
			int newStroke = Integer.parseInt(keyStroke) - 1;
			if (newStroke == yourInventory.size()) {
				return;
			} else {
				System.out.println("=========================================================");
				adventure.ship.setGoldPieces(adventure.ship.getGoldPieces() + (yourInventory.get(newStroke).getCost() / 2));
				if (yourInventory.get(newStroke).getName() == "Part") {
					adventure.setNumberOfPartsFound(adventure.getNumberOfPartsFound() - 1);
				}
				System.out.println("=| You have sold: " + yourInventory.get(newStroke).getName() + " for " + (yourInventory.get(newStroke).getCost() / 2) + " gold pieces. ");
				System.out.println("=| You now have " + adventure.ship.getGoldPieces() + " gold pieces. ");
				System.out.println("=========================================================");
				adventure.ship.removeItem(yourInventory.get(newStroke));
				System.out.println("===============================================");
				sell(adventure);
				}	
		}
		 
		}
	
	public ArrayList<Item> getShopInventory() {
		return shopInventory;
	}
	
	public void viewShop(Adventure adventure) {
		String[] arg = {"1", "2", "3", "4"};
	    ArrayList<String> validArg = new ArrayList<String>(Arrays.asList(arg));
	    System.out.println("=============================================");
	    System.out.println("=| 1: View Items in the shop");
	    System.out.println("=| 2: Buy");
	    System.out.println("=| 3: Sell");
	    System.out.println("=| 4: Return");
	    System.out.println("=============================================");
	    System.out.print("=| Please select an option.. ");
	    String keyStroke = scan.next();
	    while (validArg.contains(keyStroke) == false) {
	    	System.out.println("=| Invalid entry. Please try again.");
	    	System.out.println("=============================================");
		    System.out.print("=| Please select an option.. ");
	    	keyStroke = scan.next();
	    	
	    }
	    int intStroke = Integer.parseInt(keyStroke);
	    if (intStroke == 1) {
	    	updateShop();
	    	System.out.println("=============================================");
	    	System.out.println("=| SHOP |====================================");
	    	for (int i = 0; i < shopInventory.size(); i++) {
				shopInventory.get(i).itemDetails();
			}
	    	System.out.println("=============================================");
	    	System.out.println("=| You have " + adventure.ship.getGoldPieces() + " gold pieces.");
	    	
	    	viewShop(adventure);
	    } else if (intStroke == 2) {
	    	buy(adventure.ship);
	    	viewShop(adventure);
	    } else if (intStroke == 3) {
	    	sell(adventure);
	    	viewShop(adventure);
	    } else {
	    	return;
	    }
	}

}
