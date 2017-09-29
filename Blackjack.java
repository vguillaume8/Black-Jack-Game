import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;




public class Blackjack {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		String [] deck = new String [13];
		deck[0]= "2";
		deck[1]= "3";
		deck[2]= "4";
		deck[3]= "5";
		deck[4]= "6";
		deck[5]= "7";
		deck[6]= "8";
		deck[7]= "9";
		deck[8]= "10";
		deck[9]= "J";
		deck[10]= "Q";
		deck[11]= "K";
		deck[12]= "A";
		
		String dealerHand[] = new String[21];
		int numUserCards;
		numUserCards=2;
		int numDealerCards;
		numDealerCards=2;
		Random generator = new Random(System.nanoTime());
		int num = generator.nextInt(13);
		int num2 = generator.nextInt(13);
		int num4= generator.nextInt(13);
		int num5= generator.nextInt(13);
		
		dealerHand[numDealerCards]=deck[num4];
		numDealerCards= numDealerCards+1;
		dealerHand[numDealerCards]=deck[num5];
		numDealerCards= numDealerCards+1;
		System.out.println("The current Dealer Hand is " + handScore(numDealerCards, dealerHand));
		int numCards =0;
		String [] userHand = new String[20];
		userHand[numCards]= deck[num];
		numCards = numCards +1;
		userHand[numCards]= deck[num2];
		numCards = numCards +1;
		//userHand[numUserCards]=getCard(deck);
		//numUserCards++;
		//userHand[numUserCards]= getCard(deck);
		//numUserCards++;
		//printHand(numUserCards, userHand);
		handScore(numDealerCards, dealerHand);
		System.out.println("Here is your deck:");
		for(int i=0; i<numCards; i++){
			System.out.println(userHand[i]);
		}
		System.out.println("Here is you curent hand score: "+handScore(numCards, userHand));
		if(handScore(numUserCards, userHand)==21){
			System.out.println("You Win!!!");
		}
		else{
			int hitOrStay=0;
			WinOrLose: while(handScore(numUserCards, userHand )<21 && hitOrStay ==0){
				//Enter 0 to hit, 1 to stay
				System.out.println("Enter 0 to hit, 1 to stay");
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				hitOrStay= Integer.parseInt(reader.readLine());
				
				if(hitOrStay ==0){
					numCards = numCards+1;
					userHand[numUserCards]=getCard(deck);
					numUserCards++;
					System.out.println("Your current score is " + handScore(numCards, userHand));
					if(handScore(numCards, userHand) < 21){
						continue WinOrLose;
					}
					
				}
				
				
				if(hitOrStay==1){
					if(handScore(numDealerCards, dealerHand)<17){
						numDealerCards= numDealerCards+1;
						dealerHand[numDealerCards]=getCard(deck);
						numDealerCards= numDealerCards+1;
						System.out.println("The current dealer hand is " + handScore(numDealerCards, dealerHand));
					}
					System.out.println("The current dealer hand is " + handScore(numDealerCards, dealerHand));
					if(handScore(numDealerCards, dealerHand)< handScore(numCards, userHand)){
						System.out.println("Congrats!! You Won");
						break;
					}
					else if(handScore(numDealerCards, dealerHand) >21){
						System.out.println("Congrats!!! You Won!!!");
					}
						
						
					else{
						System.out.println("Sorry You Lost");
						break;
				}
				}
				if(handScore(numDealerCards, dealerHand)<17){
					numDealerCards= numDealerCards+1;
					dealerHand[numDealerCards]=getCard(deck);
					numDealerCards= numDealerCards+1;
					System.out.println("The current dealer hand is " + handScore(numDealerCards, dealerHand));
					
				}
				if(handScore(numCards, userHand) > 21){
					System.out.println("Sorry You Lost");
					break;
				}
				if(handScore(numDealerCards, dealerHand) > 21){
					System.out.println("Congrats!!! You Won!");
				}
			
				if(handScore(numDealerCards, dealerHand)< handScore(numCards, userHand)){
					System.out.println("Congrats!! You Won");
					break;
				}
				else{
					System.out.println("Sorry You Lost");
					break;
				}
			
				
			}
			}
				
			

			
		

		
		
		
		//if(handScore(numCards, userHand) ==21){
			//System.out.println("You Win!!!");
			
		//}
		//else{
			/*while(handScore(numCards, userHand)<21){
				System.out.println("Would you like it hit?, Enter yes or no");
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				String hit = reader.readLine();
				if(hit == "yes"){
					getCard(deck);
					}
				if(hit == "no"){
					
				}*/
			
			
		

		

		/*String userinput= reader.readLine();
		if(userinput == "0"){
			System.out.println("The game is over");*/
		
		for(int i=0; i<1; i++){
			//int random = (int)(Math.random() * 12 +0);
			
			//System.out.println(deck[num]);
			//System.out.println(cardScore1(deck[num]));
			
			
		}
		}
		
		
		
		
	
	public static int cardScore1(String PassedIn) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		if(PassedIn == "2"){
			return 2;
		}
		if(PassedIn == "3"){
			return 3;
		}
		if(PassedIn == "4"){
			return 4;
		}
		if(PassedIn == "5"){
			return 5;
		}
		if(PassedIn == "6"){
			return 6;
		}
		if(PassedIn == "7"){
			return 7;
		}
		if(PassedIn == "8"){
			return 8;
		}
		if(PassedIn == "9"){
			return 9;
		}
		if(PassedIn == "10"){
			return 10;
		}
		if(PassedIn == "J"){
			return 10;
		}
		if(PassedIn == "Q"){
			return 10;
		}
		if(PassedIn == "K"){
			return 10;
		}
		if(PassedIn == "A"){
			int value =0;
			while(value != 1 && value != 11){
				System.out.println("Enter 11 or 1 for Ace");
				int Ace = 	Integer.parseInt(reader.readLine());
				//System.out.println("Invalid input, enter 11 or 1");
				value= Ace;
			}
			if(value == 11){
				return 11;
			}
			if(value == 1){
				return 1;
	}
		    
		//System.out.println(PassedIn);
		
		    }
		return 0;
		}



	public static void printHand(int numCards, String hand[]){
		//System.out.print("Here is your hand: ");
		for(int i=0; i<numCards; i++)
		{
			System.out.print(hand[i]+" ");
		}
	}
	public static int handScore(int numCards, String hand[]) throws IOException
	{
		int sum=0;
		for(int i=0; i<numCards; i++)
		{
			//int curentCardScore=cardScore(hand[i]);
			//sum=sum+currentCardScore;
			//cardScore(userHand[i]);
			sum=sum+cardScore1(hand[i]);
			
			
		}
		//find a way to circle through each hand
		return sum;
	}
	public static int cardScore(String card)
	{
		return 0;
	}
	
	public static String getCard(String myDeck[]){
		//get random integer 0-12
		Random generator = new Random(System.nanoTime());
		int num3 = generator.nextInt(13);
		return (myDeck[num3]);
	}
}