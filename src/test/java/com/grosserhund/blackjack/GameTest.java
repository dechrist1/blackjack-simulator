package com.grosserhund.blackjack;

import com.grosserhund.blackjack.elements.Rules;
import com.grosserhund.blackjack.elements.Table;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.config.Configurator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertTrue;

class GameTest {
    private Rules rules;
    private Game game;

    @BeforeEach
    void setUp() {
        Configurator.setRootLevel(Level.TRACE);
        rules = new Rules();
        rules.setMaximumPlayers(1);
        rules.setTotalDecks(1);
        rules.setCutIndex(75);
        rules.setAllowPlayerSplit(true);
        rules.setAllowDoubleDown(true);

        rules.setAllowBetting(true);
        rules.setMinimumBet(new BigDecimal(10));
        rules.setBlackjackPays(new BigDecimal("1.5")); // 3:2

        Table table = new Table(rules, new BigDecimal(50000));//000));

        table.addPlayer("Worf", new BigDecimal(500));
//        table.addPlayer("Data", new BigDecimal(500));
//        table.addPlayer("Beverly", new BigDecimal(500));
//        table.addPlayer("Wil", new BigDecimal(500));
//        table.addPlayer("Deanna", new BigDecimal(500));
//        table.addPlayer("Jean Luc", new BigDecimal(500));
//        table.addPlayer("Wesley", new BigDecimal(1000));

        game = table.getGame();

    }

    @Test
    void playGame() {
        assertTrue(game.playGame());
    }
}