package explorer;

public class Food extends Item {
	
	private int increaseHealing;
	private int cost;
	private int reduceHunger;
	private int reduceTiredness;
	
	
	public Food(String tempName, int tempIncreaseHealing, int tempCost, String tempExamine, int tempReduceHunger, int tempReduceTiredness) {
		super(tempName, tempExamine);
		increaseHealing = tempIncreaseHealing;
		cost = tempCost;
		reduceHunger = tempReduceHunger;
		reduceTiredness = tempReduceTiredness;
	}
	
	public int getIncreaseHealing() {
		return increaseHealing;
	}
	
	public int getReduceHunger() {
		return reduceHunger;
	}
	
	public int getReduceTiredness() {
		return reduceTiredness;
	}
	
	public int getCost() {
		return cost;
	}
	
	public void itemDetails() {
		System.out.println("=| " + this.getName() + " | Quantity: " + this.getQuantity() + " | Cost: " + this.getCost() + " gold pieces");
		System.out.println("=|      Increases health by: " + increaseHealing + " points");
		System.out.println("=|      Reduces hunger by  : " + reduceHunger + "%");
		System.out.println("=|      Reduces tiredness by : " + reduceTiredness + "%");
		System.out.println("=|      " + this.getExamine());
		System.out.println("=| ");
	}
	
	public void sellItemDetails() {
		System.out.println("=| " + this.getName() + " | Quantity: " + this.getQuantity() + " | Sells for: " + (this.getCost() / 2) + " gold pieces");
		System.out.println("=|      Increases health by: " + increaseHealing + " points");
		System.out.println("=|      Reduces hunger by  : " + reduceHunger + "%");
		System.out.println("=|      Reduces tiredness by : " + reduceTiredness + "%");
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
