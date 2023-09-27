package edu.ntnu.idatt2001.domain.goal;

import edu.ntnu.idatt2001.domain.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HealthGoalTest {

    static HealthGoal healthGoal;
    static Player player;

    @BeforeEach
    void setUp() {
        player = new Player("Mari", 110, 10, 10);
    }

    @Nested
    @DisplayName("Testing the is fulfilled method with the health goal.")
    class IsHealthGoalFulfilledTests {
        @Test
        @DisplayName("Testing if the method returns true when health goal is fulfilled.")
        void isFulfilledTest() {
            healthGoal = new HealthGoal(100);
            assertTrue(healthGoal.isFulfilled(player));
        }

        @Test
        @DisplayName("Testing if the method returns false when the health goal is not fulfilled.")
        void isNotFulfilledTest() {
            healthGoal = new HealthGoal(120);
            assertFalse(healthGoal.isFulfilled(player));
        }
    }
}