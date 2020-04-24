import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScoreTest {

    @Test
    void addPoint() {
        Score s = new Score();
        s.addPoint();
        s.addPoint();
        s.addPoint();

        assertEquals(s.getValue(), 3);
    }
}