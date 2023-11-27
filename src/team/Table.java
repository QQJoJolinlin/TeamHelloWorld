package team;

import java.util.ArrayList;
import java.util.Collections;

public class Table {
	
	ArrayList<Card> pile = new ArrayList<>();
	int amount;
	
	/**
	 * @param amount
	 */
	public Table(int amount) {
		this.amount = amount;
	}
	
	public boolean playCards(ArrayList<Card> cards) {
		//TODO unfinished method
		return false;
	}
	
	public Card getTopCard() {
		Collections.sort(pile, Collections.reverseOrder());
		return pile.get(0);
	}

	/**
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}
	
	
	

}
