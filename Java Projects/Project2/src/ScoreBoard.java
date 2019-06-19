import java.awt.*;

import javax.swing.*;

public class ScoreBoard extends JFrame {
	private static final int WINDOW_WIDTH = 400;
	private static final int WINDOW_HEIGHT = 150;
	private JLabel guestW, dealW, scoreDealer, scoreGuest;
	private ButtonGroup buttons;
	private JButton startJB, leaveJB, dealGuestJB, dealDealerJB;
	private JPanel leftJP, topLeftJP, rightJP, topRightJP;

	public ScoreBoard() {
		setTitle("Score Board");
		setLayout(new GridLayout(2, 2));
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buildGUI();
		setVisible(true);
	}

	public void buildGUI() {
		leftJP = new JPanel();
		rightJP = new JPanel();
		topLeftJP = new JPanel();
		topRightJP = new JPanel();
		guestW = new JLabel("Guest Wins", SwingConstants.CENTER);
		dealW = new JLabel("Dealer Wins", SwingConstants.CENTER);
		scoreGuest = new JLabel("0", SwingConstants.CENTER);
		scoreDealer = new JLabel("0", SwingConstants.CENTER);
		startJB = new JButton("Start Game");
		leaveJB = new JButton("Leave Table");
		dealGuestJB = new JButton("Deal Guest Cards");
		dealDealerJB = new JButton("Deal Guest Cards");
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
		add(topLeftJP);
		topLeftJP.setBackground(Color.MAGENTA);
		topLeftJP.add(guestW);
		topLeftJP.add(scoreGuest);
		// add to the top right panel
		add(topRightJP);
		topRightJP.setBackground(Color.CYAN);
		topRightJP.add(dealW);
		topRightJP.add(scoreDealer);
		// add to the bottom left panel
		add(leftJP);
		leftJP.add(startJB);
		leftJP.add(dealGuestJB);
		// add to the bottom right panel
		add(rightJP);
		rightJP.add(leaveJB);
		rightJP.add(dealDealerJB);

	}
}
