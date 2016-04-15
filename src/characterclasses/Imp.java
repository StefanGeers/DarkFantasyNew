package characterclasses;

import java.util.ArrayList;

public class Imp extends Demon{
	
	public Imp(String name, String job, int maxHealth, int currentHealth, int damageDealing) {
		super(name, job, maxHealth, currentHealth);
		ArrayList<String> DMGType = new ArrayList<String>();
		DMGType.add("slashing");
		setDamage(damageDealing);
		setDmgType(DMGType);
		setAttackDescription("The imp charges at you slashing wildly with his razorsharp claws.");
		setArmorDescription("The imp seem weathered and abused, scars riddle his body, from both blades and fire, but the skin seems thin, and his frame frail.");
		setThoughtDescription("All you get from the pathetic imp are some fleeting images of horror, torture and terror. The life of an imp isn't great.");
		
		setPiercingRes(2.0); 
		setBashingRes(3.0);
		setSlashingRes(2.0);
		setBlastRes(1.5);
		setFireRes(0.5);
		setElecRes(0.8);
		setIceRes(1.2);
		setEarthRes(1.5); 
		setDarkRes(0.0);
		setHolyRes(5.0);
		setNatureRes(1.0);
		setSpiritRes(1.0);
	
	}
}
