package gui;

import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

import board.ChessSpecs;

import java.util.List;

import javax.swing.JPanel;
import game.ChessGame;

public class Graveyard extends JPanel{
	
	private static List<String> graveyard = new ArrayList<>(); 
	
	public void initGraveyard(){
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JScrollPane scroll = new JScrollPane();
		
		
		
		this.add(scroll, BoxLayout.Y_AXIS);
	}
	
/*	public static List<String> updateGraveyard(){
		graveyard = game.ChessGame.getGraveyard();
		for (String deadPiece : graveyard)
		{
			String pieceId = ChessSpecs.getDeadImageName(deadPiece);
			
			JButton newPiece = new JButton();
			
		}
	}
	
	
*/
}
