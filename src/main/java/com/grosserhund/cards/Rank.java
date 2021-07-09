package com.grosserhund.cards;

public enum Rank {
    TWO("Two", "2", 1, 2), THREE("Three", "3", 2, 3), FOUR("Four", "4", 3, 4), FIVE("Five", "5", 4, 5), SIX("Six", "6", 5, 6), SEVEN("Seven", "7", 6, 7), EIGHT("Eight", "8", 7, 8), NINE("Nine", "9", 8, 9), TEN("Ten", "10", 9, 10), JACK("Jack", "J", 10, 10), QUEEN("Queen", "Q", 11, 10), KING("King", "K", 12, 10), ACE("Ace", "A", 13, 11);

    private final String name;
    private final String abbrev;
    private final int rank;
    private final int value;

    Rank(String name, String abbrev, int rank, int value) {
        this.name = name;
        this.abbrev = abbrev;
        this.rank = rank;
        this.value = value;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the abbrev
     */
    public String getAbbrev() {
        return abbrev;
    }

    /**
     * @return the rank
     */
    public int getRank() {
        return rank;
    }

    /**
     * @return the value
     */
    public int getValue() {
        return value;
    }


}
