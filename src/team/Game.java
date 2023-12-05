package team;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class that controls and manages a game of scum. Use class Player, Table, and Card. 
 * 
 * Needs testing
 */
public class Game {
	private ArrayList<Player> players = new ArrayList<>();
	private ArrayList<Card> deck = new ArrayList<>();
	Table table = new Table(0);
	int currentPlayerInt = 0;

	Player currentPlayer;
	int currentPlayerIndex = 0;
	
	//Update constructor to use ai Players
//>>>>>>> branch 'master' of https://github.com/QQJoJolinlin/TeamHelloWorld.git
	public Game(String[] names) {
		for(String s: names) {
			players.add(new Player(s));
		}
		table = new Table(0);
	}
	
	/**
	 * @return the deck
	 */
	public ArrayList<Card> getDeck() {
		return deck;
	}
	
	/**
	 * @return the table
	 */
	public Table getTable() {
		return table;
	}

	/**
	 * @return the currentPlayer
	 */
	public Player getCurrentPlayer() {
		return currentPlayer;
	}
	
	/**
	 * @return the players
	 */
	public ArrayList<Player> getPlayers() {
		return players;
	}
	
	/**
	 * Method to play the game. Stops when all the players are out of cards.
	 */
	public void play(Scanner scnr) {
		startGame();
		while(totalCards() > 1) {
			playRound(scnr);
		}
		
	}
	
	public void startGame() {
		deck = createDeck();
		Collections.shuffle(deck);
		int i = 0;
		while(deck.size() > 0) {
			players.get(i).addCard(deck.get(0));
			deck.remove(0);
			
			i++;
			if(i > players.size() -1)
				i=0;
		}
	}
	
	
	public void playRound(Scanner scnr) {
		while(!allPlayersPassed()) {
			//Can add if statement here if we want players to pass multiple times or just once per round
			//if(!currentPlayer.isPassed())
			currentPlayer = players.get(currentPlayerIndex);
			ArrayList<Card> inputCards = getPlayedCards(scnr);
			currentPlayer.playCards(inputCards, table);
			if(!allPlayersPassed()) {
				currentPlayerIndex++;
				if(currentPlayerIndex > players.size() -1)
					currentPlayerIndex = 0;
			}
			if(inputCards != null)
				inputCards.clear();
		}
		table.setAmount(0);
		table.clearPile();
		for(Player p : players) {
			p.setPassed(false);
		}
		
	}
	
	//might be unneeded
	public void sortDeck() {
		Collections.sort(deck, Collections.reverseOrder());
	}

	private ArrayList<Card> createDeck() {
		Suit[] suits = Suit.values();
		for(Suit s: suits) {
			for(int i = 3; i < 11; i++) {
				deck.add(new Card(s, "" + i, i - 2));
			}
			deck.add(new Card(s, "jack", 9));
			deck.add(new Card(s, "queen", 10));
			deck.add(new Card(s, "king", 11));
			deck.add(new Card(s, "ace", 12));
			deck.add(new Card(s, "2", 13));
		}
		return deck;
	}
	
	
	/**
	 * Gets the total number of cards remaining in the hands of all players.
	 * 
	 * @return total number of cards left
	 */
	public int totalCards() {
		int totalCards = 0;
		for(Player p : players) {
			totalCards = totalCards + p.getCardsRemaining();
		}
		return totalCards;
	}
	
	
	/**
	 * Checks all players to see if they have all passed
	 * 
	 * @return true if all players have passed and false if at least one player hasn't
	 */
	public boolean allPlayersPassed() {
		for(Player p : players) {
			if(!p.isPassed())
				return false;
		}
		return true;
	}
	
	//Use this method to get cards from gui
	public ArrayList<Card> getPlayedCards(Scanner scnr) {
		boolean turnOver = false;
		while(!turnOver) {
			System.out.println();
			System.out.println("Table: " + table.getTopCard().toString());
			System.out.println(currentPlayer.getName() + "'s turn");
			System.out.println();
			menu();

			boolean validInput = false;
			int input = 0;

			while(validInput == false) {
				try {
					input = scnr.nextInt();
					if(input >= 1 && input <= 4)
						validInput = true;
				} catch (Exception e) {
					System.out.println("Invalid input try again");
					scnr.nextLine();
					input = 0;
				}	
			}

			switch(input) {
			case 1:
				System.out.println(currentPlayer.getHand());
				break;
			case 2:
				System.out.println(currentPlayer.getValidCards(table));
				break;
			case 3:
				playedCards(scnr);
				break;
			case 4:
				System.out.println("Passing");
				turnOver = true;
				return null;
			default:
				turnOver = true;
				return null;
			}	
		}
		
		ArrayList<Card> tempIn = new ArrayList<>();
		return tempIn;
	}
	
	private void menu() {
		System.out.println("Menu:");
		System.out.println("1) Show hand");
		System.out.println("2) Show playable cards");
		System.out.println("3) Play");
		System.out.println("4) Pass");
	}
	
	private ArrayList<Card> playedCards(Scanner scnr) {
		System.out.println("Available Cards to Play");
		ArrayList<Card> playersCards = currentPlayer.getValidCards(table);
		int counter = 1;
		for(int i = 0; i < playersCards.size(); i++) {	
			if(i == 0) {
				System.out.println(counter + ") " + playersCards.get(i).getName() + "'s");
				counter++;
				continue;
			}
			if(playersCards.get(i).equals(playersCards.get(i-1)))
				continue;
			else
				System.out.println((counter) + ") " + playersCards.get(i).getName() + "'s");
			counter++;
		}
		return null;

		
	}

	
	

}
