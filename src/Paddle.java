
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
	public Paddle() {

		if (this instanceof LeftPaddle) {
			this.initialPosition = new Vector2(10, 250);
			this.position = new Vector2(10, 250);
			this.halfHeight = 50;
			this.halfWidth = 10;
			this.speed = Level.LEFTPADDLESPEED_EASY;
			if (Level.getDifficulty() == Level.MEDIUM) {
				speed = Level.LEFTPADDLESPEED_MEDIUM;
			} else if (Level.getDifficulty() == Level.HARD) {
				speed = Level.LEFTPADDLESPEED_HARD;
			}	
		}

		if (this instanceof RightPaddle) {
			this.initialPosition = new Vector2(490, 250);
			this.position = new Vector2(490, 250);
			this.halfHeight = 50;
			this.halfWidth = 10;
			this.speed = 30;
		}
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
		if (Math.abs(ball.getPosition().x - this.position.x) <= ball.RADIUS + this.halfWidth
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
