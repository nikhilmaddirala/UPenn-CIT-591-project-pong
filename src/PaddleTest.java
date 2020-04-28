import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PaddleTest {

    /**
     * Tests the bounce trigger method.
     */
    @Test
    public void bounceTriggerTest() {
        Ball ball = new Ball();

        LeftPaddle leftPaddle = new LeftPaddle();
        assertEquals(false, leftPaddle.bounceTrigger(ball));

        RightPaddle rightPaddle = new RightPaddle();
        assertEquals(false, leftPaddle.bounceTrigger(ball));

    }

    /**
     * Test that the paddle is correctly initialized at the correct positions.
     */
    @Test
    public void initTest() {

        LeftPaddle leftPaddle = new LeftPaddle();
        assertEquals(10, leftPaddle.position.x);
        assertEquals(250, leftPaddle.position.y);

        RightPaddle rightPaddle = new RightPaddle();
        assertEquals(490, rightPaddle.position.x);
        assertEquals(250, rightPaddle.position.y);

    }

}