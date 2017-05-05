package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import board.ChessSpecs;
import board.Position;
import game.ChessGame;

public class ChessBoardPanel extends JPanel {
	
	private int numClicks = 0; 
	private int difficulty = 2;
	private boolean tutor = false;
	private boolean mode = false;
	private ChessGame game = new ChessGame(); 
	
	private Position current; 
	private Position future; 
	
	public ChessBoardPanel(int diff, boolean hints, boolean pvp){
		difficulty = diff;
		tutor = hints;
		mode = pvp;
		this.setLayout(new GridBagLayout());
		setUpPieces(); 
	}
	
	private void setUpPieces(){
		
		List<Position> ps = null; 
		if (tutor){
			ps = game.getBestMove(2); 
		}
		
		for (int r = 0; r<8; r++){
			for (int c = 0; c<8; c++){
				GridBagConstraints constraints = new GridBagConstraints(); 
				String squareColor = ""; 
				if ((r+c)%2==0) squareColor = "w"; 
				else squareColor = "b"; 
				System.out.println(squareColor);
			    String pieceId = game.getPieceAt(new Position(r,c)); 
			    String imageName = null; 
			    if (!pieceId.equals("-")){
			    	imageName = squareColor + pieceId; 
			    	//imageName = ChessSpecs.getImageName(imageName); 
			    }else{
			    	imageName = squareColor; 
			    }
			    System.out.println(imageName);
//			    imageName = ChessSpecs.getImageName(imageName); 
			    if (tutor && ps.contains((new Position(r,c)))){
			    	imageName = ChessSpecs.getImageName(imageName+ "_star");
			    }else{
			    	imageName = ChessSpecs.getImageName(imageName); 
			    }
			    System.out.println(imageName);
			    ImageIcon icon = null; 
			    try{
			    	Image img = ImageIO.read(getClass().getResource("../images/"+imageName ));
			    	icon = new ImageIcon(img); 
			    }catch (IOException e){
			    	System.out.println("couldnt open file");
			    }
//				String id = ChessSpecs.getImageName(game.getPieceAt(new Position(r,c))); 
//				ImageIcon icon = new ImageIcon(); 
//				try{
//					if (id!=null){
//						Image img = ImageIO.read(getClass().getResource("../images/"+id ));
//						icon = new ImageIcon(img); 
//					}else{
//						Image img = ImageIO.read(getClass().getResource("../images/8722.png" ));
//						icon = new ImageIcon(img); 
//					}
//				}catch (IOException e){
//					System.out.println("couldnt open file");
//				}
				GuiChessPiece piece = new GuiChessPiece(icon, new Position(r,c)); 
				piece.setBackground(Color.BLACK);
				piece.addActionListener(new
				         ActionListener()
				         {
				            public void actionPerformed(ActionEvent event)
				            {
				            	numClicks++; 
				            	if (numClicks==1){
				            		current = new Position(piece.getRow(), piece.getColumn());
				            		//redrawBoard(true); 
				            		
				            	}
				            	else if (numClicks==2){
				            		future = new Position(piece.getRow(), piece.getColumn()); 
				            		if(mode)
				            			makeMoveVsUser(); 
				            		else
				            			makeMoveVsAi(); 
				            		numClicks = 0; 	
				            	}
				            }
				         });
				piece.setPreferredSize(new Dimension(60, 60));
				
				constraints.gridx = c; 
				constraints.gridy = r; 
				//constraints. 
				this.add(piece, constraints); 
			}
		}
	}
	
	private void makeMoveVsAi(){
		if (game.isValidMove(current, future)){
			game.makeUserMove(current, future);
			redrawBoard(false); 
			game.switchTurns();
			game.makeAiMove(difficulty);
			game.switchTurns();
			redrawBoard(tutor); 
		}
	}
	
	private void makeMoveVsUser(){
		if (game.isValidMove(current, future)){
			game.makeUserMove(current, future);
			game.switchTurns();
			redrawBoard(tutor); 
		}
	}
	public void redrawBoard(Boolean showBest){
		List<Position> ps = null; 
		if (showBest){
			ps = game.getBestMove(2); 
		}
		
		//System.out.println(game.getGraveyard());
		for (Component temp : this.getComponents()){
			GridBagConstraints gbc = ((GridBagLayout) this.getLayout()).getConstraints(temp);
			GuiChessPiece t =  (GuiChessPiece) temp; 
			//t.setBackground(Color.black);
			//t.setText(game.getPieceAt(new Position(gbc.gridy,gbc.gridx)));
			String squareColor = ""; 
			if ((gbc.gridy+gbc.gridx)%2==0) squareColor = "w"; 
			else squareColor = "b"; 
			System.out.println(squareColor);
		    String pieceId = game.getPieceAt(new Position(gbc.gridy,gbc.gridx)); 
		    String imageName = null; 
		    if (!pieceId.equals("-")){
		    	imageName = squareColor + pieceId; 
		    	//imageName = ChessSpecs.getImageName(imageName); 
		    }else{
		    	imageName = squareColor; 
		    }
		    System.out.println(imageName);
		    
		    if (showBest && ps.contains((new Position(gbc.gridy,gbc.gridx)))){
		    	imageName = ChessSpecs.getImageName(imageName+ "_star");
		    }else{
		    	imageName = ChessSpecs.getImageName(imageName); 
		    }
		    
		    
		    System.out.println(imageName);
		    ImageIcon icon = null; 
		    try{
		    	Image img = ImageIO.read(getClass().getResource("../images/"+imageName ));
		    	icon = new ImageIcon(img); 
		    }catch (IOException e){
		    	System.out.println("couldnt open file");
		    }
			t.setIcon(icon);
			//t.setBackground(Color.black);
			//t.setText("hello");
			//t.invalidate();
		}
		
	
		
		
		
		
		System.out.println(game);
		this.validate();
		this.repaint();
	}
	
//	public void redrawBoard(){
//		//System.out.println(game.getGraveyard());
//		for (Component temp : this.getComponents()){
//			GridBagConstraints gbc = ((GridBagLayout) this.getLayout()).getConstraints(temp);
//			GuiChessPiece t =  (GuiChessPiece) temp; 
//			//t.setBackground(Color.black);
//			//t.setText(game.getPieceAt(new Position(gbc.gridy,gbc.gridx)));
//			String id = ChessSpecs.getImageName(game.getPieceAt(new Position(gbc.gridy,gbc.gridx))); 
//			ImageIcon icon = new ImageIcon(); 
//			try{
//				if (id!=null){
//					Image img = ImageIO.read(getClass().getResource("../images/"+id ));
//					icon = new ImageIcon(img); 
//					
//					
//				}else{
//					Image img = ImageIO.read(getClass().getResource("../images/8722.png" ));
//					icon = new ImageIcon(img); 
//				}
//			}catch (IOException e){
//				System.out.println("couldnt open file");
//			}
//			t.setIcon(icon);
//			//t.setBackground(Color.black);
//			//t.setText("hello");
//			//t.invalidate();
//		}
//		System.out.println(game);
//		this.validate();
//		this.repaint();
//	}
	
	
	
}
