package pontoon;


//Dealer function - extends from person
public class Dealer extends Person{
	//Create dealer
    public Dealer(){
    	//Set dealers name
        super.setName("Dealer");}

    //Showing dealer's hand
    public void printFirstHand(){
    	//Print dealers current hand with second card hidden
        System.out.println("Dealer's Hand");
        System.out.println(super.getHand().getCard(0));
        System.out.println("Seoond card hidden");
    }



}
