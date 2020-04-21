import java.util.ArrayList;

public class Balls {
    public ArrayList<Ball> balls;
    private int numberOfBalls;

    public Balls() {
        this.balls = new ArrayList<Ball>();
        balls.add(new Ball());
    }

    public void checkForBounce() {
        for (Ball ball : this.balls){
            ball.checkForBounce();
        }
    }

	public void updatePosition(double dt) {
        for (Ball ball : this.balls){
            ball.updatePosition(dt);
        }
	}

    public void draw() {
        for (Ball ball : this.balls){
            ball.draw();
        }
    }

    public void reset() {
        for (Ball ball : this.balls){
            ball.reset();
        }
    }

    public void addBall(){
        balls.add(new Ball());        
    }

    public void removeBall(Ball ball){
        balls.remove(ball);
    }

}