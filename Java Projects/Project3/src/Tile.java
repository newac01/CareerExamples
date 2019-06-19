import java.awt.*;
import java.awt.Event.*;
import java.io.*;

import javax.swing.JButton;
//Aaron New
//CS161 Project3 Tile
public class Tile extends JButton  implements Serializable {
	private String symbol;
	private Color BGColor,FGColor;
	boolean Clicked = false;
	//constructor
	public Tile(String tileSymbol,Color bg,Color fg){
		symbol = tileSymbol;
		BGColor = bg;
		FGColor = fg;
	setText(symbol);
	setBackground(BGColor);
	setForeground(FGColor);
	
	}
	//gets the symbol to the GUI
	public String getSymbol() {
		return symbol;
	}
	//sets the symbol based on user clicks
	public void setSymbol(String s) {
		symbol = s;
		setText(symbol);
	}
	// gets the BGcolor to the GUI
	public Color getBGColor() {
		return BGColor;
	}
	// sets the BGcolor to selection
	public void setBGColor(Color bGColor) {
		BGColor = bGColor;
		setBackground(BGColor);
	}
	//gets Foreground Color to the GUI
	public Color getFGColor() {
		return FGColor;
	}
	//sets the Foreground Color to what is selected
	public void setFGColor(Color fGColor) {
		FGColor = fGColor;
		setForeground(FGColor);
	}
	
}
