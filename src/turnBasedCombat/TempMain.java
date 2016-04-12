package turnBasedCombat;

public class TempMain {
	public static void main(String[] args){
		
		Player p = new Player("Jeroen", 200, 175, 30);
		NPC q = new PatheticDemonologist("Jim", "Summoner", 50, 30, 5);
		NPC r = new PatheticDemonologist("Flamey", "Elemental", 40, 30, 15);
		NPC s = new PatheticDemonologist("Alfred", "Cult leader", 40, 30, 10);
		
		System.out.println(""+q.getFireRes() +" " + q.getHolyRes());
		CombatResolved.CombatResolution(p,q,r,s);


		
	}
}

