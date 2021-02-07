package com.grosserhund.cards;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest {
    private Deck deck;

    @BeforeEach
    void setUp() {
        deck = new Deck();
    }

    @Test
    void shuffle() {
        deck.shuffle();
    }

    @Test
    void createNewDeck() {
        assertEquals(Deck.createDeck(1).size(), 52);
    }

    @Test
    void drawFaceDown() {
        Card card = deck.draw(true);

        assertNotNull(card);
        assertTrue(card.isFaceDown());
    }

    @Test
    void drawFaceUp() {
        Card card = deck.draw(false);

        assertNotNull(card);
        assertTrue(card.isFaceUp());
    }
}