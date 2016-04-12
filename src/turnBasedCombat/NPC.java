package turnBasedCombat;

public class NPC extends Character {
	public NPC(String NPC_name, String job, int maxHealth, int currentHealth){
		super(maxHealth, currentHealth);
		setName(NPC_name);
		setProfession(job);

	}
	
	public NPC(){
		this(null, null, 0, 0);
	}
	
	


	

	
	

}
	

