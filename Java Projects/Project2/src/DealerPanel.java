import java.awt.*;
import java.util.*;

import javax.swing.*;
//Aaron New
//CS161 
//Dealer panel class project 2
public class DealerPanel extends JPanel {
	private JLabel sumDealerJL, handDealJL;
	private JLabel[] handDealer = new JLabel[12];
	private JPanel dealerHandJP;
	private int dealerScore = 0;

	public DealerPanel() {
		// dealer
		sumDealerJL = new JLabel("Sum = " + dealerScore, SwingConstants.CENTER);
		dealerHandJP = new JPanel();
		dealerHandJP.setLayout(new GridLayout(13, 1));
		dealerHandJP.setBorder(BorderFactory.createTitledBorder("Dealer Hand"));
		dealerHandJP.add(sumDealerJL);
		// populate panel with JLabels
		for (int i = 0; i < handDealer.length; i++) {
			handDealer[i] = new JLabel("Empty", SwingConstants.CENTER);
			dealerHandJP.add(handDealer[i]);
		}

	}

	// gets Panel to table GUI
	public JPanel getDealerPanel() {
		return dealerHandJP;
	}

	// gets score to table GUI
	public int getDealerSum() {
		return dealerScore;
	}
	// updates the game GUI with the dealers cards in their hand
	public void updateDealerHand(Card[] cards) {
		for (int i = 0; i < handDealer.length && i < cards.length; i++) {
			if (cards[i] != null) {
				handDealer[i].setText(cards[i].toString());
			}
			else
				handDealer[i].setText("");
		}
	}
	// gets 
	public JLabel getDealerHandJL() {
		return handDealJL;
	}
	// sets the sum of the dealers cards
	public void setDealerCardSum(int score){
		sumDealerJL.setText("Sum = " + score);
	}
	// sets the hand to reset the game
	public void setDealerHandJL(){
		for (int i = 0; i < handDealer.length; i++) {
			handDealer[i].setText("Empty");
		}
	}

}
