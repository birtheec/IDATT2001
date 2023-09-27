package edu.ntnu.idatt2001.domain.goal;

import edu.ntnu.idatt2001.domain.Player;

/**
 * Goal interface.
 */
public interface Goal {

    /**
     * Checks if a goal is fulfilled.

     * @param player Player.
     */
    boolean isFulfilled(Player player);
}

