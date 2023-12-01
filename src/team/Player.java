package team;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Player {
	String name;
	int cardsRemaining;
	boolean passed = false;
	
	ArrayList<Card> hand = new ArrayList<>();
	ArrayList<Card> validCards = new ArrayList<>();
	
	
	/**
	 * @param name
	 */
	public Player(String name) {
		this.name = name;
	}
	
	/**
	 * @return the passed
	 */
	public boolean isPassed() {
		return passed;
	}
	
	/**
	 * @param passed the passed to set
	 */
	public void setPassed(boolean passed) {
		this.passed = passed;
	}

	public int getCardsRemaining() {
		cardsRemaining = hand.size();
		return cardsRemaining;	
	}
	
<<<<<<< HEAD
	public void addCard(Card c) {
		hand.add(c);
	}

	@Override
	public String toString() {
		return "Player [name=" + name + "]";
	}
	public String getName() {
		return this.name;
	}

=======
>>>>>>> branch 'master' of https://github.com/QQJoJolinlin/TeamHelloWorld.git
	/**
	 * @return the hand
	 */
	public ArrayList<Card> getHand() {
		Collections.sort(hand);
		return hand;
	}
	
	/**
	 * Adds a card to the player's hand. Used when dealing initial cards.
	 * 
	 * @param c - card to be added
	 */
	public void addCard(Card c) {
		hand.add(c);
	}
	
	@Override
	public String toString() {
		return "Player [name=" + name + "]";
	}
	
	/**
	 * Plays the given cards. if cards is empty or null the player will pass their turn. Method also checks cards 
	 * to make sure they all have the same value.
	 * 
	 * @param cards - cards to be played
	 * @param t - table to add the cards to
	 * @return true if everything worked properly or false if something went wrong
	 */
	public boolean playCards (ArrayList<Card> cards, Table t) {
		//Add check for if player is passed or reset passed boolean
		getValidCards(t);
		if(validCards.size() == 0 || cards.size() == 0 || validCards == null)
			passed = true;
		if(validCards.containsAll(cards)) {
			for(int i = 0; i < cards.size()-1; i++) {
				if(cards.get(i).equals(cards.get(i+1)))
					continue;
				else 
					return false;
			}
			if(t.getAmount() == 0)
				t.setAmount(cards.size());
			t.addCards(cards);
			hand.removeAll(cards);
			return true;
		}
		return false;
	}
	
	/**
	 * Gets the in the players hand that they can player based on the table
	 * 
	 * @param t - the current table
	 * @return ArrayList with all the valid cards
	 */
	public ArrayList<Card> getValidCards(Table t) {
		Collections.sort(hand);
		Card topCard = t.getTopCard();
		int indexSplit = 0;
		for(int i = 0; i < hand.size(); i++) {
			if(hand.get(i).getValue() > topCard.getValue()) {
				indexSplit = i;
				break;
			}
		}
		
		validCards = new ArrayList<>(hand.subList(indexSplit, hand.size()));
		
		Map<Card, Integer> hm = new HashMap<>();
		for (Card c : validCards) {
			Integer count = hm.get(c);
			hm.put(c, (count == null) ? 1 : count + 1);
		}		
		
		validCards.removeIf(x -> hm.get(x) < t.getAmount());

		return validCards;
	}
	
}
