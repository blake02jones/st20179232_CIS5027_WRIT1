package pontoon;


//Card class
public class Card{
	//Suit and rank variable for each card
    private Suit suit;
    private Rank rank;
    //Creating a card requires a suit and a rank
    public Card(Suit suit, Rank rank){
        this.suit = suit;
        this.rank = rank;}
    //New instance of card
    public Card(Card card){
        this.suit = card.getSuit();
        this.rank = card.getRank();}
    //Value of card
    public int getValue(){
        return rank.rankValue;}
    //Suit of card
    public Suit getSuit(){
        return suit;}
    //Rank of card
    public Rank getRank(){
        return rank;}


    //Card as string
    public String toString(){
    	//Show rank, suit and value of card
        return (""+rank+" of "+ suit + " ["+this.getValue()+"]");}
    }