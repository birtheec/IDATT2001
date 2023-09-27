package edu.ntnu.idatt2001.domain.action;

import static org.junit.jupiter.api.Assertions.*;

import edu.ntnu.idatt2001.domain.Player;
import javafx.application.Platform;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * Test class for the HealthAction class.
 *
 * @author Birthe and Eline
 * @version 28.02.23
 */
class HealthActionTest {
  static Player player;

  @BeforeEach
  void setup() {
    player = new Player("Tom", 80, 50, 30);
  }

  @Nested
  @DisplayName("HealthAction class test.")
  class HealthActionTests {

    @Test
    @DisplayName("Testing executing the action of adding health to the player's health.")
    void healthActionExecuteTest() {
      HealthAction healthAction = new HealthAction(10);
      healthAction.execute(player);
      assertEquals(90, player.getHealth());
    }

    @Test
    @DisplayName("Testing executing the action of adding negative health score to the player's health.")
    void negativeHealthActionExecuteTest() {
      HealthAction healthAction = new HealthAction(-10);
      healthAction.execute(player);
      assertEquals(70, player.getHealth());
    }
  }
}