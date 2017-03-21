package gui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import board.ChessSpecs;
import board.Position;
import game.ChessGame;

public class ChessBoardPanel extends JPanel {
	
	private int numClicks = 0; 
	private ChessGame game = new ChessGame(); 
	
	private Position current; 
	private Position future; 
	
	public ChessBoardPanel(){
		this.setLayout(new GridBagLayout());
		setUpPieces(); 
	}
	
	private void setUpPieces(){

		for (int r = 0; r<8; r++){
			for (int c = 0; c<8; c++){
				GridBagConstraints constraints = new GridBagConstraints(); 
				//JLabel identifier = new JLabel(game.getPieceAt(new Position(r,c))); 
				

				//ImageIcon icon = new ImageIcon("../images/" + ChessSpecs.getImageName(game.getPieceAt(new Position(r,c)))); 
				//ImageIcon icon = new ImageIcon("../images/black_bishop.png"); 
				String id = ChessSpecs.getImageName(game.getPieceAt(new Position(r,c))); 
				ImageIcon icon = new ImageIcon(); 
				try{
					if (id!=null){
						Image img = ImageIO.read(getClass().getResource("../images/"+id ));
						icon = new ImageIcon(img); 
					}else{
						Image img = ImageIO.read(getClass().getResource("../images/8722.png" ));
						icon = new ImageIcon(img); 
					}
				}catch (IOException e){
					System.out.println("couldnt open file");
				}
				GuiChessPiece piece = new GuiChessPiece(icon, new Position(r,c)); 
				piece.addActionListener(new
				         ActionListener()
				         {
				            public void actionPerformed(ActionEvent event)
				            {
				            	numClicks++; 
				            	if (numClicks==1){
				            		current = new Position(piece.getRow(), piece.getColumn()); 
				            	}
				            	else if (numClicks==2){
				            		future = new Position(piece.getRow(), piece.getColumn()); 
				            		makeMoveVsAi(); 
				            		numClicks = 0; 
				            		
				            	}
				            }
				         });
				
				piece.setPreferredSize(new Dimension(60, 60));
				
				constraints.gridx = c; 
				constraints.gridy = r; 
				this.add(piece, constraints); 
			}
		}
	}
	
	private void makeMoveVsAi(){
		game.makeUserMove(current, future);
		redrawBoard(); 
		game.switchTurns();
		game.makeAiMove();
		game.switchTurns();
		redrawBoard(); 

	}
	
	
	public void redrawBoard(){
		System.out.println(game);
		for (Component temp : this.getComponents()){
			GridBagConstraints gbc = ((GridBagLayout) this.getLayout()).getConstraints(temp);
			GuiChessPiece t =  (GuiChessPiece) temp; 
			//t.setText(game.getPieceAt(new Position(gbc.gridy,gbc.gridx)));
			String id = ChessSpecs.getImageName(game.getPieceAt(new Position(gbc.gridy,gbc.gridx))); 
			ImageIcon icon = new ImageIcon(); 
			try{
				if (id!=null){
					Image img = ImageIO.read(getClass().getResource("../images/"+id ));
					icon = new ImageIcon(img); 
				}else{
					Image img = ImageIO.read(getClass().getResource("../images/8722.png" ));
					icon = new ImageIcon(img); 
				}
			}catch (IOException e){
				System.out.println("couldnt open file");
			}
			t.setIcon(icon);
			t.invalidate();
		}
		this.repaint();
	}
	
	
	
}
