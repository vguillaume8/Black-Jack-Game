import java.util.Random;
import java.util.Scanner;
import java.io.IOException;
/**
    A simple one player Blackjack Game
    @author Vinston Guillaume
 */
public class Blackjack {
    static Random random = new Random(System.nanoTime());
    static Scanner scanner = new Scanner(System.in);
    static String[] deck = new String[13];
    static String[] UserHand = new String[30];
    static String[] DealerHand = new String[30];
    static int numUserCards = 0;
    static int numDealerCards = 0;
    static int numCards;
//-------------------------------------------------------------------------------

    /**
        Creates the deck of playing cards
        @param deck the deck array
    */
    public static void populateDeck(String[] deck) {
        deck[0] = "2";
        deck[1] = "3";
        deck[2] = "4";
        deck[3] = "5";
        deck[4] = "6";
        deck[5] = "7";
        deck[6] = "8";
        deck[7] = "9";
        deck[8] = "10";
        deck[9] = "J";
        deck[10] = "Q";
        deck[11] = "K";
        deck[12] = "A";
    }
//-------------------------------------------------------------------------------
    /**
        Pulls a random card from the deck
        @param deck the deck array
        @return a random card 
    */
    public static String randomCard(String[] deck) {
        int num = random.nextInt(13);
        return deck[num];
    }
//-------------------------------------------------------------------------------
    /**
        Checks if the user wants to play
        @return is the user is playing
    */
    public static boolean UserisPlaying() {
        System.out.println("Do you wanna play? 1 for yes, 2 for no");
        System.out.println("--------------------------------------");
        int answer = scanner.nextInt();
        if(answer == 2) {
            System.out.println("Good Bye!!!");
            return false;
        }
        return true;
    }
//-------------------------------------------------------------------------------
    /**
        Print the current hand of the player
        @param hand the User's hand
        @param numCards the number of cards dealt
    */
    public static void printHand(String[] hand, int numCards) {
         System.out.print("Deck: ");
         for(int i = 0; i < numCards; i++) {
            System.out.print(hand[i] + " ");
        }
    }
//-------------------------------------------------------------------------------
   /**
        Increments the amount of cards
    */
   public static void incrementCards() {
        numCards++;
        numDealerCards++;
        numUserCards++;
    }
//-------------------------------------------------------------------------------
    /**
        Caluclates the score for each card
        @param PassedIn the card
        @return the value of the card
    */
    public static int cardScore(String PassedIn)  {
        switch (PassedIn) {
            case "null":
                return 0;
            case "2":
                return 2;
            case "3":
                return 3;
            case "4":
                return 4;
            case "5":
                return 5;
            case "6":
                return 6;
            case "7":
                return 7;
            case "8":
                return 8;
            case "9":
                return 9;
            case "10":
                return 10;
            case "J":
                return 10;
            case "Q":
                return 10;
            case "K":
                return 10;
           case "A":
                //System.out.println("Enter 11 or 1 for Ace");
                //int Ace = scanner.nextInt();
                return 11;
                
        }
        return 0;
	}
		

//-------------------------------------------------------------------------------
    /**
        Calculates the score of the User's hand
        @param hand the User's hand 
        @return the score of the User's hand
    */
    public static int handScore(String hand[]) {
		int sum=0;
		for(int i=0; i < hand.length; i++) {
			if(hand[i] != null){
                sum = sum + cardScore(hand[i]);
            }else{
			    return sum;
            }
		

			
			
		}
		//find a way to circle through each hand
		return sum;
	}

    /**
     * Calculates the score of the Dealer's hand
     * @param hand the dealers hand
     * @return the score of the dealer's hand
     */
    public static int dealerScore(String[] hand){
        int sum = 0;
        for(int i = 0; i < hand.length; i++){
            if(hand[i] != null){
                sum = sum + cardScore(hand[i]);
            }else{
                return sum;
            }

        }

        return sum;
    }

//-------------------------------------------------------------------------------
    /**
        Checks if the user has won the game
        @return if the User has won the game
    */
    public static boolean Win() {
        if(handScore(UserHand) > 21) {
            return false;
        }
        if(handScore(UserHand) == 21 ) {
            return true;
        }
        if(dealerScore(DealerHand) > 21 && handScore(UserHand) < 21) {
        return true;
        }
        return false;
    }
//-------------------------------------------------------------------------------
    /**
        Checks if the game is over
        @return if the game is over or not
    */
    public static boolean gameOver() {
        if(handScore(UserHand) > 21) {
            return true;
        }
        if(dealerScore(DealerHand) > 21) {
            return true;
        }
        if(handScore(UserHand) == 21) {
            return true;
        }
        if(handScore(DealerHand) == 21) {
            return true;
        }
        return false;
    }
//-------------------------------------------------------------------------------
    /**
        Asks the user if they would like to hit or stay
     */
    public static void hitOrStay() {
        System.out.println("Would like to hit or Stay? 1 to hit; 0 to stay");
        int hit = scanner.nextInt();
        if(hit == 1) {
            UserHand[numUserCards] = randomCard(deck);
            numUserCards++;
        }
        if(dealerScore(DealerHand) < 17) {
            DealerHand[numDealerCards] = randomCard(deck);
            numDealerCards++;
           // }
        }
        if(dealerScore(DealerHand) >= 17) {
            System.out.println("The Dealer is staying");
        }
        if(hit == 0){
            while(dealerScore(DealerHand) < 17) {
                DealerHand[numDealerCards] = randomCard(deck);
                numDealerCards++;
                System.out.println("Still running");


            }
            gameOver();
        }
       /* else {
            if(handScore(numCards, DealerHand) < 17) {
                DealerHand[numDealerCards] = randomCard(deck);
                gameOver();
                numDealerCards++;
            }*/
        
        numCards++;
        printHand(UserHand, numCards);
        System.out.println();
        System.out.println("Your current score is: " + handScore(UserHand));
        System.out.println("--------------------------------------");
        System.out.print("Dealer's ");
        printHand(DealerHand, numCards);
        System.out.println();
        System.out.println("The Dealer's score is: " + dealerScore(DealerHand));
    }
//-------------------------------------------------------------------------------
    /**
        Resets everything when the game restarts
     */
    public static void reset() {
        numUserCards = 0;
        numCards = 0;
        numDealerCards = 0;
        for(int i =0; i < DealerHand.length; i++) {
            UserHand[i] = null;
            DealerHand[i] = null;
        }
    }


    public static void main(String[] args) {

        while(UserisPlaying() == true) {
            populateDeck(deck);
            UserHand[numUserCards] = randomCard(deck);
            DealerHand[numDealerCards] = randomCard(deck);
            incrementCards();
            printHand(UserHand, numCards); // Prints User Hand
            System.out.println();
            System.out.println("Your current score is: " + handScore(UserHand));
            System.out.println("--------------------------------------");
            printHand(DealerHand, numCards);
            System.out.println();
            System.out.println("The Dealer's score is: " + dealerScore(DealerHand));
            System.out.println("--------------------------------------");
            while(gameOver() == false) {
                hitOrStay();
               // System.out.println(gameOver());
            }
            if(Win() == true) {
                System.out.println("You Won!!!");
            } else {
                System.out.println("Sorry, You lost");
            }
            reset();

            



        }

    }
}