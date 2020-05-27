package explorer;
import java.util.Random;


/**
 * Command Class holds the layout for the command-line application.
 * Contains the main() method which will be called to start the Space Explorer game.
 */
public class Command {
	
	
	/**
 	 * Random number generator between two Integer values.
 	 *
 	 * @param min the min boundary for random number generation.
 	 * @param max the max boundary for random number generation.
 	 * @return a random Integer value between the min and max value.
 	 */
	 public static int RandomNumbers(int min, int max) {
			Random rng = new Random();
			int rngNum = rng.nextInt(max - min) + min;
			return rngNum;
		}
	 /**
	 * Outputs to console the starting screen.
	 */
	 private static void printOpening() {
		 System.out.println("===========================================| Welcome to Space Explorer! |================================================");
		 System.out.println("=========================================================================================================================");
		 System.out.println("==| HOW TO PLAY |========================================================================================================");
		 System.out.println("=| You must endeavour on a mission to discover the missing part pieces, which are scatterered among the vast planets   |=");
		 System.out.println("=| you will encounter. The amount of parts to collect will be determined on the number of days you wish to play for.   |=");
		 System.out.println("=| You may only discover one part piece per planet, to which you must pilot the ship to discover more. Different       |=");
		 System.out.println("=| professions may greatly aid you in your adventures. As the days increase, your crew members may become tired or     |=");
		 System.out.println("=| hungry. You may rest and purchase food at the nearby outpost to keep your Crew healthy. Additionally, Crew Members  |=");
		 System.out.println("=| have health. If any of these three drop below 0, the Crew Member will die.                                          |=");
		 System.out.println("==| BEWARE! |============================================================================================================");
		 System.out.println("=| This will not be easy. You may encounter various random events:                                                     |=");
		 System.out.println("=|      - Alien Pirates: May hijack your spaceship and steal one of your items.                                        |=");
		 System.out.println("=|      - Asteroid Belt: May blow up and cause damage to your ships shield level.                                      |=");
		 System.out.println("=|      - Space Plague: This can damage your Crew Members, and may get worse if left untreated.                        |=");
		 System.out.println("=========================================================================================================================");

	 }
	 /**
	  * The main method is where the game is initialized
	  *
	  * @param spaceExplorer creates a new Adventure class
	  * @param newPlayer creates a new Player class
	  */
	 private static void main() {
		 printOpening();
			Adventure spaceExplorer = new Adventure();
			Player newPlayer = new Player();
			spaceExplorer.planet.shop.genShop();
			spaceExplorer.nameShip();
			spaceExplorer.setNumberOfDays();
			spaceExplorer.setPlayers();
			spaceExplorer.determineCrew();
			spaceExplorer.setName();
			spaceExplorer.setNumberOfParts();
			System.out.println("=| All crew members have been given names.");
			System.out.println("=| Time to begin the adventure!");
			System.out.println("===========================================================");
			while ((spaceExplorer.getCurrentDays() <= spaceExplorer.getNumberOfDays()) && (spaceExplorer.getNumberOfPartsFound() < spaceExplorer.getNumberOfParts())) {
				newPlayer.nextDay(spaceExplorer);
				System.out.println("=| Day " + spaceExplorer.getCurrentDays() + "..");
				if (spaceExplorer.getCurrentDays() > 2) {
					RandomEvent random = new RandomEvent();
					random.pickEvent(spaceExplorer);
				}
				spaceExplorer.playMain();
				System.out.println("=============================================");
			}
	 }
	 
	 /**
	  * Calls the main() method.
	  */
	public static void main(String[] args) {
		main();
	}

}
