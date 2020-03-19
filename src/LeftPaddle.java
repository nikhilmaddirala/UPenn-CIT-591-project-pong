
/**
 * This class models the left paddle of the game.
 *
 */
public class LeftPaddle {
	// ================================================================================
	// Variables
	// ================================================================================
	Vector2 position;
	Vector2 velocity;
	double x;
	double y;
	double halfWidth = 10; 
	double halfHeight = 50;

	// ================================================================================
	// Constructors
	// ================================================================================
	public LeftPaddle(double x, double y, double speed) {
		this.x = x;
		this.y = y;
		this.position = new Vector2(x, y);
		this.velocity = new Vector2(Math.random(), Math.random());
		this.velocity = this.velocity.times(2.0);
		this.velocity = this.velocity.minus(new Vector2(1.0, 1.0));
		this.velocity = this.velocity.normalized();
		this.velocity = this.velocity.times(speed);
	}

	// ================================================================================
	// Methods
	// ================================================================================
	public void draw() {
		PennDraw.setPenColor(PennDraw.BLACK);
//		PennDraw.filledCircle(position.x, position.y, 20);
		PennDraw.filledRectangle(this.x, this.y, this.halfWidth, this.halfHeight);
	}

}
