package com.grosserhund.blackjack;

import com.grosserhund.blackjack.elements.Rules;
import com.grosserhund.blackjack.elements.Table;
import com.grosserhund.blackjack.players.player.Player;
import com.grosserhund.util.StopWatch;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.config.Configurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

public class Test {
	private static final Logger LOGGER = LoggerFactory.getLogger(Test.class.getName());

	public static void main(String[] av) {
		int gamesToPlay = 1000000;
		Configurator.setRootLevel(Level.INFO);//DEBUG);

		LOGGER.info("Initializing virtual blackjack table");

		Rules rules = new Rules();
		rules.setMaximumPlayers(7);
		rules.setTotalDecks(8);
		rules.setCutIndex(75);
		rules.setAllowPlayerSplit(true);

		rules.setAllowBetting(false);
		rules.setMinimumBet(new BigDecimal(10));
		rules.setBlackjackPays(new BigDecimal("1.5")); // 3:2

		Table table = new Table(rules, new BigDecimal(50000));//000));

		table.addPlayer("Worf", new BigDecimal(500));
		table.addPlayer("Data", new BigDecimal(500));
		table.addPlayer("Beverly", new BigDecimal(500));
		table.addPlayer("Wil", new BigDecimal(500));
		table.addPlayer("Deanna", new BigDecimal(500));
		table.addPlayer("Jean Luc", new BigDecimal(500));
		table.addPlayer("Wesley", new BigDecimal(1000));

		Game game = table.getGame();

		LOGGER.info("Starting Blackjack simulation");
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();

		for (int i = 0; i < gamesToPlay; i++) {
			if(!game.playGame())
				break;
		}

		stopWatch.stop();
		LOGGER.info("Ended Blackjack Simulation");

		for(Player player: table.getPlayers()) {
			LOGGER.info(player.getStats());
		}

		LOGGER.info(table.getDealer().getStats());

		LOGGER.info("Blackjack completed in {} seconds", stopWatch.getTotalTimeSeconds());
	}

}
