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
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JButton;
import java.awt.CardLayout;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class ScumGui extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel playersHand;

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
		String[] names = {"bob", "mike", "carl"};
		ArrayList<JLabel> players = new ArrayList();
		Game testGame = new Game(names);
		testGame.startRound();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1161, 748);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 64, 64));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(10, 10));
		
		panel = new JPanel();
		panel.setBackground(new Color(0, 128, 64));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 128, 64));
		panel.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		playersHand = new JPanel();
		OverlapLayout overlapping = new OverlapLayout(new Point(20, 0));
		overlapping.setPopupInsets(new Insets(20, 0, 0, 0));
		panel_1.add(playersHand, BorderLayout.SOUTH);
		
		// Adding Cards
		for(int i = 0; i < testGame.getPlayers().get(0).getHand().size(); i++)
		{
			playersHand.add(displayCard(testGame.getPlayers().get(0).getHand().get(i)));
		}
		
		
		//Display Players
	players = displayPlayers(testGame.getPlayers());
		for(int i = 0; i < testGame.getPlayers().size(); i++)
		{
			switch(i) {
			case 0:
				players.get(i).setFont(new Font("Times New Roman", Font.BOLD, 24));
				players.get(i).setHorizontalAlignment(SwingConstants.CENTER);
				panel.add(players.get(i), BorderLayout.SOUTH);
				break;
			case 1:
				players.get(i).setFont(new Font("Times New Roman", Font.BOLD, 24));
				players.get(i).setHorizontalAlignment(SwingConstants.CENTER);
				panel.add(players.get(i), BorderLayout.NORTH);
				break;
			case 2:
				players.get(i).setFont(new Font("Times New Roman", Font.BOLD, 24));
				players.get(i).setHorizontalAlignment(SwingConstants.CENTER);
				panel.add(players.get(i), BorderLayout.EAST);
				break;
			case 3:
				players.get(i).setFont(new Font("Times New Roman", Font.BOLD, 24));
				players.get(i).setHorizontalAlignment(SwingConstants.CENTER);
				panel.add(players.get(i), BorderLayout.WEST);
				break;
				default: System.out.println("Something has Broken");
					break;
			}
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
	public static JLabel  displayCard(Card currentCard) {
		JLabel card = new JLabel("");
		card.setHorizontalAlignment(SwingConstants.CENTER);
		//lblNewLabel.setIcon(new ImageIcon(ScumGui.class.getResource("/resources/10_of_clubs.png")));
		System.out.println("/resources/" +currentCard.getName()
				+"_of_" +currentCard.getSuit()+".png");
		try{
			Image image = ImageIO.read(ScumGui.class.getResource("/resources/" +currentCard.getName()
					+"_of_" +currentCard.getSuit()+".png")).getScaledInstance(50, 70, Image.SCALE_DEFAULT); // Finally got it to fucking work    
			card.setIcon(new ImageIcon(image));
		} 
		catch (Exception e) {
			System.out.println("Bad Things Happening");
		}
		
		return card;
	}
	}


