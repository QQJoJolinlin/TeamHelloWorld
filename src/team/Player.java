package team;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Player {
	String name;
	int cardsRemaining;
	boolean passed = false;
	
	ArrayList<Card> hand = new ArrayList<>();
	ArrayList<Card> validCards = new ArrayList<>();
	ArrayList<Card> invalidCards = new ArrayList<>();
	
	
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

	public boolean playCards (ArrayList<Card> cards,Table t) {
		getValidCards(t);
		if(validCards.size() == 0 || cards.size() == 0)
			passed = true;
		if(validCards.containsAll(cards)) {
			for(int i = 0; i < cards.size()-1; i++) {
				if(cards.get(i).equals(cards.get(i+1)))
					continue;
				else 
					return false;
			}
			t.addCards(cards);
			hand.removeAll(cards);
			if(t.getAmount() == 0)
				t.setAmount(cards.size());
			return true;
		}
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
		Collections.sort(hand);
		return hand;
	}
	
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
	
	public int getCardsRemaining() {
		cardsRemaining = hand.size();
		return cardsRemaining;
		
	}
	
	

}
