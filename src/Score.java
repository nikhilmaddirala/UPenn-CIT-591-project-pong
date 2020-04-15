public class Score {
    private int currentScore;

    /**
     * Constructor
     */
    Score() {
        currentScore = 0;
    }


    /**
     * Adds a point
     */
    public void addPoint() {
        currentScore++;
    }

    /**
     * Subtracts a point
     */
    public void subtractPoint() {
        currentScore--;
    }

    /**
     * Gets the current score
     * @return current score
     */
    public int getCurrentScore() {
        return currentScore;
    }

    public void writeToScreen(Vector2 position) {
        PennDraw.setFont("Courier", 30);
        PennDraw.text(position.x, position.y, Integer.toString(currentScore));
    }
}
