
public class Paddle {

	private static final double LEFTX = 10;
	private static final double LEFTY = 250;
	private static final double RIGHTX = 490;
	private static final double RIGHTY = 250;
	private static final double HALF_WIDTH = 10;
	private static final double HALF_HEIGHT = 50;
	private static final double COMPUTER_PLAYER_SPEED = 30;
	public static final int PADDLESPEED_EASY = 10;
	public static final int PADDLESPEED_MEDIUM = 20;
	public static final int PADDLESPEED_HARD = 30;
	public Vector2 initialPosition;
	public Vector2 position;
	public double halfWidth;
	public double halfHeight;
	public double speed;

	public Paddle() {
		halfHeight = HALF_HEIGHT;
		halfWidth = HALF_WIDTH;

		if (this instanceof LeftPaddle) {
			initialPosition = new Vector2(LEFTX, LEFTY);
			position = new Vector2(LEFTX, LEFTY);
			speed = getPaddleSpeed();
		}

		if (this instanceof RightPaddle) {
			initialPosition = new Vector2(RIGHTX, RIGHTY);
			position = new Vector2(RIGHTX, RIGHTY);
			speed = Level.getMode() == Level.SINGLE_PLAYER ? COMPUTER_PLAYER_SPEED : getPaddleSpeed();
		}
	}

	/**
	 * This method checks whether a ball should bounce off the paddle.
	 * 
	 * @param ball The ball to be checked.
	 */
	public void checkForBounce(Ball ball) {
		if (Math.abs(ball.getPosition().x - this.position.x) <= ball.RADIUS + this.halfWidth
				&& ball.getPosition().y <= this.position.y + this.halfHeight
				&& ball.getPosition().y >= this.position.y - this.halfHeight) {

			if ((this instanceof LeftPaddle && ball.getVelocity().x < 0)
					|| (this instanceof RightPaddle && ball.getVelocity().x > 0)) {
				SoundEffect.blip();
				Vector2 newBallVelocity = new Vector2(-ball.getVelocity().x, ball.getVelocity().y);
				ball.setVelocity(newBallVelocity);
			}
		}
	}

	/**
	 * This method checks bounce for all balls in a collection of balls.
	 * 
	 * @param balls
	 */
	public void checkForBounce(Balls balls) {
		for (Ball ball : balls.getBalls()) {
			checkForBounce(ball);
		}
	}

	/**
	 * This method draws the paddle.
	 */
	public void draw() {
		PennDraw.setPenColor(PennDraw.BLACK);
		PennDraw.filledRectangle(this.position.x, this.position.y, this.halfWidth, this.halfHeight);
	}

	/**
	 * This method resets the paddle position.
	 */
	public void reset() {
		position = new Vector2(initialPosition.x, initialPosition.y);
	}

	/**
	 * Determines the paddle speed based on the level of game difficulty
	 * 
	 * @return double speed
	 */
	private double getPaddleSpeed() {
		if (Level.getDifficulty() == Level.EASY) {
			return PADDLESPEED_EASY;
		} else if (Level.getDifficulty() == Level.MEDIUM) {
			return PADDLESPEED_MEDIUM;
		}
		return PADDLESPEED_HARD;
	}

}
