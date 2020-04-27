import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BallsTest {

    /**
     * Test ball addition
     */
    @Test
    void addBall() {
        Balls b = new Balls();
        ArrayList<Ball> balls = b.getBalls();

        assertEquals(balls.size(), 1);

        b.addBall();
        b.addBall();

        assertEquals(balls.size(), 3);

    }

    /**
     * Test ball removal
     */
    @Test
    void removeBall() {
        Balls b = new Balls();
        ArrayList<Ball> balls = b.getBalls();

        Ball b1 = new Ball();

        balls.add(b1);

        assertEquals(balls.size(), 2);

        b.addBall();
        b.addBall();

        assertEquals(balls.size(), 4);


        b.removeBall(b1);

        assertEquals(balls.size(), 3);

    }
}