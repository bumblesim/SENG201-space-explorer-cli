package explorer;

public class RandomEvent {

    public void alienPirates(Adventure adventure) {
    	boolean hasLuckyMan = false; 
    	
    	for (int i = 0; i < adventure.getChosenCrew().size(); i++) {
			if (adventure.getChosenCrew().get(i) instanceof LuckyMan) {
				hasLuckyMan = true;
			}
    	}
        try {
        	int randomNum = (int)(Math.random() * ((100 - 1) + 1));
        	if (hasLuckyMan) {
        		if (randomNum > 50) {
        			System.out.println("=| Because you had a LuckyMan, the Alien Pirates were unsuccessful in raiding your ship.");
        		} else {
        			System.out.println("=| Alien pirates are raiding your ship!");
                	adventure.ship.removeRandom();
        		}
        	} else {
    			System.out.println("=| Alien pirates are raiding your ship!");
            	adventure.ship.removeRandom();
    		}
        	}
        	catch(Exception e) {
        	  System.out.println("=| Your inventory is empty. The alien pirates were unsuccesful in stealing any items.");
        	}
        }
   
    public void spacePlague(Adventure adventure) {
        for (int i = 0; i < adventure.getChosenCrew().size(); i++) {
        	int randomNum = (int)(Math.random() * ((10 - 1) + 1));
    		if (randomNum > 8) {
    			System.out.println("=| " + adventure.getChosenCrew().get(i).getName() + " has been hit with the plague. ");
    			adventure.getChosenCrew().get(i).setDiseased(true);
    		}
        }    
    }
   
    public void asteroidBelt(Adventure adventure) {
    	System.out.println("You have run through an asteroid belt!");
    	adventure.ship.updateShieldLevel();
    }
    
    public void pickEvent(Adventure adventure) {
		int randomNum = (int)(Math.random() * ((3 - 1) + 1));
    	if (randomNum == 1) {
    		alienPirates(adventure);
    	}
    	else if (randomNum == 2) {
    		spacePlague(adventure);
    	} else {
    		asteroidBelt(adventure);
    		
    	}
    }

 
}
