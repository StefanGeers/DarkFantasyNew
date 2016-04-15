package turnbasedcombat;

import java.util.ArrayList;
import java.util.Scanner;

import characterclasses.Character;
import characterclasses.Player;

public class CombatResolved{
		
		public void CombatResolution(Player Player, Character Enemy1){CombatResolution(Player, Enemy1, null, null);}
		public void CombatResolution(Player Player, Character Enemy1, Character Enemy2){CombatResolution(Player, Enemy1, Enemy2, null);}
		
		public static void CombatResolution(Player Player, Character Enemy1, Character Enemy2, Character Enemy3){
			
			int playerHP = Player.getCurrentHP();
			int totalEnemyHP = Enemy1.getCurrentHP()+Enemy2.getCurrentHP()+Enemy3.getCurrentHP();
			//int playerDMG = Player.getDamage();
						
			while (playerHP > 0 && totalEnemyHP > 0){
				if (Player.getCurrentHP() <= 0){
					PlayerDeath.playerDies();
				}
				playerTurn(Player, Enemy1, Enemy2, Enemy3);
				totalEnemyHP = Enemy1.getCurrentHP()+Enemy2.getCurrentHP()+Enemy3.getCurrentHP();
				if(totalEnemyHP > 0){
					theirTurn(Player, Enemy1);
					theirTurn(Player, Enemy2);
					theirTurn(Player, Enemy3);
				}
					System.out.println("\n");
			}
			System.out.println("You win!");
		}
		
		private static void playerTurn(Player Player, Character Enemy1, Character Enemy2, Character Enemy3){
			Character target = Player;
			
			System.out.print("Who do you want to interact with?\n 1) " + Enemy1.getProfession() + "\n 2) " + Enemy2.getProfession() + "\n 3) " + Enemy3.getProfession() + "\n 4) yourself! \n 5) I first take another close look at my foes.");
			Scanner input = new Scanner(System.in);
			int choice = input.nextInt();

				switch(choice){
				case 1: target = Enemy1; break;
				case 2: target = Enemy2; break;
				case 3: target = Enemy3; break;
				case 4: target = Player; break;
				case 5: inspect(Player, Enemy1, Enemy2, Enemy3); break;
				default: System.out.println("next time please chooose a listed number"); playerTurn(Player, Enemy1, Enemy2, Enemy3);
			}
			
			System.out.println("What do you want to do?\n 1) Attack \n 2) Defend(To be added) \n 3) Magic(To be added) \n 4) Items \n 5) take another look at your foes");
			choice = input.nextInt();
			if (choice == 1){
				System.out.println("What kind of attack did you have in mind?\n 1) Slash \n 2) Stab \n 3) Pommelstrike");
				choice = input.nextInt();
				switch(choice){
				case 1: slashingAtk(Player, target); break;
				case 2: piercingAtk(Player, target); break;
				case 3: bashingAtk(Player, target); break;
				default: System.out.println("next time please choose a listed number"); playerTurn(Player, Enemy1, Enemy2, Enemy3);
				}
			}
			else if (choice == 2){System.out.println("what did I say about defending? It's not implemented yet, so stop being a scrub and start attacking.");}
			else if (choice == 3){
				System.out.println("What spell do you want to cast?\n 1) Read mind\n 2) Ice Spike\n 3) Fireball");
				choice = input.nextInt();
				switch(choice){
				case 1: Magic.MindRead((Character)Player, target); break;
				case 2: Magic.IceSpike((Character)Player, target); break;
				case 3: Magic.Fireball((Character) Player, target); break;
				default: System.out.println("next time please choose a listed number"); playerTurn(Player, Enemy1, Enemy2, Enemy3);
				}
			}
			else if (choice == 4){
				System.out.println("What kind of item did you want to use?\n 1) Health Potion");
				choice = input.nextInt();
				switch(choice){
				case 1: Player.setCurrentHP(Player.getMaxHP()); System.out.println("\n Your wounds knit before your very eyes, and energy surges back into your tired limbs"); break;
				default: System.out.println("next time please choose a listed number"); playerTurn(Player, Enemy1, Enemy2, Enemy3);
				}
			}
			else if (choice == 5){
				inspect(Player, Enemy1, Enemy2, Enemy3);
				
			}
			else{
				System.out.println("please choose a number between 1 and 5"); playerTurn(Player, Enemy1, Enemy2, Enemy3);
			}
		}
		
		private static void inspect(Player Player, Character Enemy1, Character Enemy2, Character Enemy3){
			String standing = "";
			String dead = "";
			String description = "";
			int total = 0;
			boolean death = false;
			
			if (Enemy1.getCurrentHP()>0){
				standing = standing + " a " + Enemy1.getProfession() + ", ";
				description = description + "" + Enemy1.getArmorDescription() + "\n";
				total += 1;
			} else {dead = dead + "a " + Enemy3.getProfession() + ", "; death = true;}
			if (Enemy2.getCurrentHP()>0){
				standing = standing + " a " + Enemy2.getProfession() + ", ";
				description = description + "" + Enemy2.getArmorDescription() + "\n";
				total += 1;
			} else {dead = dead + "a " + Enemy3.getProfession() + ", "; death = true;}
			if (Enemy3.getCurrentHP()>0){
				standing = standing + " a " + Enemy3.getProfession() + ", ";
				description = description + "" + Enemy3.getArmorDescription() + "\n";
				total += 1;
			} else {dead = dead + "a " + Enemy3.getProfession() + ", "; death = true;}
			
			System.out.println("Before you " + total + " foes;" + standing + "still draw breath.");
			
			System.out.println("" + description);
			
			if (death){
			System.out.println("All the while " + dead + " decays into the dirt." );
			}
		playerTurn(Player, Enemy1, Enemy2, Enemy3);
		}
			
		private static void theirTurn(Player Player, Character Enemy){
			if(Enemy.getCurrentHP() > 0){
				DealDamage(Enemy, Player);
				System.out.println("" + Enemy.getAttackDescription() + " You have " + Player.getCurrentHP() + " HP remaining");
			}
			else {return;}
		}
		
		protected static double calcDMGMod(ArrayList<String> atktypes, Character Defender){
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
					default: break;
				}
			}		
			return atkMod;
		}
		
		private static ArrayList<String> PlayerDMGMod(Player Player, String attackType){
			ArrayList<String> Combined = new ArrayList<String>();
			Combined.add(attackType);
			if (Player.getDmgType() != null){
			Combined.addAll(Player.getDmgType());
			}
			if (Player.Weapon.getDmgType()!= null){
			Combined.addAll(Player.Weapon.getDmgType());
			}
			return Combined;
		}
		
		//Death text
		protected static void Death(Character Defender){
			
			if (Defender.getCurrentHP() <= 0){
				System.out.println("\nThe " + Defender.getProfession() + " collapses under the weight of his wounds. He dies on the cold ground.");
			}

			else {System.out.println("Something went wrong you shouldnt be seeing this. Death sequence went wrong.\nDeath is to blame, the character apperently beat death at chess, winning his soul back.");}
			
		}
		
		private static void DealDamage(Character Attacker, Character Defender){
			int newHealth = Defender.getCurrentHP();
			double dmgMod = calcDMGMod(Attacker.getDmgType(), Defender);
			newHealth -= (int)Math.round(Attacker.getDamage() * dmgMod);
			
			if (newHealth <= 0){
				newHealth = 0;
				Defender.setCurrentHP(newHealth);
				Death(Defender);
				return;
			}
			
			Defender.setCurrentHP(newHealth);
		}
		
		private static void piercingAtk(Player Player, Character Defender){
			int newHealth = Defender.getCurrentHP();
			if (newHealth <= 0){System.out.println("Stop stabbing the corpse you psychopath!"); return;}
			double dmgMod = calcDMGMod(PlayerDMGMod(Player, "piercing"), Defender);
			int damage = (int)Math.round(Player.Weapon.getPierceDMG() * dmgMod); //done sepparatly so that it can be used in text later
			newHealth -= damage;
			
			System.out.println("You rush forward and stab them with the pointy end of your " + Player.Weapon.getName() + ". Dealing " + damage + " damage to the " + Defender.getProfession() + ".\n");
			
			if (newHealth <= 0){
				newHealth = 0;
				Defender.setCurrentHP(newHealth);
				Death(Defender);
				return;
			}
			
			Defender.setCurrentHP(newHealth);
		}
		private static void bashingAtk(Player Player, Character Defender){
			int newHealth = Defender.getCurrentHP();
			if (newHealth <= 0){System.out.println("You start grinding the corpse of the " + Defender.getProfession() + " into a fine bloody paste."); return;}
			double dmgMod = calcDMGMod(PlayerDMGMod(Player, "bashing"), Defender);
			int damage = (int)Math.round(Player.Weapon.getPierceDMG() * dmgMod); //done sepparatly so that it can be used in text later
			newHealth -= damage;
			
			System.out.println("You use the hard end of you weapon to make a nice dent in the enemies skull. Dealing  " + damage + " damage to the " + Defender.getProfession() + ".\n");
						
			if (newHealth <= 0){
				newHealth = 0;
				Defender.setCurrentHP(newHealth);
				Death(Defender);
				return;
			}
			
			Defender.setCurrentHP(newHealth);
		}
		private static void slashingAtk(Player Player, Character Defender){
			int newHealth = Defender.getCurrentHP();
			if (newHealth <= 0){System.out.println("You start cutting up the " + Defender.getProfession() + "'s corpse, so as to more easily dispose of it later."); return;}
			double dmgMod = calcDMGMod(PlayerDMGMod(Player, "slashing"), Defender);
			int damage = (int)Math.round(Player.Weapon.getPierceDMG() * dmgMod); //done sepparatly so that it can be used in text later
			newHealth -= damage;
			
			System.out.println("With a swift flurry of blows you slice your oponent to ribbons. Dealing " + damage + " damage to the " + Defender.getProfession() + ".\n");
			
			if (newHealth <= 0){
				newHealth = 0;
				Defender.setCurrentHP(newHealth);
				Death(Defender);
				return;
			}
			
			Defender.setCurrentHP(newHealth);
		}
		
	}
