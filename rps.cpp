//This is a very simple c++ program to run and play the timeless game of rock, paper, scissors on a single game,
// best n of n+2 game basis, or infinite game basis.

#include <iostream>
#include <cstdlib>
#include <stdio.h>
#include <string.h>
#include <time.h>

using namespace std;

void playgame(int loopcount);

int main() {

	string ans;
	cout << "\nWould you like to play rock, paper, scissors?\n";
	cin >> ans;

	if(ans != "yes" && ans != "no"){
		cout << "\nCorrect usage is typing 'yes' or 'no', exiting program.\n" << endl;
		exit(0); 
	}

	if(ans == "no"){
		cout << "\nFair enough.\n" << endl;
		exit(0);
	}

	if(ans == "yes"){

		int loopcount;
		cout << "\nType a positive number to choose how many games you would like to play." << endl;
		cout << "\tIf you type 1, it will be 1 game." << endl;
		cout << "\tIf you type 2, it will be best 2 out of 3." << endl;
		cout << "\tIf you type 4, it wil be best 4 out of 7." << endl;
		cout << "\tThis works for any positive number." << endl;
		cout << "\tIf you type -1, the game will go on infinitely." << endl;
		cin >> loopcount;

		playgame(loopcount);
	}

}

void playgame(int loopcount){

	int pwins = 0;
	int owins = 0;
	string rwin = "You have won the round.\n";
	string rlose = "You have lost the round.\n";
	srand(time(0));

	if(loopcount == -1){
		cout << "\nThis game can last, quite literally, as long as your computer is working.\n";
		cout << "In order to exit this infinite battle between rock, paper, and scissors, type: 'exit'\n";
	}

	while(pwins != loopcount && owins != loopcount) {

		int rand = (std::rand())%3;
		string player;
		string opponent;

		cout << "\nrock, paper, or scissors?\n";
		cin >> player;

		if(player == "exit"){
			exit(0);
		}

		if(player != "rock" && player != "paper" && player != "scissors"){
			cout << "\nCorrect usage is to type 'rock' or 'paper' or 'scissors'";
		}

		if(rand == 0){
			opponent = "rock";
		}else if(rand == 1){
			opponent = "paper";
		}else{
			opponent = "scissors";
		}

		cout << "\nYou have chosen: " << player << endl;
		cout << "Your opponent has chosen: " << opponent << endl;

		if(opponent == "rock" && player == "paper"){
			cout << rlose;
			owins++;
		}else if(opponent == "rock" && player == "scissors"){
			cout << rwin;
			pwins++;
		}else if(opponent == "paper" && player == "rock"){
			cout << rlose;
			owins++;
		}else if(opponent == "paper" && player == "scissors"){
			cout << rwin;
			pwins++;
		}else if(opponent == "scissors" && player == "paper"){ 
			cout << rlose;
			owins++;
		}else if(opponent == "scissors" && player == "rock"){
			cout << rwin;
			pwins++;
		}else if(opponent == player){
			cout << "Tie round\n";
		}

		cout << "Current score: you/opponent  " << pwins << "/" << owins << endl;
	}
	
	if(owins == loopcount){
		cout << "You have lost the game, better luck next time.\n";
	}else{
		cout << "You have won the game, congratulations/n";
	}
}
