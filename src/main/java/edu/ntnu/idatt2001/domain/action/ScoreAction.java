package edu.ntnu.idatt2001.domain.action;

import edu.ntnu.idatt2001.domain.Player;

/**
 * ScoreAction class, which inherits from the interface Action.
 *
 * @author Birthe and Eline
 * @version 16.02.23
 */
public class ScoreAction implements Action {
  private final int points;

  /**
   * Constructor of the ScoreAction class.
   *
   * @param points (int)
   */
  public ScoreAction(int points) {
    this.points = points;
  }

  /**
   * Execute the change of the player's score.
   *
   * @param player (Player)
   */
  @Override
  public void execute(Player player) {
    player.addScore(this.points);
  }
}
