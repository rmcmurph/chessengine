package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
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

public class Menu extends JFrame {

	private static JFrame menu;

	public void displayMenu(){
	
		menu = new Menu();
		
		menu.setTitle("Chess Champion");
		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menu.setExtendedState(JFrame.MAXIMIZED_BOTH);
		menu.setMinimumSize(new Dimension(640, 320));

		
		addComponentsToPane(menu.getContentPane());
		
		menu.setVisible(true);
		}
	
	public static void addComponentsToPane(Container pane){
		pane.setLayout(new BoxLayout(pane, BoxLayout.PAGE_AXIS));
		JLabel title = new JLabel("Main Menu"); 
		title.setFont(new Font("Sans-Serif", Font.PLAIN, 60));
		title.setAlignmentX(CENTER_ALIGNMENT);
		
		pane.add(title);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
		
		addButton("Start Game", buttonPanel);
		addButton("Options", buttonPanel);
		addButton("Help", buttonPanel);
		
		pane.add(buttonPanel, BorderLayout.CENTER);
		
		
	}
	
	private static void addButton(String text, Container container){
		JButton button = new JButton(text);
		button.setAlignmentX(Component.CENTER_ALIGNMENT);
		button.setMaximumSize(new Dimension(300, 300));
		
		if (text == "Start Game"){
			button.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent event)
	    			{
	    				MasterInterface m = new MasterInterface(); 
	    				m.display();
	    				menu.dispose();
	    			}
	    			
	    	});
		}
		else if (text == "Options"){
			button.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent event)
				{
					Options o = new Options(); 
					o.displayOptions();
					menu.dispose();
				}
			
			});
		}
//		else if (text == "Help")
			
		
		button.setFont(new Font("Sans-Serif", Font.PLAIN, 40));
		container.add(button);
	}
	
	public void toggleVis(){
		this.setVisible(!this.isVisible());
		}
	
}
