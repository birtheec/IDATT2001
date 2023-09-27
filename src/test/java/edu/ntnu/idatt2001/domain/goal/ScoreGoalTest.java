package edu.ntnu.idatt2001.domain.goal;

import edu.ntnu.idatt2001.domain.Player;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class ScoreGoalTest {

    static ScoreGoal scoreGoal;
    static Player player;

    @BeforeEach
    void setUp() {
        player = new Player("Mario", 10, 55, 10);
    }

    @Nested
    @DisplayName("Testing the is fulfilled method with the score goal.")
    class IsScoreGoalFulfilledTests {
        @Test
        @DisplayName("Testing if the method returns true when score goal is fulfilled.")
        void isFulfilledTest() {
            scoreGoal = new ScoreGoal(50);
            assertTrue(scoreGoal.isFulfilled(player));
        }

        @Test
        @DisplayName("Testing if the method returns false when score goal is not fulfilled.")
        void isNotFulfilledTest() {
            scoreGoal = new ScoreGoal(100);
            assertFalse(scoreGoal.isFulfilled(player));
        }
    }
}