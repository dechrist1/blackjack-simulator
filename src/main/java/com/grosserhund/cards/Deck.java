package com.grosserhund.cards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class Deck {
	private final List<Card> cards;
	int index;

	public Deck() {
		cards = createDeck(0);
		index = 0;
	}

	public static List<Card> createDeck(int deckNumber) {
		List<Card> cards = new ArrayList<>();

		Arrays.asList(Suit.values()).forEach(suit ->
				Arrays.asList(Rank.values()).forEach(rank ->
						cards.add(new Card(deckNumber, suit, rank))
				)
		);

		return cards;
	}

    public void shuffle() {
		Collections.shuffle(cards, new Random());
		index = 0;
	}

	public Card draw(boolean faceDown) {
		if(index < cards.size()) {
			Card card = cards.get(index++);
			card.setFaceDown(faceDown);
			return card;
		} else {
			return null;
		}
	}
}