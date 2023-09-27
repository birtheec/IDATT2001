package edu.ntnu.idatt2001.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Player class.
 * Represents a player of the game Paths, with its characteristic influencing the story.
 * These characteristics include the player's health, score, gold reserves and inventory.
 *
 * @author Birthe and Eline
 * @version 16.02.23
 */

public class Player {
  private final String name;
  private int health;
  private int score;
  private int gold;
  private final List<String> inventory;


  /**
   * Constructor of the class Player.
   * Checking for illegal arguments.
   *
   * @param name   The name of the player (String)
   * @param health The health of the player as a positive integer(int)
   * @param score  The player's score as a positive integer(int)
   * @param gold   The player's amount of gold as positive integer(int)
   * @throws IllegalArgumentException "The name can not be empty."
   * @throws IllegalArgumentException "The health of the player has to be grater than zero."
   * @throws IllegalArgumentException "The score has to be greater than zero."
   * @throws IllegalArgumentException "The amount of gold has to be greater than zero."
   */
  public Player(String name, int health, int score, int gold) {
    if (name.isBlank()) {
      throw new IllegalArgumentException("The name can not be empty.");
    }
    if (health < 0) {
      throw new IllegalArgumentException("The health of the player has to be greater than zero.");
    }
    if (score < 0) {
      throw new IllegalArgumentException("The score has to be greater than zero.");
    }
    if (gold < 0) {
      throw new IllegalArgumentException("The amount of gold has to be greater than zero.");
    }
    this.name = name;
    this.health = health;
    this.score = score;
    this.gold = gold;
    this.inventory = new ArrayList<>();
  }

  /**
   * Accessing the name of the player.
   *
   * @return name (String)
   */
  public String getName() {
    return this.name;
  }

  /**
   * Accessing the health of the player.
   *
   * @return health (int)
   */
  public int getHealth() {
    return health;
  }

  /**
   * Accessing the score of the player.
   *
   * @return score (int)
   */
  public int getScore() {
    return score;
  }

  /**
   * Accessing the number of gold the player has collected.
   *
   * @return gold (int)
   */
  public int getGold() {
    return gold;
  }

  /**
   * Accessing the players collected inventory.
   *
   * @return inventory (List<String>)
   */
  public List<String> getInventory() {
    return inventory;
  }

  /**
   * Adding to the players' health.
   * Checking for the total sum of health is greater than zero.
   *
   * @param health (int)
   * @throws IllegalArgumentException "The players total health has to be greater than zero."
   */
  public void addHealth(int health) {
    if (this.health + health < 0) {
      throw new IllegalArgumentException("The players total health has to be greater than zero.");
    }
    this.health += health;
  }

  /**
   * Adding to the players' health.
   * Checking if the health is greater than zero.
   *
   * @param score (int)
   * @throws IllegalArgumentException "The player has to have a positive score."
   */
  public void addScore(int score) {
    if (this.score + score < 0) {
      throw new IllegalArgumentException("The player has to have a positive score.");
    }
    this.score += score;
  }


  /**
   * Adding to the players' amount of gold.
   * Checking if the amount of gould is greater than zero.
   *
   * @param gold (int)
   * @throws IllegalArgumentException "The amount of gold has to be greater than zero."
   */
  public void addGold(int gold) {
    if (this.gold + gold < 0) {
      throw new IllegalArgumentException("The amount of gold has to be greater than zero.");
    }
    this.gold += gold;
  }

  /**
   * Adding items to the inventory.
   * Checking if the item is null or not.
   *
   * @param item (String)
   * @throws IllegalArgumentException "It is not possible to add an empty item to the inventory!"
   */
  public void addToInventory(String item) {
    if (item == null) {
      throw new IllegalArgumentException("It is not possible to add an empty item "
          + "to the inventory.");
    }
    this.inventory.add(item);
  }
}


