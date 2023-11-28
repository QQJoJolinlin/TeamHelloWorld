package team;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * This is a main class for testing the other classes in the console
 */
public class ConsoleMain {

	public static void main(String[] args) {
		String[] names = {"bob", "mike", "carl"};
		Game testGame = new Game(names);
		
		testGame.getPlayers().forEach(x -> System.out.println(x));
		
		System.out.println();
		
		testGame.getDeck().forEach(x -> System.out.println(x));
		
		System.out.println();
		
		testGame.startRound();
		
		testGame.getPlayers().forEach(x -> {
			System.out.println(x.name + " hand");
			System.out.println(x.getHand());
			});
		
		System.out.println();
		
		
		Player testPlayer = testGame.getPlayers().get(2);
		
		ArrayList<Card> testCards = new ArrayList<>();
		testCards.add(new Card(Suit.Clubs, "3", 1));
		testCards.add(new Card(Suit.Clubs, "3", 1));
		
		testGame.getTable().addCards(testCards);
		
		System.out.println(testPlayer.getValidCards(testGame.getTable()));
		
		
	

	}

}
