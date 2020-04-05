
public class Paddle {

	// ================================================================================
	// Variables
	// ================================================================================
	Vector2 position;
	double halfWidth;
	double halfHeight;
	double speed;

	// ================================================================================
	// Methods
	// ================================================================================
	/**
	 * This method checks whether a ball should bounce off the paddle.
	 * 
	 * @param ball The ball to be checked.
	 */
	public void checkForBounce(Ball ball) {
		if (Math.abs(ball.position.x - this.position.x) <= 20 + this.halfWidth
				&& ball.position.y <= this.position.y + this.halfHeight
				&& ball.position.y >= this.position.y - this.halfHeight) {
			Vector2 newBallVelocity = new Vector2(-ball.velocity.x, ball.velocity.y);
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

}
