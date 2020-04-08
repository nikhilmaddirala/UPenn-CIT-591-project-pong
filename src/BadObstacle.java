
public class BadObstacle extends Obstacle {

	// ================================================================================
	// Variables
	// ================================================================================

	// ================================================================================
	// Constructors
	// ================================================================================
	public BadObstacle(double x, double y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	// ================================================================================
	// Methods
	// ================================================================================
	/**
	 * This method triggers a new ball based on the result of checkForTrigger.
	 * 
	 * @param checkForTrigger
	 */
	public void triggerEvent(boolean checkForTrigger) {

	}

	/**
	 * This method draws the bad obstacle.
	 */
	public void draw() {
		PennDraw.setPenColor(PennDraw.RED);
		PennDraw.filledCircle(position.x, position.y, 20);
		// todo - change shape from circle to something else
	}

}
