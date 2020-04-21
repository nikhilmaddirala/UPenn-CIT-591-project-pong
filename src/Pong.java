import java.util.ArrayList;

import javax.swing.*;

/**
 * Pong is where the initial game state is set up and subsequently tracked during game play.
 */
public class Pong extends SwingWorker {
    public static final int WIDTH = 500;
    public static final int HEIGHT = 500;

    private Score leftScore;
    private Score rightScore;

    private Balls balls;
    
    private LeftPaddle leftPaddle;
    private RightPaddle rightPaddle;
    private Obstacles obstacles;

    /**
     * Pong constructor
     */
    public Pong() {
        leftScore = new Score();
        rightScore = new Score();

        balls = new Balls();
        leftPaddle = new LeftPaddle();
        rightPaddle = new RightPaddle();

        obstacles = new Obstacles();
    }

    /**
     * Use PennDraw to create Pong frame
     */
    private void createFrame() {
        PennDraw.setCanvasSize(Pong.WIDTH, Pong.HEIGHT);
        PennDraw.setScale(0, Pong.HEIGHT);
        PennDraw.enableAnimation(60);
    }

    /**
     * Start game
     */
    private void initGame() {

        while(true) {
            PennDraw.clear();

            leftScore.writeToScreen(new Vector2(20, 480));
            rightScore.writeToScreen(new Vector2(480, 480));

            balls.checkForBounce();
            leftPaddle.checkForBounce(balls);
            rightPaddle.checkForBounce(balls);
            balls.updatePosition(0.167);
            balls.draw();
            
            obstacles.draw();
            obstacles.triggerEvent(balls);

            leftPaddle.updatePosition(0.167, balls);
            leftPaddle.draw();

            rightPaddle.updatePosition(0.167);
            rightPaddle.draw();

            updateScore();

            PennDraw.advance();
        }

    }

    /**
     * Create game JFrame on a background thread
     * @return null
     */
    @Override
    public Object doInBackground() {
        createFrame();
        initGame();
        return null;
    }

    /**
     * Increment left and right paddle scores during game play
     */
    private void updateScore() {
        for (Ball ball : this.balls.balls){
            Vector2 position = ball.getPosition();

            if (position.x <= 0) {
                rightScore.addPoint();
                reset();
            } else if (position.x >= 500) {
                leftScore.addPoint();
                reset();
            }
                
        }

    }

    /**
     * Reset the ball and paddle positions to their initial values
     */
    private void reset() {
        balls.reset();
        leftPaddle.reset();
        rightPaddle.reset();
    }

    private void endGame() {
        new EndFrame();
        PennDraw.hide();
    }

    /**
     * Determine game winner
     * @return
     */
    public static String getWinner() {
        return "";
    }

    /**
     * Calculate high score for the game
     * @return
     */
    public static int getHighScore() {
        return 0;
    }
}
