import java.awt.event.KeyEvent;

/**
 * This class models the right paddle of the game for Player 2 (or computer player).
 *
 */
public class RightPaddle {
	// ================================================================================
	// Variables
	// ================================================================================
	Vector2 position;
	double halfWidth;
	double halfHeight;
	double speed;

	// ================================================================================
	// Constructors
	// ================================================================================
	public RightPaddle(double x, double y, double speed) {
		this.position = new Vector2(x, y);
		this.halfHeight = 50;
		this.halfWidth = 10;
		this.speed = 20;
	}

	// ================================================================================
	// Methods
	// ================================================================================

	
	/**
	 * This method updates the position of the paddle based on the ball's position.
	 * It simulates a computer player controlling the paddle.
	 * @param dt
	 * @param ball
	 */
	public void updatePosition(double dt, Ball ball) {
		if (ball.position.y > this.position.y) {
			Vector2 upVelocity = new Vector2(0,this.speed);
			this.position = this.position.plus(upVelocity.times(dt));
		}
		if (ball.position.y < this.position.y) {
			Vector2 downVelocity = new Vector2(0,(-1)*this.speed);
			this.position = this.position.plus(downVelocity.times(dt));
		}

	}
	
	/**
	 * This method checks whether the ball should bounce off a paddle.
	 */
	public void checkForBounce(Ball ball) {
		if (this.position.x - ball.position.x <= 20 + this.halfWidth && 
				ball.position.y <= this.position.y + this.halfHeight &&
				ball.position.y >= this.position.y - this.halfHeight) {
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
