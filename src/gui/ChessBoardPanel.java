package gui;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import java.awt.Graphics2D;
import javax.swing.*;
import javax.swing.border.*;
import java.net.URL;
import javax.imageio.ImageIO;

import board.ChessSpecs;
import board.Position;
import game.ChessGame;
import game.ChessTimer;

public class ChessBoardPanel extends JPanel {
	
	private int numClicks = 0; 
	private ChessGame game = new ChessGame(); 
	private Position current; 
	private Position future; 
	static final String[] pieces = {
	        "\u2654", "\u2655", "\u2656", "\u2657", "\u2658", "\u2659"
	    };
	private BufferedImage[][] chessPieceImages = new BufferedImage[2][6];
    private JButton[][] chessBoardSquares = new JButton[8][8];
    private JPanel chessBoard;
    private static final String COLS = "ABCDEFGH";
    public static final int QUEEN = 0, KING = 1,
            ROOK = 2, KNIGHT = 3, BISHOP = 4, PAWN = 5;
    public static final int[] STARTING_ROW = {
        ROOK, KNIGHT, BISHOP, KING, QUEEN, BISHOP, KNIGHT, ROOK
    };
    public static final int BLACK = 0, WHITE = 1;
	
	public ChessBoardPanel(){
		initializeBoard();
		setUpPieces();
	}
	
	private void initializeBoard(){
		this.setLayout(new BorderLayout(3,3));
		this.add(new JLabel("GYARD"), BorderLayout.LINE_END);

		
		
		chessBoard = new JPanel(new GridLayout(0,9));
//		chessBoard = new JPanel(new GridBagLayout()) {
		
/*		@Override
            public final Dimension getPreferredSize() {
                Dimension d = super.getPreferredSize();
                Dimension prefSize = null;
                Component c = getParent();
                if (c == null) {
                    prefSize = new Dimension(
                            (int)d.getWidth(),(int)d.getHeight());
                } else if (c!=null &&
                        c.getWidth()>d.getWidth() &&
                        c.getHeight()>d.getHeight()) {
                    prefSize = c.getSize();
                } else {
                    prefSize = d;
                }
                int w = (int) prefSize.getWidth();
                int h = (int) prefSize.getHeight();
                // the smaller of the two sizes
                int s = (w>h ? h : w);
                return new Dimension(s,s);
            }
        };
*/        
        Color BGcolor = new Color(211, 211, 211);
        chessBoard.setBackground(BGcolor);
        JPanel boardConstrain = new JPanel(new GridBagLayout());
        boardConstrain.setBackground(BGcolor);
        boardConstrain.add(chessBoard);
        this.add(boardConstrain);
        
        Insets buttonMargin = new Insets(0, 0, 0, 0);
        for (int ii = 0; ii < chessBoardSquares.length; ii++) {
            for (int jj = 0; jj < chessBoardSquares[ii].length; jj++) {
                JButton b = new JButton();
                b.setMargin(buttonMargin);
                ImageIcon icon = new ImageIcon(
                        new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB));
                b.setIcon(icon);
                if ((jj % 2 == 1 && ii % 2 == 1)
                        || (jj % 2 == 0 && ii % 2 == 0)) {
                    b.setBackground(Color.WHITE);
                } else {
                    b.setBackground(Color.BLACK);
                }
                chessBoardSquares[jj][ii] = b;
            }
        }
        
        chessBoard.add(new JLabel(""));
        // fill the top row
        for (int ii = 0; ii < 8; ii++) {
            chessBoard.add(
                    new JLabel(COLS.substring(ii, ii + 1),
                    SwingConstants.CENTER));
        }
        // fill the black non-pawn piece row
        for (int ii = 0; ii < 8; ii++) {
            for (int jj = 0; jj < 8; jj++) {
                switch (jj) {
                    case 0:
                        chessBoard.add(new JLabel("" + (9-(ii + 1)),
                                SwingConstants.CENTER));
                    default:
                        chessBoard.add(chessBoardSquares[jj][ii]);
                }
            }
        }
		}
	
	private void setUpPieces(){
		
		createImages();
        for (int ii = 0; ii < STARTING_ROW.length; ii++) {
            chessBoardSquares[ii][0].setIcon(new ImageIcon(
                    chessPieceImages[BLACK][STARTING_ROW[ii]]));
        }
        for (int ii = 0; ii < STARTING_ROW.length; ii++) {
            chessBoardSquares[ii][1].setIcon(new ImageIcon(
                    chessPieceImages[BLACK][PAWN]));
        }
        // set up the white pieces
        for (int ii = 0; ii < STARTING_ROW.length; ii++) {
            chessBoardSquares[ii][6].setIcon(new ImageIcon(
                    chessPieceImages[WHITE][PAWN]));
        }
        for (int ii = 0; ii < STARTING_ROW.length; ii++) {
            chessBoardSquares[ii][7].setIcon(new ImageIcon(
                    chessPieceImages[WHITE][STARTING_ROW[ii]]));
        }
        
        for (int r = 0; r<8; r++){
			for (int c = 0; c<8; c++){
	

				GridBagConstraints constraints = new GridBagConstraints(); 
				GuiChessPiece piece = new GuiChessPiece(chessBoardSquares[r][c].getIcon(), new Position(r,c)); 
				piece.addActionListener(new
				         ActionListener()
				         {
				            public void actionPerformed(ActionEvent event)
				            {
				            	System.out.println("action performed");
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
//				constraints.gridx = c; 
//				constraints.gridy = r; 
				chessBoard.add(piece); 
			}
        }
        
	}
	
	
	   private final void createImages() {
		   int piece, side;
		   boolean gradient = false;
		   
		   for(int i = 0; i < 2; i++){
//			   side = i;
			   for(int j = 0; j < 6; j++){
//				   piece = j;
				   BufferedImage img = ChessPieceImages.getImageForChessPiece(j, i, gradient);
				   chessPieceImages[i][j] = img;
			   }
		   }
	   }
	   
	   
		private void makeMoveVsAi(){
			System.out.println("made move");
			if (game.isValidMove(current, future)){
				System.out.println("validMove");
				game.makeUserMove(current, future);
				redrawBoard(); 
				game.switchTurns();
				game.makeAiMove(2);
				game.switchTurns();
				redrawBoard(); 
			}
		}
		
		private void makeMoveVsUser(){
			if (game.isValidMove(current, future)){
				game.makeUserMove(current, future);
				game.switchTurns();
				redrawBoard(); 
			}
		}
	
	public void redrawBoard(){
		System.out.println(game);
		for (Component temp : this.getComponents()){
			GridBagConstraints gbc = ((GridBagLayout) this.getLayout()).getConstraints(temp);
			GuiChessPiece t =  (GuiChessPiece) temp; 
			//t.setText(game.getPieceAt(new Position(gbc.gridy,gbc.gridx)));
			String id = ChessSpecs.getImageName(game.getPieceAt(new Position(gbc.gridy,gbc.gridx))); 
			if (id!=null){
				//converting the ID to the correct inputs
				String idArray[] = id.split(",");
				int[] intID = new int[idArray.length];
				for (int i = 0; i < idArray.length; i++) {
			         String numberAsString = idArray[i];
			         intID[i] = Integer.parseInt(numberAsString);
			      } 
				
				ImageIcon icon = new ImageIcon(chessPieceImages[intID[0]][STARTING_ROW[intID[1]]]);
				t.setIcon(icon);
				}
			else{
				try{
					Image img = ImageIO.read(getClass().getResource("../images/8722.png" ));
					ImageIcon icon = new ImageIcon(img); 
					t.setIcon(icon);
				}catch (IOException e){
					System.out.println("couldnt open file");
					}
				
				}
			t.invalidate();
		}
		this.repaint();
	}
	
	
	
}