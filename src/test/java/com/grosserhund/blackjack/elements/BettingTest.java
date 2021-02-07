package com.grosserhund.blackjack.elements;

import com.grosserhund.blackjack.players.dealer.Dealer;
import com.grosserhund.blackjack.players.player.BlackjackPlayerHand;
import com.grosserhund.blackjack.players.player.Player;
import com.grosserhund.cards.Card;
import com.grosserhund.cards.Rank;
import com.grosserhund.cards.Suit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertTrue;

class BettingTest {
    private final BigDecimal minimumBet = new BigDecimal(10);
    private Rules rules;
    private Table table;
    private Betting betting;
    private Player player;
    private Dealer dealer;

    @BeforeEach
    void setUp() {
        rules = new Rules();
        betting = rules.getBetting();
        table = new Table(rules, new BigDecimal(100000));
        table.addPlayer("Worf", new BigDecimal(500));
        player = table.getPlayers().get(0);
        dealer = table.getDealer();
    }

    @Test
    void playerCanPlay() {
        rules.setAllowBetting(true);
        assertTrue(betting.playerCanPlay(player));
    }

    @Test
    void placeInitialBet() {
        player.deal(new Card(1, Suit.SPADES, Rank.ACE));
        player.deal(new Card(1, Suit.SPADES, Rank.QUEEN));
        BlackjackPlayerHand blackjackPlayerHand = player.getHands().get(0);
        assertTrue(betting.placeInitialBet(player, blackjackPlayerHand));
    }

    @Test
    void doubleDown() {
        player.deal(new Card(1, Suit.SPADES, Rank.FIVE));
        player.deal(new Card(1, Suit.HEARTS, Rank.FIVE));
        BlackjackPlayerHand blackjackPlayerHand = player.getHands().get(0);
        betting.placeInitialBet(player, blackjackPlayerHand);
        assertTrue(betting.doubleDown(player, blackjackPlayerHand));
    }

    @Test
    void playerCanBet() {
        assertTrue(betting.playerCanBet(player, minimumBet));
    }

    @Test
    void playerCanPlayOrBet() {
        betting.playerCanPlayOrBet(player);
    }

//    @Test
//    void split() {
//        dealer.deal(new Card(0, Suit.SPADES, Rank.TWO));
//        dealer.deal(new Card(0, Suit.SPADES, Rank.TWO));
//
//        player.deal(new Card(0, Suit.SPADES, Rank.ACE));
//        player.deal(new Card(0, Suit.CLUBS, Rank.ACE));
//
//
//        BlackjackPlayerHand blackjackPlayerExistingHand = player.getHands().get(0);
//        betting.placeInitialBet(player, blackjackPlayerExistingHand);
//
//        BlackjackPlayerHand blackjackPlayerNewHand = player.getHands().get(0);
//        blackjackPlayerNewHand.addCard(new Card(0, Suit.CLUBS, Rank.TEN));
//
//        blackjackPlayerExistingHand.split();
//        blackjackPlayerExistingHand.addCard(new Card(0, Suit.CLUBS, Rank.TEN));
//
//
//        betting.split(player, blackjackPlayerExistingHand, blackjackPlayerNewHand);
//    }

//    @Test
//    void naturalBlackJack() {
//    }

//    @Test
//    void winHand() {
//    }
//
//    @Test
//    void loseHand() {
//    }
//
//    @Test
//    void pushHand() {
//    }
}