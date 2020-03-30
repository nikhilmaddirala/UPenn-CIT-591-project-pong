

/**
 * This class runs the game.
 *
 */
public class Pong {
	
	public static void main(String[] args) {
		PennDraw.setCanvasSize(500, 500);
		PennDraw.setScale(0, 500);
		PennDraw.enableAnimation(60);

		Ball ball = new Ball(250, 250, 10);

		LeftPaddle leftPaddle = new LeftPaddle(10, 250, 10);

		while(true) {
			PennDraw.clear();

			ball.checkForBounce();
			ball.updatePosition(0.167);
			ball.draw();
			
			leftPaddle.draw();

			PennDraw.advance();
		}
	}

}
