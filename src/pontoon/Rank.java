package pontoon;


//List of ranks
public enum Rank {
    ACE("Ace", 11),
    TWO("Two", 2),
    THREE("Three", 3),
    FOUR("Four",4),
    FIVE("Five",5),
    SIX("Six",6),
    SEVEN("Seven",7),
    EIGHT("Eight",8),
    NINE("Nine",9),
    TEN("Ten",10),
    JACK("Jack",10),
    QUEEN("Queen",10),
    KING("King",10);

	
	//Type for name and value
    String rankName;
    int rankValue;

    
    //Each rank has name and value
    Rank(String rankName, int rankValue){
        this.rankName = rankName;
        this.rankValue = rankValue;}
    
    //Rank to string
    public String toString(){
        return rankName;}
}

