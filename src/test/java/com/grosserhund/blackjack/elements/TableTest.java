package com.grosserhund.blackjack.elements;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TableTest {
    private Table table;

    @BeforeEach
    void setUp() {
        table = new Table(new Rules(), new BigDecimal(100000));
    }


    @Test
    void addPlayer() {
        assertTrue(table.addPlayer("Worf", new BigDecimal(500)));
    }

    @Test
    void getPlayers() {
        assertNotNull(table.getPlayers());
    }

    @Test
    void getDealer() {
        assertNotNull(table.getDealer());
    }

    @Test
    void getShoe() {
        assertNotNull(table.getShoe());
    }
}