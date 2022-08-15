//Montana Williams
//CS 145
//Card lab
//7/19/2022
//For additional comments see CardMain

//This class creates a card object
public class Card {

    private final int suit;
    private final int rank;
    private final String[] cardSuit={"Spades","Clubs","Hearts","Diamonds"};
    private final String[] cardRank={"Ace","Two","Three","Four","Five","Six",
            "Seven","Eight","Nine","Ten","Jack","Queen","King","Joker"};
    
    //Creates a single card object
    public Card(int rank, int suit){
        this.rank=rank;
        this.suit=suit;
    }//end constructor

    //Shows a card
    public void show(){

        if(rank==13) {//Jokers don't have a suit, so display different.
            System.out.println(cardRank[rank]);
        }else{
            System.out.println(cardRank[rank] + " of " + cardSuit[suit]);
        }//end switch/case

    }//end show method

    //Returns the value of a card's rank (aces are low)
    public int getRankValue(){
        return rank;
    }//end getRankValue

}//end Card class
