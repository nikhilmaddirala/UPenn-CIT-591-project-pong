import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class LevelTest {

    @Test
    void setDifficulty() {
        Level.setDifficulty(1);
        assertEquals(Level.getDifficulty(), Level.EASY);

        Level.setDifficulty(2);
        assertEquals(Level.getDifficulty(), Level.MEDIUM);

        Level.setDifficulty(3);
        assertEquals(Level.getDifficulty(), Level.HARD);
    }

    @Test
    void setMode() {
        Level.setMode(1);
        assertEquals(Level.getMode(), Level.SINGLE_PLAYER);

        Level.setMode(2);
        assertEquals(Level.getMode(), Level.TWO_PLAYER);
    }
}