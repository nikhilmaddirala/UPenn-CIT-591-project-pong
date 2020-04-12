
public class Paddle {

	// ================================================================================
	// Variables
	// ================================================================================
	Vector2 initialPosition;
	Vector2 position;
	double halfWidth;
	double halfHeight;
	double speed;

	// ================================================================================
	// Constructors
	// ================================================================================
	public Paddle(double x, double y, double speed) {
		this.initialPosition = new Vector2(x, y);
		this.position = new Vector2(x, y);
		this.halfHeight = 50;
		this.halfWidth = 10;
		this.speed = 20;
	}

	// ================================================================================
	// Methods
	// ================================================================================
	/**
	 * This method checks whether a ball should bounce off the paddle.
	 * 
	 * @param ball The ball to be checked.
	 */
	public void checkForBounce(Ball ball) {
		if (Math.abs(ball.getPosition().x - this.position.x) <= 20 + this.halfWidth
				&& ball.getPosition().y <= this.position.y + this.halfHeight
				&& ball.getPosition().y >= this.position.y - this.halfHeight) {
			Vector2 newBallVelocity = new Vector2(-ball.getVelocity().x, ball.getVelocity().y);
			ball.setVelocity(newBallVelocity);
		}
	}

	/**
	 * This method draws the paddle.
	 */
	public void draw() {
		PennDraw.setPenColor(PennDraw.BLACK);
		PennDraw.filledRectangle(this.position.x, this.position.y, this.halfWidth, this.halfHeight);
	}

	public void reset() {
		position = new Vector2(initialPosition.x, initialPosition.y);
	}

}
