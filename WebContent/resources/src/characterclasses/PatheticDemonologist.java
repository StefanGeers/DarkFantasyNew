package characterclasses;

import java.util.ArrayList;

public class PatheticDemonologist extends Mage {

	public PatheticDemonologist(String name, String job, int maxHealth, int currentHealth, int damageDealing) {
		super(name, job, maxHealth, currentHealth);
		ArrayList<String> DMGType = new ArrayList<String>();
		DMGType.add("blast");
		DMGType.add("fire");
		setDamage(damageDealing);
		setDmgType(DMGType);
		setAttackDescription("Meanwhile the man chants and a ball of fire forms between his gnarled fingers. \nWith an evil glint in his eye he throws it at you, hitting you square in the shoulder.");
		setArmorDescription("The man is clad in an old tattered robe, on some exposed flesh you can see old burn marks.");
		setThoughtDescription("\n" + '"' + "Stop struggling you pathetic demons and submit to my will slave. Now when this pathetic wretch is dead I'm going home and summon myself a nice succubus."+ '"'+"\n" + '"' + "Your mind begins to flood with horrible visions to terrible to describe here and you quickly disconnect" + '"');
	}
}