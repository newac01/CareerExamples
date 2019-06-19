import java.awt.*;
import java.util.*;

import javax.swing.*;
//Aaron New
//CS 161
//PlayerPanel project 2

public class PlayerPanel extends JPanel {
	private JLabel sumGuestJL;
	private JLabel[] hand = new JLabel[12];
	private int guestScore = 0;
	private JPanel guestHandJP;

	// PlayerPanel Constructor
	public PlayerPanel() {
		sumGuestJL = new JLabel("Sum = " + guestScore, SwingConstants.CENTER);
		guestHandJP = new JPanel();
		guestHandJP.setLayout(new GridLayout(13, 1));
		guestHandJP.setBorder(BorderFactory.createTitledBorder("Guest Hand"));
		guestHandJP.add(sumGuestJL);
		for (int i = 0; i < hand.length; i++) {
			hand[i] = new JLabel("Empty", SwingConstants.CENTER);
			guestHandJP.add(hand[i]);
		}
	}

	// gets playerPanel to tableGUI
	public JPanel getPlayerPanel() {
		return guestHandJP;
	}

	// gets players score to tableGUI
	public int getGuestCardSum() {
		return guestScore;
	}

	// allows the score to be changed from 0
	public void setGuestCardSum(int score) {
		sumGuestJL.setText("Sum = " + score);
		}
	// changes cards in guests hand
	public void updateGuestHand(Card[] cards) {
		for (int i = 0; i < hand.length && i < cards.length; i++) {
			if (cards[i] != null) {
				hand[i].setText(cards[i].toString());
			}
			else
				hand[i].setText("");
		}
		
	}
	// get JLabel to the table
	public JLabel[] getGuestHandJL() {
		return hand;
	}
	// allows for the game gui to set the labels to empty each time a resetTable() is called
	public void setGuestHandJL(){
		for (int i = 0; i < hand.length; i++) {
			hand[i].setText("Empty");
		}
	}
}
