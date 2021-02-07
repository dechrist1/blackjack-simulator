package com.grosserhund.blackjack;

import com.grosserhund.blackjack.elements.Table;
import com.grosserhund.blackjack.players.dealer.BlackJackDealerState;
import com.grosserhund.blackjack.players.dealer.BlackjackDealerHand;
import com.grosserhund.blackjack.players.dealer.Dealer;
import com.grosserhund.blackjack.players.player.BlackJackPlayerState;
import com.grosserhund.blackjack.players.player.BlackjackPlayerHand;
import com.grosserhund.blackjack.players.player.Player;
import com.grosserhund.cards.Card;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Game {
    private static final Logger LOGGER = LoggerFactory.getLogger(Game.class.getName());
    private final Table table;
    private final Dealer dealer;
    private int gameNumber = 0;

    public Game(Table table) {
        this.table = table;
        LOGGER.debug("Game Object created");

        this.dealer = table.getDealer();
    }

    public boolean playGame() {
        if(table.getRules().isAllowedBetting()) {
            int playersThatCanPlay = 0;
            for(Player player: table.getPlayers()) {
                if(player.canPlay()) {
                    playersThatCanPlay++;
                }
            }

            if(playersThatCanPlay == 0) {
                return false;
            }
        }

        gameNumber++;

        LOGGER.debug("Starting game {}", gameNumber);
        table.getShoe().shuffle();
        clearHand();
        deal();
        if(!checkDealerForBlackjack()) {
            if(playPlayers() == 0) {
                return false;
            }
            playDealer();
        }
        calculateWinners();
        return true;
    }

    private boolean checkDealerForBlackjack() {
        if(dealer.getHand().isHandBlackJack()) {
            for(Player player: table.getPlayers()) {
                for(BlackjackPlayerHand playerHand: player.getHands()) {
                    if(!playerHand.isHandBlackJack()) {
                        playerHand.standOnDealerBlackjack();
                    }
                }
            }
            return true;
        }
        return false;
    }

    private int playPlayers() {
        int playerGamesPlayed = 0;

        for(Player player: table.getPlayers()) {
            if(player.playHand(table.getShoe()))
                playerGamesPlayed++ ;
        }

        return playerGamesPlayed;
    }

    private void playDealer() {
        dealer.playHand(table.getShoe());
    }

    private void calculateWinners() {
        BlackjackDealerHand dealerHand = dealer.getHand();

        for(Player player: table.getPlayers()) {
            for(BlackjackPlayerHand playerHand: player.getHands()) {
                player.handsPlayed();
                dealer.handsPlayed();
                if(playerHand.getBlackJackState() == BlackJackPlayerState.STAND_ON_DEALER_BLACKJACK) {
                    if(playerHand.getBlackJackState() == BlackJackPlayerState.NATURAL_BLACKJACK) {
                        dealer.handPushed(dealerHand);
                        player.handPushed(dealer, playerHand);
                    } else {
                        dealer.handWon(dealerHand);
                        player.handLost(dealer, playerHand);
                    }
                    continue;
                }

                if(playerHand.getBlackJackState() == BlackJackPlayerState.BUSTED &&
                        dealerHand.getBlackjackState() == BlackJackDealerState.BUSTED) {
                    player.playerBusted(playerHand);
                    dealer.dealerBusted(dealerHand);
                    dealer.handLost(dealerHand);
                    player.handLost(dealer, playerHand);
                    continue;
                }

                if (playerHand.getBlackJackState() == BlackJackPlayerState.BUSTED ) {
                    player.playerBusted(playerHand);
                    player.handLost(dealer, playerHand);
                    dealer.handWon(dealerHand);
                    continue;
                }

                if (dealerHand.getBlackjackState() == BlackJackDealerState.BUSTED) {
                    dealer.dealerBusted(dealerHand);
                    player.handWon(dealer, playerHand);
                    dealer.handLost(dealerHand);
                    continue;
                }

                if(playerHand.getBlackJackState() == BlackJackPlayerState.NATURAL_BLACKJACK &&
                        dealerHand.getBlackjackState() == BlackJackDealerState.NATURAL_BLACKJACK) {
                    player.naturalBlackjack();
                    dealer.naturalBlackjack();
                    player.handPushed(dealer, playerHand);
                    dealer.handPushed(dealerHand);
                    continue;
                }

                if(playerHand.getBlackJackState() == BlackJackPlayerState.NATURAL_BLACKJACK) {
                    player.naturalBlackjack(dealer, playerHand);
                    player.handWon(dealer, playerHand);
                    dealer.handLost(dealerHand);
                    continue;
                }

                if(dealerHand.getBlackjackState() == BlackJackDealerState.NATURAL_BLACKJACK) {
                    dealer.naturalBlackjack();
                    dealer.handWon(dealerHand);
                    player.handLost(dealer, playerHand);
                    continue;
                }

                if(playerHand.getBlackJackState() == BlackJackPlayerState.FIVE_CARD_CHARLIE) {
                    player.fiveCardCharlie();
                    player.handWon(dealer, playerHand);
                    dealer.handLost(dealerHand);
                    continue;
                }

                if(playerHand.getTotal() > dealerHand.getTotal()) {
                    player.handWon(dealer, playerHand);
                    dealer.handLost(dealerHand);
                } else if(playerHand.getTotal() < dealerHand.getTotal()) {
                    player.handLost(dealer, playerHand);
                    dealer.handWon(dealerHand);
                } else {
                    player.handPushed(dealer, playerHand);
                    dealer.handPushed(dealerHand);
                }
            }

            LOGGER.debug(player.printHands());
        }
        LOGGER.debug((dealer.printHand()));
    }

    private void clearHand() {
        for (Player player : table.getPlayers()) {
            player.clearHand();
        }

       table.getDealer().clearHand();
    }


    private void deal() {
        for (int i = 0; i < 2; i++) {
            Card dealerCard = table.getShoe().draw(i != 0);
            table.getDealer().deal(dealerCard);

            for (Player player : table.getPlayers()) {
                if(player.canPlay()) {
                    if (i == 0) {
                        player.setDealerUpCard(dealerCard);
                    }
                    player.deal(table.getShoe().draw(false));
                }
            }
        }
    }
}
