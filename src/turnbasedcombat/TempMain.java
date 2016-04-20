package turnbasedcombat;

import characterclasses.GreaterDemon;
import characterclasses.Imp;
import characterclasses.NPC;
import characterclasses.PatheticDemonologist;

public class TempMain {
	public static void main(String[] args){
		
		Player p = new Player("Stefan", 200, 175, 30);
		NPC q = new GreaterDemon("O'crap", "Greater Demon", 80, 80, 20);
		NPC r = new Imp("hctiB'elttiL", "Imp", 25, 25, 10);
		NPC s = new PatheticDemonologist("Alfred", "Cult leader", 55, 55, 15);

		System.out.println("You find yourself among the ruins of an ancient library, the books have long gone to dust, but their are still sign of habitation.");
		System.out.println("You advance slowly and silently, in the distance you hear some footsteps approaching, one of which sounds very heavy.");
		System.out.println("You don't have to wait long to find out what it is as a " + q.getProfession() + ", an " + r.getProfession() + " and a cultist round the corner.");
		System.out.println("The battle begins!!!\n");
		CombatResolved.CombatResolution(p,q,r,s);

	}
}