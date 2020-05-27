package explorer;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Sets up the main game. Generates a new Ship, Planet. Stores important information about the adventure.
 */
public class Adventure {
	public Scanner scan = new Scanner(System.in);
	   
    /** The number of days the adventure will go for. */
    private int numberOfDays;
   
    /** The number of Crew Members that the player will be playing with. */
    private int numberOfPlayers;
   
    /** The number of parts the player must find. */
    private int numberOfParts;
    
    /** The number of parts the player has found. */
    private int numberOfPartsFound = 0;
    
    /** The current day in the adventure. */
    private int currentDays = 0;
   
    /** An ArrayList of the Crew Members in the adventure. */
    private ArrayList<CrewMember> chosenCrew = new ArrayList<CrewMember>();
   
    /** The Player's ship. */
    public Ship ship = new Ship();
   
    /** The planet the the player is currently on. */
    public Planet planet = new Planet();
    
    /**
     * Sets numberOfDays to the desired input from the Player. Must be between 3-10.
     */
	public void setNumberOfDays() {
    	String[] arg = {"3", "4", "5", "6", "7", "8", "9", "10"};
    	ArrayList<String> validArg = new ArrayList<String>(Arrays.asList(arg));
    	System.out.print("=| How many days would you like to play the for? Please choose between 3 and 10 days.. ");
    	String keyStroke = scan.next();
    	while (validArg.contains(keyStroke) == false) {
    		System.out.println("=| Invalid entry. Please try again.");
    		System.out.print("=| How many days would you like to play the for? Please choose between 3 and 10 days.. ");
    		keyStroke = scan.next();
    	}
    	numberOfDays = Integer.parseInt(keyStroke);
    	System.out.println("=| Number of days has been set to " + numberOfDays + ".");
    	System.out.println("=========================================================================================================================");
    }
    
	/**
	 * Gets the ArrayList of chosenCrew
	 * @return returns the chosenCrew ArrayList
	 */
    public ArrayList<CrewMember> getChosenCrew() {
    	return chosenCrew;
    }
    
    /**
     * Gets the Integer value of numberOfDays
     * @return numberOfDays
     */
    public int getNumberOfDays() {
    	return numberOfDays;
    }
    
    /**
     * Gets the Integer value of numberOfParts
     * @return numberOfParts
     */
    public int getNumberOfParts() {
		return numberOfParts;
	}
    
    /**
     * Sets numberOfParts to numberOfDays * 2/3 and outputs to console the numberOfParts needed to win the game.
     */
	public void setNumberOfParts() {
		numberOfParts = (numberOfDays * 2/3);
		System.out.println("=| The number of parts you must find is " + numberOfParts + ". ");
		System.out.println("===========================================================");
	}

	
	/**
	 * Gets Integer value of currentDays.
	 * @return currentDays
	 */
	public int getCurrentDays() {
		return currentDays;
	}
	
	/**
	 * Sets currentDays to input Integer value.
	 * @param currentDays an Integer value you wish to update currentDays.
	 */
	public void setCurrentDays(int currentDays) {
		this.currentDays = currentDays;
	}
    
	/**
	 * Sets numberOfPlayers to an Integer value the Player enters. 
	 * Must be between 2-4. Outputs to console the chosen number back to the player.
	 */
    public void setPlayers() {
        String[] arg = {"2", "3", "4"};
    	ArrayList<String> validArg = new ArrayList<String>(Arrays.asList(arg));
    	System.out.print("=| How many crew members would you like to play with? Please choose between 2 and 4 players.. ");
    	String keyStroke = scan.next();
    	while (validArg.contains(keyStroke) == false) {
    		System.out.println("=| Invalid entry. Please try again.");
    		System.out.print("=| How many crew members would you like to play with? Please choose between 2 and 4 players.. ");
    		keyStroke = scan.next();
    	}
    	numberOfPlayers = Integer.parseInt(keyStroke);
    	System.out.println("=| Number of players has been set to " + numberOfPlayers + ".");
    }
    
    
    /**
     * Adds Crew Member classes to the chosenCrew variable. 
     * Player's can choose different crew members by inputting different values.
     */
    public void determineCrew() {
    	String[] arg = {"1", "2", "3", "4", "5", "6"};
    	ArrayList<String> validArg = new ArrayList<String>(Arrays.asList(arg));
    	int picksRemaining = numberOfPlayers - chosenCrew.size();
    	System.out.println("=========================================================================================================================");
    	System.out.println("=| # | Name       | Health | Crafting | Treasure Hunting | Special Ability                                             |=");
        System.out.println("=| 1 | Tank       | 99     | 8%       | 33%              | Immune to the Space Plague                                  |=");
        System.out.println("=| 2 | Explorer   | 37     | 5%       | 75%              | 2 chances of loot while searching                           |=");
        System.out.println("=| 3 | Repair-man | 58     | 28%      | 50%              | Start the game with 100% shield                             |=");
        System.out.println("=| 4 | Luckyman   | 10-99  | 1-30%    | 1-99%            | 50% chance aliens don't steal                               |=");
        System.out.println("=| 5 | Chef       | 45     | 8%       | 20%              | Eating food for all Crew Members restores hunger completely |=");
        System.out.println("=| 6 | Doctor     | 50     | 7%       | 20%              | Sleeping for all Crew Members restores tiredness completely |=");
        System.out.println("=========================================================================================================================");
        while (chosenCrew.size() < numberOfPlayers) {
        	picksRemaining = numberOfPlayers - chosenCrew.size();
            System.out.print("=| Please select a crew member (" + picksRemaining + " picks remaining).. ");
            String crewString = scan.next();
            while (validArg.contains(crewString) == false) {
            	System.out.println("=| Invalid entry. Please try again.");
            	System.out.print("=| Please select a crew member (" + picksRemaining + " picks remaining).. ");
                crewString = scan.next();
            }
            int crewNumber = Integer.parseInt(crewString);
            if (crewNumber == 1) {
                chosenCrew.add(new Tank());
                System.out.println("=| Crew Member Tank has been added to the ship's crew.");
                System.out.println("===========================================================");
            }
            else if (crewNumber == 2) {
            	chosenCrew.add(new Explorer());
            	System.out.println("=| Crew Member Explorer has been added to the ship's crew.");
            	System.out.println("===========================================================");
            }
            else if (crewNumber == 3) {
            	chosenCrew.add(new RepairMan());
            	System.out.println("=| Crew Member RepairMan has been added to the ship's crew.");
            	System.out.println("===========================================================");
            	ship.setShieldLevel(100);
            }
            else if (crewNumber == 4) {
            	int rngHealth = Command.RandomNumbers(10, 99);
            	int rngCrafting = Command.RandomNumbers(1, 30);
            	int rngTreasureHunting = Command.RandomNumbers(1, 99);
            	chosenCrew.add(new LuckyMan(rngHealth, rngCrafting, rngTreasureHunting));
            	System.out.println("=| Crew Member Luckyman has been added to the ship's crew.");
            	System.out.println("===========================================================");
            }
            else if (crewNumber == 5) {
            	chosenCrew.add(new Chef());
            	System.out.println("=| Crew Member Chef has been added to the ship's crew.");
            	System.out.println("===========================================================");
            }
            else if (crewNumber == 6) {
            	chosenCrew.add(new Doctor());
            	System.out.println("=| Crew Member Doctor has been added to the ship's crew.");
            	System.out.println("===========================================================");
            }
            else {
            	System.out.println("=| Invalid entry. Please try again.");
            }
        }
    }
    
    
    /**
     * Removes a Crew Member from the chosenCrew ArrayList
     * @param member the Crew Member being removed from chosenCrew.
     */
    public void removeCrew(CrewMember member) {
    	chosenCrew.remove(member);
    }
    
    /**
     * Cycles through chosenCrew and prompts Player to set a name for each Crew Member.
     * Must be between 3-12 characters.
     * Outputs in console once name has been updated.
     */
    public void setName() {
    	for (int i = 0; i < chosenCrew.size(); i++) {
    		System.out.print("=| Please enter a name for player " + (i + 1) + ": " + chosenCrew.get(i).getClass().getSimpleName() + ": ");
        	String keyStroke = scan.next();
        	while (keyStroke.length() < 3 || keyStroke.length() > 12) {
        		System.out.print("=| Invalid entry. Please enter a name between 3-12 characters: ");
        		keyStroke = scan.next();
        	}
            chosenCrew.get(i).setName(keyStroke);
            System.out.println("Player " + (i + 1) + "'s name (" + chosenCrew.get(i).getClass().getSimpleName() + ") has been updated to " + keyStroke + ".");
            System.out.println("===========================================================");
            }
    	System.out.println("=| Player Breakdown:");
    	System.out.println("===========================================================");
    	for (int i = 0; i < chosenCrew.size(); i++) {
    		System.out.println("=| Player " + (i + 1) + ":");
    		chosenCrew.get(i).viewPlayer();
    		System.out.println("===========================================================");
    	}
    }
    /**
     * Initializes a new Planet. Updates planet variable.
     */
    public void newPlanet() {
    	planet = new Planet();
    	planet.shop.genShop();
    }
    
    /**
	 * Gets the Integer value numberOfPartsFound.
	 *
	 * @return numberOfPartsFound
	 */
	public int getNumberOfPartsFound() {
		return numberOfPartsFound;
	}

	/**
	 * Sets numberOfPartsFound to any given Integer value.
	 *
	 * @param numberOfPartsFound the new Integer value to update numberOfPartsFound to.
	 */
	public void setNumberOfPartsFound(int numberOfPartsFound) {
		this.numberOfPartsFound = numberOfPartsFound;
	}
	
	/**
	 * Updates the Ship's name to what the player enters.
	 * Must be between 3-12 Characters.
	 * Outputs to the console once the name has been updated.
	 */
	public void nameShip() {
		System.out.print("=| Please enter a name for your ship.. ");
		String keyStroke = scan.next();
		while (keyStroke.length() < 3 || keyStroke.length() > 12) {
    		System.out.print("=| Invalid entry. Please enter a name between 3-12 characters: ");
    		keyStroke = scan.next();
    	}
		ship.setName(keyStroke);
		System.out.println("=| The ship's name has been set to " + ship.getName());
		System.out.println("=========================================================================================================================");
	}
	
	/**
	 * Asks player to perform an action with a Crew Member.
	 * Based on input, will execute a method or return.
	 */
	public void playAction() {
		String[] arg = {"1", "2", "3", "4", "5", "6"};
    	ArrayList<String> validArg = new ArrayList<String>(Arrays.asList(arg));
    	System.out.println("===============================================");
    	System.out.println("=| # | Crew Member Action                    |=");
    	System.out.println("=| 1 | Consume a Food/Medical Item           |=");
		System.out.println("=| 2 | Rest a Crew Member                    |=");
		System.out.println("=| 3 | Repair the shields of the ship        |=");
		System.out.println("=| 4 | Search the planet for spaceship parts |=");
		System.out.println("=| 5 | Pilot the ship to a new planet        |=");
		System.out.println("=| 6 | Return                                |=");
		System.out.println("===============================================");
		System.out.print("=| Please select an option.. ");
    	String keyStroke = scan.next();
    	while (validArg.contains(keyStroke) == false) {
    		System.out.println("=| Invalid entry. Please try again.");
    		System.out.print("=| Please select an option.. ");
    		keyStroke = scan.next();
    	}
    	int pick = Integer.parseInt(keyStroke);
    	Action crewAction = new Action();
    	if (pick == 1) {
    		ArrayList<String> newArg = new ArrayList<String>();
    		System.out.println("=============================================");
    		for (int i = 0; i < chosenCrew.size(); i++) {
    			System.out.print("=| " + (i + 1) + ": ");
    			System.out.println(chosenCrew.get(i).getName() + " | Profession: " + chosenCrew.get(i).getClass().getSimpleName() + " | Actions Remaining: " + chosenCrew.get(i).getActionsRemaining());
    			newArg.add(Integer.toString(i + 1));
    		}
    		System.out.println("=| " + (chosenCrew.size() + 1) + ": Return");
    		System.out.println("=============================================");
    		System.out.print("=| Please select a Crew Member to feed.. ");
        	keyStroke = scan.next();
        	while (validArg.contains(keyStroke) == false) {
        		System.out.println("=| Invalid entry. Please try again.");
        		System.out.println("=============================================");
        		for (int i = 0; i < chosenCrew.size(); i++) {
        			System.out.print("=| " + (i + 1) + ": ");
        			System.out.println(chosenCrew.get(i).getName() + " | Profession: " + chosenCrew.get(i).getClass().getSimpleName() + " | Actions Remaining: " + chosenCrew.get(i).getActionsRemaining());
        			newArg.add(Integer.toString(i + 1));
        		}
        		System.out.println("=| " + (chosenCrew.size() + 1) + ": Return");
        		System.out.println("=============================================");
        		System.out.print("=| Please select a Crew Member to feed.. ");
        		keyStroke = scan.next();
        	}
        	int newStroke = (Integer.parseInt(keyStroke) - 1);
        	if (newStroke == chosenCrew.size()) {
        		return;
        	} else {
        		ArrayList<String> itemArg = new ArrayList<String>();
        		System.out.println("=============================================");
        		for (int i = 0; i < ship.getInventory().size(); i++) {
        			System.out.print("=| " + (i + 1) + ": ");
        			ship.getInventory().get(i).sellDetails();
        			itemArg.add(Integer.toString(i + 1));
        		}
        		System.out.println("=| " + (ship.getInventory().size() + 1) + ": Return");
        		System.out.println("=============================================");
        		System.out.println("=| Please select an option.. ");
            	keyStroke = scan.next();
            	while (itemArg.contains(keyStroke) == false) {
            		System.out.println("=| Invalid entry. Please try again.");
            		System.out.println("=============================================");
            		for (int i = 0; i < ship.getInventory().size(); i++) {
            			System.out.print("=| " + (i + 1) + ": ");
            			ship.getInventory().get(i).buyDetails();
            			itemArg.add(Integer.toString(i + 1));
            		}
            		System.out.println("=| " + (ship.getInventory().size() + 1) + ": Return");
            		System.out.println("=============================================");
            		System.out.println("Please select an option.. ");
            		keyStroke = scan.next();
            	}
            	int itemStroke = (Integer.parseInt(keyStroke) - 1);
            	if (newStroke == chosenCrew.size()) {
            		return;
            	} else {
            		crewAction.feedMember(chosenCrew, chosenCrew.get(newStroke), ship.getInventory().get(itemStroke), ship);
            	}
        	}
    	} else if (pick == 2) {
    		ArrayList<String> newArg = new ArrayList<String>();
    		System.out.println("===============================================");
    		for (int i = 0; i < chosenCrew.size(); i++) {
    			System.out.print("=| " + (i + 1) + ": ");
    			System.out.println(chosenCrew.get(i).getName() + " | Profession: " + chosenCrew.get(i).getClass().getSimpleName() + " | Actions Remaining: " + chosenCrew.get(i).getActionsRemaining());
    			newArg.add(Integer.toString(i + 1));
    		}
    		System.out.println("=| " + (chosenCrew.size() + 1) + ": Return");
    		System.out.println("===============================================");
    		System.out.print("=| Please select a Crew Member to rest.. ");
        	keyStroke = scan.next();
        	while (validArg.contains(keyStroke) == false) {
        		System.out.println("=| Invalid entry. Please try again.");
        		System.out.println("===============================================");
        		for (int i = 0; i < chosenCrew.size(); i++) {
        			System.out.print("=| " + (i + 1) + ": ");
        			System.out.println(chosenCrew.get(i).getName() + " | Profession: " + chosenCrew.get(i).getClass().getSimpleName() + " | Actions Remaining: " + chosenCrew.get(i).getActionsRemaining());
        			newArg.add(Integer.toString(i + 1));
        		}
        		System.out.println("=| " + (chosenCrew.size() + 1) + ": Return");
        		System.out.println("===============================================");
        		System.out.print("=| Please select a Crew Member to rest.. ");
        		keyStroke = scan.next();
        	}
        	int newStroke = (Integer.parseInt(keyStroke) - 1);
        	if (newStroke == chosenCrew.size()) {
        		return;
        	} else {
        		crewAction.sleepCrew(chosenCrew, chosenCrew.get(newStroke));
        	}
    	} else if (pick == 3) {
    		ArrayList<String> newArg = new ArrayList<String>();
    		System.out.println("=======================================================");
    		for (int i = 0; i < chosenCrew.size(); i++) {
    			System.out.print("=| " + (i + 1) + ": ");
    			System.out.println(chosenCrew.get(i).getName() + " | Profession: " + chosenCrew.get(i).getClass().getSimpleName() + " | Actions Remaining: " + chosenCrew.get(i).getActionsRemaining());
    			newArg.add(Integer.toString(i + 1));
    		}
    		System.out.println("=| " + (chosenCrew.size() + 1) + ": Return");
    		System.out.println("=======================================================");
    		System.out.println("=| Please select a Crew Member to repair the ship.. ");
        	keyStroke = scan.next();
        	while (validArg.contains(keyStroke) == false) {
        		System.out.println("=| Invalid entry. Please try again.");
        		System.out.println("=======================================================");
        		for (int i = 0; i < chosenCrew.size(); i++) {
        			System.out.print("=| " + (i + 1) + ": ");
        			System.out.println("=| " + chosenCrew.get(i).getName() + " | Profession: " + chosenCrew.get(i).getClass().getSimpleName() + " | Actions Remaining: " + chosenCrew.get(i).getActionsRemaining());
        			newArg.add(Integer.toString(i + 1));
        		}
        		System.out.println("=| " + (chosenCrew.size() + 1) + ": Return");
        		System.out.println("=======================================================");
        		System.out.println("=| Please select a Crew Member to repair the ship.. ");
        		keyStroke = scan.next();
        	}
        	int newStroke = (Integer.parseInt(keyStroke) - 1);
        	if (newStroke == chosenCrew.size()) {
        		return;
        	} else {
        		crewAction.repairShip(this, chosenCrew.get(newStroke));
        	}
    	} else if (pick == 4) {
    		ArrayList<String> newArg = new ArrayList<String>();
    		System.out.println("=============================================");
    		for (int i = 0; i < chosenCrew.size(); i++) {
    			System.out.print("=| " + (i + 1) + ": ");
    			System.out.println(chosenCrew.get(i).getName() + " | Profession: " + chosenCrew.get(i).getClass().getSimpleName() + " | Actions Remaining: " + chosenCrew.get(i).getActionsRemaining());
    			newArg.add(Integer.toString(i + 1));
    		}
    		System.out.println("=| " + (chosenCrew.size() + 1) + ": Return");
    		System.out.println("=============================================");
    		System.out.print("=| Please select an option.. ");
        	keyStroke = scan.next();
        	while (validArg.contains(keyStroke) == false) {
        		System.out.println("=| Invalid entry. Please try again.");
        		System.out.println("=============================================");
        		for (int i = 0; i < chosenCrew.size(); i++) {
        			System.out.print("=| " + (i + 1) + ": ");
        			System.out.println(chosenCrew.get(i).getName() + " | Profession: " + chosenCrew.get(i).getClass().getSimpleName() + " | Actions Remaining: " + chosenCrew.get(i).getActionsRemaining());
        			newArg.add(Integer.toString(i + 1));
        		}
        		System.out.println("=| " + (chosenCrew.size() + 1) + ": Return");
        		System.out.println("=============================================");
        		System.out.print("=| Please select an option.. ");
        		keyStroke = scan.next();
        	}
        	int newStroke = (Integer.parseInt(keyStroke) - 1);
        	if (newStroke == chosenCrew.size()) {
        		return;
        	} else {
        		crewAction.searchPlanet(this, chosenCrew.get(newStroke));
        		playAction();
        	}
    	} else if (pick == 5) {
    		crewAction.pilotShip(chosenCrew, this);
    		
    	} else {
    		return;
    	}
    	}
	
	/**
	 * Asks player to perform an action.
	 * Based on input, will execute a method.
	 */
	public void playMain() {
		String[] arg = {"1", "2", "3", "4", "5"};
    	ArrayList<String> validArg = new ArrayList<String>(Arrays.asList(arg));
    	System.out.println("=============================================");
    	System.out.println("=| # | Action                               |");
		System.out.println("=| 1 | View Status of Crew Members          |");
		System.out.println("=| 2 | Perform an action with a Crew Member |");
		System.out.println("=| 3 | View the status of the Space Ship    |");
		System.out.println("=| 4 | Visit the Space Outpost              |");
		System.out.println("=| 5 | Move on to the next day              |");
		System.out.println("=============================================");
		System.out.print("=| Please select an option.. ");
    	String keyStroke = scan.next();
    	while (validArg.contains(keyStroke) == false) {
    		System.out.println("=| Invalid entry. Please try again.");
    		System.out.println("=============================================");
    		System.out.print("=| Please select an option.. ");
    		keyStroke = scan.next();
    	}
    	int pick = Integer.parseInt(keyStroke);
    	if (pick == 1) {
    		System.out.println("=============================================");
    		for (int i = 0; i < chosenCrew.size(); i++) {
    			chosenCrew.get(i).viewStatus();
    			if (i != chosenCrew.size() - 1) {
    				System.out.println("=============================================");
    			}
    		}
    		playMain();
    		
    	} else if (pick == 2) {
    		playAction();
    		playMain();
    		
    	} else if (pick == 3) {
    		ship.viewShip();
    		playMain();
    		
    	} else if (pick == 4) {
    		planet.shop.viewShop(this);
    		playMain();
        	}
    		else {
    		return;
    	}
	}
	
    
}    
