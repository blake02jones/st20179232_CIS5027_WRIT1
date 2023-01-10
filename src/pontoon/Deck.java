package pontoon;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

//Deck class
public class Deck {
    //Array to hold cards in deck
    private ArrayList<Card> deck;
    //Create blank deck
    public Deck(){
        deck = new ArrayList<Card>();}
    //Use constructor for card (c)
    public Deck(Deck c){
        Collections.copy(this.deck, c.getCards());}

    
    //Create deck of cards
    public Deck(boolean makeDeck){
        deck = new ArrayList<Card>();
        if(makeDeck){
            //Iterate through suits and ranks
            for(Suit suit : Suit.values()){
                for(Rank rank : Rank.values()){
                    //Add each card
                    deck.add(new Card(suit, rank));}
            }
        }
    }

    
    //Add card
    public void addCard(Card card){
        deck.add(card);}
    //Add array list of cards to deck
    public void addCards(ArrayList<Card> cards){
        deck.addAll(cards);}

    
    //Create string
    public String toString(){
        //Output for string
        String output = "";
        //For each card in deck
        for(Card card: deck){
        	//Output card and line break
            output += card;
            output += "\n";}
        //Show Output
        return output;}
    

    //Shuffle function
    public void shuffle(){
    	//Shuffle deck at random
        Collections.shuffle(deck, new Random());}


    //Taking a card
    public Card takeCard(){
            //Take first card from deck and remove it
            Card cardToTake = new Card(deck.get(0));
            deck.remove(0);
            //Return card
            return cardToTake;}

    
    //Are there cards left
    public boolean hasCards(){
    	//Return true if deck size > 0 and false if not
        if (deck.size()>0){
            return true;}
        else{
            return false;}
    }
    

    //Cards left in deck
    public int cardsLeft(){
        return deck.size();}

    
    //Array list of cards
    public ArrayList<Card> getCards() {
        return deck;}

    
    //Clears deck
    public void emptyDeck(){
        deck.clear();
    }


    //Reload deck
    public void reloadDeckFromDiscard(Deck pile){
        this.addCards(pile.getCards());
        //Shuffle deck and clear pile
        this.shuffle();
        pile.emptyDeck();
        //Print that the deck is re-shuffling
        System.out.println("Ran out of cards, re-shuffling");}
}
