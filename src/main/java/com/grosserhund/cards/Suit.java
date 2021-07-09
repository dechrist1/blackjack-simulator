package com.grosserhund.cards;

public enum Suit {
    DIAMONDS("Diamonds", "D"),
    CLUBS("Clubs", "C"),
    HEARTS("Hearts", "H"),
    SPADES("Spades", "S");

    private final String name;
    private final String abbrev;

    Suit(String name, String abbrev) {
        this.name = name;
        this.abbrev = abbrev;
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

}
