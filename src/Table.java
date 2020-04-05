public class Table {
int width;
int height;
Ball ball;
LeftPaddle leftPaddle;
RightPaddle rightPaddle;
//Score leftPaddleScore;
//Score rightPaddleScore;

    /**
     * Table constructor
     * @param width
     * @param height
     * @param ball
     * @param lp
     * @param rp
     */
    public Table(int width, int height, Ball ball, LeftPaddle lp, RightPaddle rp) {
        this.width = width;
        this.height = height;
        this.ball = ball;
        this.leftPaddle  = lp;
        this.rightPaddle = rp;
//        this.leftPaddleScore = new Score();
//        this.rightPaddleScore = new Score();
    }

    /**
     * Create a table using PennDraw
     */
    public void createTable() {
        PennDraw.setCanvasSize(width, height);
        PennDraw.setScale(0, height);
        PennDraw.enableAnimation(60);
    }

    /**
     * Set up initial game state
     */
    public void initGame() {
        createTable();

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

    /**
     * Increment and decrement left and right paddle scores during game play
     */
    public void adjustScore() {

    }

    /**
     * Get the left paddle score
     * @return int
     */
//    public int getLeftPaddleScore() {
//        return leftPaddleScore.currentScore();
//    }

    /**
     * Get the right paddle score
     * @return int
     */
//    public int getRightPaddleScore() {
//        return rightPaddleScore.currentScore();
//    }
}
