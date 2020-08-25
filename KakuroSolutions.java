/**
 * KakuroSolutions.java
 * Version 1.0
 * 
 * Written by Joy Valdez
 * Date Created: October 23, 2019
 * Last Modified: January 2, 2020
 */
/*	************************************************************************
 *	DESCRIPTION
 *	The following program is a Kakuro puzzle solution finder.
 *	It will ask the user to enter how many numbers to add, and what 
 *	is the total sum of that many numbers. It will then find all possible 
 *	unique combinations for those restrictions given by the user.
 *	************************************************************************
 */

import java.util.*;

public class KakuroSolutions {
	// Initialized Variables
	final static int ONE = 1, TWO = 2, THREE = 3, FOUR = 4, FIVE = 5;
	final static int  SIX = 6, SEVEN = 7,EIGHT = 8, NINE = 9;
	static int sum,  comboSum, v1, v2, v3, v4, v5, v6, v7, v8, v9;
	
	public static void main(String[] args){
//		test(); // This will display every possible lowest and highest sums
		
		greet();
		rules();
		
		int done = 0, n = 0;
		Scanner keyboard = new Scanner(System.in);
		
		do{
			boolean isGood = false;
			System.out.println();
						
			while (!isGood){	// Asks the user for n numbers to add
				try{
					System.out.println("How many numbers do you wish to add?");
					n = keyboard.nextInt();
					isGood = true;
				}catch(InputMismatchException e){
					keyboard.nextLine();
					System.out.println();
					System.out.println("OPPS! You did not enter a valid number.");
					System.out.println("Try again.");
					System.out.println();
				}
			}
			
			isGood = false;			
			while (!isGood) {	// Asks the user for a total sum
				try {
					System.out.println("What is the total sum of the numbers?");
					sum = keyboard.nextInt();
					isGood = true;
				} catch (InputMismatchException e) {
					keyboard.nextLine();
					System.out.println();
					System.out.println("OPPS! You did not enter a valid number.");
					System.out.println("Try again.");
					System.out.println();
				}
			}
			if ((n < 1 || n > 9) || (sum < 3 || sum > 46)){
				System.out.println("OOPS! Numbers entered are out of range.");
				System.out.println("Make sure you read the rules carefully.");
				rules();
			}
			else{
				System.out.println("Wonderful!! Valid numbers entered.");
				System.out.println("************************************************");
				System.out.println("POSSIBLE KAKURO COMBINATIONS");
				if (n==2)
					Two();
				else if(n==3)
					Three();
				else if(n==4)
					Four();
				else if(n==5)
					Five();
				else if(n==6)
					Six();
				else if(n==7)
					Seven();
				else if(n==8)
					Eight();
				else if (n==9)
					Nine();
				else
					System.out.println("There are no possible combinations of "+ n +" distinct numbers for the sum of "+ sum);
				System.out.println("************************************************");
			}
			
			isGood = false;
			
			while (!isGood) {	// Asks the user if they are done with the program
				try {
					System.out.print("Will that be all? (Enter 1 for yes / 0 for no) ");
					done = keyboard.nextInt();
					if (done != 1 && done != 0){
						System.out.println("\nOPPS! You did not enter a 1 or 0");
						System.out.println("Setting your answer to 0.");
						done = 0;
					}
					isGood = true;
				} catch (InputMismatchException e) {
					keyboard.nextLine();
					System.out.println();
					System.out.println("OPPS! You did not enter a valid answer.");
					System.out.println("Try again.");
					System.out.println();
				}
			}
		}while (done == 0);
		
		System.out.println("\nEnd of Program");
		farewell();
		keyboard.close();
	}//----------------------- End of Main Class -----------------------//
	
	// ---------------------------- Methods -------------------------- //
	public static void test(){
		/*
		 * This Method will display the lowest and highest sum of 
		 * every possible combination between 2 to 9 numbers added
		 */
		System.out.println("TESTING FOR LOWEST & HIGHEST SUMS");
		int low2 = 1+2, high2 = 8+9;
		int low3 = 1+2+3, high3 = 7+8+9;
		int low4 = 1+2+3+4, high4 = 6+7+8+9;
		int low5 = 1+2+3+4+5, high5 = 5+6+7+8+9;
		int low6 = 1+2+3+4+5+6, high6 = 4+5+6+7+8+9;
		int low7 = 1+2+3+4+5+6+7, high7 = 3+4+5+6+7+8+9;
		int low8 = 1+2+3+4+5+6+7+8, high8= 2+3+4+5+6+7+8+9;
		int low9 = 1+2+3+4+5+6+7+8+9, high9= 1+2+3+4+5+6+7+8+9;
		
		System.out.println("Low2 \t"+ low2 + "\tHigh2 \t"+ high2);
		System.out.println("Low3 \t"+ low3 + "\tHigh3 \t"+ high3);
		System.out.println("Low4 \t"+ low4 + "\tHigh4 \t"+ high4);
		System.out.println("Low5 \t"+ low5 + "\tHigh5 \t"+ high5);
		System.out.println("Low6 \t"+ low6 + "\tHigh6 \t"+ high6);
		System.out.println("Low7 \t"+ low7 + "\tHigh7 \t"+ high7);
		System.out.println("Low8 \t"+ low8 + "\tHigh8 \t"+ high8);
		System.out.println("Low9 \t"+ low9 + "\tHigh9 \t"+ high9);		
	}	
	public static void greet(){
		System.out.println("++=============================================++");
		System.out.println("||                                             ||");
		System.out.println("||    Welcome to the Kakuro Solution Finder    ||");
		System.out.println("||                                             ||");
		System.out.println("++=============================================++");
	}
	public static void rules(){
		System.out.println();
		System.out.println("KAKURO PUZZLE RULES:");
		System.out.println("[1] You can add between 2 to 9 numbers total");
		System.out.println("[2] The total sum of a combination must be between 3 and 45");
		System.out.println("[3] Every number that has to be added must be between 1-9");
		System.out.println("[4] Every combination must have distinct numbers added (no repetitions)");
		System.out.println();
	}
	public static void farewell(){
		System.out.println();
		System.out.println("*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*");
		System.out.println("|    Thanks for using the Kakuro Solution Finder    |");
		System.out.println("|         v(^_^)v    Bye for now    v(^_^)v         |");
		System.out.println("*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*");
		System.out.println();
	}
	// ----------------- Methods for finding Possible Sum Combinations ----------------- //
	public static void Two(){	
		// Low = 3 High = 17
		v1 = ONE; v2 = TWO;
		if (sum < 3 || sum > 17){
			System.out.println("There are no possible combinations of 2 distinct numbers for the sum of "+ sum + ".");
			System.out.println("Possible combinations of 2 distinct numbers must have a sum between 3-17\n");
		}
		while(v1 < 10){
			while(v2 < 10){
				comboSum = v1 + v2;
				if (comboSum == sum){
					System.out.println("\t"+v1+" + "+v2);
				}v2++;
			}v1++;
			v2 = v1+1;
		}
	}
	public static void Three(){	
		// Low = 6 High = 24
		v1 = ONE; v2 = TWO; v3 = THREE;
		if (sum < 6 || sum > 24){
			System.out.println("There are no possible combinations of 3 distinct numbers for the sum of "+ sum + ".");
			System.out.println("Possible combinations of 3 distinct numbers must have a sum between 6-24\n");
		}
		while(v1 < 10){
			while(v2 < 10){
				while (v3 < 10) {
					comboSum = v1 + v2 + v3;
					if (comboSum == sum) {
						System.out.println("\t"+v1+" + "+v2+" + "+v3);
					}v3++;					
				}v2++;
				v3 = v2+1;
			}v1++;
			v2 = v1+1;
			v3 = v2+1;
		}
	}
	public static void Four(){	
		// Low = 10 High = 30
		v1 = ONE; v2 = TWO; v3 = THREE;
		v4 = FOUR;
		if (sum < 10 || sum > 30){
			System.out.println("There are no possible combinations of 4 distinct numbers for the sum of "+ sum + ".");
			System.out.println("Possible combinations of 4 distinct numbers must have a sum between 10-30\n");
		}
		while(v1 < 10){
			while(v2 < 10){
				while (v3 < 10) {
					while(v4 < 10){
						comboSum = v1 + v2 + v3 + v4;
						if (comboSum == sum) {
							System.out.println("\t"+v1+" + "+v2+" + "+v3+" + "+v4);
						}v4++;						
					}v3++;
					v4 = v3+1;
				}v2++;
				v3 = v2+1;
				v4 = v3+1;
			}v1++;
			v2 = v1+1;
			v3 = v2+1;
			v4 = v3+1;
		}
	}
	public static void Five(){	
		// Low = 15 High = 35
		v1 = ONE; v2 = TWO; v3 = THREE;
		v4 = FOUR; v5 = FIVE;
		if (sum < 15 || sum > 35){
			System.out.println("There are no possible combinations of 5 distinct numbers for the sum of "+ sum + ".");
			System.out.println("Possible combinations of 5 distinct numbers must have a sum between 15-35\n");
		}
		while(v1 < 10){
			while(v2 < 10){
				while (v3 < 10){
					while(v4 < 10){
						while(v5 < 10){
							comboSum = v1 + v2 + v3 + v4 + v5;
							if (comboSum == sum) {
								System.out.println("\t"+v1+" + "+v2+" + "+v3+" + "+v4+" + "+v5);
							}v5++;
						}v4++;
						v5 = v4+1;
					}v3++;
					v4 = v3+1;
					v5 = v4+1;
				}v2++;
				v3 = v2+1;
				v4 = v3+1;
				v5 = v4+1;
			}v1++;
			v2 = v1+1;
			v3 = v2+1;
			v4 = v3+1;
			v5 = v4+1;
		}
	}
	public static void Six(){	
		// Low = 21 High = 39
		v1 = ONE; v2 = TWO; v3 = THREE;
		v4 = FOUR; v5 = FIVE; v6 = SIX;
		if (sum < 21 || sum > 39){
			System.out.println("There are no possible combinations of 6 distinct numbers for the sum of "+ sum + ".");
			System.out.println("Possible combinations of 6 distinct numbers must have a sum between 21-39\n");
		}
		while(v1 < 10){
			while(v2 < 10){
				while (v3 < 10){
					while(v4 < 10){
						while(v5 < 10){
							while(v6 < 10){
								comboSum = v1 + v2 + v3 + v4 + v5 + v6;
								if (comboSum == sum) {
									System.out.println("\t"+v1+" + "+v2+" + "+v3+" + "+v4+" + "+v5+" + "+v6);
								}v6++;
							}v5++;
							v6 = v5+1;
						}v4++;
						v5 = v4+1;
						v6 = v5+1;
					}v3++;
					v4 = v3+1;
					v5 = v4+1;
					v6 = v5+1;
				}v2++;
				v3 = v2+1;
				v4 = v3+1;
				v5 = v4+1;
				v6 = v5+1;
			}v1++;
			v2 = v1+1;
			v3 = v2+1;
			v4 = v3+1;
			v5 = v4+1;
			v6 = v5+1;
		}
	}
	public static void Seven(){	
		// Low = 28 High = 42
		v1 = ONE; v2 = TWO; v3 = THREE;
		v4 = FOUR; v5 = FIVE; v6 = SIX;
		v7 = SEVEN;
		if (sum < 28 || sum > 42){
			System.out.println("There are no possible combinations of 7 distinct numbers for the sum of "+ sum + ".");
			System.out.println("Possible combinations of 7 distinct numbers must have a sum between 28-42\n");
		}
		while(v1 < 10){
			while(v2 < 10){
				while (v3 < 10){
					while(v4 < 10){
						while(v5 < 10){
							while(v6 < 10){
								while(v7 < 10){
									comboSum = v1 + v2 + v3 + v4 + v5 + v6 +v7;
									if (comboSum == sum) {
										System.out.println("\t"+v1+" + "+v2+" + "+v3+" + "+v4+" + "+v5+" + "+v6+" + "+v7);
									}v7++;
								}v6++;
								v7 = v6+1;
							}v5++;
							v6 = v5+1;
							v7 = v6+1;
						}v4++;
						v5 = v4+1;
						v6 = v5+1;
						v7 = v6+1;
					}v3++;
					v4 = v3+1;
					v5 = v4+1;
					v6 = v5+1;
					v7 = v6+1;
				}v2++;
				v3 = v2+1;
				v4 = v3+1;
				v5 = v4+1;
				v6 = v5+1;
				v7 = v6+1;
			}v1++;
			v2 = v1+1;
			v3 = v2+1;
			v4 = v3+1;
			v5 = v4+1;
			v6 = v5+1;
			v7 = v6+1;
		}
	}
	public static void Eight(){	
		// Low = 36 High = 44
		v1 = ONE; v2 = TWO; v3 = THREE;
		v4 = FOUR; v5 = FIVE; v6 = SIX;
		v7 = SEVEN; v8 = EIGHT;
		if (sum < 36 || sum > 44){
			System.out.println("There are no possible combinations of 8 distinct numbers for the sum of "+ sum + ".");
			System.out.println("Possible combinations of 8 distinct numbers must have a sum between 36-44\n");
		}
		while(v1 < 10){
			while(v2 < 10){
				while (v3 < 10){
					while(v4 < 10){
						while(v5 < 10){
							while(v6 < 10){
								while(v7 < 10){
									while (v8 < 10){
										comboSum = v1 + v2 + v3 + v4 + v5 + v6 + v7 + v8;
										if (comboSum == sum) {
											System.out.println("\t"+v1+" + "+v2+" + "+v3+" + "+v4+" + "+v5+" + "+v6+" + "+v7+" + "+v8);
										}v8++;
									}v7++;
									v8 = v7+1;
								}v6++;
								v7 = v6+1;
							}v5++;
							v6 = v5+1;
							v7 = v6+1;
							v8 = v7+1;
						}v4++;
						v5 = v4+1;
						v6 = v5+1;
						v7 = v6+1;
						v8 = v7+1;
					}v3++;
					v4 = v3+1;
					v5 = v4+1;
					v6 = v5+1;
					v7 = v6+1;
					v8 = v7+1;
				}v2++;
				v3 = v2+1;
				v4 = v3+1;
				v5 = v4+1;
				v6 = v5+1;
				v7 = v6+1;
				v8 = v7+1;
			}v1++;
			v2 = v1+1;
			v3 = v2+1;
			v4 = v3+1;
			v5 = v4+1;
			v6 = v5+1;
			v7 = v6+1;
			v8 = v7+1;
		}
	}
	public static void Nine(){	
		// Low = 45 High = 45
		v1 = ONE; v2 = TWO; v3 = THREE;
		v4 = FOUR; v5 = FIVE; v6 = SIX;
		v7 = SEVEN; v8 = EIGHT; v9 = NINE;
		if (sum != 45){
			System.out.println("There are no possible combinations of 9 distinct numbers for the sum of "+ sum + ".");
			System.out.println("The only possible combination of 9 distinct numbers must be equal to 45\n");
		}	
		else
			System.out.println("\t"+v1+" + "+v2+" + "+v3+" + "+v4+" + "+v5+" + "+v6+" + "+v7+" + "+v8+" + "+v9);
	}
}//-------------------- End of KakuroSolutions Class --------------------//
