
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
		this.velocity = new Vector2(250, 0); // initialize ball to move horizontally
		this.velocity = this.velocity.normalized();
		this.velocity = this.velocity.times(speed); // todo - for reset, using negative speed will move ball in opposite direction
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
	 */
	public void checkForBounce() {
		if (position.x <= 20.0 || position.x >= 480.0) {
			this.velocity = new Vector2(-this.velocity.x, this.velocity.y);
		}
		if (position.y <= 20.0 || position.y >= 480.0) {
			this.velocity = new Vector2(this.velocity.x, -this.velocity.y);
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
