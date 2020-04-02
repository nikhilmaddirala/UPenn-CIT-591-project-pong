import java.awt.event.KeyEvent;

/**
 * This class models the left paddle of the game for Player 1.
 *
 */
public class LeftPaddle {
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
	 * This method updates the position of the paddle based on user's keyboard input.
	 * Up arrow makes the paddle go up and down arrow makes it go down.
	 * @param dt
	 */
	public void updatePosition(double dt) {
		if (PennDraw.isKeyPressed(KeyEvent.VK_UP)) {
			Vector2 upVelocity = new Vector2(0,this.speed);
			this.position = this.position.plus(upVelocity.times(dt));
		}
		if (PennDraw.isKeyPressed(KeyEvent.VK_DOWN)) {
			Vector2 downVelocity = new Vector2(0,(-1)*this.speed);
			this.position = this.position.plus(downVelocity.times(dt));
		}

	}
	
	/**
	 * This method checks whether the ball should bounce off a paddle.
	 */
	public void checkForBounce(Ball ball) {
		if (ball.position.x - this.position.x <= 20 + this.halfWidth && 
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
