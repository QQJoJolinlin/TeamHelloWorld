package team;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Class for keeping track of the cards that have already been played
 * 
 * needs testing
 */
public class Table {
	
	ArrayList<Card> pile = new ArrayList<>();
	int amount;
	
	/**
	 * @param amount
	 */
	public Table(int amount) {
		this.amount = amount;
	}
	
	/**
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}
	
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}

	
	/**
	 * Add cards to the pile. Cards should be checked for validity before using this method.
	 * 
	 * @param cards - cards to be added to pile
	 */
	public void addCards(ArrayList<Card> cards) {
		pile.addAll(cards);
		Collections.sort(pile, Collections.reverseOrder());
	}
	
	/**
	 * Gets the top card of the pile which has the highest value
	 * 
	 * @return card with the highest value
	 */
	public Card getTopCard() {
		//Sort might be redundant here
		Collections.sort(pile, Collections.reverseOrder());
		return pile.get(0);
	}
	
	/**
	 * Clears the pile
	 */
	public void clearPile() {
		pile.clear();
	}

	
	
	
	

}
