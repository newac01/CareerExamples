import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.UIManager.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
//Aaron New
//CS161 Project3 GUI
public class TileDesignGUI extends JFrame {

	// fields
	private Tile[][] tile;
	private ActionListener ButtonListener, MenuListener;
	private JButton save, load, exit, reset;
	// used to create menuBar
	private JMenuBar menuBar;
	private JMenu lookandFeelJM, file;
	private JMenuItem normlookandFeel, nimbusLookandFeel;
	private JComboBox<String> box;
	// for BackGround Colors
	private String[] backgroundList = { "Black", "White", "Red", "Green",
			"Blue", "Pink", "Teal", "Purple", "Orange", "Yellow" };
	// for ForeGround colors
	private JRadioButton black, white, red, blue, green, teal, purple, orange,
			yellow, pink;
	private ButtonGroup buttonGroup;
	private JPanel combinedPanel, tilesJP, southButtonsJP, eastPanel,
			foregroundPanel, boxPanel;
	private JFileChooser jfc;

	// constructor to build the GUI
	public TileDesignGUI() {

		this.setTitle("Tile Designer");
		// set size
		this.setSize(950, 800);
		// change default close to exit
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// add menuBar
		menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);

		file = new JMenu("File");
		lookandFeelJM = new JMenu("Look and Feel");
		// add menu bar item
		file.add(lookandFeelJM);
		// add item to the GUI
		menuBar.add(file);
		//sets border
		menuBar.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder("Menu"),
				BorderFactory.createCompoundBorder(
						BorderFactory.createEtchedBorder(0),
						BorderFactory.createBevelBorder(3))));
		// used for normal selection
		normlookandFeel = new JMenuItem("Normal");
		// make a new listener
		MenuListener = new MenuBarListener();
		normlookandFeel.addActionListener(MenuListener);
		lookandFeelJM.add(normlookandFeel);
		// used for Nimbus L&F
		nimbusLookandFeel = new JMenuItem("Nimbus");
		nimbusLookandFeel.addActionListener(MenuListener);
		lookandFeelJM.add(nimbusLookandFeel);
		// Combined Panel
		combinedPanel = new JPanel();
		combinedPanel.setLayout(new BorderLayout());
		// tiles JPanel
		tilesJP = new JPanel();
		// give tiles a grid layout
		tilesJP.setLayout(new GridLayout(9, 9));
		tile = new Tile[9][9];
		// add 81 buttons or "tiles" to the panel
		for (int i = 0; i < tile.length; i++) {
			for (int j = 0; j < tile[i].length; j++) {
				tile[i][j] = new Tile("O", Color.BLACK, Color.WHITE);
				ButtonListener = new ButtonListener(tile[i][j]);
				// add listener for the buttons or "tiles" being clicked
				tile[i][j].addActionListener(ButtonListener);
				// add the buttonArray to the tiles panel
				tilesJP.add(tile[i][j]);
			}
		}

		// east Button panel
		eastPanel = new JPanel();
		eastPanel.setLayout(new BorderLayout());
		eastPanel.add(ResetJB(), BorderLayout.NORTH);
		eastPanel.add(FGColorPanel(), BorderLayout.CENTER);
		eastPanel.add(BGColorPanel(), BorderLayout.SOUTH);
		// add panels to combined panel
		southButtonPanel();
		combinedPanel.add(southButtonsJP, BorderLayout.SOUTH);
		combinedPanel.add(tilesJP, BorderLayout.CENTER);
		combinedPanel.add(eastPanel, BorderLayout.EAST);
		// add combined panel to the frame
		this.add(combinedPanel);
		this.setPreferredSize(new Dimension(800, 350));
		pack();
	}
	//gets the bg to the frame
	public JPanel BGColorPanel() {
		// BackgroundPanel
		boxPanel = new JPanel();
		box = new JComboBox<String>(backgroundList);
		boxPanel.add(box);
		//set border
		boxPanel.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder("BG Color"),
				BorderFactory.createCompoundBorder(
						BorderFactory.createEtchedBorder(0),
						BorderFactory.createBevelBorder(1))));
		return boxPanel;
	}
	//builds the ForeGround color panel
	//gets it to the frame
	public JPanel FGColorPanel() {
		// Create radio Buttons for
		black = new JRadioButton("Black");
		white = new JRadioButton("White");
		red = new JRadioButton("Red");
		blue = new JRadioButton("Blue");
		green = new JRadioButton("Green");
		teal = new JRadioButton("Teal");
		purple = new JRadioButton("Purple");
		orange = new JRadioButton("Orange");
		yellow = new JRadioButton("Yellow");
		pink = new JRadioButton("Pink");
		// add button group and buttons to it
		buttonGroup = new ButtonGroup();
		buttonGroup.add(black);
		buttonGroup.add(white);
		buttonGroup.add(red);
		buttonGroup.add(blue);
		buttonGroup.add(green);
		buttonGroup.add(teal);
		buttonGroup.add(purple);
		buttonGroup.add(orange);
		buttonGroup.add(yellow);
		buttonGroup.add(pink);
		// foregroundPanel
		foregroundPanel = new JPanel();
		foregroundPanel.setLayout(new GridLayout(5, 2));
		foregroundPanel.add(black);
		foregroundPanel.add(red);
		foregroundPanel.add(white);
		white.setSelected(true);
		foregroundPanel.add(blue);
		foregroundPanel.add(green);
		foregroundPanel.add(teal);
		foregroundPanel.add(purple);
		foregroundPanel.add(orange);
		foregroundPanel.add(yellow);
		foregroundPanel.add(pink);
		foregroundPanel.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder("FG Color"),
				BorderFactory.createCompoundBorder(
						BorderFactory.createEtchedBorder(0),
						BorderFactory.createBevelBorder(1))));
		return foregroundPanel;
	}
	//build the south button panel
	public void southButtonPanel() {
		// create buttons
		save = new JButton("Save");
		load = new JButton("Load");
		exit = new JButton("Exit");
		// add action listeners
		save.addActionListener(new SaveButtonListener());
		load.addActionListener(new LoadButtonListener());
		exit.addActionListener(new ExitButtonListener());
		// set mnemonics
		save.setMnemonic(KeyEvent.VK_S);
		load.setMnemonic(KeyEvent.VK_L);
		exit.setMnemonic(KeyEvent.VK_X);
		reset.setMnemonic(KeyEvent.VK_R);
		// add tooltips to the buttons
		save.setToolTipText("Saves the current tile structure");
		load.setToolTipText("Loads a new .til file");
		exit.setToolTipText("Closes the program");
		// south button panel
		southButtonsJP = new JPanel();
		southButtonsJP.setLayout(new GridLayout(1, 3));
		southButtonsJP.add(save);
		southButtonsJP.add(load);
		southButtonsJP.add(exit);
	}

	// gets the background color
	public Color backgroundColor() {
		Color currentBGColor = null;
		String BGselection = box.getSelectedItem() + "";
		if (BGselection.equals("Black"))
			currentBGColor = Color.BLACK;
		else if (BGselection.equals("White"))
			currentBGColor = Color.WHITE;
		else if (BGselection.equals("Red"))
			currentBGColor = Color.RED;
		else if (BGselection.equals("Green"))
			currentBGColor = Color.GREEN;
		else if (BGselection.equals("Blue"))
			currentBGColor = Color.BLUE;
		else if (BGselection.equals("Pink"))
			currentBGColor = Color.PINK;
		else if (BGselection.equals("Teal"))
			currentBGColor = Color.CYAN;
		else if (BGselection.equals("Purple"))
			currentBGColor = Color.MAGENTA;
		else if (BGselection.equals("Orange"))
			currentBGColor = Color.ORANGE;
		else if (BGselection.equals("Yellow"))
			currentBGColor = Color.YELLOW;
		return currentBGColor;
	}

	// returns the current selected foreground color
	public Color foregroundColor() {
		Color currentFGColor = null;
		if (black.isSelected())
			currentFGColor = Color.BLACK;
		else if (white.isSelected())
			currentFGColor = Color.WHITE;
		else if (red.isSelected())
			currentFGColor = Color.RED;
		else if (green.isSelected())
			currentFGColor = Color.GREEN;
		else if (blue.isSelected())
			currentFGColor = Color.BLUE;
		else if (pink.isSelected())
			currentFGColor = Color.PINK;
		else if (teal.isSelected())
			currentFGColor = Color.CYAN;
		else if (purple.isSelected())
			currentFGColor = Color.MAGENTA;
		else if (orange.isSelected())
			currentFGColor = Color.ORANGE;
		else
			currentFGColor = Color.YELLOW;
		return currentFGColor;
	}

	// method to make the Reset JButton
	public JButton ResetJB() {
		reset = new JButton("Reset");
		// add mnemonic to 'r' key
		reset.setMnemonic(KeyEvent.VK_R);
		// add toolTip to reset button
		reset.setToolTipText("Reset the GUI to default");
		// give the button a listener for it's actions
		reset.addActionListener(new ResetButtonListener());
		// returns the button
		return reset;
	}

	// method used to reset the gui to the default
	public void resetToDefault() {
		// change index selection to
		box.setSelectedIndex(0);
		white.setSelected(true);
		try {
			UIManager.setLookAndFeel(UIManager
					.getCrossPlatformLookAndFeelClassName());
		} catch (Exception except) {
			System.out.println("Look and Feel not set :(");
		}

		for (int i = 0; i < tile.length; i++) {
			for (int j = 0; j < tile[i].length; j++) {
				tile[i][j].setFGColor(Color.WHITE);
				tile[i][j].setBGColor(Color.BLACK);
				tile[i][j].setText("O");
			}
		}
		repaint();
	}

	// tool Bar listener used to change look and feel of GUI
	private class MenuBarListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//changes the look and feel to the Frame
			if (e.getSource() == nimbusLookandFeel) {
				try {
					for (LookAndFeelInfo info : UIManager
							.getInstalledLookAndFeels()) {
						if ("Nimbus".equals(info.getName())) {
							UIManager.setLookAndFeel(info.getClassName());
							break;
						}
					}
					//catches exception
				} catch (Exception except) {
					System.out.println("Look and Feel not set :(");
				}
			}
			//changes the look and feel to the normal state
			if (e.getSource() == normlookandFeel) {
				try {
					UIManager.setLookAndFeel(UIManager
							.getCrossPlatformLookAndFeelClassName());
					//catch exception
				} catch (Exception except) {
					System.out.println("Look and Feel not set :(");
				}
			}
			repaint();
		}
	}
	//listener will call the reset method
	private class ResetButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// call the reset method
			resetToDefault();
		}
	}
	//gets the exit button to the frame
	public JButton ExitButton() {
		exit = new JButton("Exit");
		return exit;
	}
	//when any tile is selected
	private class ButtonListener implements ActionListener {
		Tile tileTemp;

		public ButtonListener(Tile tile) {
			this.tileTemp = tile;
		}
		//changes the symbol and the colors of bg and fg
		public void actionPerformed(ActionEvent e) {
			tileTemp = (Tile) e.getSource();
			if (tileTemp.getSymbol().equals("O"))
				tileTemp.setSymbol("X");
			else if (tileTemp.getSymbol().equals("X"))
				tileTemp.setSymbol("*");
			else if (tileTemp.getSymbol().equals("*"))
				tileTemp.setSymbol("@");
			else if (tileTemp.getSymbol().equals("@"))
				tileTemp.setSymbol("<");
			else if (tileTemp.getSymbol().equals("<"))
				tileTemp.setSymbol(">");
			else if (tileTemp.getSymbol().equals(">"))
				tileTemp.setSymbol(" ");
			else if (tileTemp.getSymbol().equals(" "))
				tileTemp.setSymbol("O");
			tileTemp.setBGColor(backgroundColor());
			tileTemp.setFGColor(foregroundColor());
		}
	}
	//saves the gui so it can be loaded again
	private class SaveButtonListener implements ActionListener {
		String userInput = "";
		// allows for the use of object in the showInputDialog
		// allows for the OptionPane to have a title of "User Input"
		JFrame frame = new JFrame();

		public void actionPerformed(ActionEvent event) {
			// allows for the user to name their file before saving
			userInput = JOptionPane
					.showInputDialog(
							frame,
							"Please enter what name you would like to save your file under(.til)",
							"User Input", JOptionPane.INFORMATION_MESSAGE);
			//used to get the tile saved
			try {
				FileOutputStream fos = new FileOutputStream(userInput);
				ObjectOutputStream os = new ObjectOutputStream(fos);
				for (int i = 0; i < tile.length; i++) {
					for (int j = 0; j < tile[i].length; j++) {
						os.writeObject(tile[i][j]);
					}
				}
				os.close();
			} catch (IOException pst) {
				pst.printStackTrace();
			}
		}
	}
	//will load previously saved .til files
	private class LoadButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// Make a JFileChooser
			jfc = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter(
					"Tile file", "til");
			jfc.setFileFilter(filter);
			int returnVal = jfc.showOpenDialog(null);
			//approves the file selected then initiates the following
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				ObjectInputStream ins;
				try {
					ins = new ObjectInputStream(new FileInputStream(
							jfc.getSelectedFile()));
					for (int i = 0; i < tile.length; i++) {
						for (int j = 0; j < tile[i].length; j++) {
							Tile loadedTile = (Tile) ins.readObject();
							tile[i][j].setSymbol(loadedTile.getText());
							tile[i][j].setBGColor(loadedTile.getBackground());
							tile[i][j].setFGColor(loadedTile.getForeground());
							tile[i][j].repaint();
						}
					}
					tilesJP.validate();
					ins.close();
					// catch stack trace
				} catch (Exception pst) {
					pst.printStackTrace();
				}
			}
		}
	}

	// Listener used for the Exit button
	// will exit when pressed
	private class ExitButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
}