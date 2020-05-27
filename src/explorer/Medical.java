package explorer;

public class Medical extends Item {
	
	private int increaseHealing;
	private int cost;
	
	public Medical(String tempName, int tempIncreaseHealing, int tempCost, String tempExamine) {
		super(tempName, tempExamine);
		increaseHealing = tempIncreaseHealing;
		cost = tempCost;
	}
	
	public int getCost() {
		return cost;
	}
	
	public int getIncreaseHealing() {
		return increaseHealing;
	}

	public void itemDetails() {
			System.out.println("=| " + this.getName() + " | Quantity: " + this.getQuantity() + " | Cost: " + this.getCost() + " gold pieces");
			System.out.println("=|      Increases health by: " + this.getIncreaseHealing() + " points");
			System.out.println("=|      " + this.getExamine());
			System.out.println("=| ");
		}
	
	public void sellItemDetails() {
		System.out.println("=| " + this.getName() + " | Quantity: " + this.getQuantity() + " | Sells for: " + (this.getCost() / 2) + " gold pieces");
		System.out.println("=|      Increases health by: " + this.getIncreaseHealing() + " points");
		System.out.println("=|      " + this.getExamine());
		System.out.println("=| ");
	}
	
	public void buyDetails() {
		System.out.println(this.getName() + " | Heals for: " + this.getIncreaseHealing() + " | Quantity: " + this.getQuantity() + " | Cost: " + this.getCost() + " gold pieces");
	}
	
	public void sellDetails() {
		System.out.println(this.getName() + " | Quantity: " + this.getQuantity() + " | Sells for: " + (this.getCost() / 2) + " gold pieces");
	}
		
	}

