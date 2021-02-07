package com.grosserhund.blackjack.elements;

import com.grosserhund.blackjack.Game;
import com.grosserhund.blackjack.players.dealer.Dealer;
import com.grosserhund.blackjack.players.player.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Table {
    private static final Logger LOGGER = LoggerFactory.getLogger(Table.class.getName());

    private final Rules rules;
    private final List<Player> players;
    private final Game game;
    private final Shoe shoe;
    private final Dealer dealer;

    public Table(Rules rules, BigDecimal dealerBank) {
        this.rules = rules;
        shoe = new Shoe(rules.getTotalDecks(), rules.getCutIndex());
        dealer = new Dealer(rules, dealerBank);
        game = new Game(this);
        players = new ArrayList<>();
    }

    public boolean addPlayer(String name, BigDecimal openingBank) {
        if(players.size() < rules.getMaximumPlayers()) {
            players.add(new Player(name, rules, openingBank));
            return true;
        }

        LOGGER.error("Unable to add player {} = maximum players = {}", name, rules.getMaximumPlayers() );
        return false;
    }

    public Rules getRules() {
        return rules;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public Shoe getShoe() {
        return shoe;
    }

    public Game getGame() {
        return game;
    }
}
