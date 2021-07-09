package com.grosserhund.blackjack.players;


import com.grosserhund.blackjack.players.dealer.BlackJackDealerState;
import com.grosserhund.cards.Card;
import com.grosserhund.cards.Hand;
import com.grosserhund.cards.Rank;

public abstract class BlackjackHand extends Hand {
    private enum HandResult {WIN, LOSE, TIE}

    protected HandResult handResult;

    protected BlackJackState blackJackState;
    protected int total = 0;
    protected boolean softHand = false;
    private int aceCount;


//	public abstract boolean isFiveCardCharlie();

    public BlackjackHand() {

    }

//	public abstract void hit(boolean faceDown);


//	public void getHand() {
//		total = getTotal();
//	}

    private int getHardTotal() {
        int hardTotal = 0;
        aceCount = 0;

        for (Card card : cards) {
            if (card.getRank() == Rank.ACE) {
                aceCount++;
            }

            hardTotal += card.getRank().getValue();
        }

        return hardTotal;
    }


    public int getSoftTotal() {
        int softTotal = 0;
        for (int i = 0; i < aceCount; i++) {
            softTotal = 0;

            for (Card card : cards) {
                if (card.getRank() == Rank.ACE) {
                    if (softTotal + Rank.ACE.getValue() > 21) {
                        softTotal += 1;
                    } else {
                        softTotal += Rank.ACE.getValue();
                    }
                } else {
                    softTotal += card.getRank().getValue();
                }
            }

            if (softTotal < 21) {
                softHand = true;
                break;
            }
        }
        if (softTotal > 30) {
            System.out.println("Oops! - " + softTotal);
        }

        return softTotal;
    }


    public int getTotal() {
        total = getHardTotal();

        if (aceCount > 0 && total > 21) {
            total = getSoftTotal();
        }

        return total;
    }

    public void winHand() {
        handResult = HandResult.WIN;
    }

    public void loseHand() {
        handResult = HandResult.LOSE;
    }

    public void tieHand() {
        handResult = HandResult.TIE;
    }

    public boolean isHandBlackJack() {
        return getTotal() == 21 && getCardCount() == 2;
    }

    public abstract void addCard(Card card);

    public abstract BlackJackDealerState getBlackjackState();


}
