
import java.util.ArrayList;

/**
 * This class models a ball with a position and velocity.
 *
 */
public class Ball {
	// ================================================================================
	// Variables
	// ================================================================================
	Vector2 position;
	Vector2 velocity;

	// ================================================================================
	// Constructors
	// ================================================================================
	public Ball(double x, double y, double speed) {
		this.position = new Vector2(x, y);
		this.velocity = new Vector2(Math.random(), Math.random());
		this.velocity = this.velocity.times(2.0);
		this.velocity = this.velocity.minus(new Vector2(1.0, 1.0));
		this.velocity = this.velocity.normalized();
		this.velocity = this.velocity.times(speed);
	}

	// ================================================================================
	// Methods
	// ================================================================================
	/**
	 * This method updates the position of the ball based on time elapsed.
	 * @param dt The amount of time elapsed.
	 */
	public void updatePosition(double dt) {
		this.position = this.position.plus(this.velocity.times(dt));
	}

	/**
	 * This method checks for obstacles or walls updates the velocity of the ball accordingly.
	 * @param obstacles
	 */
	public void checkForBounce(ArrayList<Obstacle> obstacles) {
		if (position.x <= 20.0 || position.x >= 480.0) {
			this.velocity = new Vector2(-this.velocity.x, this.velocity.y);
		}
		if (position.y <= 20.0 || position.y >= 480.0) {
			this.velocity = new Vector2(this.velocity.x, -this.velocity.y);
		}
		for (Obstacle o : obstacles) {
			double radiusSum = 20 + o.radius; // 20 is the ball's hard-coded radius
			double distToObstacle = this.position.distanceTo(o.pos);
			if (distToObstacle < radiusSum) {
				Vector2 awayFromObstacleCenter = this.position.minus(o.pos);
				awayFromObstacleCenter = awayFromObstacleCenter.normalized();
				this.velocity = this.velocity.reflect(awayFromObstacleCenter);
				awayFromObstacleCenter = awayFromObstacleCenter.times(radiusSum - distToObstacle);
				this.position = this.position.plus(awayFromObstacleCenter);
			}
		}
	}
	
	/**
	 * This method checks whether the ball should bounce off a paddle.
	 * @param leftPaddle
	 * @param rightPaddle
	 */
	public void checkForBounce(LeftPaddle leftPaddle, RightPaddle rightPaddle) {
		if (this.position.x - leftPaddle.position.x <= 30 || rightPaddle.position.x - this.position.x <= 30) {
			this.velocity = new Vector2(-this.velocity.x, this.velocity.y);
		}
	}

	/**
	 * This method draws the ball.
	 */
	public void draw() {
		PennDraw.setPenColor(PennDraw.RED);
		PennDraw.filledCircle(position.x, position.y, 20);
	}

}
