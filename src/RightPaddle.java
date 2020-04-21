import java.awt.event.KeyEvent;

/**
 * This class models the right paddle of the game for Player 1.
 *
 */
public class RightPaddle extends Paddle {
	// ================================================================================
	// Variables
	// ================================================================================

	// ================================================================================
	// Constructors
	// ================================================================================
	public RightPaddle() {
		super();
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
	public void updatePosition(double dt) {
		if (PennDraw.isKeyPressed(KeyEvent.VK_UP) && (this.position.y + this.halfHeight <= Pong.HEIGHT)) {
			Vector2 upVelocity = new Vector2(0, this.speed);
			this.position = this.position.plus(upVelocity.times(dt));
		}
		if (PennDraw.isKeyPressed(KeyEvent.VK_DOWN) && (this.position.y - this.halfHeight >= 0)) {
			Vector2 downVelocity = new Vector2(0, (-1) * this.speed);
			this.position = this.position.plus(downVelocity.times(dt));
		}

	}
}
