package edu.ntnu.idatt2001.domain;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class StoryTest {

    static Story story;
    static Passage passage1;
    static Passage passage2;

    @BeforeEach
    void setUp() {
        story = new Story("Scary trolls", new Passage("Mountain", "In the mountain"));
        passage1 = new Passage("Cloud", "In the cloud");
        passage2 = new Passage("Sky", "In the sky");

    }

    @Nested
    @DisplayName("Testing the accessor methods of the Story class.")
    class AccessorMethodTests {
        @Test
        @DisplayName("Testing accessing the story's title.")
        void getTitleTest() {
            assertEquals("Scary trolls", story.getTitle());
        }

        @Test
        @DisplayName("Testing accessing the story's opening passages title.")
        void getOpeningPassagesTitleTest() {
            assertEquals("Mountain", story.getOpeningPassage().getTitle());
        }

        @Test
        @DisplayName("Testing accessing the story's opening passages content.")
        void getOpeningPassagesContentTest() {
            assertEquals("In the mountain", story.getOpeningPassage().getContent());
        }

        @Test
        @DisplayName("Testing accessing the story's passages.")
        void getPassagesTest() {
            assertTrue(story.getPassages().isEmpty());
        }
    }

    @Nested
    @DisplayName("Testing if the methods of the Story class work properly.")
    class MethodTests {
        @Test
        @DisplayName("Testing method for get passage as well as add passage, by the size of the list.")
        void getPassageAndAddPassageTest() {
            story.addPassage(passage1);
            story.addPassage(passage2);
            assertEquals(2, story.getPassages().size());
        }

        @Test
        @DisplayName("Testing method for add passage, by the index of the list.")
        void checkIfCorrectItemsAreAddedTest() {
            story.addPassage(passage1);
            Link link1 = new Link(passage1.getTitle(), passage1.getTitle());
            assertEquals(passage1, story.getPassage(link1));
        }

        //TODO: er dette nødvendig?
        @Test
        @DisplayName("Negative test of the add passage method. Adding items to the list, then using assert false to see " +
                "if it is empty.")
        void addPassageFalse() {
            story.addPassage(passage1);
            story.addPassage(passage2);
            assertFalse(story.getPassages().isEmpty());
        }
    }

    @Nested
    @DisplayName("Testing exception handling in the Story class.")
    class ExceptionHandlingTests {
        @Test
        @DisplayName("Testing the exception thrown for title in the constructor of the Story class.")
        void exceptionHandlingTitleTest() {
            assertThrows(IllegalArgumentException.class, () -> new Story("", new Passage("Sky", "Big")));
        }

        @Test
        @DisplayName("Testing the exception thrown for opening passage in the constructor of the Story class.")
        void exceptionHandlingOpeningPassageTest() {
            assertThrows(IllegalArgumentException.class, () -> new Story("Ground", null));
        }
        @Test
        @DisplayName("Testing the exception thrown when inserting an invalid parameter in the get passage method.")
        void exceptionHandlingGetPassageTest() {
            assertThrows(IllegalArgumentException.class, () -> story.getPassage(null));
        }

        @Test
        @DisplayName("Testing the exception thrown when inserting an invalid parameter in the add passage method.")
        void exceptionHandlingAddPassageTest() {
            assertThrows(IllegalArgumentException.class, () -> story.addPassage(null));
        }
    }
}

