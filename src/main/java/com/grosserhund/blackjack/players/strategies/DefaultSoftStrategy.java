package com.grosserhund.blackjack.players.strategies;

import com.grosserhund.blackjack.players.BlackJackState;
import com.grosserhund.blackjack.players.player.BlackJackPlayerState;
import com.grosserhund.blackjack.players.player.BlackjackPlayerHand;
import com.grosserhund.cards.Card;
import com.grosserhund.cards.Rank;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class DefaultSoftStrategy {
	private static final Logger LOGGER = LoggerFactory.getLogger(DefaultSoftStrategy.class.getName());
	private static final DefaultSoftStrategy SINGLE_INSTANCE = new DefaultSoftStrategy();

	private final Map<Rank, Map<Integer, BlackJackPlayerState>> actions = new HashMap<>();

	public static DefaultSoftStrategy getStrategy() {
		return SINGLE_INSTANCE;
	}

	private DefaultSoftStrategy() {
		actions.put(Rank.TWO, DEALER_TWO());
		actions.put(Rank.THREE, DEALER_THREE());
		actions.put(Rank.FOUR, DEALER_FOUR());
		actions.put(Rank.FIVE, DEALER_FIVE());
		actions.put(Rank.SIX, DEALER_SIX());
		actions.put(Rank.SEVEN, DEALER_SEVEN());
		actions.put(Rank.EIGHT, DEALER_EIGHT());
		actions.put(Rank.NINE, DEALER_NINE());
		actions.put(Rank.TEN, DEALER_TEN());
		actions.put(Rank.JACK, DEALER_TEN());
		actions.put(Rank.QUEEN, DEALER_TEN());
		actions.put(Rank.KING, DEALER_TEN());
		actions.put(Rank.ACE, DEALER_ACE());
	}

	private static Map<Integer, BlackJackPlayerState> DEALER_TWO() {
		Map<Integer, BlackJackPlayerState> map = new HashMap<>();

		map.put(11, BlackJackPlayerState.STAND);
		map.put(10, BlackJackPlayerState.STAND);
		map.put(9, BlackJackPlayerState.STAND);
		map.put(8, BlackJackPlayerState.STAND);
		map.put(7, BlackJackPlayerState.HIT);
		map.put(6, BlackJackPlayerState.HIT);
		map.put(5, BlackJackPlayerState.HIT);
		map.put(4, BlackJackPlayerState.HIT);
		map.put(3, BlackJackPlayerState.HIT);

		return map;
	}

	private static Map<Integer, BlackJackPlayerState> DEALER_THREE() {
		Map<Integer, BlackJackPlayerState> map = new HashMap<>();

		map.put(11, BlackJackPlayerState.STAND);
		map.put(10, BlackJackPlayerState.STAND);
		map.put(9, BlackJackPlayerState.STAND);
		map.put(8, BlackJackPlayerState.DOUBLE_DOWN);
		map.put(7, BlackJackPlayerState.DOUBLE_DOWN);
		map.put(6, BlackJackPlayerState.HIT);
		map.put(5, BlackJackPlayerState.HIT);
		map.put(4, BlackJackPlayerState.HIT);
		map.put(3, BlackJackPlayerState.HIT);

		return map;
	}

	private static Map<Integer, BlackJackPlayerState> DEALER_FOUR() {
		Map<Integer, BlackJackPlayerState> map = new HashMap<>();

		map.put(11, BlackJackPlayerState.STAND);
		map.put(10, BlackJackPlayerState.STAND);
		map.put(9, BlackJackPlayerState.STAND);
		map.put(8, BlackJackPlayerState.DOUBLE_DOWN);
		map.put(7, BlackJackPlayerState.DOUBLE_DOWN);
		map.put(6, BlackJackPlayerState.DOUBLE_DOWN);
		map.put(5, BlackJackPlayerState.DOUBLE_DOWN);
		map.put(4, BlackJackPlayerState.HIT);
		map.put(3, BlackJackPlayerState.HIT);

		return map;
	}

	private static Map<Integer, BlackJackPlayerState> DEALER_FIVE() {
		Map<Integer, BlackJackPlayerState> map = new HashMap<>();

		map.put(11, BlackJackPlayerState.STAND);
		map.put(10, BlackJackPlayerState.STAND);
		map.put(9, BlackJackPlayerState.STAND);
		map.put(8, BlackJackPlayerState.DOUBLE_DOWN);
		map.put(7, BlackJackPlayerState.DOUBLE_DOWN);
		map.put(6, BlackJackPlayerState.DOUBLE_DOWN);
		map.put(5, BlackJackPlayerState.DOUBLE_DOWN);
		map.put(4, BlackJackPlayerState.DOUBLE_DOWN);
		map.put(3, BlackJackPlayerState.DOUBLE_DOWN);

		return map;
	}

	private static Map<Integer, BlackJackPlayerState> DEALER_SIX() {
		Map<Integer, BlackJackPlayerState> map = new HashMap<>();

		map.put(11, BlackJackPlayerState.STAND);
		map.put(10, BlackJackPlayerState.STAND);
		map.put(9, BlackJackPlayerState.STAND);
		map.put(8, BlackJackPlayerState.DOUBLE_DOWN);
		map.put(7, BlackJackPlayerState.DOUBLE_DOWN);
		map.put(6, BlackJackPlayerState.DOUBLE_DOWN);
		map.put(5, BlackJackPlayerState.DOUBLE_DOWN);
		map.put(4, BlackJackPlayerState.DOUBLE_DOWN);
		map.put(3, BlackJackPlayerState.DOUBLE_DOWN);

		return map;
	}

	private static Map<Integer, BlackJackPlayerState> DEALER_SEVEN() {
		Map<Integer, BlackJackPlayerState> map = new HashMap<>();

		map.put(11, BlackJackPlayerState.STAND);
		map.put(10, BlackJackPlayerState.STAND);
		map.put(9, BlackJackPlayerState.STAND);
		map.put(8, BlackJackPlayerState.STAND);
		map.put(7, BlackJackPlayerState.HIT);
		map.put(6, BlackJackPlayerState.HIT);
		map.put(5, BlackJackPlayerState.HIT);
		map.put(4, BlackJackPlayerState.HIT);
		map.put(3, BlackJackPlayerState.HIT);

		return map;
	}

	private static Map<Integer, BlackJackPlayerState> DEALER_EIGHT() {
		Map<Integer, BlackJackPlayerState> map = new HashMap<>();

		map.put(11, BlackJackPlayerState.STAND);
		map.put(10, BlackJackPlayerState.STAND);
		map.put(9, BlackJackPlayerState.STAND);
		map.put(8, BlackJackPlayerState.STAND);
		map.put(7, BlackJackPlayerState.HIT);
		map.put(6, BlackJackPlayerState.HIT);
		map.put(5, BlackJackPlayerState.HIT);
		map.put(4, BlackJackPlayerState.HIT);
		map.put(3, BlackJackPlayerState.HIT);

		return map;
	}

	private static Map<Integer, BlackJackPlayerState> DEALER_NINE() {
		Map<Integer, BlackJackPlayerState> map = new HashMap<>();

		map.put(11, BlackJackPlayerState.STAND);
		map.put(10, BlackJackPlayerState.STAND);
		map.put(9, BlackJackPlayerState.STAND);
		map.put(8, BlackJackPlayerState.HIT);
		map.put(7, BlackJackPlayerState.HIT);
		map.put(6, BlackJackPlayerState.HIT);
		map.put(5, BlackJackPlayerState.HIT);
		map.put(4, BlackJackPlayerState.HIT);
		map.put(3, BlackJackPlayerState.HIT);

		return map;
	}

	private static Map<Integer, BlackJackPlayerState> DEALER_TEN() {
		Map<Integer, BlackJackPlayerState> map = new HashMap<>();

		map.put(11, BlackJackPlayerState.STAND);
		map.put(10, BlackJackPlayerState.STAND);
		map.put(9, BlackJackPlayerState.STAND);
		map.put(8, BlackJackPlayerState.HIT);
		map.put(7, BlackJackPlayerState.HIT);
		map.put(6, BlackJackPlayerState.HIT);
		map.put(5, BlackJackPlayerState.HIT);
		map.put(4, BlackJackPlayerState.HIT);
		map.put(3, BlackJackPlayerState.HIT);

		return map;
	}

	private static Map<Integer, BlackJackPlayerState> DEALER_ACE() {
		Map<Integer, BlackJackPlayerState> map = new HashMap<>();

		map.put(11, BlackJackPlayerState.STAND);
		map.put(10, BlackJackPlayerState.STAND);
		map.put(9, BlackJackPlayerState.STAND);
		map.put(8, BlackJackPlayerState.HIT);
		map.put(7, BlackJackPlayerState.HIT);
		map.put(6, BlackJackPlayerState.HIT);
		map.put(5, BlackJackPlayerState.HIT);
		map.put(4, BlackJackPlayerState.HIT);
		map.put(3, BlackJackPlayerState.HIT);

		return map;
	}

	
	public BlackJackState getBlackJackState(Card dealerCard, BlackjackPlayerHand playerHand) {
		Map<Integer, BlackJackPlayerState> dealerUpActions = actions.get(dealerCard.getRank());

		BlackJackPlayerState blackJackPlayerState =	dealerUpActions.get(playerHand.getSoftTotal());

		if(playerHand.getSoftTotal() > 3){
			if (blackJackPlayerState != null && blackJackPlayerState.equals(BlackJackPlayerState.DOUBLE_DOWN)) {
				if (playerHand.getCardCount() > 2 || playerHand.isDoubleDownNotAllowed()) {
					blackJackPlayerState = BlackJackPlayerState.HIT;
				}
			}

			if (blackJackPlayerState == null) {
				LOGGER.warn("BlackjackPlayerState is null for dealer {} and hand total {}",
						dealerCard, playerHand.getSoftTotal());
			} else {
				LOGGER.trace("BlackjackPlayerState: {}", blackJackPlayerState);
			}
		}
		return blackJackPlayerState;
	}
}