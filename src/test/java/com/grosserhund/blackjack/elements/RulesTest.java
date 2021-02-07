package com.grosserhund.blackjack.elements;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class RulesTest {

    private Rules rules;

    @BeforeEach
    void setUp() {
        rules = new Rules();
    }

    @Test
    void getMaximumPlayers() {
        int maximumPlayers = 7;
        rules.setMaximumPlayers(maximumPlayers);
        assertEquals(maximumPlayers, rules.getMaximumPlayers());
    }

    @Test
    void getTotalDecks() {
        int totalDecks = 7;
        rules.setTotalDecks(totalDecks);
        assertEquals(totalDecks, rules.getTotalDecks());
    }

    @Test
    void getDealerStandValue() {
        int standValue = 17;
        rules.setDealerStandValue(standValue);
        assertEquals(standValue, rules.getDealerStandValue());
    }

    @Test
    void getDealerStandSoftValue() {
        int standSoftValue = 17;
        rules.setDealerStandSoftValue(standSoftValue);
        assertEquals(standSoftValue, rules.getDealerStandSoftValue());
    }

    @Test
    void getCutIndex() {
        int cutIndex = 17;
        rules.setCutIndex(cutIndex);
        assertEquals(cutIndex, rules.getCutIndex());
    }

    @Test
    void isAllowPlayerSplit() {
        rules.setAllowPlayerSplit(true);
        assertTrue(rules.isAllowPlayerSplit());
    }

    @Test
    void isAllowDoubleDown() {
        rules.setAllowDoubleDown(true);
        assertTrue(rules.isAllowDoubleDown());
    }

    @Test
    void isDoubleDownOnSplit() {
        rules.setDoubleDownOnSplit(true);
        assertTrue(rules.isDoubleDownOnSplit());
    }

    @Test
    void getMinimumBet() {
        BigDecimal minimumBet = new BigDecimal("5");
        rules.setMinimumBet(minimumBet);
        assertEquals(minimumBet, rules.getMinimumBet());
    }

    @Test
    void getDealerStartingBank() {
        BigDecimal dealerStartingBank = new BigDecimal("100000");
        rules.setDealerStartingBank(dealerStartingBank);
        assertEquals(dealerStartingBank, rules.getDealerStartingBank());
    }

    @Test
    void isBettingAllowed() {
        rules.setAllowBetting(true);
        assertTrue(rules.isAllowedBetting());
    }

    @Test
    void isBettingNotAllowed() {
        rules.setAllowBetting(false);
        assertTrue(rules.isNotAllowedBetting());
    }

    @Test
    void getBlackjackPays() {
        BigDecimal blackjackPays = new BigDecimal("1.5"); // 3:2
        rules.setBlackjackPays(blackjackPays);
        assertEquals(blackjackPays, rules.getBlackjackPays());
    }

    @Test
    void getBetting() {
        assertNotNull(rules.getBetting());
    }
}