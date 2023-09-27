package edu.ntnu.idatt2001.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * Test class for the Player class.
 *
 * @author Birthe and Eline
 * @version 28.02.23
 */
class PlayerTest {

  static Player player;

  @BeforeEach
  void setup() {
    player = new Player("Tom", 89, 54, 43);
  }

  @Nested
  @DisplayName("Testing the accessor methods of the Player class.")
  class AccessorMethodTests {

    @Test
    @DisplayName("Testing accessing player's name.")
    void getPlayerNameTest() {
      assertEquals("Tom", player.getName());
    }

    @Test
    @DisplayName("Testing accessing the health of the player.")
    void getPlayerHealthTest() {
      Player player1 = new Player("Hannah", 9, 7, 4);
      assertEquals(9, player1.getHealth());
    }

    @Test
    @DisplayName("Testing accessing the player's score.")
    void getPlayerScoreTest() {
      assertEquals(54, player.getScore());
    }

    @Test
    @DisplayName("Testing accessing the player's gold reservoir.")
    void getPlayerGoldTest() {
      Player player1 = new Player("Hannah", 88, 17, 4);
      assertEquals(4, player1.getGold());
    }

    @Test
    @DisplayName("Testing accessing the inventory of the player.")
    void getPlayerInventoryTest() {
      assertTrue(player.getInventory().isEmpty());
    }
  }

  @Nested
  @DisplayName("Testing if the methods of the Player class work properly.")
  class MethodTests {

    @Test
    @DisplayName("Testing adding the player's health.")
    void addPlayerHealthTest() {
      player.addHealth(3);
      assertEquals(92, player.getHealth());
    }

    @Test
    @DisplayName("Testing adding the player's score.")
    void addPlayerScoreTest () {
      player.addScore(5);
      assertEquals(59, player.getScore());
    }

    @Test
    @DisplayName("Testing adding the player's amount of gold.")
    void addPlayerGoldTest() {
      player.addGold(70);
      assertEquals(113, player.getGold());
    }

    @Test
    @DisplayName("Testing adding items to the inventory, by the size of the list.")
    void addToInventoryBySizeTest() {
      player.addToInventory("Flower");
      player.addToInventory("Stone");
      assertEquals(2, player.getInventory().size());
    }

    @Test
    @DisplayName("Testing adding items to the inventory, by index of the list.")
    void addToInventoryByIndexTest() {
      player.addToInventory("Flower");
      player.addToInventory("Stone");
      assertEquals("Stone", player.getInventory().get(1));
    }
  }

  @Nested
  @DisplayName("Testing exception handling in the Player class.")
  class ExceptionHandlingTests {
    @Test
    @DisplayName("Testing the exceptions thrown in the constructor of the Player class, for an empty name of the player.")
    void exceptionConstructorPlayerEmptyNameTest() {
      assertThrows(IllegalArgumentException.class, () -> new Player("", 3, 5, 7));
    }

    @Test
    @DisplayName("Testing the exceptions thrown in the constructor of the Player class, for a player with a negative health score.")
    void exceptionConstructorPlayerNegativeHealthTest() {
      assertThrows(IllegalArgumentException.class, () -> new Player("Hannah", -3, 5, 7));
    }

    @Test
    @DisplayName("Testing the exceptions thrown in the constructor of the Player class, for a negative player score.")
    void exceptionConstructorPlayerNegativeScoreTest() {
      assertThrows(IllegalArgumentException.class, () -> new Player("Hannah", 3, -5, 7));
    }

    @Test
    @DisplayName("Testing the exceptions thrown in the constructor of the Player class, for a player with a negative amount of gold.")
    void exceptionConstructorPlayerGoldTest() {
      assertThrows(IllegalArgumentException.class, () -> new Player("Hannah", 3, 5, -7));
    }

    @Test
    @DisplayName("Testing adding a negative health score, such as the player's health gets negative.")
    void addNegativeHealthTest() {
      assertThrows(IllegalArgumentException.class, () -> player.addHealth(-100));
    }

    @Test
    @DisplayName("Testing adding a negative score, such as the player's score gets negative.")
    void addNegativeScoreTest() {
      assertThrows(IllegalArgumentException.class, () -> player.addScore(-100));
    }

    @Test
    @DisplayName("Testing adding a negative amount of gold, such as the gold reservoir gets negative.")
    void addNegativeGoldTest() {
      assertThrows(IllegalArgumentException.class, () -> player.addGold(-100));
    }

    @Test
    @DisplayName("Testing adding nothing to the inventory.")
    void addNothingToInventoryTest() {
      assertThrows(IllegalArgumentException.class, () -> player.addToInventory(null));
    }
  }
}