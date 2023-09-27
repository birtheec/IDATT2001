package edu.ntnu.idatt2001.domain.action;

import static org.junit.jupiter.api.Assertions.*;

import edu.ntnu.idatt2001.domain.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * Test class for the InventoryAction class.
 *
 * @author Birthe and Eline
 * @version 16.02.23
 */
class InventoryActionTest {
  static Player player;

  @BeforeEach
  void setup() {
    player = new Player("Tom", 80, 50, 30);
  }

  @Nested
  @DisplayName("InventoryAction class test")
  class InventoryActionTests {

    @Test
    @DisplayName("Testing executing the action of adding an item to the player's inventory.")
    void inventoryActionExecuteTest() {
      InventoryAction inventoryAction = new InventoryAction("Stone");
      inventoryAction.execute(player);
      assertEquals("Stone", player.getInventory().get(0));
    }
  }
}