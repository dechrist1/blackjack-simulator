package com.grosserhund.blackjack.players.player;

import com.grosserhund.blackjack.elements.Rules;
import com.grosserhund.blackjack.elements.Shoe;
import com.grosserhund.blackjack.players.AbstractPlayer;
import com.grosserhund.blackjack.players.BlackJackState;
import com.grosserhund.blackjack.players.dealer.Dealer;
import com.grosserhund.blackjack.players.strategies.DefaultHardStrategy;
import com.grosserhund.blackjack.players.strategies.DefaultSoftStrategy;
import com.grosserhund.blackjack.players.strategies.DefaultSplitStrategy;
import com.grosserhund.cards.Card;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Player extends AbstractPlayer {
    private static final Logger LOGGER = LoggerFactory.getLogger(Player.class.getName());

    private final DefaultSplitStrategy splitStrategy = DefaultSplitStrategy.getStrategy();
    private final DefaultHardStrategy hardStrategy = DefaultHardStrategy.getStrategy();
    private final DefaultSoftStrategy softStrategy = DefaultSoftStrategy.getStrategy();
    private final List<BlackjackPlayerHand> hands = new ArrayList<>();
    private final String name;

    private Card dealerUpCard;
    private int fiveCardCharlie = 0;
    private int splitHands = 0;

    public Player(String name, Rules rules, BigDecimal openingBank) {
        super(rules, openingBank);
        this.name = name;
    }

    public boolean canPlay() {
        return betting.playerCanPlay(this);
    }

    public void setDealerUpCard(Card dealerUpCard) {
        this.dealerUpCard = dealerUpCard;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public void deal(Card card) {
        BlackjackPlayerHand hand;

        if (hands.size() == 0) {
            gamesPlayed();
            BlackjackPlayerHand blackjackPlayerHand =
                    new BlackjackPlayerHand(hardStrategy, softStrategy, rules.isAllowDoubleDown());
            betting.placeInitialBet(this, blackjackPlayerHand);
            hands.add(blackjackPlayerHand);
        }

        hand = hands.get(0);

        if (hand.getCardCount() < 2) {
            hand.addCard(card);
            LOGGER.trace("Dealing {} to {}", card, name);
        }
    }

    @Override
    public boolean playHand(Shoe shoe) {
        if (!betting.playerCanPlay(this)) {
            return false;
        }

        BlackjackPlayerHand blackjackPlayerHand = hands.get(0);

        blackjackPlayerHand.setDealerUpCard(dealerUpCard);

        BlackJackState blackJackState = splitStrategy.getBlackJackState(dealerUpCard, blackjackPlayerHand);

        if (blackJackState.equals(BlackJackPlayerState.STAND_ON_DEALER_BLACKJACK)) {
            LOGGER.trace("Dealer stands on blackjack for {}: {}", name, blackjackPlayerHand);
            return true;
        }

        //Check for a possible split
        if (rules.isAllowPlayerSplit()) {
            if (blackjackPlayerHand.isFirstTwoCardsTheSame()) {
                if (blackJackState == BlackJackPlayerState.SPLIT) {
                    BlackjackPlayerHand hand = split(shoe, blackjackPlayerHand);
                    if (hand != null) {
                        splitHands();
                        hands.add(hand);
                        LOGGER.trace("Hands now split: {}", hands);
                    }
                }
            }
        }

        for (BlackjackPlayerHand hand : hands) {
            BlackJackPlayerState state;// = (BlackJackPlayerState) hand.getBlackJackState();
            LOGGER.debug("Beginning Blackjack state for {}: {}", name, hand);

            while (!(state = hand.getBlackJackState()).isStand()) {
                LOGGER.trace("Current Blackjack state for {}: {}", name, hand);

                switch (state) {
                    case DOUBLE_DOWN:
                        doubleDown(hand);
                    case HIT:
                        hand.addCard(shoe.draw(false));
                        break;
                }
            }
            LOGGER.debug("Ending Blackjack state for {}: {}", name, hand);
        }
        return true;
    }


    private BlackjackPlayerHand split(Shoe shoe, BlackjackPlayerHand existingPlayerHand) {
        BlackjackPlayerHand newPlayerHand = null;

        if (betting.playerCanPlayOrBet(this)) {
            newPlayerHand = new BlackjackPlayerHand(hardStrategy, softStrategy, rules.isDoubleDownOnSplit());

            newPlayerHand.split(existingPlayerHand);
            newPlayerHand.setDealerUpCard(existingPlayerHand.getDealerUpCard());

            existingPlayerHand.addCard(shoe.draw(false));
            newPlayerHand.addCard(shoe.draw(false));

            betting.split(this, existingPlayerHand, newPlayerHand);
        }
        return newPlayerHand;
    }

    public void doubleDown(BlackjackPlayerHand blackjackPlayerHand) {
        blackjackPlayerHand.setDoubleDownAllowed(false);
        blackjackPlayerHand.doubledDown(true);
        betting.doubleDown(this, blackjackPlayerHand);
    }

    public String printHands() {
        return name + " (count=" + hands.size() + "): " + hands.toString();
    }

    public List<BlackjackPlayerHand> getHands() {
        return hands;
    }


    public void fiveCardCharlie() {
        fiveCardCharlie++;
    }

    public void splitHands() {
        splitHands++;
    }

    public String getStats() {
        return name + ":" + super.getStats() +
                ", fiveCardCharlie=" + fiveCardCharlie +
                ", splitHands=" + splitHands;
    }

    @Override
    public void clearHand() {
        hands.clear();
    }

    public void naturalBlackjack(Dealer dealer, BlackjackPlayerHand blackjackPlayerHand) {
        naturalBlackjack();
        betting.naturalBlackJack(this, dealer, blackjackPlayerHand);
    }

    public void handWon(Dealer dealer, BlackjackPlayerHand blackjackPlayerHand) {
        handWon(blackjackPlayerHand);
        betting.winHand(this, dealer, blackjackPlayerHand);
    }

    public void handLost(Dealer dealer, BlackjackPlayerHand blackjackPlayerHand) {
        handLost(blackjackPlayerHand);
        betting.loseHand(this, dealer, blackjackPlayerHand);
    }

    public void handPushed(Dealer dealer, BlackjackPlayerHand blackjackPlayerHand) {
        handPushed(blackjackPlayerHand);
        betting.pushHand(this, dealer, blackjackPlayerHand);
    }
}
