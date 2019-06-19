import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import javax.swing.*;
//Aaron New
//CS161
//Project 1
//Class creates panels and calls on calculation class

public class CombinedPanels extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// declarations
	private JPanel northJP, payInfoJP, loanTermJP, finInfoJP, priceWOJP,
			actionButtonJP;
	private JLabel totalLoanJL2, monthPayJL2, totalPayJL2, northJL,
			totalLoanJL, monthPayJL, totalPayJL, basePriceJL, downPaymentJL,
			salesTaxJL;
	private JTextField basePriceTF, downPaymentTF, salesTaxTF;
	private JRadioButton twoYearRB, threeYearRB, fourYearRB, fiveYearRB;
	private JCheckBox autoTransCB, antiLockBreakCB, sunRoofCB, navSysCB,
			audioPackCB;
	private JButton calcJB, resetJB, exitJB;
	// declare ButtonGroup
	private ButtonGroup yearButtonGroup;
	private double interestRate = .045, optionsTotal;
	private int numberOfMonths = 24;
	// declare AutoInfoLoan object
	private AutoInfoLoan newAutoLoan;

	// Constructor
	public CombinedPanels() {

		// add panels placed in subclasses
		// Fix Grids for each panel
		setLayout(new BorderLayout());
		// Top Panel
		northJP = new northPanel();
		add(northJP, BorderLayout.NORTH);
		// Center Panel
		JPanel centerPanel = new JPanel(new GridLayout(2, 2));
		payInfoJP = new payInfoPanel();
		centerPanel.add(payInfoJP);
		loanTermJP = new loanTerm();
		centerPanel.add(loanTermJP);
		finInfoJP = new finInformation();
		centerPanel.add(finInfoJP);
		priceWOJP = new priceWO();
		centerPanel.add(priceWOJP);
		// add centerPanel to center of BorderLayout
		add(centerPanel, BorderLayout.CENTER);
		// Lower panel
		actionButtonJP = new ActionButton();
		add(actionButtonJP, BorderLayout.SOUTH);
		// radio button action listeners
		twoYearRB.addActionListener(new RadioButtonListener());
		threeYearRB.addActionListener(new RadioButtonListener());
		fourYearRB.addActionListener(new RadioButtonListener());
		fiveYearRB.addActionListener(new RadioButtonListener());
		// CheckBox button item listeners
		autoTransCB.addItemListener(new CheckBoxListener());
		antiLockBreakCB.addItemListener(new CheckBoxListener());
		sunRoofCB.addItemListener(new CheckBoxListener());
		navSysCB.addItemListener(new CheckBoxListener());
		audioPackCB.addItemListener(new CheckBoxListener());
		// action button listeners
		exitJB.addActionListener(new CloseButtonListener());
		resetJB.addActionListener(new ResetButtonListener());
		calcJB.addActionListener(new CalculateButtonListener());

	}// end combinedPanels constructor

	// For the orange title bar with the blue text
	public class northPanel extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		// constructor
		public northPanel() {
			add(northJL = new JLabel("Auto Loan Calculator"),
					BorderLayout.NORTH);
			// centers the label
			northJL.setHorizontalAlignment(JLabel.CENTER);
			// allows for color change on panel
			this.setOpaque(true);
			// changes background of panel to orange
			this.setBackground(Color.ORANGE);
			// changes text color of JLabel to blue
			northJL.setForeground(Color.BLUE);
		}// end northPanel Constructor
	}// end northPanel class

	// For pay information panel
	public class payInfoPanel extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		// constructor
		public payInfoPanel() {
			// build panel layout
			setLayout(new GridLayout(3, 2));
			setBorder(BorderFactory.createCompoundBorder(
					BorderFactory.createTitledBorder("Payment Information"),
					BorderFactory.createCompoundBorder(
							BorderFactory.createEtchedBorder(0),
							BorderFactory.createBevelBorder(0))));
			// add labels to panel
			add(totalLoanJL = new JLabel("Total Loan Amount: $"));
			add(totalLoanJL2 = new JLabel("0.0", SwingConstants.RIGHT));
			add(monthPayJL = new JLabel("Monthly Payment: $"));
			add(monthPayJL2 = new JLabel("0.0", SwingConstants.RIGHT));
			add(totalPayJL = new JLabel("Total Payment: $"));
			add(totalPayJL2 = new JLabel("0.0", SwingConstants.RIGHT));
		}// end payInfoPanel constructor
	}// end payInfoPanel class

	// For loan term panel
	public class loanTerm extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		// constructor
		public loanTerm() {
			// build panel layout
			setLayout(new GridLayout(4, 1));
			// add detailed border
			setBorder(BorderFactory.createCompoundBorder(
					BorderFactory.createTitledBorder("Loan Term"),
					BorderFactory.createCompoundBorder(
							BorderFactory.createEtchedBorder(0),
							BorderFactory.createBevelBorder(0))));
			// create button group for one radio button selection at a time
			yearButtonGroup = new ButtonGroup();
			yearButtonGroup.add(twoYearRB = new JRadioButton("24 Months"));
			yearButtonGroup.add(threeYearRB = new JRadioButton("36 Months"));
			yearButtonGroup.add(fourYearRB = new JRadioButton("48 Months"));
			yearButtonGroup.add(fiveYearRB = new JRadioButton("60 Months"));
			// add button group to panel
			add(twoYearRB);
			add(threeYearRB);
			add(fourYearRB);
			add(fiveYearRB);
			// Initially select 48 months
			twoYearRB.setSelected(true);
		}// end loanTerm constructor

	}// end loanTerm class

	// For financial information panel
	public class finInformation extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		// constructor
		public finInformation() {
			// make layout for panel
			setLayout(new GridLayout(3, 2));
			// create detailed border
			setBorder(BorderFactory.createCompoundBorder(
					BorderFactory.createTitledBorder("Financing Information"),
					BorderFactory.createCompoundBorder(
							BorderFactory.createEtchedBorder(0),
							BorderFactory.createBevelBorder(0))));
			// add JLabels and text Fields
			add(basePriceJL = new JLabel("Base Price: $"));
			add(basePriceTF = new JTextField("0.0"));
			add(downPaymentJL = new JLabel("Down Payment: $"));
			add(downPaymentTF = new JTextField("0.0"));
			add(salesTaxJL = new JLabel("Sales Tax: %"));
			add(salesTaxTF = new JTextField("7.0"));
		}// end finInformation constructor
	}// end finInformation class

	// For price with options panel
	public class priceWO extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		// constructor
		public priceWO() {
			// make layout for panel
			setLayout(new GridLayout(5, 1));
			// create detailed border
			setBorder(BorderFactory.createCompoundBorder(
					BorderFactory.createTitledBorder("Price With Options"),
					BorderFactory.createCompoundBorder(
							BorderFactory.createEtchedBorder(0),
							BorderFactory.createBevelBorder(0))));
			// initialize CheckBoxes
			autoTransCB = new JCheckBox("Auto Transmission: $1,800");
			antiLockBreakCB = new JCheckBox("AntiLock Brake: $1,200");
			sunRoofCB = new JCheckBox("Sun Roof: $800");
			navSysCB = new JCheckBox("Navigation System: $1,350");
			audioPackCB = new JCheckBox("Audio Package: $1,550");
			// set antiLock to selected default
			antiLockBreakCB.setSelected(true);
			// add CheckBoxes to panel
			add(autoTransCB);
			add(antiLockBreakCB);
			add(sunRoofCB);
			add(navSysCB);
			add(audioPackCB);
		}// end priceWO constructor
	}// end priceWO class

	// method used to find if a button is selected
	public void actionPerformed(ActionEvent e) {
		if (exitJB.isSelected()) {
			System.exit(0);
		}

	}// end method

	// For bottom of frame
	public class ActionButton extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		// constructor
		ActionButton() {
			// make layout for panel
			setLayout(new GridLayout(1, 3));
			// create detailed border
			setBorder(BorderFactory.createCompoundBorder(
					BorderFactory.createTitledBorder("Action Buttons"),
					BorderFactory.createCompoundBorder(
							BorderFactory.createEtchedBorder(0),
							BorderFactory.createBevelBorder(0))));
			// add buttons to panel
			add(calcJB = new JButton("Calculate"));
			add(resetJB = new JButton("Reset"));
			add(exitJB = new JButton("Exit"));
		}// end constructor
	}// end class

	// CheckBoxes used in finding options
	private class CheckBoxListener implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			// initial options total to 0
			optionsTotal = 0;
			// if selected statements
			if (autoTransCB.isSelected()) {
				optionsTotal += 1800;
			}
			if (antiLockBreakCB.isSelected()) {
				optionsTotal += 1200;
			}
			if (sunRoofCB.isSelected()) {
				optionsTotal += 800;
			}
			if (navSysCB.isSelected()) {
				optionsTotal += 1350;
			}
			if (audioPackCB.isSelected()) {
				optionsTotal += 1550;
			}
		}// end method
	}// end class

	// radio button for interest rate
	private class RadioButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// if selected statements
			// 24 monthsRB
			if (e.getSource() == twoYearRB) {
				interestRate = .045;
				numberOfMonths = 24;
			}
			// 36 monthsRB
			if (e.getSource() == threeYearRB) {
				interestRate = .055;
				numberOfMonths = 36;
			}
			// 48 monthsRB
			if (e.getSource() == fourYearRB) {
				interestRate = .065;
				numberOfMonths = 48;
			}
			// 60 monthsRB
			if (e.getSource() == fiveYearRB) {
				interestRate = .07;
				numberOfMonths = 60;
			}

		}// end method
	}// end class

	// action listeners for close button
	private class CloseButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// exits program
			System.exit(0);

		}
	}

	// action listener for calculate button
	private class CalculateButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// declare decimal format
			DecimalFormat dec = new DecimalFormat("##.00");
			// send variables to the AutoInfoLoan overloaded constructor
			newAutoLoan = new AutoInfoLoan(interestRate,
					Double.parseDouble(basePriceTF.getText()),
					Double.parseDouble(downPaymentTF.getText()),
					Double.parseDouble(salesTaxTF.getText()), optionsTotal,
					numberOfMonths);
			// change JLabel text to calculation
			totalLoanJL2.setText(dec.format(newAutoLoan.getLoanAmt()) + "");
			monthPayJL2.setText(dec.format(newAutoLoan.getmonthPay()) + "");
			totalPayJL2.setText(dec.format(newAutoLoan.getTotalPay()) + "");
		}// end method
	}// end class

	// action listener for reset button
	private class ResetButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// change text fields and JLabels
			totalLoanJL2.setText("0.0");
			monthPayJL2.setText("0.0");
			totalPayJL2.setText("0.0");
			basePriceTF.setText("0.0");
			downPaymentTF.setText("0.0");
			salesTaxTF.setText("7.0");
			// change JRadioButton
			twoYearRB.setSelected(true);
			// change JCheckBox
			autoTransCB.setSelected(false);
			antiLockBreakCB.setSelected(true);
			sunRoofCB.setSelected(false);
			navSysCB.setSelected(false);
			audioPackCB.setSelected(false);
			// reset Values to starting values
			numberOfMonths = 24;
			optionsTotal = 1200;
			interestRate = .045;
		}// end method
	}// end class
}// end CombinedPanels PUBLIC Class
