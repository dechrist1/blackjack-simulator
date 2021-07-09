package com.grosserhund.blackjack.players.player;

import com.grosserhund.blackjack.players.BlackJackState;

public enum BlackJackPlayerState implements BlackJackState {
    NEW_HAND,
    BUSTED,
    BLACKJACK,
    NATURAL_BLACKJACK,
    FIVE_CARD_CHARLIE,
    SPLIT,
    DOUBLE_DOWN,
    STAND,
    STAND_DOUBLE_DOWN,
    STAND_ON_DEALER_BLACKJACK,
    HIT;

    @Override
    public boolean continueDrawing() {
        return !isStand();
    }

    @Override
    public boolean isStand() {
        switch (this) {
            case STAND:
            case STAND_DOUBLE_DOWN:
            case BUSTED:
            case NATURAL_BLACKJACK:
            case BLACKJACK:
            case FIVE_CARD_CHARLIE:
            case STAND_ON_DEALER_BLACKJACK:
                return true;
        }

        return false;
    }
}
