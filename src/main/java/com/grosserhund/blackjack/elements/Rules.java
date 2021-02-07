package com.grosserhund.blackjack.elements;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

public class Rules {
     private static final Logger LOGGER = LoggerFactory.getLogger(Rules.class.getName());

    private final Betting betting = new Betting(this);
    private int maximumPlayers = 1;
    private int totalDecks = 1;
    private int dealerStandValue = 17;
    private int dealerStandSoftValue = 17;
    private int cutIndex = maximumPlayers  * 5 + 5; // players * cards five-card charlie ;
    private boolean allowPlayerSplit = true;
    private boolean allowDoubleDown = true;
    private boolean doubleDownOnSplit = true;

    private boolean allowBetting = false;
    private BigDecimal minimumBet = new BigDecimal(10);
    private BigDecimal dealerStartingBank = new BigDecimal(10000);
    private BigDecimal blackjackPays = new BigDecimal("1.5"); // Blackjack usually pays 3:2

    public int getMaximumPlayers() {
        return maximumPlayers;
    }

    public void setMaximumPlayers(int maximumPlayers) {
        if(maximumPlayers < 1 || maximumPlayers > 7) {
            LOGGER.warn("The maximum number of players ({}) must be between 1 and 7", maximumPlayers);
        } else {
            this.maximumPlayers = maximumPlayers;
        }
    }

    public int getTotalDecks() {
        return totalDecks;
    }

    public void setTotalDecks(int totalDecks) {
        if(totalDecks < 1 || totalDecks > 8) {
            LOGGER.warn("The number of decks ({}) must be between 1 and 8", totalDecks);
        } else {
            this.totalDecks = totalDecks;
        }
    }

    public int getDealerStandValue() {
        return dealerStandValue;
    }

    public void setDealerStandValue(int dealerStandValue) {
        if(dealerStandValue < 1 || dealerStandValue > 21) {
            LOGGER.warn("The Sealer's stand value ({}) must be between 1 and 8", dealerStandValue);
        } else {
            this.dealerStandValue = dealerStandValue;
        }
    }

    public int getDealerStandSoftValue() {
        return dealerStandSoftValue;
    }

    public void setDealerStandSoftValue(int dealerStandSoftValue) {
        if(dealerStandSoftValue < 1 || dealerStandSoftValue > 21) {
            LOGGER.warn("The Dealer's stand softvalue ({}) must be between 1 and 8", dealerStandSoftValue);
        } else {
            this.dealerStandSoftValue = dealerStandSoftValue;
        }
    }

    public int getCutIndex() {
        return cutIndex;
    }

    public void setCutIndex(int cutIndex) {
        this.cutIndex = cutIndex;
    }

    public boolean isAllowPlayerSplit() {
        return allowPlayerSplit;
    }

    public void setAllowPlayerSplit(boolean allowPlayerSplit) {
        this.allowPlayerSplit = allowPlayerSplit;
    }

    public boolean isAllowDoubleDown() {
        return allowDoubleDown;
    }

    public void setAllowDoubleDown(boolean allowDoubleDown) {
        this.allowDoubleDown = allowDoubleDown;
    }

    public boolean isDoubleDownOnSplit() {
        return doubleDownOnSplit;
    }

    public void setDoubleDownOnSplit(boolean doubleDownOnSplit) {
        this.doubleDownOnSplit = doubleDownOnSplit;
    }

    public BigDecimal getMinimumBet() {
        return minimumBet;
    }

    public void setMinimumBet(BigDecimal minimumBet) {
        if(minimumBet.compareTo(BigDecimal.ZERO) <= 0) {
            LOGGER.warn("The minimum bet ({}) must be greater than 0 - betting turned off", minimumBet);
            allowBetting = false;
        } else {
            this.minimumBet = minimumBet;
        }
    }

    public BigDecimal getDealerStartingBank() {
        return dealerStartingBank;
    }

    public void setDealerStartingBank(BigDecimal dealerStartingBank) {
        this.dealerStartingBank = dealerStartingBank;
    }

    public boolean isAllowedBetting() {
        return allowBetting;
    }

    public boolean isNotAllowedBetting() {
        return !allowBetting;
    }

    public void setAllowBetting(boolean allowBetting) {
        this.allowBetting = allowBetting;
    }


    public BigDecimal getBlackjackPays() {
        return blackjackPays;
    }

    public void setBlackjackPays(BigDecimal blackjackPays) {
        this.blackjackPays = blackjackPays;
    }

    public Betting getBetting() {
        return betting;
    }
}

