package edu.ntnu.idatt2001.domain;

import edu.ntnu.idatt2001.domain.action.Action;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Link class

 * @author Birthe and Eline
 * @version 17.02.2023
 */
public class Link {

    /**
     * Defining all the object variables for link. Text and reference are final variables,
     * and will therefore not have any mutator methods.
     */
    private final String text;
    private final String reference;
    private final List<Action> actions;

    /**
     * Constructor for Link.
     * Checks for illegal arguments.
     *
     * @param text      A descriptive text that indicates a choice or an action in a history.
     *                  The part of the link that is visible to the player.
     * @param reference A string that unambigously identifies a passage (a part of a history).
     *                  This will be the title of the passage.
     * @throws IllegalArgumentException "Text can not be empty."
     * @throws IllegalArgumentException "Reference can not be empty."
     */
    public Link(String text, String reference) {
        if (text.isBlank()) {
            throw new IllegalArgumentException("Text can not be empty.");
        }
        if (reference.isBlank()) {
            throw new IllegalArgumentException("Reference can not be empty.");
        }
        this.text = text;
        this.reference = reference;
        this.actions = new ArrayList<>();
    }

    /**
     * Get method for text.
     *
     * @return Text.
     */
    public String getText() {
        return text;
    }

    /**
     * Get method for reference.
     *
     * @return Reference.
     */
    public String getReference() {
        return reference;
    }

    /**
     * Get method for actions.
     *
     * @return Actions.
     */
    public List<Action> getActions() {
        return actions;
    }

    /**
     * Method to add an action to actions.
     *
     * @param actions Actions
     */
    public void addAction(Action actions) {
        if (actions == null) {
            throw new IllegalArgumentException("The action is empty, and can therefor not be added.");
        }
        this.actions.add(actions);
    }

    /**
     * To string method for link, consisting of all the variables in link.
     *
     * @return String for link.
     */
    @Override
    public String toString() {
        return "Link" + "\n"
                + "Text: " + text + "\n"
                + "Reference: " + reference + "\n"
                + "Actions: " + actions + "\n";
    }

    /**
     * Equals method for the Link class.
     *
     * @param o Object.
     * @return Boolean.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Link link)) return false;
        return text.equals(link.text) && reference.equals(link.reference) && actions.equals(link.actions);
    }

    /**
     * Method for hash code.
     *
     * @return Int.
     */
    @Override
    public int hashCode() {
        return Objects.hash(text, reference, actions);
    }
}


