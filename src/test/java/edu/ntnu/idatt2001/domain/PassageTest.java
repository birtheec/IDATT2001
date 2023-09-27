package edu.ntnu.idatt2001.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

//TODO: adding tests for toString, hashCode and equals-methods?
//TODO: addLink test (("negative test")?
/**
 * Test class for the Passage class.
 *
 * @author Birthe and Eline
 * @version 28.02.23
 */
class PassageTest {

  static Passage passage;

  @BeforeEach
  void setup() {
    passage = new Passage("Forest", "In the forest");
  }

  @Nested
  @DisplayName("Testing the accessor methods of the Passage Class")
  class AccessorMethodTests {

    @Test
    @DisplayName("Testing accessing the title of the passage.")
    void getPassagesTitleTest() {
      assertEquals("Forest", passage.getTitle());
    }

    @Test
    @DisplayName("Testing accessing the content of the passage.")
    void getContentOfPassageTest() {
      assertEquals("In the forest", passage.getContent());
    }

    @Test
    @DisplayName("Testing accessing the links of the passage.")
    void getLinksOfPassageTest() {
      assertTrue(passage.getLinks().isEmpty());
    }
  }

  @Nested
  @DisplayName("Testing if the methods of the Passage class work properly.")
  class MethodTests {

    @Test
    @DisplayName("Testing adding links to the passage, by adding a link and checking if the list of links is not empty.")
    void addLinkByAddingALink() {
      Link link1 = new Link("Sky", "In to the sky");
      assertTrue(passage.addLink(link1));
    }

    //TODO: trenger jeg denne da addLink er en boolean, hvis ja: skal jeg da lage en for by index?
    @Test
    @DisplayName("Testing adding links to the passage, by the size of the list.")
    void addLinksBySizeTest() {
      Link link1 = new Link("Sky", "In to the sky");
      passage.addLink(link1);
      assertEquals(1, passage.getLinks().size());
    }

    @Test
    @DisplayName("Testing if the passage has links.")
    void hasPassageLinkTest() {
      Link link1 = new Link("Sky", "In to the sky");
      Link link2 = new Link("Moon", "On to the moon");
      passage.addLink(link1);
      passage.addLink(link2);
      assertTrue(passage.hasLink());
    }
  }

  @Nested
  @DisplayName("Testing exception handling in the Passage class.")
  class ExceptionHandlingTests {

    @Test
    @DisplayName("Testing the exceptions thrown in the constructor of the Passage class, with an empty title.")
    void emptyTitleConstructorPassageTest() {
      assertThrows(IllegalArgumentException.class, () -> new Passage("", "In the forest."));
    }

    @Test
    @DisplayName("Testing the exceptions thrown in the constructor of the Passage class, with an empty content.")
    void emptyContentConstructorPassageTest() {
      assertThrows(IllegalArgumentException.class, () -> new Passage("Forest", ""));
    }

    @Test
    @DisplayName("Testing adding an empty link to the passage.")
    void addEmptyLinkTest() {
      assertThrows(IllegalArgumentException.class, () -> passage.addLink(null));
    }
  }
}
