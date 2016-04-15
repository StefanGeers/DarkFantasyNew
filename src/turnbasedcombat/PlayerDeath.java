package turnbasedcombat;

import java.util.Scanner;

public class PlayerDeath {
	public static void playerDies(){
		System.out.println("As you lie on the hard ground, and it slowly grows colder, you start to wonder if you could have done anything different. Your vision fades and all is blackness. \n\n You died woul you like to try again? 1) Yes!!! 2)Nah, I give up.");
		Scanner input = new Scanner(System.in);
		int choice = input.nextInt();
		
		String[] scrubby = {};
		
		switch(choice){
		case 1: TempMain.main(scrubby); break;
		case 2: System.out.println("Fine give up then! You sicken me!"); System.exit(0);
		default: System.out.println("Please select one or two."); playerDies();
		}
	}
}
