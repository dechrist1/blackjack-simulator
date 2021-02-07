package com.grosserhund.blackjack.players.dealer;

import com.grosserhund.blackjack.players.BlackJackState;

public enum BlackJackDealerState implements BlackJackState {
	NEW_HAND,	
	BUSTED,
	BLACKJACK,
	NATURAL_BLACKJACK,
	STAND,
	STAND_HARD,
	STAND_SOFT,
	HIT;

	@Override
	public boolean continueDrawing() {
		return !isStand();
	}
	
	public boolean isStand() {
		switch(this) {
			case STAND:
			case BUSTED:
			case STAND_HARD:
			case STAND_SOFT:
			case BLACKJACK:
			case NATURAL_BLACKJACK:
				return true;
			default:
				return false;
		}
	}
}
