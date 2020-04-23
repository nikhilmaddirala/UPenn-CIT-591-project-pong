public class Score {
    private int value;

    /**
     * Constructor
     */
    Score() {
        value = 0;
    }


    /**
     * Adds a point
     */
    public void addPoint() {
        value++;
    }

    /**
     * Gets the current score
     * @return current score
     */
    public int getValue() {
        return value;
    }

    /**
     * Writes the score to the game window at a given position
     * @param position
     */
    public void writeToScreen(Vector2 position) {
        PennDraw.setFont("Courier", 30);
        PennDraw.text(position.x, position.y, Integer.toString(value));
    }
}
