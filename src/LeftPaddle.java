import java.awt.event.KeyEvent;

/**
 * This class models the left paddle of the game for Player 2.
 *
 */
public class LeftPaddle extends Paddle {
	// ================================================================================
	// Variables
	// ================================================================================
	public static final String OWNER = Level.getMode() == Level.SINGLE_PLAYER ? "Computer" : "Player 2";
	// ================================================================================
	// Constructors
	// ================================================================================
	public LeftPaddle() {
		super();
	}

	// ================================================================================
	// Methods
	// ================================================================================
	/**
	 * This method updates the position of the paddle based on user's keyboard input
	 * (in two player mode) or based on the computer logic (in one player mode).
	 * 
	 * @param dt
	 * @param ball
	 */
	public void updatePosition(double dt, Ball ball) {
		if (Level.getMode() == Level.SINGLE_PLAYER) {
			if (ball.getPosition().y > this.position.y && (this.position.y + this.halfHeight <= Pong.HEIGHT)) {
				Vector2 upVelocity = new Vector2(0, this.speed);
				this.position = this.position.plus(upVelocity.times(dt));
			}
			if (ball.getPosition().y < this.position.y && (this.position.y - this.halfHeight >= 0)) {
				Vector2 downVelocity = new Vector2(0, (-1) * this.speed);
				this.position = this.position.plus(downVelocity.times(dt));
			}
		} else {
			if (PennDraw.isKeyPressed(KeyEvent.VK_W) && (this.position.y + this.halfHeight <= Pong.HEIGHT)) {
				Vector2 upVelocity = new Vector2(0, this.speed);
				this.position = this.position.plus(upVelocity.times(dt));
			}
			if (PennDraw.isKeyPressed(KeyEvent.VK_S) && (this.position.y - this.halfHeight >= 0)) {
				Vector2 downVelocity = new Vector2(0, (-1) * this.speed);
				this.position = this.position.plus(downVelocity.times(dt));
			}

		}

	}

	/**
	 * Same as the updatePosition(double dt, Ball ball) method, but for multiple
	 * balls. Computer logic follows an arbitrary ball.
	 * 
	 * @param dt
	 * @param balls
	 */
	public void updatePosition(double dt, Balls balls) {
		Ball ball = balls.getBalls().get(0);
		this.updatePosition(dt, ball);
	}

}
