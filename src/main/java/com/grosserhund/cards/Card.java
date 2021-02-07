package com.grosserhund.cards;

public class Card {

	private final int deck;
	private boolean faceDown = true;
	private final Rank rank;
	private final Suit suit;

	public Card(int deck, Suit suit, Rank rank) {
		this.deck = deck;
		this.suit = suit;
		this.rank = rank;
	}

	
	/**
	 * @return Whether the card is face down
	 */
	public boolean isFaceDown() {
		return faceDown;
	}


	/**
	 * @return Whether the card is face up
	 */
	public boolean isFaceUp() {
		return !faceDown;
	}


	/**
	 * @param faceDown the faceDown to set
	 */
	public Card setFaceDown(boolean faceDown) {
		this.faceDown = faceDown;
		return this;
	}


	/**
	 * @return the deck
	 */
	public int getDeck() {
		return deck;
	}


	/**
	 * @return the rank
	 */
	public Rank getRank() {
		return rank;
	}


	/**
	 * @return the suit
	 */
	public Suit getSuit() {
		return suit;
	}

	public String get() {
		return "Card [deck=" + deck + ", " + rank.getAbbrev() + " " + suit.getAbbrev() + "]"; 
	}

	@Override
	public String toString() {
		return "Card [deck=" + deck + ", faceDown=" + faceDown + ", rank=" + rank + ", suit=" + suit + "]";
	}
}
