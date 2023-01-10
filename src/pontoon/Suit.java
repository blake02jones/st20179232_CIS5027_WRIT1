package pontoon;


//List of suits
public enum Suit {
    CLUB("Clubs"),
    DIAMOND("Diamonds"),
    HEART("Hearts"),
    SPADE("Spades");

	
	//Type for name
    String suitName;

    
    //Each suit has a name
    Suit(String suitName) {
        this.suitName = suitName;}

    
    //Name to string
    public String toString(){
        return suitName;}
}
