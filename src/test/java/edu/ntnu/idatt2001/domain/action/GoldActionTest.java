package edu.ntnu.idatt2001.domain.action;

import static org.junit.jupiter.api.Assertions.*;

import edu.ntnu.idatt2001.domain.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

//TODO: lambda i AssertEquals?
/**
 * Test class for the GoldAction class.
 *
 * @author Birthe and Eline
 * @version 28.02.23
 */
class GoldActionTest {
  static Player player;
  static GoldAction goldAction;

  @BeforeEach
  void setup() {
    player = new Player("Tom", 80, 50, 30);
  }
  @Nested
  @DisplayName("GoldActionT class tests.")
  class assertEqualsTests {

    @Test
    @DisplayName("Testing executing the action of adding gold to the player's gold reservoir.")
    void goldActionExecuteTest() {
      goldAction = new GoldAction(10);
      goldAction.execute(player);
      assertEquals(40, player.getGold());
    }

    @Test
    @DisplayName("Testing executing the action of adding a negative amount of gold to the player's gold reservoir.")
    void negativeGoldActionExecuteTest() {
      goldAction = new GoldAction(-10);
      goldAction.execute(player);
      assertEquals(20, player.getGold());
    }
  }
}