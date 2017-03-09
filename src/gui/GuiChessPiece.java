package gui;

import javax.swing.Icon;
import javax.swing.JButton;

import board.Position;

public class GuiChessPiece extends JButton{
	private Position piecePosition; 
	
	public GuiChessPiece(Icon i, Position p){
		piecePosition = new Position(p.getRow(), p.getColumn()); 
		this.setIcon(i);
	}
	
	public int getRow(){
		return piecePosition.getRow(); 
	}
	
	public int getColumn(){
		return piecePosition.getColumn(); 
	}
	

}
