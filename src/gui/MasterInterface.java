package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import game.ChessGame;

/**
 * 
 * @author estorrs
 *
 */

/**
 * 
 * Main GUI
 *
 */
public class MasterInterface extends JFrame{
	
	
	/**
	 * updates the GUI when changes are made to DailyPlayerList
	 */
	public void display() {
		
		//the header
		JLabel title = new JLabel("Chess Gui"); 
        title.setHorizontalAlignment(SwingConstants.CENTER);
        
        
        //clears frame
		this.getContentPane().removeAll(); 
		


	    //add components to frame
	    this.setLayout(new BorderLayout());
        this.add(title, BorderLayout.NORTH);
        this.add(new ChessBoardPanel(), BorderLayout.CENTER); 
       // this.remove();
//        

        
        this.pack(); 
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	

	
	/**
	 * returns a JPanel that represents a player.  JPanel shows player name, position, salary, and add button
	 * @param i integer value indicating whether to use an addition or removal button.  0 for add button,
	 *  	  1 for remove button. Otherwise if any other integer is given, remove button is used.  
	 * @param p player to be used to make panel
	 * @param dpl daily player list for day
	 * @return JPanel that represents the given player.  
**/


	private static final long serialVersionUID = 1L;
}

