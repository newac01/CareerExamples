// Aaron New
// CS161 Project 2 Dealer Class
public class Dealer extends Player {
	private int numberOfCards;
	private Card[] hand;
	
	public Dealer(Deck currentDeck) {
		super(currentDeck);
		hand = super.getCurrentHand();
	}
	// dealer stand when value is 16 or larger as boolean
	boolean stand() {
		if (super.bust() == false) {
			int temp = super.getValue();
			if (temp >= 16) {
				return true;
			}
		} else {
			return false;
		}
		return false;
	}
	// gets the value of the cards in dealers hand
	int valueOf() {
		int value = super.getValue();
		return value;
	}
	// gets the value of the cards as integer
	public int getValue() {
		int temp = super.getValue();
		for (int i = 0; i < numberOfCards; i++) {
			int handCount = hand[i].getValue();
			if (handCount <= 1) {
				handCount += 10;
			} else if (handCount > 10) {
				handCount = 10;
			}
			// if value is 1 for "ace" then give 11

			temp += handCount;
		}
		return temp;
	}

}
