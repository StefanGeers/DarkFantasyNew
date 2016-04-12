package turnBasedCombat;

public class Player extends Character{
	private String playerName;
	
	Weapon Weapon = new Sword("sword", 40, 10, 25);

	//private static boolean playerpresent = false;
	
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
