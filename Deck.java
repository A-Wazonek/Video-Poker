/**
    	Creates a deck to be used in the PokerSimulator class
*/

import java.util.Random;
public class Deck {
	private int[][] unshuffledDeck = new int[2][52];
	private int[][] usedDeck =  new int[2][52];
	private int numberOfUsedCards;
	private int SMALLEST_CARD_NUMBER = 1;
	private int MAX_CARD_NUMBER = 15;
	private int MAX_CARD_SUIT = 5;
	private int SUITS = 1;
	private int FACES = 0;
	private int BLANK_CARD = 0;
	private Random shuffler = new Random();
	
	int next;
	
	/**
   		Constructs a deck, which runs the shuffle method
	 */
	public Deck(){
		
		shuffle();
		
	}
	
	/**
    	Fills the two separate decks with cards, the first deck is unshuffled and is values from 2 to 14 (14 being ace). The second deck created is originally a copy of the unshuffled deck, but it is then shuffled
	 */
	public void shuffle()
	{
			
		for(int col = 0; col<unshuffledDeck.length;col++)
		{
			int cardNo = SMALLEST_CARD_NUMBER;
			for(int row = 0; row<unshuffledDeck[col].length;row++)
			{
			cardNo++;
			if(col == FACES){
				if(cardNo == MAX_CARD_NUMBER) cardNo =2;
				unshuffledDeck[col][row] = cardNo;
				usedDeck[col][row] = cardNo;
				}
			else if(col == SUITS){
				if(cardNo >= MAX_CARD_SUIT) cardNo =1;
				unshuffledDeck[col][row] = cardNo;
				usedDeck[col][row] = cardNo;
			}
			}
			
		}
		for(int row = 0; row<usedDeck[0].length;row++)
		{
			next = shuffler.nextInt(52);
			if(next>row)
			{
				int temp = usedDeck[0][next];
				usedDeck[0][next] = usedDeck[0][row];
				usedDeck[0][row] = temp;
				int temp2 = usedDeck[1][next];
				usedDeck[1][next] = usedDeck[1][row]; // makes sure that the suit follows with the card
				usedDeck[1][row] = temp2;
			}
		}
			numberOfUsedCards = 0;
	}

	/**
    	Takes the top card of the deck and returns it
    	@return returns a 2d array of the card, with the first dimension being the card face and the second being its suit
	 */
	public int[][] deal(){
		int[][] card = new int[2][1];
		for(int i = 0; i<usedDeck[0].length;i++)
		{
			if(i<numberOfUsedCards){
				continue;}
			else if(i>= numberOfUsedCards){
				card[0][0] = usedDeck[0][i];
				card[1][0] = usedDeck[1][i];
				usedDeck[0][i] = BLANK_CARD;
				usedDeck[1][i] = BLANK_CARD; //changedShitto 0
				numberOfUsedCards++;
				break;
			}
		}
		
		return card;
	}
	
	/**
    	Returns a string which is the shuffled deck printed out (used for testing the shuffler)
    	@return returns a string of the shuffled deck. 
	 */
	public String printShuffledDeck()
	{
		String deck = new String();
		deck += "Shuffled Deck: ";
		for(int col = 0; col< usedDeck.length;col++)
		{
			for(int row = 0; row < usedDeck[col].length;row++)
			{
				deck+=" " + usedDeck[col][row];
			}
		
		}
		return deck;
	}
	
	/**
    	Returns a string which is the unshuffled deck printed out (used for testing the shuffler)
    	@return returns a string of the unshuffled deck. 
	 */
	public String printUnshuffledDeck()
	{
		String deck = new String();
		deck += "Unshuffled Deck: ";
		for(int col = 0; col< unshuffledDeck.length;col++)
			{
			for(int row = 0; row < unshuffledDeck[col].length;row++)
				{
					deck+=" " + unshuffledDeck[col][row];
				}
				
			}
		return deck;
	}
	
}
