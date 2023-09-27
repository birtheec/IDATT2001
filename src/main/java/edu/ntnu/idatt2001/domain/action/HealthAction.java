package edu.ntnu.idatt2001.domain.action;

import edu.ntnu.idatt2001.domain.Player;

//TODO: trengs det en illegal Argument her?
/**
 * HealthAction class, which inherits from the interface Action.
 *
 * @author Birthe and Eline
 * @version 16.02.23
 */
public class HealthAction implements Action {
  private final int health;

  /**
   * Constructor of the HealthAction class.
   *
   * @param health (int)
   */
  public HealthAction(int health) {
    this.health = health;
  }

  /**
   * Execute the change of the player's health.
   *
   * @param player (Player)
   */
  @Override
  public void execute(Player player) {
    player.addHealth(this.health);
  }
}