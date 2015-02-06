/**
    	Creates a hand out of cards received from the Deck or from the Card class
*/

public class Hand {
	private Deck deck;
	private int BLANK_CARD = 0;
	private int[][] drawnHand = new int[2][5];
	private String[] drawnHandString = new String[5];
	
	private int ACE = 14, KING = 13, QUEEN = 12, JACK = 11;
	private int HEARTS = 1, DIAMONDS = 2, CLUBS = 3, SPADES = 4;
	
	/**
		Creates a hand that uses the inputed deck
		@param newDeck the deck used by the simulator class
	 */
	public Hand(Deck newDeck)
	{
		deck = newDeck;
	}
	
	/**
		Takes a card in the form of a 2d array, with the first dimension being the face value and the second being the suit, and adds it to the hand if there is enough room. 
		@param card takes in a 2d array which represents a card
	*/
	public void add(int[][] card){
		for(int i = 0; i < drawnHand[0].length;i++)
		{
			if(drawnHand[0][i] == 0){
				drawnHand[0][i] = card[0][0];
				drawnHand[1][i] = card[1][0];
				break;
			}
		}
	}
	
	/**
		Takes in a Card type and adds it to the hand if there is room. 
		@param card takes in the specified card, in the form of a Card object
	*/
	public void add(Card card)
	{
		for(int i = 0; i < drawnHand[0].length;i++)
		{
			if(drawnHand[0][i] == BLANK_CARD)
			{
				drawnHand[0][i] = card.getFace();
				drawnHand[1][i] = card.getSuit();
				break;
			}
		}
	}
	
	/**
		Returns a string of the hand printed out
		@return returns a string of the hand
	*/
	public String showHand()
	{
		cardsToString();
		String hand = new String();
		for(int i = 0; i < drawnHand[0].length;i++)
		{
			hand += "CARD " + (i+1) + ": " + drawnHandString[i];
			if(i != drawnHand[0].length-1)
				hand+= ", ";
		}
		return hand;
	}
	
	/**
		Converts the users current hand, which consists of integers, and converts it to a string array. 
	*/
	private void cardsToString()
	{
		for(int k = 0; k<drawnHand[0].length; k++)
			for(int h = 0; h<drawnHand[0].length;h++)
			{
				if(drawnHand[0][k] < drawnHand[0][h])
				{
					int temp = drawnHand[0][h];
					drawnHand[0][h] = drawnHand[0][k];
					drawnHand[0][k] = temp;
					temp = drawnHand[1][h];
					drawnHand[1][h] = drawnHand[1][k];
					drawnHand[1][k] = temp;
				}
			}
		for(int i = 0; i< drawnHandString.length; i++)
		{
			if(drawnHand[0][i] == ACE){ drawnHandString[i] = "Ace";}
			else if(drawnHand[0][i] == KING){ drawnHandString[i] = "King";}
			else if(drawnHand[0][i] == QUEEN){ drawnHandString[i] = "Queen";}
			else if(drawnHand[0][i] == JACK){ drawnHandString[i] = "Jack";}
			else{ drawnHandString[i] = "" + drawnHand[0][i];}
		}
		for(int i = 0; i< drawnHandString.length; i++)
		{
			if(drawnHand[1][i] == HEARTS){ drawnHandString[i] += " of Hearts";}
			else if(drawnHand[1][i] == DIAMONDS){ drawnHandString[i] += " of Diamonds";}
			else if(drawnHand[1][i] == CLUBS){ drawnHandString[i] += " of Clubs";}
			else if (drawnHand[1][i] == SPADES){drawnHandString[i] += " of Spades";}
			else{drawnHandString[i] = "No Card";}
		}
	}
	
	/**
	Returns an integer which is the number of cards in the hand
	@return returns an integer equal to the number of cards currently in the hand
	*/
	public int size()
	{
		int size = 0; 
		for(int i = 0; i<drawnHand[0].length; i++)
		{
			if(drawnHand[0][i] > 0) size++;
		}
		return size;
	}
		
	/**
		Returns a string which represents what the player has in their current hand (in terms of Royal Flush, Straight, Pair, etc)
		@return returns a string of what their hand contains (in terms of Royal Flush, Straight, Pair, etc)
	*/
	public String handContains()
	{
		
		//checks for a royal flush
		if(drawnHand[0][0] == 10 && drawnHand[0][1] == JACK && drawnHand[0][2] == QUEEN && drawnHand[0][3] == KING && drawnHand[0][4] == ACE) 
			if(drawnHand[1][0] == drawnHand[1][1] && drawnHand[1][0] == drawnHand[1][2]&& drawnHand[1][0] == drawnHand[1][3] && drawnHand[1][0] == drawnHand[1][4])return "Royal Flush!";
		
		//checks for a straight flush
		if(drawnHand[0][0] == drawnHand[0][1]-1 && drawnHand[0][0] == drawnHand[0][2]-2 && drawnHand[0][0] == drawnHand[0][3]-3 && drawnHand[0][0] == drawnHand[0][4]-4) 
			if(drawnHand[1][0] == drawnHand[1][1] && drawnHand[1][0] == drawnHand[1][2]&& drawnHand[1][0] == drawnHand[1][3] && drawnHand[1][0] == drawnHand[1][4])return "Straight Flush!";
		
		//checks for a straight flush that has an ace in it
		if(drawnHand[0][4] == ACE && (drawnHand[0][0] == 2 || drawnHand[0][0] == 10) && drawnHand[0][2] == drawnHand[0][3]-1 && drawnHand[0][2] == drawnHand[0][4]-2)
			if(drawnHand[1][0] == drawnHand[1][1] && drawnHand[1][0] == drawnHand[1][2]&& drawnHand[1][0] == drawnHand[1][3] && drawnHand[1][0] == drawnHand[1][4])return "Straight Flush!";
		
		//checks for four of a kind
				for(int h = 2; h<drawnHand[0].length-1; h++) 
				{
					if(drawnHand[0][h] == drawnHand[0][h-2] && drawnHand[0][h] == drawnHand[0][h+1])return "Four of a kind! ";
				}
		
		//checks for a full house
		boolean pair = false;
		boolean three = false;
		int number1 = BLANK_CARD;
		for(int h = 1; h<drawnHand[0].length-1; h++) 
		{
			if(drawnHand[0][h] == drawnHand[0][h-1] && drawnHand[0][h] == drawnHand[0][h+1])
			{
				three = true; 
				number1 = drawnHand[0][h];
			}
		}
		for(int j = 0; j<drawnHand[0].length;j++)
		{
			for(int i = 1; i<drawnHand[0].length;i++)
			{
				if(drawnHand[0][j] == drawnHand[0][i] &&i!=j && drawnHand[0][i]!= number1 && drawnHand[0][j]!= number1)
				{
					pair = true;
				}
			}
		}
		if(pair && three){return "Full House!";}
		
		
		//checks for a flush
		if(drawnHand[1][0] == drawnHand[1][1] && drawnHand[1][0] == drawnHand[1][2]&& drawnHand[1][0] == drawnHand[1][3] && drawnHand[1][0] == drawnHand[1][4])return "Flush!";
		
		//checks for a straight
		if(drawnHand[0][0] == drawnHand[0][1]-1 && drawnHand[0][0] == drawnHand[0][2]-2 && drawnHand[0][0] == drawnHand[0][3]-3 && drawnHand[0][0] == drawnHand[0][4]-4) return "Straight!";
		
		//checks for a straight with an Ace in it
		if(drawnHand[0][4] == ACE && (drawnHand[0][0] == 2 || drawnHand[0][0] == 10) && drawnHand[0][1] == drawnHand[0][2]-1 && drawnHand[0][2] == drawnHand[0][3]-1) return "Straight!";
		
		
		// checks for three of a kind
				for(int h = 1; h<drawnHand[0].length-1; h++) 
				{
					if(drawnHand[0][h] == drawnHand[0][h-1] && drawnHand[0][h] == drawnHand[0][h+1])return "Three of a kind! " + drawnHandString[h] + " and " + drawnHandString[h-1] + " and " + drawnHandString[h+1];
				}
				
		//checks for two pairs
		int twoPairs = 0;
		for(int j = 0; j<drawnHand[0].length;j++)
		{
			for(int i = 1; i<drawnHand[0].length;i++)
				{
					if(drawnHand[0][j] == drawnHand[0][i] &&i!=j){
						twoPairs++;
					}
				}
		}		
		if(twoPairs >= 3){return "Two Pairs!";}
		
				
		//checks for a pair
		for(int j = 0; j<drawnHand[0].length;j++)
			{
			for(int i = 1; i<drawnHand[0].length;i++)
				{
					if(drawnHand[0][j] == drawnHand[0][i] &&i!=j){
						return "Pair! " + drawnHandString[i] + " and " + drawnHandString[j];
				}
			}
		}
		
		
		
		if(drawnHand[0][0] == 1){return "High Card: " + drawnHandString[0];}
		
		else
			return "High card: " + drawnHandString[4];
	}
	
	/**
		Discards the card at the position equal to its cardNumber
		@param cardNumber Discards the card which is that the cardNumbers position
	*/
	public void discard(int cardNumber)
	{
		drawnHand[0][cardNumber-1] = 0; //the minus 1 is because the User sees the cards starting at Card 1, but in the array card 1 is stored at position 0. If the user wants to remove card 1, they're actually trying to remove card 0. 
		drawnHand[1][cardNumber-1] = 0;
		drawnHandString[cardNumber-1] = "";
	}
	
	/**
		Discards the whole hand 
	*/
	public void discardHand()
	{
		int size = size();
		for(int i = 1; i<=size;i++)
			discard(i);
	}
}
