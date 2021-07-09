package com.grosserhund.blackjack.elements;

import com.grosserhund.blackjack.players.dealer.Dealer;
import com.grosserhund.blackjack.players.player.BlackjackPlayerHand;
import com.grosserhund.blackjack.players.player.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

public class Betting {
    private static final Logger LOGGER = LoggerFactory.getLogger(Betting.class.getName());
    private final Rules rules;

    public Betting(Rules rules) {
        this.rules = rules;
    }

    public boolean playerCanPlay(Player player) {
        if (rules.isNotAllowedBetting())
            return true;

        BigDecimal playerTotal = player.getCurrentBank();
        for (BlackjackPlayerHand blackJackPlayerHand : player.getHands()) {
            playerTotal = playerTotal.add(blackJackPlayerHand.getCurrentBet());
        }
        return playerTotal.compareTo(rules.getMinimumBet()) >= 0;
    }


    public boolean placeInitialBet(Player player, BlackjackPlayerHand blackjackPlayerHand) {
        if (rules.isNotAllowedBetting()) {
            LOGGER.trace("No initial betting needed - Playing for fun");
            return true;
        }

        if (playerCanBet(player, rules.getMinimumBet())) {
            player.setCurrentBank(player.getCurrentBank().subtract(rules.getMinimumBet()));
            blackjackPlayerHand.setCurrentBet(rules.getMinimumBet());
            LOGGER.debug("Balances after Initial bet for {}, bet=${} Bank=${}, Bet=${}", player.getName(), rules.getMinimumBet(), player.getCurrentBank(), blackjackPlayerHand.getCurrentBet());
            return true;
        } else {
            LOGGER.debug("Unable to place a bet for for {} ${}", player.getName(), rules.getMinimumBet());
            return false;
        }
    }

    public boolean doubleDown(Player player, BlackjackPlayerHand blackjackPlayerHand) {
        if (rules.isNotAllowedBetting()) {
            LOGGER.trace("No double down betting needed - Playing for fun");
            return true;
        }

        BigDecimal currentBet = blackjackPlayerHand.getCurrentBet();
        if (playerCanBet(player, currentBet)) {
            player.setCurrentBank(player.getCurrentBank().subtract(currentBet));
            blackjackPlayerHand.setCurrentBet(blackjackPlayerHand.getCurrentBet().add(currentBet));
            LOGGER.debug("Balances after Double Down for {} Bank= ${}, bet= ${}, ", player.getName(), player.getCurrentBank(), blackjackPlayerHand.getCurrentBet());
            return true;
        }

        return false;

    }

    public boolean playerCanBet(Player player, BigDecimal betAmount) {
        int rc = player.getCurrentBank().compareTo(betAmount);

        LOGGER.debug("Player {} {} bet with a bank of ${} and a bet amount of {}", player.getName(),
                rc > 0 ? "can" : "can not", player.getCurrentBank(), betAmount);
        return rc >= 0;

    }

    public boolean playerCanPlayOrBet(Player player) {
        return (rules.isNotAllowedBetting() ||
                player.getCurrentBank().compareTo(rules.getMinimumBet()) > 0);
    }

    public void split(Player player, BlackjackPlayerHand existingPlayerHand, BlackjackPlayerHand newPlayerHand) {
        if (rules.isNotAllowedBetting()) {
            LOGGER.trace("No split betting needed - Playing for fun");
            return;
        }

        BigDecimal existingBet = existingPlayerHand.getCurrentBet();

        if (playerCanBet(player, existingBet)) {
            newPlayerHand.setCurrentBet(existingBet);
            player.setCurrentBank(player.getCurrentBank().subtract(existingBet));

            LOGGER.debug("Balances after Split for {} bank= ${}, Existing hand bet=${}, New hand bank=${}",
                    player.getName(), player.getCurrentBank(), existingPlayerHand.getCurrentBet(), newPlayerHand.getCurrentBet());
        } else {
            LOGGER.error("Split issue - {} bank = {}", player.getName(), player.getCurrentBank());
        }
    }

    public void naturalBlackJack(Player player, Dealer dealer, BlackjackPlayerHand blackjackPlayerHand) {
        BigDecimal playerBank = player.getCurrentBank();
        BigDecimal currentBet = blackjackPlayerHand.getCurrentBet();
        BigDecimal dealerBank = dealer.getCurrentBank();
        BigDecimal winningAmount = currentBet.multiply(rules.getBlackjackPays());

        LOGGER.debug("Player Bank before = ${}", playerBank);
        playerBank = playerBank.add(currentBet);         // add original bet back
        playerBank = playerBank.add(winningAmount);      // add blackjack payout
        dealerBank = dealerBank.subtract(winningAmount); // dealer lost

        dealer.setCurrentBank(dealerBank);
        player.setCurrentBank(playerBank);
        blackjackPlayerHand.setCurrentBet(BigDecimal.ZERO);

        LOGGER.debug("Player Bank after = ${}", playerBank);
    }

    public void winHand(Player player, Dealer dealer, BlackjackPlayerHand blackjackPlayerHand) {
        BigDecimal playerBank = player.getCurrentBank();
        BigDecimal currentBet = blackjackPlayerHand.getCurrentBet();
        BigDecimal dealerBank = dealer.getCurrentBank();

        LOGGER.debug("Player Bank before = ${}", playerBank);
        playerBank = playerBank.add(currentBet);         // add original bet back
        playerBank = playerBank.add(currentBet);      // add winning payout
        dealerBank = dealerBank.subtract(currentBet); // dealer lost

        dealer.setCurrentBank(dealerBank);
        player.setCurrentBank(playerBank);
        blackjackPlayerHand.setCurrentBet(BigDecimal.ZERO);

        LOGGER.debug("Player Bank after = ${}", playerBank);
    }


    public void loseHand(Player player, Dealer dealer, BlackjackPlayerHand blackjackPlayerHand) {
        BigDecimal currentBet = blackjackPlayerHand.getCurrentBet();
        BigDecimal dealerBank = dealer.getCurrentBank();

        LOGGER.debug("Dealer Bank before = ${}", dealerBank);
        dealerBank = dealerBank.add(currentBet);      // add to dealer's earnings

        dealer.setCurrentBank(dealerBank);
        blackjackPlayerHand.setCurrentBet(BigDecimal.ZERO);

        LOGGER.debug("Dealer Bank after = ${}", dealerBank);
    }


    public void pushHand(Player player, Dealer dealer, BlackjackPlayerHand blackjackPlayerHand) {
        BigDecimal currentBet = blackjackPlayerHand.getCurrentBet();
        BigDecimal playerBank = player.getCurrentBank();

        LOGGER.debug("Player Bank before = ${}", playerBank);
        playerBank = playerBank.add(currentBet);      // add to dealer's earnings

        player.setCurrentBank(playerBank);
        blackjackPlayerHand.setCurrentBet(BigDecimal.ZERO);

        LOGGER.debug("Player Bank after = ${}", playerBank);
    }

}
