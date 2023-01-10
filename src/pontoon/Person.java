package pontoon;


//Person class
public abstract class Person {
    //Persons hand
    private Hand hand;
    //name - i.e. Player or Dealer
    private String name;


    //Person requires a hand and a name
    public Person(){
        this.hand = new Hand();
        this.name = "";}


    //Setters and Getters
    public Hand getHand(){
        return this.hand;}
    public void setHand(Hand hand){
        this.hand = hand;}
    public String getName(){
        return this.name;}
    public void setName(String name){
        this.name = name;}

    
    //Prints hand
    public void printHand(){
        System.out.println(this.name + "'s hand: ");
        System.out.println(this.hand + " Value: " + this.hand.calculatedValue());}

    
    //Player hits from deck, (discard deck if needed
    public void hit(Deck deck, Deck discard){
        //If there are no cards left in the deck
        if (!deck.hasCards()) {
            //Get cards from discard pile
            deck.reloadDeckFromDiscard(discard);}
        //Take card from deck
        this.hand.takeCardFromDeck(deck);
        //Show person took card
        System.out.println(this.name + " gets a card");
        //Print hand
        this.printHand();
        //Pause to read
        Game.pause();}


    //21 check
    public boolean hasBlackjack(){
    	//Check if person has 21 - return true or false
        if(this.getHand().calculatedValue() == 21){
            return true;}
        else{
            return false;}
    }
}
