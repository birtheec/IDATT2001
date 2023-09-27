package edu.ntnu.idatt2001.domain;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Story class
 *
 * @author Birthe and Eline
 * @version 17.02.2023
 */
public class Story {

    /**
     * Defining all the object variables for story. All the variables are final,
     * and will therefore not have any mutator methods.
     */
    private final String title;
    private final Map<Link, Passage> passages;

    private final Passage openingPassage;

    /**
     * Constructor for story.

     * @param title The title of the story.
     * @param openingPassage The first passage in the story.
     * @throws IllegalArgumentException "Title can not be empty."
     * @throws IllegalArgumentException "Opening passage can not be empty."
     */
    public Story(String title, Passage openingPassage) {
        if (title.isBlank()) {
            throw new IllegalArgumentException("Title can not be empty.");
        }
        if (openingPassage == null) {
            throw new IllegalArgumentException("Opening passage can not be empty.");
        }
        this.title = title;
        this.openingPassage = openingPassage;
        this.passages = new HashMap<>();
    }

    /**
     * Get method for title.

     * @return Title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Get method for opening passage.

     * @return Opening passage.
     */
    public Passage getOpeningPassage() {
        return openingPassage;
    }

    /**
     * Get method for passage.

     * @param link Link.
     * @return Passage.
     */
    public Passage getPassage(Link link) {
        if (link == null) {
            throw new IllegalArgumentException("The link is empty and can therefor not be added.");
        }
        return passages.get(link);
    }

    /**
     * Get method for passages.

     * @return Values of passage.
     */
    public Collection<Passage> getPassages() {
        return passages.values();
    }


    /**
     * Method to add passage to map.

     * @param passage Passage.
     */
    public void addPassage(Passage passage) {
        if (passage == null) {
            throw new IllegalArgumentException("The passage is empty, and can therefore not be added");
        }
        Link link = new Link(passage.getTitle(), passage.getTitle());
        this.passages.put(link, passage);
    }
}
