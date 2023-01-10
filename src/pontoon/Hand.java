package pontoon;


import java.util.ArrayList;


//Hand class
public class Hand {
	//Make array to store cards
    private ArrayList<Card> hand;
    //Hand is new instance of card list
    public Hand(){
        hand = new ArrayList<Card>();}
    //Take card from deck
    public void takeCardFromDeck(Deck deck){
    	//Add taken card to hand
        hand.add(deck.takeCard());}


    public void discardHandToDeck(Deck discardDeck){
        //Add cards from deck to discard pile
        discardDeck.addCards(hand);
        //Clear hand
        hand.clear();}
    

    //Make new string for cards
    public String toString(){
        //String to be output
        String output = "";
        //For each card in hand
        for(Card card: hand){
            //Add card to output string
            output += card + " - ";}
        //return output
        return output;}
    

    //Value of hand to check who wins
    public int calculatedValue(){
        //Variables for deck value and no. of aces
        int value = 0;
        int aceCount = 0;
        //For each card held
        for(Card card: hand){
            //Add card value hand
            value += card.getValue();
            //Count aces
            if (card.getValue() == 11){
                aceCount ++;}
        }
        
        
        //If bust check ace count
        if (value > 21 && aceCount > 0){
        	//Reduce ace value to 1 to potentially drop under 21
            while(aceCount > 0 && value > 21){
                aceCount --;
                value -= 10;}
        }
        //Return new value
        return value;}


    //Index the cards in hand
    public Card getCard(int idx){
        return hand.get(idx);}
}
