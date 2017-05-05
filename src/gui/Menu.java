package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
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

	private static JPanel gameCard = new JPanel();
	private static JPanel optionCard = new JPanel();
	private static JPanel helpCard = new JPanel();
	private static JPanel cards = new JPanel(new CardLayout());
	private static JPanel menuCard = new JPanel();
	private static JPanel customizeCard = new JPanel();
	private static CardLayout cardLayout = (CardLayout) cards.getLayout();
	
	public static int difficulty = 2;
	public static boolean tutor = false;
	public static boolean pvp = false;
	public static String diffText = "Difficulty: " + Integer.toString(difficulty);
	public static String tutorText = "Tutor: " + String.valueOf(tutor);
	public static String modeText = "PVP: " + String.valueOf(pvp);
	public static Color BGColor = Color.BLACK;
	public static Color FGColor = Color.WHITE;
	
	public void displayMenu(){
		
		this.setTitle("Chess Champion");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setMinimumSize(new Dimension(640, 320));
		
		cards.add(menuCard, "Main Menu");
		menuCard.setBackground(BGColor);
		
		cards.add(gameCard, "Start Game");
		gameCard.setBackground(BGColor);
		
		cards.add(optionCard, "Options");
		optionCard.setBackground(FGColor);
		
		cards.add(customizeCard, "Customization");
		customizeCard.setBackground(BGColor);
		
		cards.add(helpCard, "Help");
		
		this.getContentPane().add(cards);
		
		addComponentsToMain(menuCard);
		
		cardLayout.show(cards, "Main Menu");
		
		
		this.setVisible(true);
		}
	
	public static void addComponentsToMain(Container pane){
		pane.setLayout(new BoxLayout(pane, BoxLayout.PAGE_AXIS));
		JLabel title = new JLabel("Main Menu"); 
		title.setFont(new Font("Calibri", Font.PLAIN, 120));
		title.setForeground(FGColor);
		title.setAlignmentX(CENTER_ALIGNMENT);
		
		pane.add(title);
		
		JPanel buttonPanelMain = new JPanel();
		buttonPanelMain.setLayout(new BoxLayout(buttonPanelMain, BoxLayout.Y_AXIS));
		
		addButton("Start Game", buttonPanelMain);
		addButton("Options", buttonPanelMain);
		addButton("Help", buttonPanelMain);
		
		pane.add(buttonPanelMain, BorderLayout.CENTER);
		
		
	}
	
	public static void addComponentsToOptions(Container pane){
		pane.setLayout(new BoxLayout(pane, BoxLayout.PAGE_AXIS));
		JLabel title = new JLabel("Options"); 
		title.setFont(new Font("Calibri", Font.PLAIN, 120));
		title.setAlignmentX(CENTER_ALIGNMENT);
		title.setForeground(BGColor);
		
		pane.add(title);
		
		JPanel buttonPanelOption = new JPanel();
		buttonPanelOption.setLayout(new BoxLayout(buttonPanelOption, BoxLayout.Y_AXIS));
		
		addButton("Customization", buttonPanelOption);
		addButton(diffText, buttonPanelOption);
		addButton(tutorText, buttonPanelOption);
		addButton(modeText, buttonPanelOption);
		addButton("Back", buttonPanelOption);

		
		pane.add(buttonPanelOption, BorderLayout.CENTER);
	}
	
	public static void addComponentsToCustomize(Container pane){
		pane.setLayout(new BoxLayout(pane, BoxLayout.PAGE_AXIS));
		JLabel title = new JLabel("Customization"); 
		title.setFont(new Font("Calibri", Font.PLAIN, 120));
		title.setAlignmentX(CENTER_ALIGNMENT);
		title.setForeground(FGColor);
		
		pane.add(title);
		
		JPanel buttonPanelCustom = new JPanel();
		buttonPanelCustom.setLayout(new BoxLayout(buttonPanelCustom, BoxLayout.Y_AXIS));
		
		addButton("Red&Black", buttonPanelCustom);
		
		
		pane.add(buttonPanelCustom, BorderLayout.CENTER);
	}
	
	private static void addButton(String text, Container container){
		JButton button = new JButton(text);
		button.setAlignmentX(Component.CENTER_ALIGNMENT);
		button.setMaximumSize(new Dimension(300, 300));
		
		switch (text) {
			
			case "Start Game":
				button.setBackground(BGColor);
				button.setForeground(FGColor);
				button.setBorderPainted(false);
				button.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent event)
					{
						JButton back = new JButton("Return to Main Menu");  
						back.addActionListener(new ActionListener()
						{
							public void actionPerformed(ActionEvent event)
							{
								cardLayout.show(cards, "menuCard");
								menuCard.setVisible(true);
								gameCard.setVisible(false);
								gameCard.removeAll();
							}
						
						});
			        
					
						JPanel flowPanel = new JPanel(new FlowLayout());
						flowPanel.add(back);

						gameCard.setLayout(new BorderLayout());
						gameCard.add(new ChessBoardPanel(difficulty, tutor, pvp), BorderLayout.CENTER); 
						
						JPanel graveYard = new Graveyard();
						gameCard.add(graveYard, BorderLayout.LINE_END);
					
						gameCard.add(flowPanel, BorderLayout.NORTH);
				        gameCard.setVisible(true);
				        menuCard.setVisible(false);
						cardLayout.show(cards, "gameCard");
	    			}
	    			
	    	});

			case "Options":
				button.setBackground(BGColor);
				button.setForeground(FGColor);
				button.setBorderPainted(false);
				button.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent event)
					{
						addComponentsToOptions(optionCard);
						optionCard.setMinimumSize(new Dimension(640,320));
					
						cardLayout.show(cards, "optionCard");
						menuCard.setVisible(false);
						optionCard.setVisible(true);
					}
			
			});
		
			
			case "Mode":
				button.setBackground(FGColor);
				button.setForeground(BGColor);
				button.setBorderPainted(false);
				button.addActionListener(new ActionListener() 
				{
					public void actionPerformed(ActionEvent event)
					{
						
					}
				});
			
			case "Back":
				button.setBackground(FGColor);
				button.setForeground(BGColor);
				button.setBorderPainted(false);
				button.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent event)
					{
						cardLayout.show(cards, "menuCard");
						menuCard.setVisible(true);
						optionCard.setVisible(false);
						optionCard.removeAll();
					}
					
				});
		
		
			case "Customization":
		//		button.setBackground(BGColor);
		//		button.setBorderPainted(false);
				button.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent event)
					{
						addComponentsToCustomize(customizeCard);
						//customizeCard.setMinimumSize(new Dimension(640,320));
						
						//cardLayout.show(cards, "customizeCard");
						optionCard.setVisible(false);
						customizeCard.setVisible(true);
						optionCard.removeAll();
					}
				});
		
			case "Red&Black":
				button.setBackground(BGColor);
				button.setBorderPainted(false);
				button.addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent event)
						{
							FGColor = Color.RED;
							BGColor = Color.BLACK;
						}
					});
				
			case "Help":
				button.setBackground(BGColor);
				button.setForeground(FGColor);
				button.setBorderPainted(false);
			}
			
			
		
		if (text == diffText){
			button.setBackground(FGColor);
			button.setBorderPainted(false);
			button.addActionListener(new ActionListener() 
					{
						public void actionPerformed(ActionEvent event)
						{
							if (difficulty == 3)
								difficulty = 1;
							else
								difficulty++;
							String newDiff = Integer.toString(difficulty);
							diffText = "Difficulty: " + newDiff;
							button.setText(diffText);
						}
					});
		}
		else if (text == tutorText){
			button.setBackground(FGColor);
			button.setBorderPainted(false);
			button.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent event)
				{
					tutor = !tutor;
					
					String newText = "Tutor: " + String.valueOf(tutor);
					button.setText(newText);
				}
			});
		}
		
		else if (text == modeText){
			button.setBackground(FGColor);
			button.setBorderPainted(false);
			button.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent event)
				{
					pvp = !pvp;
					
					String newText = "PVP: " + String.valueOf(pvp);
					button.setText(newText);
				}
			});
		}
		
		button.setFont(new Font("Calibri", Font.PLAIN, 40));
		container.add(button);
	}
	
	public void toggleVis(){
		this.setVisible(!this.isVisible());
		}
	
}
