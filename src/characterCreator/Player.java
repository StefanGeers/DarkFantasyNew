package characterCreator;

import turnBasedCombat.Sword;
import turnBasedCombat.Weapon;

public class Player extends Character{
	private String playerName;
	//private Account account;
	
	public Weapon Weapon = new Sword("sword", 40, 10, 25);

	public Player(String PC_name, int maxHealth, int currentHealth, int damageDealing){
		super(maxHealth, currentHealth);
		setPlayerName(PC_name);
		setDamage(damageDealing);
	}
	
	public void setPlayerName(String name){
		this.playerName = name;
	}

	public String getName(){
		return this.playerName;
	}
	

}
