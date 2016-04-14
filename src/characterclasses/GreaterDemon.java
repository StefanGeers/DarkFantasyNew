package characterclasses;

import java.util.ArrayList;

public class GreaterDemon extends Demon{

	public GreaterDemon(String name, String job, int maxHealth, int currentHealth, int damageDealing) {
		super(name, job, maxHealth, currentHealth);
		ArrayList<String> DMGType = new ArrayList<String>();
		DMGType.add("bashing");
		setDamage(damageDealing);
		setDmgType(DMGType);
		setAttackDescription("The greater demon slowly advances, raising his shield, when he reaches you he swings his warhammer in a wide arc. \nHe catches you in the stomach, and you double over.");
		setArmorDescription("The greater demon is a terrifying sight, his armor thick, his shield broad and a huge warhammer can be seen in his right hand.");
	
		
		setPiercingRes(0.1); 
		setBashingRes(0.2);
		setSlashingRes(0.1);
		setBlastRes(0.5);
		setFireRes(0.3);
		setElecRes(0.6);
		setIceRes(1.2);
		setEarthRes(0.5); 
		setDarkRes(0.0);
		setHolyRes(5.0);
		setNatureRes(1.0);
		setSpiritRes(1.0);
	
	}
}
