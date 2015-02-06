/**
    	Runs a simulator that lets the user play video poker until they either choose to stop or until they run out of money
*/

import java.util.Scanner;
public class PokerSimulator {

		
		public static void main(String[] args)
		{
			
			int cardsRemoved = 0;
			int nextCard = 0;
			Deck deck = new Deck();
			Hand hand = new Hand(deck);
			JavaDollars wallet;
			Scanner scanner = new Scanner(System.in);
			System.out.println("How many JavaDollars will you play with (enter a number greater than 0)");
			if(scanner.hasNextInt()) 
			{
				int money = scanner.nextInt();
				boolean hasWallet = false;
				wallet = new JavaDollars(money);
				while(!hasWallet)
				{
					if(money >0){
						hasWallet = true;}
					else 
					{
						System.out.println("Enter a number greater than 0");
						money = scanner.nextInt();
						wallet.add(money);
					}
				}
			}
			else
			{
				System.out.println("ERROR: Please use integer values ONLY!");
				return;
			}
			
			do
			{
				System.out.println("Your budget: " + wallet.funds() + " JavaDollars");
				System.out.println("Play a new hand? (yes/no/help) ");
				String play = scanner.next();
				if(play.equalsIgnoreCase("yes") || play.equalsIgnoreCase("y"))
				{
					if(wallet.funds() <= 0)
					{
						System.out.println("You have no money! Please play again later");
						break;
					}
					System.out.println("How much would you like to bet? (funds: " + wallet.funds() + ")");
					int bet = scanner.nextInt();
					if(bet>wallet.funds())
					{
						System.out.println("You dont have enough money!");
						continue;
					}
					wallet.bet(bet);
					hand.add(deck.deal());
					hand.add(deck.deal());
					hand.add(deck.deal());
					hand.add(deck.deal());
					hand.add(deck.deal());
					System.out.println(hand.showHand());
					System.out.println("");
					System.out.println("Which card(s) would you like to remove? (type the card numbers, seperated by spaces. type 'keep' to keep all) ");

					if(scanner.hasNextInt())
					{
						System.out.println(scanner.nextLine());
						Scanner sc = new Scanner(scanner.nextLine());
						while(sc.hasNextInt())
						{
							nextCard = sc.nextInt();
							if(nextCard>5 || nextCard<1)
							{
								System.out.println("Please type a number between 1 and 5");
								continue;
							}
							hand.discard(nextCard);
							cardsRemoved++;
						}
					
					
						for(int i =0; i<cardsRemoved;i++)
						{
							hand.add(deck.deal());
						}
					
						System.out.println(hand.showHand());
						System.out.println("(press enter to receive payment)");
					}
					else if (scanner.nextLine().equals("n"))
					{
						//do nothing
					}
					scanner.nextLine();
					System.out.println(hand.handContains());
					wallet.won(hand.handContains());
					System.out.println("You won: " + wallet.wonThisRound() + " JavaDollars this round");
					System.out.println("You've won a total of: " + wallet.totalWon() + " JavaDollars (includes money bet)");
					hand.discardHand();
					deck.shuffle();
				}
				else if(play.equalsIgnoreCase("help") || play.equalsIgnoreCase("h"))
				{
					System.out.println("You are rewarded your prize based on how much you bet, you will recieve Z * prize value, where Z is the amount you bet");
					System.out.println("To view the return value of each set of cards, please read the PDF");
					System.out.println();
					scanner.nextLine();
				}
				else if(play.equalsIgnoreCase("no") || play.equalsIgnoreCase("n"))
					{
							System.out.println("Total won: " + wallet.totalWon());
							System.out.println("Final amount of JavaDollars : " + wallet.funds());
							break;
					}
				else
					System.out.println("Invalid input!");
					
			}
			while(true);
		
		}

}

