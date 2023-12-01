package team;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Class that controls and manages a game of scum. Use class Player, Table, and Card. 
 * 
 * Needs testing
 */
public class Game {
	private ArrayList<Player> players = new ArrayList<>();
	private ArrayList<Card> deck = new ArrayList<>();
	
	Table table;
	Player currentPlayer;
	int currentPlayerIndex = 0;
	
	//Update constructor to use ai Players
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
	public void play() {
		startGame();
		while(totalCards() > 1) {
			playRound();
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
	
	
	public void playRound() {
		while(!allPlayersPassed()) {
			//Can add if statement here if we want players to pass multiple times or just once per round
			//if(!currentPlayer.isPassed())
			currentPlayer = players.get(currentPlayerIndex);
			ArrayList<Card> inputCards = getPlayedCards();
			currentPlayer.playCards(inputCards, table);
			if(!allPlayersPassed()) {
				currentPlayerIndex++;
				if(currentPlayerIndex > players.size() -1)
					currentPlayerIndex = 0;
			}
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
	public ArrayList<Card> getPlayedCards() {
		ArrayList<Card> tempIn = new ArrayList<>();
		return tempIn;
	}

	
	

}
