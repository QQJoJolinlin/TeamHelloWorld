package team;

import java.util.ArrayList;
import java.util.Collections;

public class Game {
	private ArrayList<Player> players = new ArrayList<>();
	private ArrayList<Card> deck = new ArrayList<>();

	public Game(String[] names) {
		deck = createDeck();
		for(String s: names) {
			players.add(new Player(s));
		}
		
	}
	
	/**
	 * @return the deck
	 */
	public ArrayList<Card> getDeck() {
		return deck;
	}
	
	public void startRound() {
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
	
	public boolean playRound() {
		//TODO unfinished method
		return false;
		
	}
	
	public void sortDeck() {
		Collections.sort(deck, Collections.reverseOrder());
	}

	private ArrayList<Card> createDeck() {
		Suit[] suits = Suit.values();
		for(Suit s: suits) {
			for(int i = 3; i < 11; i++) {
				deck.add(new Card(s, "" + i, i - 2));
			}
			deck.add(new Card(s, "Jack", 9));
			deck.add(new Card(s, "Queen", 10));
			deck.add(new Card(s, "King", 11));
			deck.add(new Card(s, "Ace", 12));
			deck.add(new Card(s, "2", 13));
		}
		return deck;
	}

	/**
	 * @return the players
	 */
	public ArrayList<Player> getPlayers() {
		return players;
	}

	
	

}
