package explorer;

public abstract class Item {
	private String name;
	private String examine;
	private int quantity;

	public Item(String tempName, String tempExamine)  {
		name = tempName;
		examine = tempExamine;
		quantity = 1;

	}
	
	public abstract void itemDetails();
	
	public abstract void sellItemDetails();
	
	public abstract void buyDetails();
	
	public abstract void sellDetails();
	
	public abstract int getCost();
	
	public String getName() {
		return name;
	}

	public String getExamine() {
		return examine;
	}
	
	public void increaseQuantity() {
		quantity += 1;
	}
	
	public void decreaseQuantity() {
		quantity -= 1;
	}
	
	public void setQuantity(int num) {
		quantity = num;
	}
	
	public int getQuantity() {
		return quantity;
	}

}
