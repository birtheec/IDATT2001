package edu.ntnu.idatt2001.domain;

import edu.ntnu.idatt2001.domain.goal.Goal;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    static Game game;
    static Link link;
    static List<Goal> goals;

    @BeforeEach
    void setUp() {
        goals = new ArrayList<>();
        game = new Game(new Player("Kris", 10, 12, 13),
                new Story("Scary forest", new Passage("Level 1", "Deep in the forest")), goals);
        link = new Link("Choice 1", "Hard route");
    }

    @Nested
    @DisplayName("Testing the accessor methods of the Game class.")
    class AccessorMethodTests {
        @Test
        @DisplayName("Testing accessing the game's player's name.")
        void getPlayersNameTest() {
            assertEquals("Kris", game.getPlayer().getName());
        }

        @Test
        @DisplayName("Testing accessing the game's player's health.")
        void getPlayersHealthTest() {
            assertEquals(10, game.getPlayer().getHealth());
        }

        @Test
        @DisplayName("Testing accessing the game's player's score.")
        void getPlayersScoreTest() {
            assertEquals(12, game.getPlayer().getScore());
        }

        @Test
        @DisplayName("Testing accessing the game's player's gold.")
        void getPlayerGoldTest() {
            assertEquals(13, game.getPlayer().getGold());
        }

        @Test
        @DisplayName("Testing accessing the game's story's title.")
        void getStoryTitleTest() {
            assertEquals("Scary forest", game.getStory().getTitle());
        }

        @Test
        @DisplayName("Testing accessing the game's story's passage's title.")
        void getStoryPassagesTitleTest() {
            assertEquals("Level 1", game.getStory().getOpeningPassage().getTitle());
        }

        @Test
        @DisplayName("Testing accessing the game's story's passage's content.")
        void getStoryPassagesContentTest() {
            assertEquals("Deep in the forest", game.getStory().getOpeningPassage().getContent());
        }

        @Test
        @DisplayName("Testing accessing the game's goals. ")
        void getGoalsTest() {
            assertTrue(game.getGoals().isEmpty());
        }
    }

    @Nested
    @DisplayName("Testing if the methods of the Game class work properly.")
    class MethodTests {
        @Test
        @DisplayName("Testing method for begin.")
        void beginTest() {
            assertEquals(game.getStory().getOpeningPassage(), game.begin());
        }

        @Test
        @DisplayName("Testing method for go.")
        void goTest() {
            assertEquals(game.getStory().getPassage(link), game.go(link));
        }
    }

    @Nested
    @DisplayName("Testing exception handling in the Game class.")
    class ExceptionHandlingTests {
        @Test
        @DisplayName("Testing the exception thrown for player in the constructor of the Game class.")
        void exceptionHandlingPlayerTest() {
            assertThrows(IllegalArgumentException.class, () -> new Game(null, new Story("Cave", new Passage("The cave", "Dark")), goals));
        }

        @Test
        @DisplayName("Testing the exception thrown for story in the constructor of the Game class.")
        void exceptionHandlingStoryTest() {
            assertThrows(IllegalArgumentException.class, () -> new Game(new Player("Mario",10,12,20), null, goals));
        }

        @Test
        @DisplayName("Testing the exception thrown for goals in the constructor of the Game class.")
        void exceptionHandlingGoalsTest() {
            assertThrows(IllegalArgumentException.class, () -> new Game(new Player("Mario",10,12,20), new Story("Cave", new Passage("The cave", "Dark")), null));
        }

        @Test
        @DisplayName("Testing the exception thrown when inserting an invalid parameter in the go method.")
        void exceptionHandlingGoTest() {
            assertThrows(IllegalArgumentException.class, () -> game.go(null));
        }
    }
}