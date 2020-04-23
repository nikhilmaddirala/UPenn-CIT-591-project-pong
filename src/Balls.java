import java.util.ArrayList;

/**
 * This class models a collection of balls.
 */
public class Balls {

    // ================================================================================
    // Variables
    // ================================================================================
    private ArrayList<Ball> balls;
    private int numberOfBalls;

    // ================================================================================
    // Constructors
    // ================================================================================
    public Balls() {
        this.balls = new ArrayList<Ball>();
        balls.add(new Ball());
    }

    // ================================================================================
    // Methods
    // ================================================================================

    /**
     * Get array list of balls.
     * 
     * @return balls.
     */
    public ArrayList<Ball> getBalls() {
        return this.balls;
    }

    /**
     * Check all balls for bounce.
     */
    public void checkForBounce() {
        for (Ball ball : this.balls) {
            ball.checkForBounce();
        }
    }

    /**
     * Update position of all balls.
     * 
     * @param dt time interval.
     */
    public void updatePosition(double dt) {
        for (Ball ball : this.balls) {
            ball.updatePosition(dt);
        }
    }

    /**
     * Draw all balls.
     */
    public void draw() {
        for (Ball ball : this.balls) {
            ball.draw();
        }
    }

    /**
     * Reset all balls
     */
    public void reset() {
        for (Ball ball : this.balls) {
            ball.reset();
        }
    }

    /**
     * Add ball to collection.
     */
    public void addBall() {
        balls.add(new Ball());
    }

    /**
     * Remove ball from balls.
     * 
     * @param ball Ball to be removed.
     */
    public void removeBall(Ball ball) {
        balls.remove(ball);
    }

}