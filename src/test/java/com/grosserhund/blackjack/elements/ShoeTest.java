package com.grosserhund.blackjack.elements;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShoeTest {
    private final int decks = 8;
    private final int cutLevel = 75;

    private Shoe shoe;

    @BeforeEach
    void setUp() {
        shoe = new Shoe(8, 75);
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void drawFaceDown() {
        assertNotNull(shoe.draw(true));
    }

    @Test
    void drawFaceUp() {
        assertNotNull(shoe.draw(false));
    }

    @Test
    void getCardCount() {
        assertNotEquals(0, shoe.getCardCount());
        assertEquals(decks * 52, shoe.getCardCount());
    }

    @Test
    void shuffle() {
        assertFalse(shoe.shuffle());
    }

    @Test
    void continuousShuffle() {
        shoe = new Shoe(decks, 0);
        assertTrue(shoe.shuffle());
    }

}