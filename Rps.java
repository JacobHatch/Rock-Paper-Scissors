import java.util.Scanner;
import java.util.Random;

class Rps{
	public static void main(String[] args){

		Scanner userInput = new Scanner(System.in);

		System.out.println("\nWould you like to play a game of rock, paper, scissors?");
		String ans = userInput.nextLine();
		
		if(ans.equals("no")){
			System.out.println("\nFair enough.\n");
			System.exit(0);
		}

		if((!ans.equals("yes")) && (!ans.equals("no"))){
			System.out.println("\nCorrect usage is typing 'yes' or 'no'. Exiting program.\n");
			System.exit(0);
		}
		
		if(ans.equals("yes")){
			System.out.println("\nType a positive number to choose how many games you would like to play.");
			System.out.println("\tIf you type 1, it will be 1 game.");
			System.out.println("\tIf you type 2, it will be best 2 out of 3.");
			System.out.println("\tIf you type 4, it wil be best 4 out of 7.");
			System.out.println("\tThis works for any positive number.");
			System.out.println("\tIf you type -1, the game will go on infinitely.");

			int loop = userInput.nextInt();

			playGame(loop, userInput);
		}
	}

	public static void playGame(int loopCount, Scanner userInput){

		int pwins = 0;
		int owins = 0;
		String rwin = "You have won the round.";
		String rlose = "You have lost the round.";

		Random rand = new Random();
		long seed = rand.nextLong();
		rand.setSeed(seed);

		if(loopCount == -1){

			System.out.println("\nThis game can last, quite literally, as long as your computer is working.");
			System.out.println("In order to exit this infinite battle between rock, paper, and scissors, type: 'exit'");
		}

		while(pwins != loopCount && owins != loopCount){

			int randNum = rand.nextInt(2);

			System.out.println("\nrock, paper, or scissors?");
			String player = userInput.next();	
			String opponent = "";

			if(player.equals("exit")){
				System.exit(0);
			}

			if(!player.equals("rock") && !player.equals("paper") && !player.equals("scissors")){
				System.out.println("Correct usage is to type 'rock' or 'paper' or 'scissors'");
			}

			if(randNum == 0){
				opponent = "rock";
			}else if(randNum == 1){
				opponent = "paper";
			}else{
				opponent = "scissors";
			}

			System.out.println("\nYou have chosen: " + player);
			System.out.println("Your opponent has chosen: " + opponent);

			if(opponent.equals("rock") && player.equals("paper")){
				System.out.println(rlose + "\n");
				owins++;
			}else if(opponent.equals("rock") && player.equals("scissors")){
				System.out.println(rwin + "\n");
				pwins++;
			}else if(opponent.equals("paper") && player.equals("rock")){
				System.out.println(rlose + "\n");
				owins++;
			}else if(opponent.equals("paper") && player.equals("scissors")){
				System.out.println(rwin + "\n");
				pwins++;
			}else if(opponent.equals("scissors") && player.equals("paper")){ 
				System.out.println(rlose + "\n");
				owins++;
			}else if(opponent.equals("scissors") && player.equals("rock")){
				System.out.println(rwin + "\n");
				pwins++;
			}else if(opponent.equals(player)){
				System.out.println("Tie round\n");
			}
			
			System.out.println("Current score: you/opponent  " + pwins + "/" + owins);
		}
		
		if(owins == loopCount){
			System.out.println("You have lost the game, better luck next time");
		}else{
			System.out.println("You have won the game, congratulations!");
		}
	}
}
