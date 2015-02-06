/**
    	Creates a card used in the hand class. 
*/

	public class Card
	{
	    public int[] SUITS = {1,2,3,4}; //1 = hearts, 2 = diamonds, 3 = clubs, 4 = spades
	    public int[] FACES = {0,14,2,3,4,5,6,7,8,9,10,11,12,13};//14 = ace, 2 through 10 are two through ten respectively, 11 = Jack, 12 = Queen, 13 = King. 0 is here because its easier to put FACES[2] = 2 than FACES[1] = 2
	    private String suit ;
	    private String face ;
	    
	    /**
	       Constructs a card given a suit and face
	       @param suit the suit of the card
	       @param face the face of the card
	     */
	    public Card(String face, String suit)
	    {
		this.suit = suit ;
		this.face = face ;
	    }
	    
	    /**
	       Returns a string for this card.
	       @return a string representing the card
	     */
	    public String toString()
	    {
		return "" + face + " of " + suit ;
	    }
	    
	    /**
	       Returns the integer value for of the suit for this card
	       @return returns the integer value of the suit
	     */
	    public int getSuit()
	    {
	    	if(suit.equalsIgnoreCase("Hearts")){return SUITS[0];}
	    	else if(suit.equalsIgnoreCase("Diamonds")){return SUITS[1];}
	    	else if(suit.equalsIgnoreCase("Clubs")){return SUITS[2];}
	    	else if(suit.equalsIgnoreCase("Spades")){return SUITS[3];}
	    	else {return (Integer)null;}//returns null if the user did not provide a proper suit
	    }

	    /**
	       Returns the integer value for of the face of this card
	       @return returns the integer value of the face value
	     */
	    public int getFace()
	    {
	    	if(face.equalsIgnoreCase("two")){return FACES[2];}
	    	else if(face.equalsIgnoreCase("three")){return FACES[3];}
	    	else if(face.equalsIgnoreCase("four")){return FACES[4];}
	    	else if(face.equalsIgnoreCase("five")){return FACES[5];}
	    	else if(face.equalsIgnoreCase("six")){return FACES[6];}
	    	else if(face.equalsIgnoreCase("seven")){return FACES[7];}
	    	else if(face.equalsIgnoreCase("eight")){return FACES[8];}
	    	else if(face.equalsIgnoreCase("nine")){return FACES[9];}
	    	else if(face.equalsIgnoreCase("ten")){return FACES[10];}
	    	else if(face.equalsIgnoreCase("Jack")){return FACES[11];}
	    	else if(face.equalsIgnoreCase("Queen")){return FACES[12];}
	    	else if(face.equalsIgnoreCase("King")){return FACES[13];}
	    	else if(face.equalsIgnoreCase("Ace")){return FACES[1];}
	    	else {return (Integer)null;}//returns null if the user did not provide a proper face
	    }
	}

