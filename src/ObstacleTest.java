import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ObstacleTest {

    /**
     * Test that checkForTrigger correctly checks for trigger.
     */
    @Test
    public void checkForTrigger() {
        Ball ball = new Ball();
        Obstacle obstacle = new Obstacle(250, 250);
        assertEquals(true, obstacle.checkForTrigger(ball));

        Obstacle obstacle2 = new Obstacle(0, 0);
        assertEquals(false, obstacle2.checkForTrigger(ball));
    }

    /**
     * Test that obstacles are good and bad obstacles are drawn in the right colors
     * respectively.
     */
    @Test
    public void draw() {
        GoodObstacle goodObstacle = new GoodObstacle(Math.random(), Math.random());
        goodObstacle.draw();
        assertEquals(PennDraw.GREEN, PennDraw.getPenColor());

        BadObstacle badObstacle = new BadObstacle(Math.random(), Math.random());
        badObstacle.draw();
        assertEquals(PennDraw.RED, PennDraw.getPenColor());
    }

}