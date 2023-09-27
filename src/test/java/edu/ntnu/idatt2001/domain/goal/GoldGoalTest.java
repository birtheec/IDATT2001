package edu.ntnu.idatt2001.domain.goal;

import edu.ntnu.idatt2001.domain.Player;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class GoldGoalTest {

    static GoldGoal goldGoal;
    static Player player;

    @BeforeEach
    void setUp() {
        player = new Player("Marion", 10, 10, 201);
    }

    @Nested
    @DisplayName("Testing the is fulfilled method with the gold goal.")
    class IsGoldGoalFulfilledTests {
        @Test
        @DisplayName("Testing if the method returns true when gold goal is fulfilled.")
        void isFulfilledTest() {
            goldGoal = new GoldGoal(200);
            assertTrue(goldGoal.isFulfilled(player));
        }

        @Test
        @DisplayName("Testing if the method returns false when gold goal is not fulfilled.")
        void isNotFulfilledTest() {
            goldGoal = new GoldGoal(210);
            assertFalse(goldGoal.isFulfilled(player));
        }
    }
}