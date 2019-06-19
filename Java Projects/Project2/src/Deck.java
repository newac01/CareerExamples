import java.util.*;
// Aaron New
// CS161
// Deck class project 2

public class Deck {
	// create an array for the cards
	private Card[] cardArr;
	private int cardsUsed = 0;

	public Deck() {
		// Create an new non shuffled deck
		cardArr = new Card[52];
		// How many cards have been created so far
		int cardCount = 0;
		for (int suit = 0; suit <= 3; suit++) {
			for (int value = 1; value <= 13; value++) {
				cardArr[cardCount] = new Card(suit, value);
				cardCount++;
			}
			cardsUsed = 0;
		}
		this.shuffle();
	}

	public void shuffle() {
		// create temp card object
		Card temp;
		int ran1;
		int ran2;
		for (int i = 0; i < 100; i++) {
			// (int) forces math.random to integer
			ran1 = (int) (Math.random() * 52);
			ran2 = (int) (Math.random() * 52);
			// sets temp card to first random card
			temp = cardArr[ran1];
			// swaps random card 2 with random card 1
			cardArr[ran1] = cardArr[ran2];
			// sets temp card to random card 2
			cardArr[ran2] = temp;
		}
		cardsUsed = 0;
	}

	// increments the card count each time a card is dealt
	public Card dealCard() {
		if (cardsUsed >= 52) {
			// create new deck of cards
			cardArr = new Card[52];
			int cardCount = 0;
			for (int suit = 0; suit <= 3; suit++) {
				for (int value = 1; value <= 13; value++) {
					cardArr[cardCount] = new Card(suit, value);
					cardCount++;
				}
			}
			cardsUsed = 0;
			this.shuffle();
			return cardArr[cardsUsed];
		} else
		return cardArr[cardsUsed++];

	}
}
