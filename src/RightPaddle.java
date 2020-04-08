import java.awt.event.KeyEvent;

/**
 * This class models the right paddle of the game for Player 2 (or computer
 * player).
 *
 */
public class RightPaddle extends Paddle {
	// ================================================================================
	// Variables
	// ================================================================================

	// ================================================================================
	// Constructors
	// ================================================================================
	public RightPaddle(double x, double y, double speed) {
		super(x, y, speed);
	}

	// ================================================================================
	// Methods
	// ================================================================================

	/**
	 * This method updates the position of the paddle based on the ball's position.
	 * It simulates a computer player controlling the paddle.
	 * 
	 * @param dt
	 * @param ball
	 */
	public void updatePosition(double dt, Ball ball) {
		if (ball.position.y > this.position.y) {
			Vector2 upVelocity = new Vector2(0, this.speed);
			this.position = this.position.plus(upVelocity.times(dt));
		}
		if (ball.position.y < this.position.y) {
			Vector2 downVelocity = new Vector2(0, (-1) * this.speed);
			this.position = this.position.plus(downVelocity.times(dt));
		}

		// todo - check for edge of table

	}

}
