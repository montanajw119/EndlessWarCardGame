//Montana Williams
//CS 145
//Card lab
//7/19/2022
//For additional comments see CardMain

import java.util.Random;
import java.util.Stack;

//This class creates a deck object to manipulate a sum of cards at once
public class Deck {

    private final int cardAmount=52;
    private final Random random=new Random();
    Card[] deck=new Card[cardAmount];
    Stack<Card> shuffledDeck=new Stack<>();

    //Constructor method generates cards and shuffles
    public Deck(){

        int k=0;//index of the arrays
        for(int i=0;i<=3;i++){//4 suits
            for(int j=0;j<=12;j++){//13 cards in each suit
                deck[k]=new Card(j,i);
                k++;
            }//end j
        }//end k

        shuffle();

    }//end constructor

    //Shuffles deck of cards
    public void shuffle (){

        for (int i = 0; i < 1000; i++) {
            int k = random.nextInt(cardAmount);
            Card tmpCard = deck[i%51];
            deck[i%51]=deck[k];
            deck[k] = tmpCard;
        }//end shuffler for

        for(int i=0;i<deck.length;i++){
            shuffledDeck.add(deck[i]);
        }//end queue for

    }//end shuffle

    //Draws a card from the deck
    public Card draw() {
       
        if (shuffledDeck.isEmpty()) {
            System.out.print("Your deck is empty.");
            return new Card(14,1);//return joker
        }else{
            return shuffledDeck.pop();
        }//end if/else

    }//end draw

}//end class Deck
