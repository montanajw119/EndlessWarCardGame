//Montana Williams
//CS 145
//Card lab
//7/19/2022
//For additional comments see CardMain

import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

//This class creates one game of war
public class War {
    Deck warDeck=new Deck();
    Queue<Card> bot=new LinkedList<>();//Bot one hand
    Queue<Card> opponent=new LinkedList<>();//Bot two hand
    private int gameLimit;//Only 1000 games to be played

    //Constructor method. Deals hand.
    public War() {

        this.gameLimit=0;

        //create 2 hands of cards: Bot 1 and 2 (opponent)
        while(!warDeck.shuffledDeck.isEmpty()){
            bot.add(warDeck.draw());
            opponent.add(warDeck.draw());
        }//end while

    }//end constructor

    //Instructions before the game begins
    public void instructions(){
        Scanner input=new Scanner(System.in);

        System.out.println("""
            LET'S PLAY THE CARD GAME WAR!
            This program will simulate up to 1000 of rounds of War: Bot v Opponent bot.
                 
            RULES can be found at https://bicyclecards.com/how-to-play/war/.
            Please note aces are low in this particular program.
           
            The cards have been dealt. Type anything to begin.""");

        input.next();

    }//end instructions

    //Method to actually play the game
    public void gamePlay() {

        do{
            round();
            System.out.println();
            gameLimit++;
        }while (bot.size() > 0 && opponent.size() > 0 && gameLimit<1000);

    }//end gamePlay

    //This method plays one round of war
    public void round (){

        Card duelCardP=bot.remove();
        Card duelCardB=opponent.remove();

        System.out.print("Bot draws "); duelCardP.show();
        System.out.print("Opponent draws "); duelCardB.show();

        cardComparison(duelCardP,duelCardB);

    }// end round

    //Compare which of two cards is higher and place two dueling cards in winners hand.
    //Requires two cards to be assessed
    public void cardComparison(Card duelCardP,Card duelCardB){

        if(duelCardP.getRankValue()> duelCardB.getRankValue()){

            System.out.println("Bot wins this round.");
            bot.add(duelCardP);bot.add(duelCardB);

        }else if(duelCardP.getRankValue()< duelCardB.getRankValue()){

            System.out.println("Opponent wins this round.");
            opponent.add(duelCardP);opponent.add(duelCardB);

        }else {//Cards the same

            System.out.println("We have a war!");
            warTime(duelCardB,duelCardP);

        }//end if

    }//end cardComparison

    //A war is declared - a modified round where more cards are added to deck.
    //Requires two cards that sparked the war.
    public void warTime(Card duelCardP,Card duelCardB){

        Card warCardP=bot.remove();
        Card warCardB=opponent.remove();

        System.out.println("Bot draws "); warCardP.show();
        System.out.println("Opponent draws "); warCardB.show();

        cardComparison(warCardP,warCardB);

        if(warCardP.getRankValue()> warCardB.getRankValue()){
            bot.add(duelCardB);             bot.add(duelCardP);
            bot.add(opponent.remove());     bot.add(opponent.remove());
        }else if(warCardP.getRankValue()< warCardB.getRankValue()) {
            opponent.add(duelCardB);         opponent.add(duelCardP);
            opponent.add(bot.remove());   opponent.add(bot.remove());
        }//end card giving if else

        System.out.println("The winner takes 4 additional cards for each war won.");
    }//end warTime

    //Declares a winner after either one wins or 1000 rounds.
    public void winner(){

        if(gameLimit>=1000){
            System.out.println("We've played 1000 rounds -- I think that's enough.");
        }//end if

        if(bot.size() > 0&& bot.size() > opponent.size()){
            System.out.printf("Bot wins after %d rounds with %d cards!\n",gameLimit,bot.size());
        }else if(opponent.size() > 0 && opponent.size() > bot.size()){
            System.out.printf("Opponent wins after %d rounds with %d cards!\n",gameLimit,opponent.size());
        }//end if

        System.out.println("Thanks for playing!");

    }//end winner


}//end war Class