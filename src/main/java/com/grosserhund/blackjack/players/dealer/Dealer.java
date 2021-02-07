package com.grosserhund.blackjack.players.dealer;

import com.grosserhund.blackjack.elements.Rules;
import com.grosserhund.blackjack.elements.Shoe;
import com.grosserhund.blackjack.players.AbstractPlayer;
import com.grosserhund.cards.Card;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

public class Dealer extends AbstractPlayer {
    private static final Logger LOGGER = LoggerFactory.getLogger(Dealer.class.getName());

    private final BlackjackDealerHand dealerHand = new BlackjackDealerHand();

    public Dealer(Rules rules, BigDecimal openingBank) {
        super(rules, openingBank);
    }


    @Override
    public void deal(Card card) {
        switch(dealerHand.getCardCount()) {
            case 0:
                gamesPlayed();
                card.setFaceDown(false);
            case 1:
                dealerHand.addCard(card);
                LOGGER.trace("Dealing {} to dealer", card);
                break;
            default:
                LOGGER.error("Dealer can't draw more than two cards");
        }
    }


    @Override
    public boolean playHand(Shoe shoe) {
        BlackJackDealerState state = dealerHand.getBlackjackState();
        LOGGER.debug("Beginning dealer blackjack state {}", state);

        while(dealerHand.getBlackjackState().continueDrawing()) {
            if (state == BlackJackDealerState.HIT) {
                dealerHand.addCard(shoe.draw(false));
            }

            state = dealerHand.getBlackjackState();

            LOGGER.trace("Current dealer blackjack state {}", state);
        }

        LOGGER.debug("Ending dealer blackjack state {}", state);
        return true;
    }

    public String printHand() {
        return dealerHand.toString();
    }

    public BlackjackDealerHand getHand() {
        return dealerHand;
    }

    public String getStats() {
        return "Dealer:" + super.getStats();
    }

    @Override
    public void clearHand() {
        dealerHand.clear();
    }


}
