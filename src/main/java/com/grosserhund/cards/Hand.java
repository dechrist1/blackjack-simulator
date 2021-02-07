package com.grosserhund.cards;

import java.util.ArrayList;
import java.util.List;

public class Hand {
	protected final List<Card> cards = new ArrayList<>();
	
	public Hand() {
	}
	
	public void draw(Card card) {
		cards.add(card);
	}
	
	
	public int getCardCount() {
		return cards.size();
	}
	
	public String get() {
		StringBuilder sb = new StringBuilder("Hand [cards=");
		
		String comma = "";
		for(Card card: cards) {
			sb.append(comma).append(card.get());
			comma = ", ";
		}
		sb.append("]");
		
		return sb.toString();
	}
	
	@Override
	public String toString() {
		return "Hand [cards=" + cards + "]";
	}
	
}
