//Aaron New
//CS161 
//Card Class Project 2
public class Card {
	// get suits to numerical numbers
	private final static int SPADES = 0, DIAMONDS = 1, CLUBS = 2, HEARTS = 3;
	// get numbers for the face cards
	private final static int ACE = 1, JACK = 10, QUEEN = 10, KING = 10;
	private int suit;
	private int value;

	// constructor for card
	public Card(int cardSuit, int cardValue) {
		this.value = cardValue;
		this.suit = cardSuit;
	}

	// gives a string for the value of a card
	public String getValueString() {
		// if "this" case return "this"
		switch (value) {
		case 1:
			return "Ace";
		case 2:
			return "2";
		case 3:
			return "3";
		case 4:
			return "4";
		case 5:
			return "5";
		case 6:
			return "6";
		case 7:
			return "7";
		case 8:
			return "8";
		case 9:
			return "9";
		case 10:
			return "10";
		case 11:
			return "Jack";
		case 12:
			return "Queen";
		case 13:
			return "King";
		default:
			return "OUT OF BOUNDS";
		}
	}

	// gets suit to a string
	public String getSuitString() {
		// if "this" return "string"
		switch (suit) {
		case SPADES:
			return "Spades";
		case DIAMONDS:
			return "Diamonds";
		case CLUBS:
			return "Clubs";
		case HEARTS:
			return "Hearts";
		default:
			return "OUT OF BOUNDS";
		}
	}

	// Return the number for the suit of the card
	public int getSuit() {
		return suit;
	}

	// Return the number that gives card's value.
	public int getValue() {
		return value;
	}
	// gets the card value and the suit to the tableGUI
	public String toString() {
		return getValueString() + " of " + getSuitString();
	}
}