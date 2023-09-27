package edu.ntnu.idatt2001.domain;

import edu.ntnu.idatt2001.domain.action.GoldAction;
import edu.ntnu.idatt2001.domain.action.HealthAction;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class LinkTest {

    static Link link;
    static GoldAction goldAction;
    static HealthAction healthAction;

    @BeforeEach
    void setUp() {
        link = new Link("Go up", "Green forrest");
        goldAction = new GoldAction(10);
        healthAction = new HealthAction(20);
    }

    @Nested
    @DisplayName("Testing the accessor methods of the Link class.")
    class AccessorMethodTests {
        @Test
        @DisplayName("Testing accessing the link's text.")
        void getTextTest() {
            assertEquals("Go up", link.getText());
        }

        @Test
        @DisplayName("Testing accessing the link's reference.")
        void getReferenceTest() {
            assertEquals("Green forrest", link.getReference());
        }

        @Test
        @DisplayName("Testing accessing the link's actions.")
        void getActionsTest() {
            assertTrue(link.getActions().isEmpty());
        }
    }

    @Nested
    @DisplayName("Testing if the methods of the Link class work properly.")
    class MethodTests {
        @Test
        @DisplayName("Testing method for add action, by the size of the list.")
        void checkIfItemsAreAddedTest() {
            link.addAction(goldAction);
            link.addAction(healthAction);
            assertEquals(2, link.getActions().size());
        }

        @Test
        @DisplayName("Testing method for add action, by the index of the list.")
        void checkIfCorrectItemsAreAdded() {
            link.addAction(goldAction);
            link.addAction(healthAction);
            assertEquals(healthAction, link.getActions().get(1));
        }

        @Test
        @DisplayName("Negative test of the add actions method. Adding items to the list, then using assert false to see" +
                "if it is empty.")
        void addActionFalse() {
            link.addAction(goldAction);
            link.addAction(healthAction);
            assertFalse(link.getActions().isEmpty());
        }
    }

    @Nested
    @DisplayName("Testing exception handling in the Link class.")
    class ExceptionHandlingTests {
        @Test
        @DisplayName("Testing the exception thrown for text in the constructor of the Link class.")
        void exceptionHandlingTextTest() {
            assertThrows(IllegalArgumentException.class, () -> new Link("", "Dark forrest"));
        }

        @Test
        @DisplayName("Testing the exception thrown for reference in the constructor of the Link class.")
        void exceptionHandlingReferenceTest() {
            assertThrows(IllegalArgumentException.class, () -> new Link("Jump", ""));
        }

        @Test
        @DisplayName("Testing the exception thrown when inserting an invalid parameter in the add action method.")
        void exceptionHandlingAddActionTest() {
            assertThrows(IllegalArgumentException.class, () -> link.addAction(null));
        }
    }
}