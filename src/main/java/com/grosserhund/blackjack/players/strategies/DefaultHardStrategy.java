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

public class DefaultHardStrategy {
	private static final Logger LOGGER = LoggerFactory.getLogger(DefaultHardStrategy.class.getName());
	private static final DefaultHardStrategy SINGLE_INSTANCE = new DefaultHardStrategy();

	private final Map<Rank, Map<Integer, BlackJackPlayerState>> actions = new HashMap<>();

	public static DefaultHardStrategy getStrategy() {
		return SINGLE_INSTANCE;
	}

	private DefaultHardStrategy() {
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

		map.put(21, BlackJackPlayerState.STAND);
		map.put(20, BlackJackPlayerState.STAND);
		map.put(19, BlackJackPlayerState.STAND);
		map.put(18, BlackJackPlayerState.STAND);
		map.put(17, BlackJackPlayerState.STAND);
		map.put(16, BlackJackPlayerState.STAND);
		map.put(15, BlackJackPlayerState.STAND);
		map.put(14, BlackJackPlayerState.STAND);
		map.put(13, BlackJackPlayerState.STAND);
		map.put(12, BlackJackPlayerState.HIT);
		map.put(11, BlackJackPlayerState.DOUBLE_DOWN);
		map.put(10, BlackJackPlayerState.DOUBLE_DOWN);
		map.put(9, BlackJackPlayerState.HIT);
		map.put(8, BlackJackPlayerState.HIT);
		map.put(7, BlackJackPlayerState.HIT);
		map.put(6, BlackJackPlayerState.HIT);
		map.put(5, BlackJackPlayerState.HIT);
		map.put(4, BlackJackPlayerState.HIT);

		return map;
	}

	private static Map<Integer, BlackJackPlayerState> DEALER_THREE() {
		Map<Integer, BlackJackPlayerState> map = new HashMap<>();

		map.put(21, BlackJackPlayerState.STAND);
		map.put(20, BlackJackPlayerState.STAND);
		map.put(19, BlackJackPlayerState.STAND);
		map.put(18, BlackJackPlayerState.STAND);
		map.put(17, BlackJackPlayerState.STAND);
		map.put(16, BlackJackPlayerState.STAND);
		map.put(15, BlackJackPlayerState.STAND);
		map.put(14, BlackJackPlayerState.STAND);
		map.put(13, BlackJackPlayerState.STAND);
		map.put(12, BlackJackPlayerState.HIT);
		map.put(11, BlackJackPlayerState.DOUBLE_DOWN);
		map.put(10, BlackJackPlayerState.DOUBLE_DOWN);
		map.put(9, BlackJackPlayerState.DOUBLE_DOWN);
		map.put(8, BlackJackPlayerState.HIT);
		map.put(7, BlackJackPlayerState.HIT);
		map.put(6, BlackJackPlayerState.HIT);
		map.put(5, BlackJackPlayerState.HIT);
		map.put(4, BlackJackPlayerState.HIT);

		return map;
	}

	private static Map<Integer, BlackJackPlayerState> DEALER_FOUR() {
		Map<Integer, BlackJackPlayerState> map = new HashMap<>();

		map.put(21, BlackJackPlayerState.STAND);
		map.put(20, BlackJackPlayerState.STAND);
		map.put(19, BlackJackPlayerState.STAND);
		map.put(18, BlackJackPlayerState.STAND);
		map.put(17, BlackJackPlayerState.STAND);
		map.put(16, BlackJackPlayerState.STAND);
		map.put(15, BlackJackPlayerState.STAND);
		map.put(14, BlackJackPlayerState.STAND);
		map.put(13, BlackJackPlayerState.STAND);
		map.put(12, BlackJackPlayerState.STAND);
		map.put(11, BlackJackPlayerState.DOUBLE_DOWN);
		map.put(10, BlackJackPlayerState.DOUBLE_DOWN);
		map.put(9, BlackJackPlayerState.DOUBLE_DOWN);
		map.put(8, BlackJackPlayerState.HIT);
		map.put(7, BlackJackPlayerState.HIT);
		map.put(6, BlackJackPlayerState.HIT);
		map.put(5, BlackJackPlayerState.HIT);
		map.put(4, BlackJackPlayerState.HIT);

		return map;
	}

	private static Map<Integer, BlackJackPlayerState> DEALER_FIVE() {
		Map<Integer, BlackJackPlayerState> map = new HashMap<>();

		map.put(21, BlackJackPlayerState.STAND);
		map.put(20, BlackJackPlayerState.STAND);
		map.put(19, BlackJackPlayerState.STAND);
		map.put(18, BlackJackPlayerState.STAND);
		map.put(17, BlackJackPlayerState.STAND);
		map.put(16, BlackJackPlayerState.STAND);
		map.put(15, BlackJackPlayerState.STAND);
		map.put(14, BlackJackPlayerState.STAND);
		map.put(13, BlackJackPlayerState.STAND);
		map.put(12, BlackJackPlayerState.STAND);
		map.put(11, BlackJackPlayerState.DOUBLE_DOWN);
		map.put(10, BlackJackPlayerState.DOUBLE_DOWN);
		map.put(9, BlackJackPlayerState.DOUBLE_DOWN);
		map.put(8, BlackJackPlayerState.HIT);
		map.put(7, BlackJackPlayerState.HIT);
		map.put(6, BlackJackPlayerState.HIT);
		map.put(5, BlackJackPlayerState.HIT);
		map.put(4, BlackJackPlayerState.HIT);

		return map;
	}

	private static Map<Integer, BlackJackPlayerState> DEALER_SIX() {
		Map<Integer, BlackJackPlayerState> map = new HashMap<>();

		map.put(21, BlackJackPlayerState.STAND);
		map.put(20, BlackJackPlayerState.STAND);
		map.put(19, BlackJackPlayerState.STAND);
		map.put(18, BlackJackPlayerState.STAND);
		map.put(17, BlackJackPlayerState.STAND);
		map.put(16, BlackJackPlayerState.STAND);
		map.put(15, BlackJackPlayerState.STAND);
		map.put(14, BlackJackPlayerState.STAND);
		map.put(13, BlackJackPlayerState.STAND);
		map.put(12, BlackJackPlayerState.STAND);
		map.put(11, BlackJackPlayerState.DOUBLE_DOWN);
		map.put(10, BlackJackPlayerState.DOUBLE_DOWN);
		map.put(9, BlackJackPlayerState.DOUBLE_DOWN);
		map.put(8, BlackJackPlayerState.HIT);
		map.put(7, BlackJackPlayerState.HIT);
		map.put(6, BlackJackPlayerState.HIT);
		map.put(5, BlackJackPlayerState.HIT);
		map.put(4, BlackJackPlayerState.HIT);

		return map;
	}

	private static Map<Integer, BlackJackPlayerState> DEALER_SEVEN() {
		Map<Integer, BlackJackPlayerState> map = new HashMap<>();

		map.put(21, BlackJackPlayerState.STAND);
		map.put(20, BlackJackPlayerState.STAND);
		map.put(19, BlackJackPlayerState.STAND);
		map.put(18, BlackJackPlayerState.STAND);
		map.put(17, BlackJackPlayerState.STAND);
		map.put(16, BlackJackPlayerState.HIT);
		map.put(15, BlackJackPlayerState.HIT);
		map.put(14, BlackJackPlayerState.HIT);
		map.put(13, BlackJackPlayerState.HIT);
		map.put(12, BlackJackPlayerState.HIT);
		map.put(11, BlackJackPlayerState.DOUBLE_DOWN);
		map.put(10, BlackJackPlayerState.DOUBLE_DOWN);
		map.put(9, BlackJackPlayerState.HIT);
		map.put(8, BlackJackPlayerState.HIT);
		map.put(7, BlackJackPlayerState.HIT);
		map.put(6, BlackJackPlayerState.HIT);
		map.put(5, BlackJackPlayerState.HIT);
		map.put(4, BlackJackPlayerState.HIT);

		return map;
	}

	private static Map<Integer, BlackJackPlayerState> DEALER_EIGHT() {
		Map<Integer, BlackJackPlayerState> map = new HashMap<>();

		map.put(21, BlackJackPlayerState.STAND);
		map.put(20, BlackJackPlayerState.STAND);
		map.put(19, BlackJackPlayerState.STAND);
		map.put(18, BlackJackPlayerState.STAND);
		map.put(17, BlackJackPlayerState.STAND);
		map.put(16, BlackJackPlayerState.HIT);
		map.put(15, BlackJackPlayerState.HIT);
		map.put(14, BlackJackPlayerState.HIT);
		map.put(13, BlackJackPlayerState.HIT);
		map.put(12, BlackJackPlayerState.HIT);
		map.put(11, BlackJackPlayerState.DOUBLE_DOWN);
		map.put(10, BlackJackPlayerState.DOUBLE_DOWN);
		map.put(9, BlackJackPlayerState.HIT);
		map.put(8, BlackJackPlayerState.HIT);
		map.put(7, BlackJackPlayerState.HIT);
		map.put(6, BlackJackPlayerState.HIT);
		map.put(5, BlackJackPlayerState.HIT);
		map.put(4, BlackJackPlayerState.HIT);

		return map;
	}

	private static Map<Integer, BlackJackPlayerState> DEALER_NINE() {
		Map<Integer, BlackJackPlayerState> map = new HashMap<>();

		map.put(21, BlackJackPlayerState.STAND);
		map.put(20, BlackJackPlayerState.STAND);
		map.put(19, BlackJackPlayerState.STAND);
		map.put(18, BlackJackPlayerState.STAND);
		map.put(17, BlackJackPlayerState.STAND);
		map.put(16, BlackJackPlayerState.HIT);
		map.put(15, BlackJackPlayerState.HIT);
		map.put(14, BlackJackPlayerState.HIT);
		map.put(13, BlackJackPlayerState.HIT);
		map.put(12, BlackJackPlayerState.HIT);
		map.put(11, BlackJackPlayerState.DOUBLE_DOWN);
		map.put(10, BlackJackPlayerState.DOUBLE_DOWN);
		map.put(9, BlackJackPlayerState.HIT);
		map.put(8, BlackJackPlayerState.HIT);
		map.put(7, BlackJackPlayerState.HIT);
		map.put(6, BlackJackPlayerState.HIT);
		map.put(5, BlackJackPlayerState.HIT);
		map.put(4, BlackJackPlayerState.HIT);

		return map;
	}

	private static Map<Integer, BlackJackPlayerState> DEALER_TEN() {
		Map<Integer, BlackJackPlayerState> map = new HashMap<>();

		map.put(21, BlackJackPlayerState.STAND);
		map.put(20, BlackJackPlayerState.STAND);
		map.put(19, BlackJackPlayerState.STAND);
		map.put(18, BlackJackPlayerState.STAND);
		map.put(17, BlackJackPlayerState.STAND);
		map.put(16, BlackJackPlayerState.HIT);
		map.put(15, BlackJackPlayerState.HIT);
		map.put(14, BlackJackPlayerState.HIT);
		map.put(13, BlackJackPlayerState.HIT);
		map.put(12, BlackJackPlayerState.HIT);
		map.put(11, BlackJackPlayerState.DOUBLE_DOWN);
		map.put(10, BlackJackPlayerState.HIT);
		map.put(9, BlackJackPlayerState.HIT);
		map.put(8, BlackJackPlayerState.HIT);
		map.put(7, BlackJackPlayerState.HIT);
		map.put(6, BlackJackPlayerState.HIT);
		map.put(5, BlackJackPlayerState.HIT);
		map.put(4, BlackJackPlayerState.HIT);

		return map;
	}

	private static Map<Integer, BlackJackPlayerState> DEALER_ACE() {
		Map<Integer, BlackJackPlayerState> map = new HashMap<>();

		map.put(21, BlackJackPlayerState.STAND);
		map.put(20, BlackJackPlayerState.STAND);
		map.put(19, BlackJackPlayerState.STAND);
		map.put(18, BlackJackPlayerState.STAND);
		map.put(17, BlackJackPlayerState.STAND);
		map.put(16, BlackJackPlayerState.HIT);
		map.put(15, BlackJackPlayerState.HIT);
		map.put(14, BlackJackPlayerState.HIT);
		map.put(13, BlackJackPlayerState.HIT);
		map.put(12, BlackJackPlayerState.HIT);
		map.put(11, BlackJackPlayerState.HIT);
		map.put(10, BlackJackPlayerState.HIT);
		map.put(9, BlackJackPlayerState.HIT);
		map.put(8, BlackJackPlayerState.HIT);
		map.put(7, BlackJackPlayerState.HIT);
		map.put(6, BlackJackPlayerState.HIT);
		map.put(5, BlackJackPlayerState.HIT);
		map.put(4, BlackJackPlayerState.HIT);

		return map;
	}


	public BlackJackState getBlackJackState(Card dealerCard, BlackjackPlayerHand playerHand) {
		Map<Integer, BlackJackPlayerState> dealerUpActions = actions.get(dealerCard.getRank());

		BlackJackPlayerState blackJackPlayerState =	dealerUpActions.get(playerHand.getTotal());

		if(playerHand.getTotal() > 4) {
			if (blackJackPlayerState != null && blackJackPlayerState.equals(BlackJackPlayerState.DOUBLE_DOWN)) {
				if (playerHand.getCardCount() > 2 || playerHand.isDoubleDownNotAllowed()) {
					blackJackPlayerState = BlackJackPlayerState.HIT;
				}
			}

			if(blackJackPlayerState == null) {
				LOGGER.warn("BlackjackPlayerState is null for dealer {} and hand total {}",
					dealerCard, playerHand.getTotal());
			} else {
				LOGGER.trace("BlackjackPlayerState: {}", blackJackPlayerState);
			}
		}

		return blackJackPlayerState;
	}
}