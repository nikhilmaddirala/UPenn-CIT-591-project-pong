import javax.swing.*;

/**
 * Table is where the initial game state is set up and subsequently tracked during game play.
 */
public class Table extends SwingWorker {

   private int difficulty;
   private int mode;

   private int leftScore;
   private int rightScore;

   private Ball ball;
   private LeftPaddle leftPaddle;
   private RightPaddle rightPaddle;

    /**
     * Table constructor
     * @param difficulty
     * @param mode
     */
    public Table(int difficulty, int mode) {
        this.difficulty = difficulty;
        this.mode = mode;
        leftScore = 0;
        rightScore = 0;
        ball = getBallByLevel();
        leftPaddle = getLeftPaddleByLevel();
        rightPaddle = getRightPaddleByLevel();


        // TODO: Incorporate Obstacles

    }

    @Override
    public Object doInBackground() {
        createTable();
        initGame();
        return null;
    }

    /**
     * Get Ball class based on level (difficulty and mode)
     * @return Ball
     */
    private Ball getBallByLevel() {
        Ball ball;

        // difficulty is 1, 2, or 3; mode is 1 or 2
        if (difficulty == 1 && mode == 1) {
            // make me ball
        } else if (difficulty == 1 && mode == 2) {
            // ...
        } else if (difficulty == 2 && mode == 1) {
            // ...
        } else if (difficulty == 2 && mode == 2) {
            // ...
        } else if (difficulty == 3 && mode == 1) {
            // ...
        } else {
            // ... (diff 3 and mode 2 case)
        }

        // return ball, below if to prevent compile error
        return new Ball(250, 250, 25);
    }

    /**
     * Get LeftPaddle class based on level
     * @return LeftPaddle
     */
    private LeftPaddle getLeftPaddleByLevel() {
        LeftPaddle lp;

        // difficulty is 1, 2, or 3; mode is 1 or 2
        if (difficulty == 1 && mode == 1) {
            // make me ball
        } else if (difficulty == 1 && mode == 2) {
            // ...
        } else if (difficulty == 2 && mode == 1) {
            // ...
        } else if (difficulty == 2 && mode == 2) {
            // ...
        } else if (difficulty == 3 && mode == 1) {
            // ...
        } else {
            // ... (diff 3 and mode 2 case)
        }

        // return lp, below if to prevent compile error
        return new LeftPaddle(10, 250, 10);
    }

    /**
     * Get RightPaddle class based on level
     * @return RightPaddle
     */
    private RightPaddle getRightPaddleByLevel() {
        RightPaddle rp;

        // difficulty is 1, 2, or 3; mode is 1 or 2
        if (difficulty == 1 && mode == 1) {
            // make me ball
        } else if (difficulty == 1 && mode == 2) {
            // ...
        } else if (difficulty == 2 && mode == 1) {
            // ...
        } else if (difficulty == 2 && mode == 2) {
            // ...
        } else if (difficulty == 3 && mode == 1) {
            // ...
        } else {
            // ... (diff 3 and mode 2 case)
        }

        // return rp, below if to prevent compile error
        return new RightPaddle(490, 250, 10);
    }


    /**
     * Use PennDraw to create Table frame
     */
    private void createTable() {
        PennDraw.setCanvasSize(Pong.WIDTH, Pong.HEIGHT);
        PennDraw.setScale(0, Pong.HEIGHT);
        PennDraw.enableAnimation(60);
    }

    /**
     * Launch game UI with initial state
     */
    private void initGame() {

        while(true) {
            PennDraw.clear();

            writeScore(20, 480, leftScore);
            writeScore(480, 480, rightScore);

            ball.checkForBounce();
            leftPaddle.checkForBounce(ball);
            rightPaddle.checkForBounce(ball);
            ball.updatePosition(0.167);
            ball.draw();

            leftPaddle.updatePosition(0.167);
            leftPaddle.draw();

            rightPaddle.updatePosition(0.167, ball);
            rightPaddle.draw();

            updateScore();

            PennDraw.advance();
        }

    }

    /**
     * Increment and decrement left and right paddle scores during game play
     */
    private void updateScore() {
        Vector2 position = ball.getPosition();

        if (position.x <= 0) {
            rightScore++;
            reset();
        } else if (position.x >= 500) {
            leftScore++;
            reset();
        }
    }

    /**
     * Write the current score to the table frame
     */
    private void writeScore(double x, double y, int score) {
        PennDraw.setFont("Courier", 30);
        PennDraw.text(x, y, Integer.toString(score));
    }

    /**
     * Reset the ball and paddle positions after a player scores
     */
    private void reset() {
        ball.reset();
        leftPaddle.reset();
        rightPaddle.reset();
    }
}
