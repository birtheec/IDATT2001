package edu.ntnu.idatt2001.domain.action;

import static org.junit.jupiter.api.Assertions.*;

import edu.ntnu.idatt2001.domain.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

//TODO: add tests?
/**
 * Test class for the ScoreAction class.
 *
 * @author Birthe and Eline
 * @version 16.02.23
 */
class ScoreActionTest {
  static Player player;

  @BeforeEach
  void setup() {
    player = new Player("Tom", 80, 50, 30);
  }

  @Nested
  @DisplayName("ScoreAction class test.")
  class ScoreActionTests {

    @Test
    @DisplayName("Testing executing the action of adding a score to the player's current score.")
    void scoreActionExecuteTest() {
      ScoreAction scoreAction = new ScoreAction(10);
      scoreAction.execute(player);
      assertEquals(60, player.getScore());
    }

    @Test
    @DisplayName("Testing executing the action of adding a negative score to the player's current score.")
    void negativeScoreActionExecuteTest() {
      ScoreAction scoreAction = new ScoreAction(-10);
      scoreAction.execute(player);
      assertEquals(40, player.getScore());
    }
  }
}