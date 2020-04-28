import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ObstaclesTest {

    /**
     * Test that the number of obstacles is right for the difficulty level.
     */
    @Test
    public void countObstacles() {
        Level.setDifficulty(1);
        Obstacles obstacles1 = new Obstacles();
        assertEquals(0, obstacles1.obstacles.size());

        Level.setDifficulty(2);
        Obstacles obstacles2 = new Obstacles();
        assertEquals(6, obstacles2.obstacles.size());

        Level.setDifficulty(3);
        Obstacles obstacles3 = new Obstacles();
        assertEquals(2, obstacles3.obstacles.size());

    }

    /**
     * Test that obstacle is disappearing after getting triggered by ball. Start
     * with one obstacle and then trigger it with a ball, resulting in zero
     * obstacles at the end.
     */
    @Test
    public void triggerEvent() {
        Balls balls = new Balls();
        Obstacle obstacle = new Obstacle(250, 250);
        Obstacles obstacles = new Obstacles(obstacle);

        assertEquals(1, obstacles.obstacles.size());

        obstacles.triggerEvent(balls);

        assertEquals(0, obstacles.obstacles.size());

    }

}