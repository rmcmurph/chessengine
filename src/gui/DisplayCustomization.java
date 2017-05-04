package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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

public class DisplayCustomization extends JFrame {
	
	public void DisplayCustomization(){
		displayMenu();
	}
	
	public void displayMenu(){

				JLabel title = new JLabel("Display Options"); 		
				this.setExtendedState(JFrame.MAXIMIZED_BOTH);
				title.setFont(new Font("Sans-Serif", Font.PLAIN, 60));
				title.setAlignmentX(CENTER_ALIGNMENT);
			    this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
			    
			    JButton display = new JButton("Customize the Display");
			    display.setAlignmentX(Component.CENTER_ALIGNMENT);
				display.setMaximumSize(new Dimension(300, 300));
			    display.addActionListener(new ActionListener()
			    		{
			    			public void actionPerformed(ActionEvent event)
			    			{
			    				
			    			}
			    		});
			    
			    JButton back = new JButton("Return to Main Menu");
			    display.setAlignmentX(Component.CENTER_ALIGNMENT);
				display.setMaximumSize(new Dimension(300, 300));
			    back.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent event)
					{
						Menu menu = new Menu();		
						menu.displayMenu();
						dispose();
					}
					
				});
			    


			    this.add(title);
			    this.getContentPane().add(display, BoxLayout.Y_AXIS);
			    this.getContentPane().add(back, BoxLayout.Y_AXIS);
			    
			    
				this.setMinimumSize(new Dimension(640,320));
			    this.setVisible(true);
			    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			    
			}

		
}

