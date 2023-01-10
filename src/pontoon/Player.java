package pontoon;


import java.util.Scanner;


//Player function - extends from person
public class Player extends Person {

    Scanner input = new Scanner(System.in);

    //Create a new Player
    public Player() {
    	//Set name as "Player"
        super.setName("Player");}


    //Allow player to hit or stand
    public void makeDecision(Deck deck, Deck pile) {

        //Decision holds choice as number
        int  decision = 0;
        //Waiting for an input (getNum)
        boolean getNum = true;

        //while getting number
        while(getNum){
            try{
            	//Print options
                System.out.println("Enter 1 to Hit or 2 to Stand");
                decision = input.nextInt();
                //No longer getting number
                getNum = false;}
            //Error Catch
            catch(Exception e){
            	//Tell player to enter 1 or 2
                System.out.println("Please Enter 1 or 2");
                input.next();}
        }

        
        //If player hits
        if (decision == 1) {
            //Hit from deck
            this.hit(deck, pile);
            //Return if player has blackjack or bust
            if(this.getHand().calculatedValue()>20){
                return;}
            else{
                //Allow to hit or stand again
                this.makeDecision(deck, pile);}
        } else {
            //Player stands
            System.out.println("You stand");}
    }
}
