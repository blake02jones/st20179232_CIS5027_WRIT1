package pontoon;


//Game class stores game logic
public class Game {
    //Declare variables
    private Deck deck, pile; //Deck and discard pile
    private Dealer dealer; //Dealer 
    private Player player; //and Player from respective classes
    private int wins, losses; //Wins and losses


    //Game constructor
    public Game(){
        //Make a new deck
        deck = new Deck(true);
        //Make a blank deck for discarded cards
        pile = new Deck();
        //Create player and dealer
        dealer = new Dealer();
        player = new Player();
        //Shuffle deck
        deck.shuffle();
        //Start the round
        startRound();}


    //Starting a round
    private void startRound(){
        //Check if a round has already been played
        if(wins>0 || losses>0){
        	//Print blank line to separate rounds
        	System.out.println();
        	//Print number of wins and losses
            System.out.println("Next Round - Wins: " + wins + " Losses: " + losses);
            dealer.getHand().discardHandToDeck(pile);
            player.getHand().discardHandToDeck(pile);}
        //Check if there are at least 4 cards left in the non discarded pile
        if(deck.cardsLeft() < 4){
            //Collect discarded cards
            deck.reloadDeckFromDiscard(pile);}
        

        //Give two cards to the dealer
        dealer.getHand().takeCardFromDeck(deck);
        dealer.getHand().takeCardFromDeck(deck);
        //Give two cards to the player
        player.getHand().takeCardFromDeck(deck);
        player.getHand().takeCardFromDeck(deck);
        //Show the dealer's hand with one card hidden
        dealer.printFirstHand();
        //Show the player's hand
        player.printHand();
        

        //Check if dealer has BlackJack to begin with
        if(dealer.hasBlackjack()){
            //Show the dealer's cards
            dealer.printHand();
            	//Tell the player they lost
                System.out.println("You lose. Dealer has 21");
                //Show dealer's hand
                dealer.printHand();
                //Add a loss to the counter
                losses++;
                //Start a new round
                startRound();}

        
        //Check if player has blackjack to begin with
        if(player.hasBlackjack()){
        	//Tell the player they won
            System.out.println("You win! You have 21");
            //Add a win to the counter
            wins++;
            //Start new round
            startRound();}

        
        //Let the user hit or stick
        player.makeDecision(deck, pile);

        
        //Check if player went bust
        if(player.getHand().calculatedValue() > 21){
        	//Tell the player they went bust
            System.out.println("Bust. You have gone over 21");
            //Add a loss to the counter
            losses ++;
            //Start new round
            startRound();}
        

        //Show dealer's hand
        dealer.printHand();
        //Dealer can hit if below 17
        while(dealer.getHand().calculatedValue()<17){
            dealer.hit(deck, pile);}
        
        
        //If dealer passed 21
        if(dealer.getHand().calculatedValue()>21){
        	//Print "Dealer went bust"
            System.out.println("Dealer went bust");
            //Add a win to the counter
            wins++;}
        //If the dealer's hand is better than the player's
        else if(dealer.getHand().calculatedValue() > player.getHand().calculatedValue()){
        	//Print "You lose"
            System.out.println("You lose");
            //Add a loss to the counter
            losses++;}
        //If the player's hand is better than the dealer's
        else if(player.getHand().calculatedValue() > dealer.getHand().calculatedValue()){
        	//Print "You win"
            System.out.println("You win");
            //Add a win to the counter
            wins++;}

 
        //Start new round
        startRound();}
    
    //Small pause to allow the player to read the text displayed
    public static void pause(){
    try {
        Thread.sleep(5000);}//5000ms or 5 seconds
    //Catch for error handling
    catch (InterruptedException e) {
        e.printStackTrace();}
}
}
