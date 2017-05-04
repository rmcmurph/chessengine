package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
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

import board.ChessBoard;
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


        JButton back = new JButton("Return to Main Menu");  
        back.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				Menu menu = new Menu();		
				menu.displayMenu();
				dispose();
			}
			
		});
        

		
		
        //clears frame
		this.getContentPane().removeAll();
		
	    JPanel flowPanel = new JPanel(new FlowLayout());
	    flowPanel.add(back);



	    //add components to frame
	    this.setLayout(new BorderLayout());
        this.add(new ChessBoardPanel(), BorderLayout.CENTER); 
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		

        
        this.add(flowPanel, BorderLayout.NORTH);
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

