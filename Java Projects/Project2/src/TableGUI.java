import java.awt.*;

import javax.swing.*;
// Aaron New
// CS161 Project 2 TableGUI class
public class TableGUI extends JFrame {
	private static final int WINDOW_WIDTH = 450;
	private static final int WINDOW_HEIGHT = 600;
	private JPanel titleJP, combinedJP, leftJP, topLeftJP, rightJP, topRightJP;
	private JLabel titleJL, guestW, dealW, scoreDealer, scoreGuest;
	private JButton startJB, leaveJB, dealGuestJB, dealDealerJB;
	private JFrame ScoreBoard;
	private int guestScoreboard = 0;
	private int dealerScoreboard = 0;
	// creates instances of the classes
	private DealerPanel dealerPanel = new DealerPanel();
	private PlayerPanel playerPanel = new PlayerPanel();

	// constructor to build frame
	public TableGUI() {
		this.setTitle("TwentyOne Game Table");
		this.setLayout(new BorderLayout());
		this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.buildTableGUI();
		this.setLocation(650, 50);
		this.setResizable(false);
		this.setVisible(true);
		this.buildScoreBoardGUI();
	}// end TwentyOneGUI
	// build the table
	public void buildTableGUI() {
		setLayout(new BorderLayout());
		// title panel
		titleJP = new JPanel();
		titleJL = new JLabel("Empty Table", SwingConstants.CENTER);
		titleJP.add(titleJL);
		// changes color to green for title panel
		titleJP.setBackground(Color.GREEN);
		combinedJP = new JPanel();
		// set layout for combinedJP
		combinedJP.setLayout(new GridLayout(1, 2));
		// add guest and dealer to the table from their classes
		combinedJP.add(playerPanel.getPlayerPanel());
		combinedJP.add(dealerPanel.getDealerPanel());
		add(titleJP, BorderLayout.NORTH);
		add(combinedJP, BorderLayout.CENTER);
	}
	// builds scoreboard
	public void buildScoreBoardGUI() {
		// new JFrame created
		ScoreBoard = new JFrame();
		ScoreBoard.setLocation(240, 500);
		ScoreBoard.setTitle("Score Board");
		ScoreBoard.setLayout(new GridLayout(2, 2));
		ScoreBoard.setSize(400, 150);
		ScoreBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ScoreBoard.setResizable(false);
		ScoreBoard.setVisible(true);
		// four new panels
		leftJP = new JPanel();
		rightJP = new JPanel();
		topLeftJP = new JPanel();
		topRightJP = new JPanel();
		// add text to labels
		guestW = new JLabel("Guest Wins", SwingConstants.CENTER);
		dealW = new JLabel("Dealer Wins", SwingConstants.CENTER);
		scoreGuest = new JLabel("0", SwingConstants.CENTER);
		scoreDealer = new JLabel("0", SwingConstants.CENTER);
		// add buttons
		startJB = new JButton("Start Game");
		leaveJB = new JButton("Leave Table");
		dealGuestJB = new JButton("Deal Guest Cards");
		dealDealerJB = new JButton("Deal Dealer Cards");
		// change enabled
		dealGuestJB.setEnabled(false);
		dealDealerJB.setEnabled(false);
		// add borders
		topLeftJP.setBorder(BorderFactory.createTitledBorder(""));
		topRightJP.setBorder(BorderFactory.createTitledBorder(""));
		// set each panels layout
		topLeftJP.setLayout(new GridLayout(2, 1));
		leftJP.setLayout(new GridLayout(2, 1));
		topRightJP.setLayout(new GridLayout(2, 1));
		rightJP.setLayout(new GridLayout(2, 1));
		// add to the top left panel
		ScoreBoard.add(topLeftJP);
		// change color
		topLeftJP.setBackground(Color.MAGENTA);
		topLeftJP.add(guestW);
		topLeftJP.add(scoreGuest);
		// add to the top right panel
		ScoreBoard.add(topRightJP);
		// change color
		topRightJP.setBackground(Color.CYAN);
		topRightJP.add(dealW);
		topRightJP.add(scoreDealer);
		// add to the bottom left panel
		ScoreBoard.add(leftJP);
		leftJP.add(startJB);
		leftJP.add(dealGuestJB);
		// add to the bottom right panel
		ScoreBoard.add(rightJP);
		rightJP.add(getLeaveJB());
		rightJP.add(dealDealerJB);
	}

	// gets JButtons to TwentyOneGUI
	public JButton getLeaveJB() {
		return this.leaveJB;
	}

	public JButton getNewGameJB() {
		return this.startJB;
	}

	public JButton getDealGuestCardJB() {
		return this.dealGuestJB;
	}

	public JButton getDealDealerCardJB() {
		return this.dealDealerJB;
	}
	// changes title of the frame
	public void setTitleJL(String title) {
		titleJL.setText(title);
	}

	// updates the respective hands with cards
	public void updateGuestHand(Guest g) {
		playerPanel.updateGuestHand(g.getCurrentHand());
		playerPanel.setGuestCardSum(g.getValue());
	}
	public void updateDealerHand(Dealer d) {
		dealerPanel.updateDealerHand(d.getCurrentHand());
		dealerPanel.setDealerCardSum(d.getValue());
	}
	// updates the score on the scoreboard
	public void updateDealerScoreboard() {
		dealerScoreboard++;
		scoreDealer.setText(dealerScoreboard + "");
	}
	// updates the score on the scoreboard
	public void updateGuestScoreboard() {
		guestScoreboard++;
		scoreGuest.setText(guestScoreboard + "");
	}
	// gets the value of the guest cards
	public int getGuestCardValue() {
		return playerPanel.getGuestCardSum();
	}
	// gets the value of the dealer cards
	public int getDealerCardValue() {
		return dealerPanel.getDealerSum();
	}
	// resets table to the inital start without changing the scoreboard
	public void resetTable() {
		playerPanel.setGuestCardSum(0);
		dealerPanel.setDealerCardSum(0);
		playerPanel.setGuestHandJL();
		dealerPanel.setDealerHandJL();
		titleJL.setText("Good Luck!");
		

	}

}
