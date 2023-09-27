package edu.ntnu.idatt2001.domain.action;

import edu.ntnu.idatt2001.domain.Player;

/**
 * InventoryAction class, which inherits from the interface Action.
 *
 * @author Birthe and Eline
 * @version 16.02.23
 */
public class InventoryAction implements Action {
  private final String item;

  /**
   * Constructor of the InventoryAction class.
   *
   * @param item (String)
   */
  public InventoryAction(String item) {
    this.item = item;
  }

  /**
   * Execute the adding of an item to the players inventory.
   *
   * @param player (Player)
   */
  @Override
  public void execute(Player player) {
    player.addToInventory(item);
  }
}