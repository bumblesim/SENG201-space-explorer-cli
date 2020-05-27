package explorer;
import java.util.ArrayList;

public class Ship {
	
	private String name;
	private int shieldLevel = 50;
	private int goldPieces = 500;
	private ArrayList<Item> inventory = new ArrayList<Item>();
	
	public Ship() {
	}

	public int getShieldLevel() {
		return shieldLevel;
	}

	public void setShieldLevel(int shieldLevel) {
		this.shieldLevel = shieldLevel;
	}
	
	public void updateShieldLevel() {
		this.shieldLevel = (int)((shieldLevel * 0.8) - 10);
		System.out.println("Shield level has been reduced to " + this.shieldLevel + ".");
	}

	public int getGoldPieces() {
		return goldPieces;
	}

	public void setGoldPieces(int goldPieces) {
		this.goldPieces = goldPieces;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Item> getInventory() {
		return inventory;
	}
	
	public void updateInventory() {
		for (int i = 0; i < inventory.size(); i++) {
			if (inventory.get(i).getQuantity() == 0) {
				inventory.remove(i);
			}
		}
	}
	
	public void updateInventory(Item item) {
		boolean foundItem = false;
		for (int i = 0; i < inventory.size(); i++) {
			if (inventory.get(i).getName() == item.getName()) {
				foundItem = true;
				inventory.get(i).setQuantity(inventory.get(i).getQuantity() + 1);
			}
		}
		if (foundItem == false) {
			if (item.getName() == "Shrimp") {
				Item shrimp = new Food("Shrimp", 8, 53, "Some nicely cooked shrimp.", 15, 30);
				inventory.add(shrimp);
			} else if (item.getName() == "Stew") {
				Item stew = new Food("Stew", 9, 62, "It's a meat and potato stew.", 45, 35);
				inventory.add(stew);
			} else if (item.getName() == "Trout") {
				Item trout = new Food("Trout", 10, 74, "Some nicely cooked trout.", 60, 30);
				inventory.add(trout);
			} else if (item.getName() == "Tuna Potato") {
				Item tunaPotato = new Food("Tuna Potato", 12, 86, "A baked potato with tuna and sweetcorn.", 70, 40);
				inventory.add(tunaPotato);
			} else if (item.getName() == "Chocolate Cake") {
				Item chocolateCake = new Food("Chocolate Cake", 8, 115, "This looks very tasty.", 25, 75);
				inventory.add(chocolateCake);
			} else if (item.getName() == "Shark") {
				Item shark = new Food("Shark", 20, 194, "I'd better be careful eating this.", 80, 40);
				inventory.add(shark);
			} else if (item.getName() == "Antidote") {
				Item antidote = new Medical("Antidote", 50, 400, "Cures the space plague.");
				inventory.add(antidote);
			} else if (item.getName() == "Band-Aid") {
				Item bandAid = new Medical("Band-Aid", 25, 100, "Slows down damage from space plague.");
				inventory.add(bandAid);
			} else {
				Item part = new Part();
				inventory.add(part);
			}
		}
		System.out.println("=| " + item.getName() + " has been added to your inventory. ");
	}
	
	public void viewInventory() {
		for (int i = 0; i < inventory.size(); i++) {
			inventory.get(i).sellItemDetails();
		}
	}
	
	
	public void removeItem(Item item) {
		for (int i = 0; i < inventory.size(); i++) {
			if (inventory.get(i).getName() == item.getName()) {
				inventory.get(i).decreaseQuantity();
				System.out.println("=| " + inventory.get(i).getName() + " has been removed from your inventory.");
			}
		}
		updateInventory();
		
	}
	
	public void removeRandom() {
		int randomNum = (int)(Math.random() * ((inventory.size() - 0) + 0));;
		removeItem(inventory.get(randomNum));
		
	}
	public void viewShip() {
		System.out.println("=============================================");
		System.out.println("=| Ship Name: " + this.name);
		System.out.println("=| Gold Pieces: " + this.goldPieces);
		System.out.println("=| Shield Level: " + this.shieldLevel + "%");
		this.viewInventory();
	}

}