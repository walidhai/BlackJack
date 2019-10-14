# BlackJack
> A program that lets two participants play a game of Blackjack with each other
given a set of rules.

This program lets a player, in this case Sam, and a dealer play a game of Blackjack.
As the assignment I was doing didn't mention user input, I made both dealer and sam static player classes. The code is written so it can easily be made more interactive with input from the user.
The game starts with initializing a deck, which is either given as an argument when running the program or from a file that is already in the same folder, called Self.txt.
The rules and points of each participant decides the winner or loser.


# Running the Program
```sh
java Game.java [Filename]
```
There are some text files included with the program. Some of them checking edge cases given in the methods for reading the files. ShuffleDeck.txt and Self.txt are recommended to try, and if you don't use any files in the command line, the program will use Self.txt for init of the deck. For each run of the program, there will only be one walkthrough of the game. Each time with different output. The code written in the program makes it customizable if people want to run the game with more hands.

As for now the reading of the file should not exceed O(N^2) in time complexity and drawing of cards O(N).
