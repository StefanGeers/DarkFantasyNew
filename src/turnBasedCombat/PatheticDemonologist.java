package turnBasedCombat;

import java.util.ArrayList;

public class PatheticDemonologist extends Humanoid {

	public PatheticDemonologist(String name, String job, int maxHealth, int currentHealth, int damageDealing) {
		super(name, job, maxHealth, currentHealth);
		ArrayList<String> dmgType = new ArrayList<String>();
		dmgType.add("blast");
		dmgType.add("fire");
		setDamage(damageDealing);
		setDmgType(dmgType);
		setAttackDescription("As the man chants a ball of fire forms between his gnarled fingers, with an evil glint in his eye he throws it at you. Hitting you square in the shoulder.");
		setArmorDescription("The man is clad in an old tattered robe, on some exposed flesh you can see old burn marks.");
	}
}