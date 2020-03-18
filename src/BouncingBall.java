

import java.util.ArrayList;

public class BouncingBall {
	
	public static void main(String[] args) {
		PennDraw.setCanvasSize(500, 500);
		PennDraw.setScale(0, 500);
		PennDraw.enableAnimation(60);
		Ball ball = new Ball(250, 250, 10);
		ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();
		while(true) {
			PennDraw.clear();
			if(PennDraw.mousePressed()) {
				Vector2 mousePos = new Vector2(PennDraw.mouseX(), PennDraw.mouseY());
				Obstacle newObst = new Obstacle(mousePos.x, mousePos.y, 50);
				obstacles.add(newObst);
			}
			ball.checkForBounce(obstacles);
			ball.updatePosition(0.167);
			ball.draw();
			for(Obstacle o : obstacles) {
				o.draw();
			}
			PennDraw.advance();
		}
	}

}
