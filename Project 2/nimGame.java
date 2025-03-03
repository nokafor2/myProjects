import java.util.Scanner;
import java.util.Random;

public class nimGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to the Nim game!");
	    System.out.println("You may remove 1, 2, or 3 stones at a time.");
	    System.out.println("Whoever removes the last stone loses.");
	    //System.out.println("#1");
	    
	    //nimGameClass nimGameObj = new nimGameClass();
	    
	    int numStones = 10;
	    int baseStone = 7;
	    Random Stones = new Random();
	    int gameCount  = 1;
	    int playAgain = 1;
	    boolean winOrLose = false;
	    int gamesWon = 0;
	    int gamesLost = 0;
	    //int gameNumber = 0;
	    
        System.out.println("Game #"+gameCount);	
		while (playAgain == 1) {    
			    numStones += Stones.nextInt(baseStone);
			while (numStones > 0){
				System.out.println("There are "+numStones+" stones in the pile.");
				Scanner s = new Scanner(System.in);

				System.out.println("How many stones will you like to remove? (1, 2, 0r 3): ");
				
				int numStonesRemove = s.nextInt();
				
				if (numStonesRemove < 1){
			        System.out.println("Please enter 1, 2 , or 3.");
				}    
			    else if (numStonesRemove <= 3) {
			    	numStones -= numStonesRemove;
				    if (numStones <= 0){
				    	winOrLose = false;
				    	gamesLost++;
				    	System.out.println("You lost!"); 
				        //break;
				    }    
					
				    // The computer turn to play.
				    Random baseCpuRandomNum = new Random();
				    int cpuNumStonesRemove = 1;
				    cpuNumStonesRemove += baseCpuRandomNum.nextInt(3);
				    System.out.println("I remove "+cpuNumStonesRemove+" stones from the pile.");
				    numStones -= cpuNumStonesRemove;
				    if (numStones <= 0){
				    	winOrLose = true;
				    	gamesWon++;
				    	System.out.println("You won!"); 
				        //break;
				    }    
			    }    
			    else {
			    	System.out.println("Please enter 1, 2 , or 3.");
			    	//break;	
			    }
		    //System.out.println("Number of stones left "+numStones);	
			}
			System.out.println("You have won "+gamesWon+" out of "+gameCount+" games played.");
			Scanner j = new Scanner(System.in);
			System.out.println("Would you like to play again? (1 = Yes / 0 = No): ");
			playAgain = j.nextInt();
			if (playAgain == 1) {
				numStones = 10;
				gameCount++;
			}	
		}
	}

}
