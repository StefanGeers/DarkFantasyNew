package characterclasses;

public class Mage extends Humanoid {

	//piercing, bashing, slashing resistance all remain at 1.0
	
	public Mage(String name, String job, int maxHealth, int currentHealth) {
		super(name, job, maxHealth, currentHealth);

		setPiercingRes(1.0); 
		setBashingRes(1.0);
		setSlashingRes(0.5);
		setBlastRes(1.0);
		setFireRes(0.8);
		setElecRes(1.0);
		setIceRes(1.2);
		setEarthRes(1.0); 
		setDarkRes(1.0);
		setHolyRes(1.0);
		setNatureRes(1.0);
		setSpiritRes(1.0);
	}
}