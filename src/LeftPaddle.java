import java.awt.event.KeyEvent;

/**
 * This class models the left paddle of the game for Player 1.
 *
 */
public class LeftPaddle extends Paddle {
	// ================================================================================
	// Variables
	// ================================================================================

	// ================================================================================
	// Constructors
	// ================================================================================
	public LeftPaddle(double x, double y, double speed) {
		this.position = new Vector2(x, y);
		this.halfHeight = 50;
		this.halfWidth = 10;
		this.speed = 20;
	}

	// ================================================================================
	// Methods
	// ================================================================================

	/**
	 * This method updates the position of the paddle based on user's keyboard
	 * input. Up arrow makes the paddle go up and down arrow makes it go down.
	 * 
	 * @param dt
	 */
	public void updatePosition(double dt) {
		if (PennDraw.isKeyPressed(KeyEvent.VK_UP)) {
			Vector2 upVelocity = new Vector2(0, this.speed);
			this.position = this.position.plus(upVelocity.times(dt));
		}
		if (PennDraw.isKeyPressed(KeyEvent.VK_DOWN)) {
			Vector2 downVelocity = new Vector2(0, (-1) * this.speed);
			this.position = this.position.plus(downVelocity.times(dt));
		}

		// todo - check for edge of table

	}

}
