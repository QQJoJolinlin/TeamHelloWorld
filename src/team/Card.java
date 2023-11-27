package team;


public class Card implements Comparable<Card>{
	
	private String name;
	private Suit suit;
	private int value;
	
	/**
	 * @param name
	 * @param suit
	 * @param value
	 */
	public Card(Suit suit, String name, int value) {
		this.name = name;
		this.suit = suit;
		this.value = value;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the suit
	 */
	public Suit getSuit() {
		return suit;
	}

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}


	@Override
	public String toString() {
		return "Card [name=" + name + ", suit=" + suit + ", value=" + value + "]";
	}

	@Override
	public int compareTo(Card o) {
		return this.getValue() - o.getValue();
	}
	
	
	

}