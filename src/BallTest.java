import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BallTest {

    /**
     * Test that updatePosition changes the x and y position of the ball instance when called
     */
    @Test
    void updatePosition() {
        Ball ball = new Ball();

        assertEquals(ball.getPosition().x, 250);
        assertEquals(ball.getPosition().y, 250);

        ball.updatePosition(0.167);

        assertNotEquals(ball.getPosition().x, 250);
        assertNotEquals(ball.getPosition().y, 250);
    }

    /**
     * Test that ball returns to initial position after reset is called
     */
    @Test
    void reset() {
        Ball ball = new Ball();
        assertEquals(ball.getPosition().x, 250);
        assertEquals(ball.getPosition().y, 250);

        ball.updatePosition(0.167);

        assertNotEquals(ball.getPosition().x, 250);
        assertNotEquals(ball.getPosition().y, 250);

        ball.reset();

        assertEquals(ball.getPosition().x, 250);
        assertEquals(ball.getPosition().y, 250);
    }
}