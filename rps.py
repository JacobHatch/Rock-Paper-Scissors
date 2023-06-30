# This is a very simple python script to run and play the timeless game of rock, paper, scissors on a single game, 
# best n of n+(n-1) game basis, or infinite game basis.

import random

ans = (input("\nWould you like to play rock, paper, scissors?\n")).lower()

if ans == "no":
	print("\nFair enough\n")
	exit(0)

if ans != "no" and ans != "yes":
	print("\nCorrect usage is typing 'yes' or 'no'. Exiting program.\n")
	exit(0)

loop = input("\nType a positive number to choose how many games you would like to play:\n\tIf you type 1, it will be 1 game.\n\tIf you type 2, it will be best 2 out of 3.\n\tIf you type 4, it will be best 4 out of 7.\n\tThis works for any positive number.\n\tIf you type -1, the game will go on infinitely.\n")

def playgame(loopCount):

		pwins = 0
		owins = 0
		rwin = "You have won the round."
		rlose = "You have lost the round."

		if loopCount == -1:
			print("\nThis game can last, quite literally, as long as your computer is working.")
			print("In order to exit this infinite battle between rock, paper, and scissors, type: 'exit'")

		while pwins != loopCount and owins != loopCount:
				
			randNum = random.randint(0, 2)

			player = (input("\nrock, paper, or scissors?\n")).lower()

			if player == "exit":
				exit(0)

			if player != "rock" and player != "paper" and player != "scissors":
				print("Correct usage is to type 'rock' or 'paper' or 'scissors'.")
	
			if randNum == 0:
				opponent = "rock"
			elif randNum == 1:
				opponent = "paper"
			else:
				opponent = "scissors"

			print(f"\nYou have chosen: {player}")
			print(f"Your opponent has chosen: {opponent}\n")
	
			if opponent == "rock" and player == "paper":
				print(rlose + "\n")
				owins += 1
			elif opponent == "rock" and player == "scissors":
				print(rwin + "\n")
				pwins += 1
			elif opponent == "paper" and player == "rock":
				print(rlose + "\n")
				owins += 1
			elif opponent == "paper" and player == "scissors":
				print(rwin + "\n")
				pwins += 1
			elif opponent == "scissors" and player == "paper": 
				print(rlose + "\n")
				owins += 1
			elif opponent == "scissors" and player == "rock":
				print(rwin + "\n")
				pwins += 1
			elif opponent == player:
				print("Tie round\n")
	
			print(f"Current score: you/opponent {pwins}/{owins}\n")

		if owins == loopCount:
			print("You have lost the game, better luck next time")
		else:
			print("You have won the game, congratulations!")


if ans == "yes":
	playgame(int(loop))
