package com.grosserhund.cards;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {
    Card card;

    @BeforeEach
    void setUp() {
        card = new Card(1, Suit.SPADES, Rank.ACE);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void isFaceDown() {
        assertTrue(card.isFaceDown());
    }

    @Test
    void setFaceDown() {
        card.setFaceDown(true);
        assertTrue(card.isFaceDown());
    }

    @Test
    void setFaceUp() {
        card.setFaceDown(false);
        assertTrue(card.isFaceUp());
    }

    @Test
    void getDeck() {
        assertEquals(card.getDeck(), 1);
    }

    @Test
    void getRank() {
        assertEquals(card.getRank(), Rank.ACE);
    }

    @Test
    void getSuit() {
        assertEquals(card.getSuit(), Suit.SPADES);
    }

    @Test
    void get() {
        assertNotNull(card.get());
    }

    @Test
    void testToString() {
        assertNotNull(card.toString());
    }
}