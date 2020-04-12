
public class Obstacle {

	// ================================================================================
	// Variables
	// ================================================================================
	Vector2 position;
	Vector2 velocity;

	// ================================================================================
	// Constructors
	// ================================================================================
	public Obstacle(double x, double y) {
		this.position = new Vector2(x, y);
	}

	// ================================================================================
	// Methods
	// ================================================================================

	/**
	 * This method checks whether the obstacle is triggered based on whether a ball
	 * touches it.
	 * 
	 * @param ball The ball that triggers the obstacle.
	 * @return
	 */
	public boolean checkForTrigger(Ball ball) {
		boolean result = false;

		// todo

		return result;
	}

	/**
	 * This method draws the obstacle. Good obstacles are drawn as green squares and
	 * bad obstacles are drawn as red squares.
	 */
	public void draw() {

		if (this instanceof BadObstacle) {
			PennDraw.setPenColor(PennDraw.RED);
		}

		if (this instanceof GoodObstacle) {
			PennDraw.setPenColor(PennDraw.GREEN);
		}

		PennDraw.filledSquare(position.x, position.y, 10);
	}

}
