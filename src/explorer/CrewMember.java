package explorer;

public abstract class CrewMember {
	
	private int health;
	private int crafting;
	private int treasureHunting;
	private String name;
	private int actionsRemaining = 2;
	
	private int tiredness = 0;
	private int hunger = 0;
	
	private boolean isDiseased = false;
	private int diseasedCount = 0;
	
	public CrewMember(int tempHealth, int tempCrafting, int tempTreasureHunting) {
		this.health = tempHealth;
		this.crafting = tempCrafting;
		this.treasureHunting = tempTreasureHunting;
	}
	
	public void viewPlayer() {
		System.out.println("=|   Name: " + name + " | Profession: " + this.getClass().getSimpleName());
		System.out.println("=|        Health: " + health);
		System.out.println("=|        Crafting: " + (crafting) + "%");
		System.out.println("=|        Treasure Hunting: " + (treasureHunting) + "%");
	}
	
	public void viewStatus() {
		System.out.println("=| Name: " + name + " | Profession: " + this.getClass().getSimpleName());
		System.out.println("=|      Health: " + health);
		System.out.println("=|      Hunger: " + hunger + "%");
		System.out.println("=|      Tiredness: " + tiredness + "%");
		System.out.println("=|      Crafting: " + (crafting) + "%");
		System.out.println("=|      Treasure Hunting: " + (treasureHunting) + "%");
		System.out.println("=|      Actions Remaining: " + actionsRemaining);
		if (isDiseased) {
			if (diseasedCount != 1) {
				System.out.println("=|      Diseased: Yes for " + diseasedCount + " days.");
			}
			else {
				System.out.println("=|      Diseased: Yes for 1 day.");
			}
		}
		else {
			System.out.println("=|      Diseased: No ");
		}
	}
	
	public void updateHealth(int num) {
		this.health += num;
		if (this.health >= 99) {
			this.health = 99;
		}
	}
	
	public void updateHunger(int num) {
		hunger += num;
		if (hunger < 0) {
			hunger = 0;
		} else if (hunger > 100) {
			hunger = 100;
		}
	}
	
	public void updateTiredness(int num) {
		tiredness += num;
		if (tiredness < 0) {
			tiredness = 0;
		} else if (tiredness > 100) {
			tiredness = 100;
		}
	}

	public int getHealth() {
		return health;
	}
	
	public void setHealth(int health) {
		this.health = health;
	}
	
	public int getCrafting() {
		return crafting;
	}
	
	public int getTreasureHunting() {
		return treasureHunting;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getActionsRemaining() {
		return actionsRemaining;
	}

	public void setActionsRemaining(int actionsRemaining) {
		this.actionsRemaining = actionsRemaining;
	}

	public int getTiredness() {
		return tiredness;
	}

	public void setTiredness(int tiredness) {
		this.tiredness = tiredness;
	}

	public int getHunger() {
		return hunger;
	}

	public void setHunger(int hunger) {
		this.hunger = hunger;
	}

	public boolean isDiseased() {
		return isDiseased;
	}

	public void setDiseased(boolean isDiseased) {
		this.isDiseased = isDiseased;
	}
	
	public void increaseDiseased() {
		this.diseasedCount += 1;
	}

	public int getDiseasedCount() {
		return diseasedCount;
	}

	public void setDiseasedCount(int diseasedCount) {
		this.diseasedCount = diseasedCount;
	}
	
	public void actionsTurn(int actionsRemaining) {
		if (actionsRemaining != 1) {
			System.out.println(name + " has " + actionsRemaining + " actions remaining.");
		} else {
			System.out.println(name + " has " + actionsRemaining + " action remaining.");
		}
	}
}