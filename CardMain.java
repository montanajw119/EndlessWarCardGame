//Montana Williams
//CS 145
//Card lab
//7/19/2022
//For extra credit I used both stacks (Deck class) and Queues(War class)
//This game of war isn't really playable so much as it's a simulated game.
//      Only user input required is typing something to start the game
//      after instructions. Literally, most of the games I went through I
//      capped at 1000 rounds and they hit that before someone won.

public class CardMain {

    public static void main(String[] args) {
        War gameOfWar=new War();

        gameOfWar.instructions();
        gameOfWar.gamePlay();
        gameOfWar.winner();

    }//end main

}//end cardMain