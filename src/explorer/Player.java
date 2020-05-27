package explorer;


public class Player {
	
	public void viewCrew(CrewMember member) {
		member.viewStatus();
	}
	
	
	public void viewShip(Adventure adventure) {
		adventure.ship.viewShip();
	}
	
	public void viewShop(Adventure adventure) {
		adventure.planet.shop.viewShop(adventure);
	}
	
	public void nextDay(Adventure adventure) {
		//check pieces needed and no. of days, victory/defeat
		adventure.setCurrentDays(adventure.getCurrentDays() + 1);
		if (adventure.getNumberOfPartsFound() >= adventure.getNumberOfParts()) {
			finishGame("Won", adventure);
			
		} else if (adventure.getCurrentDays() >= adventure.getNumberOfDays()) {
			finishGame("Lost", adventure);
			
		} else {
			for (int i = 0; i < adventure.getChosenCrew().size(); i++) {
				adventure.getChosenCrew().get(i).updateHealth(-(5 + (int)(Math.random() * (10 - 5))));
				adventure.getChosenCrew().get(i).updateHunger(25 + (int)(Math.random() * (35 - 25)));
				adventure.getChosenCrew().get(i).updateTiredness(20 + (int)(Math.random() * (30 - 20)));
				adventure.getChosenCrew().get(i).setActionsRemaining(2);
				
				if (adventure.getChosenCrew().get(i).isDiseased()) {
					adventure.getChosenCrew().get(i).increaseDiseased();
					adventure.getChosenCrew().get(i).updateHealth(-4 * adventure.getChosenCrew().get(i).getDiseasedCount());
				}
				
				if (adventure.getChosenCrew().get(i).getHealth() <= 0 || adventure.getChosenCrew().get(i).getTiredness() >= 100 || adventure.getChosenCrew().get(i).getHunger() >= 100) {
					System.out.println("=| Oh dear, player " + adventure.getChosenCrew().get(i).getName() + " has died due to poor health.");
					adventure.removeCrew(adventure.getChosenCrew().get(i));
				if (adventure.getChosenCrew().size() == 0) {
					finishGame("Lost", adventure);
				}
				}
			}
		}
		
	}
	
	
	public void finishGame(String string, Adventure adventure) {
		//victory screen, display the gold pieces, victory/defeat, number of days etc
		
		if (string == "Won") {
			System.out.println("=============================================");
			System.out.println("=================| VICTORY |=================");
			System.out.println("=| Ship Name: " + adventure.ship.getName());
			System.out.println("=| You won on day " + adventure.getCurrentDays() + "/" + adventure.getNumberOfDays());
			System.out.println("=| Gold Pieces Remaining: " + adventure.ship.getGoldPieces());
			System.out.println("=| Crew Members Remaining: " + adventure.getChosenCrew().size());
			System.out.println("=============================================");
			System.exit(0);
		} else {
			System.out.println("==================| DEFEAT |=================");
			System.out.println("=| Ship Name: " + adventure.ship.getName());
			System.out.println("=| You lost on day " + adventure.getCurrentDays() + "/" + adventure.getNumberOfDays());
			System.out.println("=| Gold Pieces Remaining: " + adventure.ship.getGoldPieces());
			System.out.println("=| Crew Members Remaining: " + adventure.getChosenCrew().size());
			System.out.println("=============================================");
			System.exit(0);
		}
	}
	
}