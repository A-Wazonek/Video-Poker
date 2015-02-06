/**
    	Creates a "wallet" which contains the users JavaDollars
*/

public class JavaDollars {
	private int balance;
	private int wonOverall;
	private int bettingMoney;
	private int[] PAYOUT_LIST = {250,50,25,6,5,4,3,2,1};
	private int wonThisRound;
	
	/**
		Creates a new JavaDollar wallet. 
		@param balance the amount of money the user has.
	*/
	public JavaDollars(int balance)
	{
		this.balance = balance;
		wonOverall = 0;
		wonThisRound = 0;
	}
	

	/**
		Adds the given amount to the user's wallet.
		@param amount the amount to be added to the wallet.
	*/
	public void add(int amount)
	{
		balance += amount;
	}

	/**
		Returns an integer equal to the amount of money in the players wallet.
		@return returns the integer equal to the players balance.
	*/
	public int funds()
	{
		return balance;
	}
	
	/**
		Returns an integer equal to the amount of money the user has won in the most recent round.
		@return returns an integer equal to the amount the user won  this round.
	*/
	public int wonThisRound()
	{
		return wonThisRound;
	}
	
	/**
		Returns the total amount of money the user has won, from each round. The amount of money they have bet is subtracted from this amount.
		@return returns an integer of the total money the user has won.
	 */
	public int totalWon()
	{

		return wonOverall;
	}
	
	/**
		Bets the amount the user wants to bet.
		@param amount the amount the user wants to bet on their current hand.
	 */
	public void bet(int amount)
	{
		balance -= amount;
		wonOverall -= amount;
		bettingMoney = amount;
	}
	
	/**
		Determines what amount of JavaDollars the user has won, by multiplying what they bet by the payout attributed to their current hand. 
		@param prize the string that is checked to see what has been won this round.
	 */
	public void won(String prize)
	{
		wonThisRound = 0;
		if(prize.contains("Royal Flush!")){
			balance += bettingMoney * PAYOUT_LIST[0];
			wonOverall += bettingMoney * PAYOUT_LIST[0];
			wonThisRound = bettingMoney * PAYOUT_LIST[0];
			bettingMoney = 0;
		}
		else if(prize.contains("Straight Flush!")){
			balance += bettingMoney * PAYOUT_LIST[1];
			wonOverall += bettingMoney * PAYOUT_LIST[1];
			wonThisRound = bettingMoney * PAYOUT_LIST[1];
			bettingMoney = 0;
		}
		else if(prize.contains("Four of a kind!")){
			balance += bettingMoney * PAYOUT_LIST[2];
			wonOverall += bettingMoney * PAYOUT_LIST[2];
			wonThisRound = bettingMoney * PAYOUT_LIST[2];
			bettingMoney = 0;
		}
		else if(prize.contains("Full House!")){
			balance += bettingMoney * PAYOUT_LIST[3];
			wonOverall += bettingMoney * PAYOUT_LIST[3];
			wonThisRound = bettingMoney * PAYOUT_LIST[3];
			bettingMoney = 0;
		}
		else if(prize.contains("Flush!")){
			balance += bettingMoney * PAYOUT_LIST[4];
			wonOverall += bettingMoney * PAYOUT_LIST[4];
			wonThisRound = bettingMoney * PAYOUT_LIST[4];
			bettingMoney = 0;
		}
		else if(prize.contains("Straight!")){
			balance += bettingMoney * PAYOUT_LIST[5];
			wonOverall += bettingMoney * PAYOUT_LIST[5];
			wonThisRound = bettingMoney * PAYOUT_LIST[5];
			bettingMoney = 0;
		}
		else if(prize.contains("Three of a kind!")){
			balance += bettingMoney * PAYOUT_LIST[6];
			wonOverall += bettingMoney * PAYOUT_LIST[6];
			wonThisRound = bettingMoney * PAYOUT_LIST[6];
			bettingMoney = 0;
		}
		else if(prize.contains("Two Pairs!")){
			balance += bettingMoney * PAYOUT_LIST[7];
			wonOverall += bettingMoney * PAYOUT_LIST[7];
			wonThisRound = bettingMoney * PAYOUT_LIST[7];
			bettingMoney = 0;
		}
		else if(prize.contains("Pair!") && ( prize.contains("Jack") || prize.contains("Queen") || prize.contains("King") || prize.contains("Ace"))){
			balance += bettingMoney * PAYOUT_LIST[8];
			wonOverall += bettingMoney * PAYOUT_LIST[8];
			wonThisRound = bettingMoney * PAYOUT_LIST[8];
			bettingMoney = 0;
		}
		else 
		{
			bettingMoney = 0;
		}
	}
}
