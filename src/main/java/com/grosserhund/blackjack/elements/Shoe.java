package com.grosserhund.blackjack.elements;

import com.grosserhund.cards.Card;
import com.grosserhund.cards.Deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Shoe {
	private final List<Card> cards = new ArrayList<>();
	private int drawNumber = 0;
	private final int cutLevel; 
	private final int cardCount;
	
	public Shoe(int decks, int cutLevel) {
		Deck deck = new Deck();
		
		for(int i = 1; i <= decks; i++) {
			cards.addAll(Deck.createDeck(i));
		}
		
		this.cardCount = cards.size();
		
		shuffle();
		if(cutLevel == 0) {
			this.cutLevel = 0;			
		} else {
			this.cutLevel = cards.size() - cutLevel;
		}
	}

	public Card draw(boolean faceDown) {
		if(cutLevel == 0 || drawNumber <= cardCount)
			return cards.get(drawNumber++).setFaceDown(faceDown);
		else
		    return null;
	}

	public int getCardCount() {
		return cards.size();
	}

	public boolean shuffle() {
		if(cutLevel == 0 || drawNumber >= cutLevel) {
			Collections.shuffle(cards, new Random());
			drawNumber = 0;
			return true;
		}

		return false;
	}

	@Override
	public String toString() {
		return "Shoe [cardCount=" + cardCount +
				", drawNumber=" + drawNumber +
				", cutLevel=" + cutLevel +
				", cards=" + cards + "]";
	}
	
	

}
