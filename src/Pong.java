

/**
 * This class runs the game.
 *
 */
public class Pong {

	// May be a good idea to just have table handle table stuff and use Pong to combine everything and then have a PongRunner class
	// Something awkward about having a table.initGame method
	
	public static void main(String[] args) {
		Ball ball = new Ball(250, 250, 25);
		LeftPaddle leftPaddle = new LeftPaddle(10, 250, 10);
		RightPaddle rightPaddle = new RightPaddle(490, 250, 10);
		Table table = new Table(500, 500, ball, leftPaddle, rightPaddle);

		table.initGame();
	}

}
