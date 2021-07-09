package com.grosserhund.blackjack.players;

import com.grosserhund.blackjack.elements.Betting;
import com.grosserhund.blackjack.elements.Rules;
import com.grosserhund.blackjack.elements.Shoe;
import com.grosserhund.cards.Card;

import java.math.BigDecimal;

public abstract class AbstractPlayer {
    protected final Betting betting;
    private int gamesPlayed = 0;
    private int handsPlayed = 0;
    private int handsWon = 0;
    private int handsLost = 0;
    private int handsPushed = 0;
    private int naturalBlackJackCount = 0;
    private int blackJackCount = 0;
    private int bustedCount = 0;
    protected final Rules rules;

    private BigDecimal currentBank;
    private final BigDecimal openingBank;

    public AbstractPlayer(Rules rules, BigDecimal openingBank) {
        this.rules = rules;
        this.openingBank = openingBank;
        this.currentBank = openingBank;
        this.betting = rules.getBetting();
    }

    public abstract void deal(Card card);

    public abstract boolean playHand(Shoe shoe);

    public BigDecimal getCurrentBank() {
        return currentBank;
    }


    public void setCurrentBank(BigDecimal currentBank) {
        this.currentBank = currentBank;
    }


    public void gamesPlayed() {
        gamesPlayed++;
    }

    public void handsPlayed() {
        handsPlayed++;
    }

    public void handWon(BlackjackHand playerHand) {
        playerHand.winHand();
        handsWon++;
    }


    public void handLost(BlackjackHand playerHand) {
        playerHand.loseHand();
        handsLost++;
    }


    public void handPushed(BlackjackHand playerHand) {
        playerHand.tieHand();
        handsPushed++;
    }


    public void naturalBlackjack() {
        naturalBlackJackCount++;
    }


    public void blackjack() {
        blackJackCount++;
    }

    public void playerBusted(BlackjackHand playerHand) {
        playerHand.loseHand();
        bustedCount++;
    }

    public void dealerBusted(BlackjackHand blackjackHand) {
        blackjackHand.loseHand();
        bustedCount++;
    }


    public String getStats() {
        return " gamesPlayed=" + gamesPlayed +
                ", handsPlayed=" + handsPlayed +
                ", handsWon=" + handsWon +
                ", handsLost=" + handsLost +
                ", handsPushed=" + handsPushed +
                ", naturalBlackJackCount=" + naturalBlackJackCount +
                ", blackJackCount=" + blackJackCount +
                ", bustedCount=" + bustedCount +
                ", currentBank=" + currentBank +
                ", openingBank=" + openingBank +
                '}';
    }

    @Override
    public String toString() {
        return "AbstractPlayer{" +
                "gamesPlayed=" + gamesPlayed +
                ", handsPlayed=" + handsPlayed +
                ", handsWon=" + handsWon +
                ", handsLost=" + handsLost +
                ", handsPushed=" + handsPushed +
                ", naturalBlackJackCount=" + naturalBlackJackCount +
                ", blackJackCount=" + blackJackCount +
                ", bustedCount=" + bustedCount +
                ", rules=" + rules +
                ", currentBank=" + currentBank +
                ", openingBank=" + openingBank +
                '}';
    }

    public abstract void clearHand();
}