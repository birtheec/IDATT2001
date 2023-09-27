package edu.ntnu.idatt2001.domain.action;

import edu.ntnu.idatt2001.domain.Player;

/**
 * GoldAction class, which inherits from the interface Action.
 *
 * @author Birthe and Eline
 * @version 16.02.23
 */
public class GoldAction implements Action {
  private final int gold;

  /**
   * Constructor of the GoldAction class.
   *
   * @param gold (int)
   */
  public GoldAction(int gold) {
    this.gold = gold;
  }

  /**
   * Execute the change of the players gold reserves.
   *
   * @param player (Player)
   */
  @Override
  public void execute(Player player) {
    player.addGold(this.gold);
  }
}
