/**
 * Level class holds information about the game difficulty and mode
 */
public class Level {
    public static final int EASY = 1;
    public static final int MEDIUM = 2;
    public static final int HARD = 3;
    public static final int SINGLE_PLAYER = 1;
    public static final int TWO_PLAYER = 2;

    private static int difficulty = EASY;
    private static int mode = SINGLE_PLAYER;

    /**
     * Constructor - cannot be instantiated
     */
    private Level() {}

    /**
     * Gets the difficulty
     * @return current difficulty (1, 2, or 3)
     */
    public static int getDifficulty() {
        return difficulty;
    }

    /**
     * Sets the difficulty
     * @param difficulty difficulty to be set
     */
    public static void setDifficulty(int difficulty) {
        Level.difficulty = difficulty;
    }

    /**
     * Gets the game mode
     * @return current mode (single or two player)
     */
    public static int getMode() {
        return mode;
    }

    /**
     * Sets the mode
     * @param mode mode to be set
     */
    public static void setMode(int mode) {
        Level.mode = mode;
    }
}
