package explorer;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The Class Action.
 * Has all the actions a Crew Member can perform.
 */
public class Action {
	
	
	/**
	 * Check actions.
	 *
	 * @param member checks if the Crew Member can perform the action.
	 * @return true, if successful
	 */
	public boolean checkActions(CrewMember member) {
		if (member.getActionsRemaining() > 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * Change actions.
	 *
	 * @param member reduces the Crew Member action by 1.
	 */
	public void changeActions(CrewMember member) {
		member.setActionsRemaining(member.getActionsRemaining() - 1);
		if (member.getActionsRemaining() == 1) {
			System.out.println("=| " + member.getName() + " has 1 action remaining this turn.");
		} else {
			System.out.println("=| " + member.getName() + " has 0 actions remaining this turn.");
		}
	}
	
	/**
	 * Random number generated food roll.
	 *
	 * @param ship updates the ships inventory with a Food Item found.
	 */
	public void foodRoll(Ship ship) {
		int rngChance = (int)(Math.random() * 100);
		if (rngChance < 11) {
			System.out.println("=| Some shrimp has been found!");
			ship.updateInventory(new Food("Shrimp", 8, 53, "Some nicely cooked shrimp.", 15, 30));
		} else if (rngChance < 26) {
			System.out.println("=| A spicy stew has been found. ");
			ship.updateInventory(new Food("Stew", 9, 62, "It's a meat and potato stew.", 45, 35));
		} else if (rngChance < 51) {
			System.out.println("=| A space trout has been found. ");
			ship.updateInventory(new Food("Trout", 10, 74, "Some nicely cooked trout.", 60, 30));
		} else if (rngChance < 76) {
			System.out.println("=| A tuna potato has been found. ");
			ship.updateInventory(new Food("Tuna Potato", 12, 86, "A baked potato with tuna and sweetcorn.", 70, 40));
		} else if (rngChance < 91) {
			System.out.println("=| You have found some chocolate cake. ");
			ship.updateInventory(new Food("Chocolate Cake", 8, 115, "This looks very tasty.", 25, 75));
		} else {
			System.out.println("=| You have found a space looking shark. ");
			ship.updateInventory(new Food("Shark", 20, 194, "I'd better be careful eating this.", 80, 40));
			}
	}
	
	
	
	/**
	 * Random number generated search roll. Will only roll if RNG <= TreasureHunting of Crew Member being used.
	 *
	 * @param chance the Crew Member chance of finding an item
	 * @param adventure holds information such as the Ship to be updated
	 */
	public void searchRoll(int chance, Adventure adventure) {
		System.out.println("=| Searching the planet for items... ");
		int rngSearch = (int)(Math.random() * 100);
		int rngChance = (int)(Math.random() * 100);
		if (rngSearch <= chance) {
			if (rngChance < 31) {
				if (adventure.planet.getPartsOnPlanet() == 1) {
					System.out.println("=| A part has been found!");
					adventure.ship.updateInventory(new Part());
					adventure.planet.foundPartOnPlanet();
					adventure.setNumberOfPartsFound(adventure.getNumberOfPartsFound() + 1);
					if (adventure.getNumberOfPartsFound() >= adventure.getNumberOfParts()) {
						Player finishGame = new Player();
						finishGame.finishGame("Won", adventure);
					}
				} else {
					System.out.println("=| You would have found a part, however you have exhaused all parts from this planet.");
				}
			} else if (rngChance < 39) {
				System.out.println("=| A Band-Aid has been found. ");
				adventure.ship.updateInventory(new Medical("Band-Aid", 25, 100, "Slows down damage from space plague."));
			} else if (rngChance < 48) {
				System.out.println("=| An Antidote has been found. ");
				adventure.ship.updateInventory(new Medical("Antidote", 50, 400, "Cures the space plague."));
			} else if (rngChance < 64) {
				foodRoll(adventure.ship);
			} else {
				int coinsFound = (int)((Math.random() * 100) * 2);
				System.out.println("=| You have found " + coinsFound + " gold pieces. ");
				adventure.ship.setGoldPieces(adventure.ship.getGoldPieces() + (coinsFound));
			} 
		} else {
			System.out.println("=| No items were found.");
		}
	}

	/**
	 * Attempts to search the planet for parts, items or gold pieces.
	 *
	 * @param adventure to check if an instance of Explorer is true
	 * @param member the member being used for the search
	 */
	public void searchPlanet(Adventure adventure, CrewMember member) {
		if (checkActions(member)) {
			if (member instanceof Explorer) {
				System.out.println("=| Since your member is an Explorer, you have been granted an additional chance. ");
				searchRoll(member.getTreasureHunting(), adventure);
			}
			searchRoll(member.getTreasureHunting(), adventure);
			changeActions(member);
		} else {
			System.out.println("=| Sorry, your crew member does not have any actions remaining this turn.");
		}
	}
	
	
	/**
	 * Crew Member consumes an Item to restore health, reduce tiredness, hunger or become disease free.
	 * 
	 * @param chosenCrew the chosen crew list used to check
	 * if the crew has a Chef.
	 * @param member the Crew Member chosen to be fed.
	 * @param item the Item picked for the crew member to consume.
	 * @param ship the Ship inventory for the Item to be removed.
	 */
	public void feedMember(ArrayList<CrewMember> chosenCrew, CrewMember member, Item item, Ship ship) {
		if (checkActions(member)) {
			if (item instanceof Food) {
				member.updateHealth(((Food) item).getIncreaseHealing());
				boolean hasChef = false;
				for (int i = 0; i < chosenCrew.size(); i++) {
					if (chosenCrew.get(i) instanceof Chef) {
						hasChef = true;
					}
				}
				if (hasChef) {
					member.setHunger(0);
					System.out.println("=| Because your Crew has a Chef, hunger for " + member.getName() + " has been set to 0.");
				} else {
					member.updateHunger(-((Food) item).getReduceHunger());
					
				}
				member.updateHunger(-((Food) item).getReduceHunger());
				member.updateTiredness(-((Food) item).getReduceTiredness());
				System.out.println("=| " + member.getName() + " has consumed 1 " + item.getName());
				System.out.println("===============================================");
				member.viewStatus();
				System.out.println("===============================================");
				changeActions(member);
				ship.removeItem(item);
			} else if (item instanceof Medical) {
				member.updateHealth(((Medical) item).getIncreaseHealing());
				if (item.getName() == "Antidote") {
					member.setDiseased(false);
					member.setDiseasedCount(0);
					member.updateHealth(50);
					System.out.println("=| Your crew member " + member.getName() + " has been cured of all diseases.");
					System.out.println("=| " + member.getName() + " has consumed 1 " + item.getName());
					System.out.println("===============================================");
					member.viewStatus();
				} else {
					member.setDiseasedCount(0);
					member.updateHealth(25);
					System.out.println("=| A band-aid has been placed on " + member.getName() + ". This will help stop the space plague, but not for long!");
					System.out.println("=| " + member.getName() + " has consumed 1 " + item.getName());
					member.viewStatus();
				}
				changeActions(member);
				System.out.println("===============================================");
				ship.removeItem(item);
			} else {
				System.out.println("=| Sorry, but part pieces are not edible.");
			}
			
		} else {
			System.out.println("=| Sorry, your crew member does not have any actions remaining this turn.");
		}
	}
		
	/**
	 * Repairs the ships shields based on the Crafting value from a Crew Member.
	 *
	 * @param adventure the Adventure Ship shieldLevel gets updated by a value
	 * @param member the Crew Member's Crafting value is used to repair the Ship.
	 */
	public void repairShip(Adventure adventure, CrewMember member) {
		if (checkActions(member)) {
			int checkLevel = (int) (adventure.ship.getShieldLevel() + member.getCrafting());
			if (checkLevel > 100) {
				adventure.ship.setShieldLevel(100);
				System.out.println("=| The shield level has been repaired to 100%");
			} else {
				adventure.ship.setShieldLevel(checkLevel);
				System.out.println("=| The shield level has been restored to " + adventure.ship.getShieldLevel() + "%.");
			}
			changeActions(member);
		} else {
			System.out.println("=| Sorry, your crew member does not have any actions remaining this turn.");
		}
	}
    
	/**
	 * Rests a Crew Member to help reduce their Tiredness
	 *
	 * @param chosenCrew used to check if instance of a Doctor.
	 * @param member the Crew Member chosen to rest
	 */
	public void sleepCrew(ArrayList<CrewMember> chosenCrew, CrewMember member) {
		if (checkActions(member)) {
			boolean hasDoctor = false;
			for (int i = 0; i < chosenCrew.size(); i++) {
				if (chosenCrew.get(i) instanceof Doctor) {
					hasDoctor = true;
				}
			}
			if (hasDoctor) {
				member.setTiredness(0);
				System.out.println("=| Because your crew has a Doctor, " + member.getName() + "'s tiredness has been restored completely.");
			} else {
				member.updateTiredness(-40);
			}
			System.out.println("=| " + member.getName() + "'s tiredness has been restored to: " + member.getTiredness() + "%");
			changeActions(member);
			
	} else {
		System.out.println("=| Sorry, your crew member does not have any actions remaining this turn.");
		}	
	}
	
	/**
	 * Choose Crew Members to pilot the Ship and go to a new Planet.
	 * @param chosenCrew cycles through the list and Player can pick two Crew members to pilot the Ship.
	 * @param adventure used to initialize a new Planet Class.
	 */
	public void pilotShip(ArrayList<CrewMember> chosenCrew, Adventure adventure) {
		ArrayList<String> verifiedEntry = new ArrayList<String>();
		ArrayList<CrewMember> pilotCrew = new ArrayList<CrewMember>();
		int count = 0;
		for (int i = 0; i < chosenCrew.size(); i++) {
			if (chosenCrew.get(i).getActionsRemaining() > 0) {
				count += 1;
			}
		}
		if (count >= 2) {
			while (pilotCrew.size() < 2) {
				System.out.println("===============================================");
				for (int i = 0; i < chosenCrew.size(); i++) {
					System.out.println("=| " + (i + 1) + ": " + chosenCrew.get(i).getName() + " | Profession: " + chosenCrew.get(i).getClass().getSimpleName() + " | Actions Remaining: " + chosenCrew.get(i).getActionsRemaining());
					verifiedEntry.add(Integer.toString(i + 1));
				}
				System.out.println("=| " + (chosenCrew.size() + 1) + ": Return");
				System.out.println("===============================================");
				System.out.print("=| Please choose a crew member who will pilot the ship.. ");
				verifiedEntry.add(Integer.toString(chosenCrew.size() + 1));
				String choice = adventure.scan.next();;
				while (verifiedEntry.contains(choice) == false) {
					System.out.println("=| Invalid entry. Please try again.");
					System.out.println("===============================================");
					for (int i = 0; i < chosenCrew.size(); i++) {
						System.out.println("=| " + (i + 1) + ": " + chosenCrew.get(i).getName() + " | Profession: " + chosenCrew.get(i).getClass().getSimpleName() + " | Actions Remaining: " + chosenCrew.get(i).getActionsRemaining());
						verifiedEntry.add(Integer.toString(i + 1));
					}
					System.out.println("=| " + (chosenCrew.size() + 1) + ": Return");
					System.out.println("===============================================");
					System.out.print("=| Please choose a crew member who will pilot the ship.. ");
					verifiedEntry.add(Integer.toString(chosenCrew.size() + 1));
					choice = adventure.scan.next();
				}
				int intChoice = Integer.parseInt(choice);
				if (intChoice == (chosenCrew.size() + 1)) {
					return;
				}
				else if (checkActions(chosenCrew.get(intChoice - 1))) {
					if (pilotCrew.contains(chosenCrew.get(intChoice - 1))) {
						System.out.println("=| Sorry, this member has already piloted the ship.");
					} else {
						pilotCrew.add(chosenCrew.get(intChoice - 1));
						chosenCrew.get(intChoice - 1).setActionsRemaining(chosenCrew.get(intChoice - 1).getActionsRemaining() - 1);
					}
				} else {
					System.out.println("=| Sorry, " + chosenCrew.get(intChoice - 1).getName() + " does not have any actions remaining this turn.");
					System.out.println("=| Please choose a different crew member to pilot the ship.");
				}
			}
			adventure.newPlanet();
			System.out.println("=| The spaceship has taken off and has arrived onto a new planet.");
			
		} else {
			System.out.println("=| Sorry, you don't have enough actions to perform this action. ");
		}
		
	}
	
}
