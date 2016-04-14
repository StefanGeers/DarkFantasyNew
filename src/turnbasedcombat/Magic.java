package turnbasedcombat;

import java.util.ArrayList;

import characterclasses.Character;

public class Magic extends CombatResolved{

	public static void MagicResolved(ArrayList<String> atkTypes, Character caster, Character target, String magicFlavour, int spellDMG){
		int newHealth = target.getCurrentHP();
		int dmg = (int)Math.round(spellDMG * calcDMGMod(atkTypes, target));
		newHealth -= dmg;
		
		System.out.println("" + magicFlavour + " It deals: " + dmg + "damage.");
		
		if (newHealth <= 0){
			newHealth = 0;
			target.setCurrentHP(newHealth);
			Death(target);
			return;
		}
	}
	
	public static void MindRead(Character caster, Character target){
		int spellDMG = 10;
		ArrayList<String> atkTypes = new ArrayList<String>();
		atkTypes.add("blast");
		atkTypes.add("spirit");
		
		String magicFlavour = "You reach out with your mind, invading that of the " + target.getProfession()+ "." + target.getThoughtDescription();
		
		MagicResolved(atkTypes, caster, target, magicFlavour, spellDMG);
	}
	
	public static void Fireball(Character caster, Character target){
		int spellDMG = 50;
		ArrayList<String> atkTypes = new ArrayList<String>();
		atkTypes.add("blast");
		atkTypes.add("fire");
		
		String magicFlavour = "You weave the intricate sigils, and fire flows from your fingertips, forming into a tight ball. You throw it with glee at the " + target.getProfession()+ ".";
		
		MagicResolved(atkTypes, caster, target, magicFlavour, spellDMG);
	}
	public static void IceSpike(Character caster, Character target){
		int spellDMG = 40;
		ArrayList<String> atkTypes = new ArrayList<String>();
		atkTypes.add("piercing");
		atkTypes.add("ice");
		
		String magicFlavour = "You gather the ambient water in the air, freezing it with the coldness of your soul, forming it into a deadly ice javalin. You throw it with glee at the " + target.getProfession()+ ".";
		
		MagicResolved(atkTypes, caster, target, magicFlavour, spellDMG);
	}
	
}
