import java.awt.event.*;
//Aaron New
//CS161 
//Class will instantiate players, deck, and the game table
public class TwentyOneGUI {
	private TableGUI table;
	private Deck deck;
	private Guest guest;
	private Dealer dealer;
	private boolean isGameOver = false;

	// constructor to build GUI for TwentyOne Game
	public TwentyOneGUI() {
		// reset the table to initialize it
		table = new TableGUI();
		table.getLeaveJB().addActionListener(new ExitButton());
		table.getNewGameJB().addActionListener(new NewGame());
		table.getDealGuestCardJB().addActionListener(new DealGuest());
		table.getDealDealerCardJB().addActionListener(new DealDealer());
	}

	// will resetTable
	public void resetTable() {
		table.resetTable();
		guest.clearHand();
		dealer.clearHand();
	}

	// creates a new game
	private class NewGame implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			deck = new Deck();
			guest = new Guest(deck);
			dealer = new Dealer(deck);
			table.setTitleJL("Good Luck!");
			// shuffle deck
			deck.shuffle();
			// enable guest
			table.getDealGuestCardJB().setEnabled(true);
			resetTable();
		}
	}

	// adds cards to guest panel
	private class DealGuest implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// allows for time lapse to display who won the previous match
			if (isGameOver) {
				table.getDealDealerCardJB().setEnabled(false);
				table.getDealGuestCardJB().setEnabled(true);
				resetTable();
				isGameOver = false;
				return;
			}
			// when value is less than 16 make a decision
			if (guest.getValue() >= 16) {
				 //if guest busts
				if (guest.getValue() == 21) {
					table.updateGuestScoreboard();
					table.setTitleJL("Guest Wins with " + guest.getValue() +"!");
					isGameOver = true;
					return;
				}
				if (guest.bust()) {
					table.updateDealerScoreboard();
					table.setTitleJL("Guest bust!");
					isGameOver = true;
					return;
				}
				// when guest stands go to dealer
				if (guest.stand()) {
					table.getDealDealerCardJB().setEnabled(true);
					table.getDealGuestCardJB().setEnabled(false);
					// leaves method
					return;
				}
			}
			// hit when you have more than 0 cards
			if (guest.getValue() > 0) {
				guest.hit(deck.dealCard());
				// play when cards are 0
			} else {
				guest.play();
			}
			// updates guests hand with cards
			table.setTitleJL("Guest hand = " + guest.getValue());
			table.updateGuestHand(guest);
			
		}

	}

	// adds cards to dealer panel
	private class DealDealer implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// allows for a time lapse to display who won the game before
			// making a new table
			if (isGameOver) {
				table.getDealDealerCardJB().setEnabled(false);
				table.getDealGuestCardJB().setEnabled(true);
				resetTable();
				isGameOver = false;
				return;
			}
			if (dealer.getValue() >= 16) {
				if (dealer.getValue() == 21) {
					table.updateDealerScoreboard();
					table.setTitleJL("Dealer Wins with" + guest.getValue());
					isGameOver = true;
					return;
				}
				// if dealer busts
				if (dealer.bust()) {
					table.updateGuestScoreboard();
					// guest wins
					table.setTitleJL("Dealer Bust => Guest Wins!");
					isGameOver = true;
					return;
				}
				// guest wins
				if (dealer.stand()) {
					if (guest.getValue() > dealer.getValue()) {
						table.updateGuestScoreboard();
						table.setTitleJL("Guest Wins!");
						isGameOver = true;
						return;
						// dealer wins
					} else if (dealer.getValue() > guest.getValue()) {
						table.updateDealerScoreboard();
						table.setTitleJL("Dealer Wins!");
						isGameOver = true;
						return;
						// both guest and dealer have same value
					} else {
						table.setTitleJL("Game Pushed");
						isGameOver = true;
						return;
					}
				}
			}
			// if you have cards hit
			if (dealer.getValue() > 0) {
				dealer.hit(deck.dealCard());
				// if you have 0 cards play
			} else {
				dealer.play();
			}
			// updates dealers hand
			table.updateDealerHand(dealer);
		}

	}

	// will exit the program
	private class ExitButton implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);

		}
	}
}
