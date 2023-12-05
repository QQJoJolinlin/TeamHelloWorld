package team;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import GuiDay2.DoingTheGuiStuff;
import GuiDay2.OverlapLayout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JButton;
import java.awt.CardLayout;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

import java.awt.ComponentOrientation;
import javax.swing.border.CompoundBorder;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ScumGui extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel playersHand;
	private JPanel centerPanel;
	private JLabel thePile;
	private JLabel northHand;
	private JLabel westHand;
	private JLabel eastHand;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScumGui frame = new ScumGui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ScumGui() {
		String[] names = {"bob", "mike", "carl", "Jill"};
		ArrayList<JLabel> players = new ArrayList();
		Game testGame = new Game(names);
		Table table = new Table(0);
		testGame.startRound();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1161, 748);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 64, 64));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(10, 10));
		
		panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(new Color(0, 128, 64));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		panel_1 = new JPanel();
		panel_1.setBorder(null);
		panel_1.setBackground(new Color(0, 128, 64));
		panel.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		playersHand = new JPanel();
		playersHand.setBackground(new Color(0, 128, 64));
		OverlapLayout overlapping = new OverlapLayout(new Point(20, 0));
		overlapping.setPopupInsets(new Insets(20, 0, 0, 0));
		panel_1.add(playersHand, BorderLayout.SOUTH);
		
		centerPanel = new JPanel();
		centerPanel.setBorder(null);
		centerPanel.setMaximumSize(new Dimension(70, 100));
		centerPanel.setPreferredSize(new Dimension(70, 100));
		centerPanel.setBackground(new Color(0, 128, 64));
		centerPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		panel_1.add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(new GridLayout(1, 1, 0, 0));
		
		thePile = new JLabel("");
		thePile.setBackground(new Color(0, 128, 64));
		thePile.setBorder(null);
		thePile.setForeground(new Color(255, 0, 0));
		thePile.setFont(new Font("Tahoma", Font.BOLD, 15));
		thePile.setHorizontalTextPosition(SwingConstants.CENTER);
		thePile.setHorizontalAlignment(SwingConstants.CENTER);
		thePile.setPreferredSize(new Dimension(70, 100));
		try{
			Image image = ImageIO.read(ScumGui.class.getResource("/resources/backOfCard.png")).getScaledInstance(70, 100, Image.SCALE_DEFAULT); // Finally got it to fucking work    
			thePile.setIcon(new ImageIcon(image));
		} 
		catch (Exception e) {
			System.out.println("Bad Things Happening");
		}
		centerPanel.add(thePile);
		
		
		
		//Adding the AI players card infront of them {
		northHand = new JLabel("");
		northHand.setBorder(null);
		northHand.setHorizontalTextPosition(SwingConstants.CENTER);
		northHand.setHorizontalAlignment(SwingConstants.CENTER);
		northHand.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		panel_1.add(northHand, BorderLayout.NORTH);
		try{
			Image image = ImageIO.read(ScumGui.class.getResource("/resources/backOfCard.png")).getScaledInstance(70, 100, Image.SCALE_DEFAULT); // Finally got it to fucking work    
			northHand.setIcon(new ImageIcon(image));
		} 
		catch (Exception e) {
			System.out.println("Bad Things Happening");
		}
		
		westHand = new JLabel("");
		panel_1.add(westHand, BorderLayout.WEST);
		try{
			Image image = ImageIO.read(ScumGui.class.getResource("/resources/backOfCardHorizontal.png")).getScaledInstance(100, 70, Image.SCALE_DEFAULT); // Finally got it to fucking work    
			westHand.setIcon(new ImageIcon(image));
		} 
		catch (Exception e) {
			System.out.println("Bad Things Happening");
		}
		
		eastHand = new JLabel("");
		panel_1.add(eastHand, BorderLayout.EAST);
		try{
			Image image = ImageIO.read(ScumGui.class.getResource("/resources/backOfCardHorizontal.png")).getScaledInstance(100, 70, Image.SCALE_DEFAULT); // Finally got it to fucking work    
			eastHand.setIcon(new ImageIcon(image));
		} 
		catch (Exception e) {
			System.out.println("Bad Things Happening");
		}
		// Adding AI player Card infront of them }
		
		
		// Adding Cards
		for(int i = 0; i < testGame.getPlayers().get(0).getHand().size(); i++)
		{
			playersHand.add(displayCard(testGame.getPlayers().get(0).getHand().get(i), testGame,thePile));
		}
		BorderLayout b = new BorderLayout();
	  String[] ss = {b.SOUTH, b.WEST, b.NORTH, b.EAST};
		//Display Players
	  players = displayPlayers(testGame.getPlayers());
		for(int i = 0; i < testGame.getPlayers().size(); i++)
		{
			players.get(i).setFont(new Font("Times New Roman", Font.BOLD, 24));
			players.get(i).setHorizontalAlignment(SwingConstants.CENTER);
			panel.add(players.get(i), ss[i]);
			
			}
	}
	
	
	public static ArrayList<JLabel> displayPlayers(ArrayList<Player> players) {
		ArrayList<JLabel> playerLabels = new ArrayList();
		for(int i =0; i < players.size(); i++) {
			switch(i) {
			case 0:
				JLabel Player1 = new JLabel(players.get(i).getName());
				playerLabels.add(Player1);
				break;
			case 1: 
				JLabel Player2 = new JLabel(players.get(i).getName());
				playerLabels.add(Player2);
				break;
			case 2: 
				JLabel Player3 = new JLabel(players.get(i).getName());
				playerLabels.add(Player3);
				break;
			case 3:
				JLabel Player4 = new JLabel(players.get(i).getName());
				playerLabels.add(Player4);
				break;
			}
		}
		return playerLabels;
	}
	
	
	// Displays Players Hand {
	public static JButton  displayCard(Card currentCard, Game game, JLabel pile) {
		
		Border emptyBorder = BorderFactory.createEmptyBorder();
		JButton button = new JButton("");
		button.setBorder(emptyBorder);
		button.setHorizontalAlignment(SwingConstants.CENTER);
		//lblNewLabel.setIcon(new ImageIcon(ScumGui.class.getResource("/resources/10_of_clubs.png")));
		System.out.println("/resources/" +currentCard.getName()
				+"_of_" +currentCard.getSuit()+".png");
		try{
			Image image = ImageIO.read(ScumGui.class.getResource("/resources/" +currentCard.getName()
					+"_of_" +currentCard.getSuit()+".png")).getScaledInstance(70, 100, Image.SCALE_DEFAULT); // Finally got it to fucking work    
			ImageIcon test = new ImageIcon(image);
			test.setDescription("" + currentCard.getValue() + " " + currentCard.getSuit());
			button.setIcon(test);
		} 
		catch (Exception e) {
			System.out.println("Bad Things Happening");
		}
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			String card = ((ImageIcon)button.getIcon()).getDescription();
			
			if(playCard(card, game) )
					{
				button.disable();
				button.setVisible(false);
				try{
					Image image = ImageIO.read(ScumGui.class.getResource("/resources/" +currentCard.getName()
							+"_of_" +currentCard.getSuit()+".png")).getScaledInstance(70, 100, Image.SCALE_DEFAULT); // Finally got it to fucking work    
					ImageIcon test = new ImageIcon(image);
					test.setDescription("" + currentCard.getValue() + " " + currentCard.getSuit());
					pile.setIcon(test);
				} 
				catch (Exception e1) {
					System.out.println("Bad Things Happening");
				}
					}
			}
		});
		
		return button;
	}
	
	
	
	
	public static boolean playCard(String Card, Game game) {
	int tempInt = (Integer.parseInt(Card.substring(0, Card.indexOf(' '))));
		ArrayList<Card> playedCard = new ArrayList();
		for(int i = 0; i < game.getPlayers().get(0).getHand().size();i++)		
		{
//			//System.out.println(i);
//			System.out.print("Value: " + game.getPlayers().get(0).getHand().get(i).getValue() +  " Name: " + tempInt );
//			System.out.print("Suit: "+ game.getPlayers().get(0).getHand().get(i).getSuit() + "Suit: " + Card.substring(Card.indexOf(" ")+1));
//			System.out.print(game.getPlayers().get(0).getHand().get(i).getValue() == tempInt);
//			System.out.println(game.getPlayers().get(0).getHand().get(i).getSuit().toString().equals((Card.substring((Card.indexOf(" "))+1))));
			if((game.getPlayers().get(0).getHand().get(i).getValue() == tempInt) && (game.getPlayers().get(0).getHand().get(i).getSuit().toString().equals(Card.substring(Card.indexOf(" ")+1))))
			{
			playedCard.add(game.getPlayers().get(0).getHand().get(i));
			System.out.println("It kinda works");
			return true;
			//game.getPlayers().get(i).playCards(playedCard, game.getTable());
			
			}
		
		
	}
		return false;
	// Displays Players Hand }
	}}


