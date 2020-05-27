package explorer;

public class Part extends Item {
	private int cost = 250;
	
	public Part() {
		super("Part", "A transporter part from a planet. ");
		
	}

	public void itemDetails() {
		System.out.println("=| " + this.getName() + " | Quantity: " + this.getQuantity());
		System.out.println("=|      " + this.getExamine());
		
	}
	
	public void sellItemDetails() {
		System.out.println("=| " + this.getName() + " | Quantity: " + this.getQuantity() + " | Sells for: " + (this.getCost() / 2) + " gold pieces");
	}

	public void buyDetails() {
		
	}
	
	public void sellDetails() {
		System.out.println(this.getName() + " | Quantity: " + this.getQuantity() + " | Sells for: " + (this.getCost() / 2) + " gold pieces");
	}

	public int getCost() {
		return cost;
	}

}

