package com.grosserhund.blackjack.players.dealer;

import com.grosserhund.blackjack.players.BlackjackHand;
import com.grosserhund.cards.Card;

public class BlackjackDealerHand extends BlackjackHand {
    private int softStandValue;
    private int highCount = 17;

    public BlackjackDealerHand() {
        this.blackJackState = BlackJackDealerState.NEW_HAND;
    }


    public void clear() {
        cards.clear();
    }

    @Override
    public void addCard(Card card) {
        cards.add(card);
    }


    public BlackJackDealerState getBlackjackState() {
        total = getTotal();

        if (total > 21) {
            blackJackState = BlackJackDealerState.BUSTED;
        } else if (total == 21) {
            blackJackState = cards.size() == 2 ? BlackJackDealerState.NATURAL_BLACKJACK : BlackJackDealerState.BLACKJACK;
        } else if (softStandValue > 0 && total < softStandValue) {
            blackJackState = BlackJackDealerState.HIT;
        } else if (total >= highCount) {
            blackJackState = softHand ? BlackJackDealerState.STAND_SOFT : BlackJackDealerState.STAND_HARD;
        } else {
            blackJackState = BlackJackDealerState.HIT;
        }

        return (BlackJackDealerState) blackJackState;
    }


//	@Override
//	public String get() {
//
//		//return (blackJackState + " (cards=" + cards.size() + ", total=" + total + "): " + cards);
//		return (blackJackState + " (cards=" + cards.size() + ", total=" + total + "): " + cards);
//	}

    public Card getUpCard() {
        for (Card card : cards) {
            if (!card.isFaceDown()) {
                return card;
            }
        }
        return null;
    }

    public void setHighCount(int highCount) {
        this.highCount = highCount;
    }


    @Override
    public String toString() {
        return "BlackjackDealerHand [" +
//				" handResult=" + handResult +
                "blackJackState=" + blackJackState +
                ", total=" + getTotal() +
                ", card count=" + cards.size() +
                ", cards=" + cards + "]";
    }
}
