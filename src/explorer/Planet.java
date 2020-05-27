package explorer;

public class Planet {
	
	public Shop shop = new Shop();
	private int partsOnPlanet = 1;
	
	public int getPartsOnPlanet() {
		return partsOnPlanet;
	}
	
	public void foundPartOnPlanet() {
		partsOnPlanet -= 1;
	}
	
}
