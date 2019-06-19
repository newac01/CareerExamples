import javax.swing.*;
//Aaron New
//CS161
//Project 1 
//Class builds the GUI

public class LoanCalculateGUI extends JFrame {
	// private JPanel
	// set window size
	private final int WINDOW_WIDTH = 600;
	private final int WINDOW_HEIGHT = 450;

	// constructor to build frame
	public LoanCalculateGUI() {
		setTitle("Auto Loan Calculator");
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// call method to buildGUI
		buildGUI();
		setVisible(true);
	}// end LoanCalculateGUI

	// creates GUI from combined panels class
	private void buildGUI() {
		// builds the combPanel object from the combined panels class
		CombinedPanels combPanel = new CombinedPanels();
		// add combPanel to frame
		add(combPanel);
	}// end buildGUI

}
