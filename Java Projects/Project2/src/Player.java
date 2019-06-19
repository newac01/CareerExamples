// Aaron New
// CS161
// abstract Player class project 2
abstract public class Player {
	private final int maxCards = 12;
	private Card[] hand = new Card[maxCards];
	private static Deck newDeck;
	private int numberOfCards;
	private int handValue = 0;
	private int value = 0;

	public Player(Deck currentDeck) {
		newDeck = currentDeck;
		numberOfCards = 0;
	}

	// abstract methods
	abstract boolean stand();

	abstract int valueOf();

	// sets the players hand to nothing
	public void clearHand() {
		// makes a new instance of the card object
		hand = new Card[maxCards];
		newDeck.shuffle();
		numberOfCards = 0;
	}

	public boolean bust() {
		handValue = getValue();
		// as each card gets into hand add to value
			if (handValue > 21) {
				return true;
			}
		// or it is under 21
		return false;
	}
	// get cards in the hand
	public int getValue() {
		value = 0;
		for (int i = 0; i < numberOfCards; i++) {
			int handCount = hand[i].getValue();
			if (handCount > 10){
				handCount = 10;
			}
			value += handCount;
			}
		return value;
	}
	// hit method used in both dealer and guest to get next card
	public void hit(Card card) {
		hand[numberOfCards] = card;
		numberOfCards++;
	}
	// initially will give the dealer and guest 2 cards
	public void play() {
		for(int i = 0; i < 2; i++){
			this.hit(newDeck.dealCard());
		}
	}
	// gets the hand
	public Card[] getCurrentHand() {
		return hand;
	}
	// gets the count of the cards
	public int getCardCount(){
		return numberOfCards;
	}
}
