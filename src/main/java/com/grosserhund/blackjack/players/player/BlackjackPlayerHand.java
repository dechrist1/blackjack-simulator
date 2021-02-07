package com.grosserhund.blackjack.players.player;

import com.grosserhund.blackjack.players.BlackjackHand;
import com.grosserhund.blackjack.players.dealer.BlackJackDealerState;
import com.grosserhund.blackjack.players.strategies.DefaultHardStrategy;
import com.grosserhund.blackjack.players.strategies.DefaultSoftStrategy;
import com.grosserhund.cards.Card;

import java.math.BigDecimal;

public class BlackjackPlayerHand extends BlackjackHand {
	private final DefaultHardStrategy hardStrategy;
	private final DefaultSoftStrategy softStrategy;

	private Card dealerUpCard;
	private boolean allowPlayerSplit;
	private boolean doubleDownAllowed;
	private boolean doubledDown = false;
	private BigDecimal currentBet = BigDecimal.ZERO;

	public BlackjackPlayerHand(DefaultHardStrategy hardStrategy, DefaultSoftStrategy softStrategy, boolean doubleDownAllowed) {
		this.hardStrategy = hardStrategy;
		this.softStrategy = softStrategy;
		this.doubleDownAllowed = doubleDownAllowed;
		this.blackJackState = BlackJackPlayerState.NEW_HAND;
	}

	public boolean isFiveCardCharlie() {
		return cards.size() == 5 && total <  21;
	}


	@Override
	public void addCard(Card card) {
		cards.add(card);
	}

	@Override
	public BlackJackDealerState getBlackjackState() {
		return null;
	}

	public void split(BlackjackPlayerHand existingHand) {
		addCard(existingHand.cards.remove(1));
		this.allowPlayerSplit = false;
	}

	public boolean isFirstTwoCardsTheSame() {
		return cards.get(0).getRank() == cards.get(1).getRank();
	}

	public void setDoubleDownAllowed(boolean doubleDownAllowed) {
		this.doubleDownAllowed = doubleDownAllowed;
	}

	public boolean isDoubleDownNotAllowed() {
		return !doubleDownAllowed;
	}


	public BlackJackPlayerState getBlackJackState() {
		if(blackJackState.isStand()) {
			return (BlackJackPlayerState) blackJackState;
		}


		total = getTotal();

		if(total == 21) {
			blackJackState =  cards.size() == 2 ? BlackJackPlayerState.NATURAL_BLACKJACK: BlackJackPlayerState.BLACKJACK;
		} else if(total > 21) {
			blackJackState = BlackJackPlayerState.BUSTED;
		} else if (doubledDown) {
			blackJackState = BlackJackPlayerState.STAND_DOUBLE_DOWN;
		} else if (cards.size() == 5) {
			blackJackState = BlackJackPlayerState.FIVE_CARD_CHARLIE;
		} else {
			blackJackState = hardStrategy.getBlackJackState(dealerUpCard, this);
			if (blackJackState == null) {
//				blackJackState = blackJackState;
//			} else {
				blackJackState = softStrategy.getBlackJackState(dealerUpCard, this);
			}
		}
		return (BlackJackPlayerState) blackJackState;
	}


	public void setDealerUpCard(Card dealerUpCard) {
		this.dealerUpCard = dealerUpCard;
	}

	public Card getDealerUpCard() {
		return dealerUpCard;
	}


	public int getFirstCardValue() {
		return cards.get(0).getRank().getValue();
	}


	public void doubledDown(boolean doubledDown) {
		this.doubledDown = doubledDown;
	}

	public BigDecimal getCurrentBet() {
		return currentBet;
	}

	public void setCurrentBet(BigDecimal currentBet) {
		this.currentBet = currentBet;
	}

	@Override
	public String toString() {
		return "\n   BlackjackPlayerHand [" +
				" handResult=" + handResult +
				", blackJackState=" + blackJackState +
				", total=" + getTotal() +
				", card count=" + cards.size() +
				", allowSplit=" + allowPlayerSplit +
				", doubledDown=" + doubledDown +
				", doubleDownAllowed=" + doubleDownAllowed +
				", cards=" + cards + ", dealerUpCard=" + dealerUpCard + "]";
	}

	public void standOnDealerBlackjack() {
		blackJackState = BlackJackPlayerState.STAND_ON_DEALER_BLACKJACK;
	}


}
