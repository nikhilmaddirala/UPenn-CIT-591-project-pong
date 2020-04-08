
public class GoodObstacle extends Obstacle {

	// ================================================================================
	// Variables
	// ================================================================================

	// ================================================================================
	// Constructors
	// ================================================================================
	public GoodObstacle(double x, double y) {
		super(x, y);
	}

	// ================================================================================
	// Methods
	// ================================================================================

	/**
	 * This method triggers the removal of a ball based on the result of
	 * checkForTrigger.
	 * 
	 * @param checkForTrigger
	 */
	public void triggerEvent(boolean checkForTrigger) {

	}

	/**
	 * This method draws the good obstacle.
	 */
	public void draw() {
		PennDraw.setPenColor(PennDraw.GREEN);
		PennDraw.filledCircle(position.x, position.y, 20);
		// todo - change shape from circle to something else
	}

}
