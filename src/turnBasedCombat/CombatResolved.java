package turnBasedCombat;

import java.util.ArrayList;
import java.util.Scanner;

public class CombatResolved {
		
		public void CombatResolution(Player Player, Character Enemy1){CombatResolution(Player, Enemy1, null, null);}
		public void CombatResolution(Player Player, Character Enemy1, Character Enemy2){CombatResolution(Player, Enemy1, Enemy2, null);}
		
		public static void CombatResolution(Player Player, Character Enemy1, Character Enemy2, Character Enemy3){
			
			int playerHP = Player.getCurrentHP();
			int totalEnemyHP = Enemy1.getCurrentHP()+Enemy2.getCurrentHP()+Enemy3.getCurrentHP();
			int playerDMG = Player.getDamage();
			
			while (playerHP > 0 && totalEnemyHP > 0){
				playerTurn(Player, Enemy1, Enemy2, Enemy3);
				totalEnemyHP -= playerDMG;
				if(totalEnemyHP > 0)
					theirTurn();
					System.out.println("The enemies look warry, their current hp is:" + totalEnemyHP);
			}
			System.out.println("You win");
		}
		
		private static void playerTurn(Player Player, Character Enemy1, Character Enemy2, Character Enemy3){
			Character target = Player;
			
			System.out.print("Who do you want to interact with?\n 1) " + Enemy1.getName() + "\n 2) " + Enemy2.getName() + "\n 3)" + Enemy3.getName() + "\n 4) yourself!");
			Scanner input = new Scanner(System.in);
			int choice = input.nextInt();

			switch(choice){
			case 1: target = Enemy1; break;
			case 2: target = Enemy2; break;
			case 3: target = Enemy3; break;
			case 4: target = Player; break;
			}
			
			System.out.println("What do you want to do?\n 1) Attack \n 2) Defend \n 3) Magic \n 4) Items");
			choice = input.nextInt();
			if (choice == 1){
				System.out.println("What kind of attack did you have in mind?\n 1) Slash \n 2) Stab \n 3) Pommelstrike");
				choice = input.nextInt();
				switch(choice){
				case 1: System.out.println("you had to pick 2"); break;
				case 2: piercingAtk(Player, target); break;
				}
			}
		}
			
		private static void theirTurn(){
			System.out.println("They do some damage... I Guess");
		}
		
		private static double calcDMGMod(ArrayList<String> atktypes, Character Defender){
			double atkMod = 1.0;
			
			for (int i = 0 ; i < atktypes.size(); i++){
				switch (atktypes.get(i).toLowerCase()){
					case "piercing": atkMod *= Defender.getPiercingRes(); break;
					case "bashing": atkMod *= Defender.getBashingRes(); break;
					case "slashing": atkMod*= Defender.getSlashingRes(); break;
					case "blast": atkMod *= Defender.getBlastRes(); break;
					case "fire": atkMod *= Defender.getFireRes(); break;
					case "electricity": atkMod *= Defender.getElecRes(); break;
					case "ice": atkMod *= Defender.getIceRes(); break;
					case "earth": atkMod *= Defender.getEarthRes(); break;
					case "dark": atkMod *= Defender.getDarkRes(); break;
					case "holy": atkMod *= Defender.getHolyRes(); break;
					case "nature": atkMod *= Defender.getNatureRes(); break;
					case "spirit": atkMod *= Defender.getSpiritRes(); break;
				}
			}		
			return atkMod;
		}
		
		private int DealDamage(Character Attacker, Character Defender){
			int newHealth = Defender.getCurrentHP();
			double dmgMod = calcDMGMod(Attacker.getDmgType(), Defender);
			newHealth -= (int)Math.round(Attacker.getDamage() * dmgMod);
			
			if (newHealth <= 0){
				newHealth = 0;
			}
			
			return newHealth;
		}
		
		private static void piercingAtk(Player Player, Character Defender){
			int newHealth = Defender.getCurrentHP();
			double dmgMod = calcDMGMod(Player.Weapon.getDmgType(), Defender);
			newHealth -= (int)Math.round(Player.Weapon.getPierceDMG() * dmgMod);
			
			if (newHealth <= 0){
				newHealth = 0;
			}
			
			Defender.setCurrentHP(newHealth);
		}
		private static void bashingAtk(Player Player, Character Defender){
			int newHealth = Defender.getCurrentHP();
			double dmgMod = calcDMGMod(Player.Weapon.getDmgType(), Defender);
			newHealth -= (int)Math.round(Player.Weapon.getPierceDMG() * dmgMod);
			
			if (newHealth <= 0){
				newHealth = 0;
			}
			
			Defender.setCurrentHP(newHealth);
		}
		
	}
