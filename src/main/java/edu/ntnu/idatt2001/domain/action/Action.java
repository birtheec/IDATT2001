package edu.ntnu.idatt2001.domain.action;

import edu.ntnu.idatt2001.domain.Player;

/**
 * Action interface.
 * The interface represents an upcoming change in the state of a player.
 * These changes are related to the player's health, score, gold reserves and inventory.
 *
 * @author Birthe and Eline
 * @version 16.02.23
 */
public interface Action {

  /**
   * Executes a change of state for the player.
   *
   * @param player (Player)
   */
   void execute(Player player);
}


