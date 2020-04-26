import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class LevelTest {

    /**
     * Test that the difficulty value is the correct integer
     */
    @Test
    void setDifficulty() {
        Level.setDifficulty(1);
        assertEquals(Level.getDifficulty(), Level.EASY);

        Level.setDifficulty(2);
        assertEquals(Level.getDifficulty(), Level.MEDIUM);

        Level.setDifficulty(3);
        assertEquals(Level.getDifficulty(), Level.HARD);
    }

    /**
     * Test that the mode value is the correct integer
     */
    @Test
    void setMode() {
        Level.setMode(1);
        assertEquals(Level.getMode(), Level.SINGLE_PLAYER);

        Level.setMode(2);
        assertEquals(Level.getMode(), Level.TWO_PLAYER);
    }
}