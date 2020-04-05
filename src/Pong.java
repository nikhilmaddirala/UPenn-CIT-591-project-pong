

/**
 * This class runs the game.
 *
 */
public class Pong {
	
	public static void main(String[] args) {
		PennDraw.setCanvasSize(500, 500);
		PennDraw.setScale(0, 500);
		PennDraw.enableAnimation(60);
		Ball ball = new Ball(250, 250, 25);
		LeftPaddle leftPaddle = new LeftPaddle(10, 250, 10);
		RightPaddle rightPaddle = new RightPaddle(490, 250, 10);
		while(true) {
			PennDraw.clear();
			leftPaddle.checkForBounce(ball);
			rightPaddle.checkForBounce(ball);
			ball.updatePosition(0.167);
			ball.draw();
			
			leftPaddle.updatePosition(0.167);
			leftPaddle.draw();
			
			rightPaddle.updatePosition(0.167, ball);
			rightPaddle.draw();

						

			PennDraw.advance();
		}
	}

}
