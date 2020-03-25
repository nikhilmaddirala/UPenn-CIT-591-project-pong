

/**
 * This class runs the game.
 *
 */
public class Pong {
	
	public static void main(String[] args) {
		PennDraw.setCanvasSize(500, 500);
		PennDraw.setScale(0, 500);
		PennDraw.enableAnimation(60);
		Ball ball = new Ball(0, 250, 30);
		LeftPaddle leftPaddle = new LeftPaddle(10, 250, 10);
		PennDraw.setFontSize(28.0);
		PennDraw.setPenColor();

		while(true) {
			PennDraw.clear();
			PennDraw.textLeft(20, 480, "0");
			PennDraw.textRight(480, 480, "0");

			ball.checkForBounce();
//			ball.updatePosition(0.167);
			ball.draw();
			PennDraw.setPenColor();

			leftPaddle.draw();

			PennDraw.advance();
		}

	}

}
