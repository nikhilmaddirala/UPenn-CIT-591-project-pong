
/**
 * This class models a ball with a position and velocity.
 *
 */
public class Ball {
	// ================================================================================
	// Variables
	// ================================================================================
	public static final int BALLSPEED_EASY = 20;
	public static final int BALLSPEED_MEDIUM = 40;
	public static final int BALLSPEED_HARD = 60;
	private Vector2 initialPosition;
	private Vector2 position;
	private Vector2 velocity;
	public static final double RADIUS = 20;

	// ================================================================================
	// Constructors
	// ================================================================================
	public Ball() {
		double x = 250;
		double y = 250;
		double speed = getBallSpeed();

		this.initialPosition = new Vector2(x, y);
		this.position = new Vector2(x, y);
		double xVelocity = Math.random();
		double yVelocity = xVelocity;
		this.velocity = new Vector2(xVelocity, yVelocity);
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
	 * 
	 * @param dt The amount of time elapsed.
	 */
	public void updatePosition(double dt) {
		this.position = this.position.plus(this.velocity.times(dt));
	}

	/**
	 * This method sets the velocity of the ball.
	 * 
	 * @param velocity Desired velocity of the ball.
	 */
	public void setVelocity(Vector2 velocity) {
		this.velocity = velocity;
	}

	/**
	 * This method checks for top and bottom walls and updates the velocity of the
	 * ball accordingly.
	 */
	public void checkForBounce() {
		if (position.y <= RADIUS || position.y >= 480.0) {
			this.velocity = new Vector2(this.velocity.x, -this.velocity.y);
		}
	}

	/**
	 * This method draws the ball.
	 */
	public void draw() {
		PennDraw.setPenColor(PennDraw.RED);
		PennDraw.filledCircle(position.x, position.y, RADIUS);
	}

	/**
	 * Reset the ball to the position it was initialized to
	 */
	public void reset() {
		position = new Vector2(initialPosition.x, initialPosition.y);

		double speed = getBallSpeed();
		double xVelocity = Math.random();
		double yVelocity = Math.random();
		this.velocity = new Vector2(xVelocity, yVelocity);
		this.velocity = this.velocity.times(2.0);
		this.velocity = this.velocity.minus(new Vector2(1.0, 1.0));
		this.velocity = this.velocity.normalized();
		this.velocity = this.velocity.times(speed);

	}

	/**
	 * Get the current position
	 * 
	 * @return Vector2 - ball position
	 */
	public Vector2 getPosition() {
		return position;
	}

	/**
	 * Get the current velocity
	 * 
	 * @return Vector2 - ball velocity
	 */
	public Vector2 getVelocity() {
		return velocity;
	}

	/**
	 * Determine ball speed based on the game difficulty level
	 * 
	 * @return double speed
	 */
	private double getBallSpeed() {
		if (Level.getDifficulty() == Level.EASY) {
			return BALLSPEED_EASY;
		} else if (Level.getDifficulty() == Level.MEDIUM) {
			return BALLSPEED_MEDIUM;
		}

		return BALLSPEED_HARD;
	}
}
