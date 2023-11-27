package team;

import java.util.ArrayList;

public class Player {
	String name;
	ArrayList<Card> hand = new ArrayList<>();
	
	/**
	 * @param name
	 */
	public Player(String name) {
		this.name = name;
	}
	
	public boolean playCards (Table t) {
		//TODO unfinished method
		return false;
	}
	
	public void addCard(Card c) {
		hand.add(c);
	}

	@Override
	public String toString() {
		return "Player [name=" + name + "]";
	}

	/**
	 * @return the hand
	 */
	public ArrayList<Card> getHand() {
		return hand;
	}
	
	

}
