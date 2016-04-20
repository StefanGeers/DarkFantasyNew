package turnbasedcombat;

import java.util.ArrayList;

import characterclasses.Character;
import characterclasses.NPC;
import characterclasses.Player;

public class Magic extends CombatResolved {

	public static void MagicResolved(ArrayList<String> atkTypes, Character caster, Character target,
			String magicFlavour, int spellDMG) {
		int newHealth = target.getCurrentHP();
		int dmg = (int) Math.round(spellDMG * calcDMGMod(atkTypes, target));
		newHealth -= dmg;

		System.out.println("" + magicFlavour + " It deals: " + dmg + "damage.");

		if (newHealth <= 0) {
			newHealth = 0;
			target.setCurrentHP(newHealth);
			Death(target);
			return;
		}
	}

	public static void MindRead(Character caster, Character target) {
		if (target instanceof Player) {
			System.out.println(
					"as you try to read your own mind you become lost in an infinite loop and are lost for all eternity.");
			PlayerDeath.playerDies();
		}
		if (target.getCurrentHP() <= 0) {
			System.out.println("You terrifying images of the great beyond assail your, and you black out.");
			PlayerDeath.playerDies();
		} else {
			int spellDMG = 20;
			ArrayList<String> atkTypes = new ArrayList<String>();
			atkTypes.add("blast");
			atkTypes.add("spirit");

			String magicFlavour = "You reach out with your mind, invading that of the " + target.getProfession() + "."
					+ target.getThoughtDescription();

			MagicResolved(atkTypes, caster, target, magicFlavour, spellDMG);
		}
	}

	public static void Fireball(Character caster, Character target) {
		if (target instanceof Player && caster instanceof Player) {
			System.out.println(
					"You weave the intricate signs to create a blazing inferno, sadly you loose control and burn yourself to a crisp.");
			PlayerDeath.playerDies();
		}
		if (target.getCurrentHP() <= 0) {
			System.out.println("You cremate the corpse of the " + target.getProfession() + ". How noble.");
		} else {
			int spellDMG = 50;
			ArrayList<String> atkTypes = new ArrayList<String>();
			atkTypes.add("blast");
			atkTypes.add("fire");

			String magicFlavour = "You weave the intricate sigils, and fire flows from your fingertips, forming into a tight ball. You throw it with glee at the "
					+ target.getProfession() + ".";

			MagicResolved(atkTypes, caster, target, magicFlavour, spellDMG);
		}
	}

	public static void IceSpike(Character caster, Character target) {
		if (target instanceof Player && caster instanceof Player) {
			System.out
					.println("You decide you've had enough you conjure up a spike of ice and impale yourself upon it.");
			PlayerDeath.playerDies();
		}
		if (target.getCurrentHP() <= 0) {
			System.out.println("Inspired by vlad the impelar you conjure an ice spike and impale the body of the "
					+ target.getProfession() + " upon it. It strikes terror into the hearts of your enemies.");
		} else {
			int spellDMG = 40;
			ArrayList<String> atkTypes = new ArrayList<String>();
			atkTypes.add("piercing");
			atkTypes.add("ice");

			String magicFlavour = "You gather the ambient water in the air, freezing it with the coldness of your soul, forming it into a deadly ice javalin. You throw it with glee at the "
					+ target.getProfession() + ".";

			MagicResolved(atkTypes, caster, target, magicFlavour, spellDMG);
		}
	}

	public static void HolyPrayer(Character caster, Character target) {
		if (target instanceof Player && caster instanceof Player) {
			System.out.println(
					"You pray for salvation from the terror before you, your prayers are answered and you are taken by the gods into their warm, firey embrace.");
			PlayerDeath.playerDies();
		}
		if (target.getCurrentHP() <= 0) {
			System.out.println("You pray for the ressurection of the " + target.getProfession()
					+ ". So you may kill it again. Sadly your prayers go unanswered.");
		} else {
			int spellDMG = 60;
			ArrayList<String> atkTypes = new ArrayList<String>();
			atkTypes.add("spirit");
			atkTypes.add("holy");

			String magicFlavour = "You say a prayer to the great god Imhotep and he bathes the "
					+ target.getProfession() + " in holy fire.";

			MagicResolved(atkTypes, caster, target, magicFlavour, spellDMG);
		}
	}

	public static void Heal(Character caster, Character target) {
		if (target.getCurrentHP() <= 0) {
			System.out.println("You are a great mage but not even you can bring back the dead.");
		} else {
			target.setCurrentHP(target.getMaxHP());
			System.out.println("You heal " + target.getProfession() + " to his maximum health.");
			if (target instanceof NPC) {
				System.out.println("Good job dumbass! The goal is to kill them not heal them.");
			}
		}
	}

}
