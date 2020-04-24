import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class EndFrameTest {

    @Test
    void constructorTest() {
        EndFrame e = new EndFrame("Player 1");
        e.getFont();
        assertEquals(e.getTitle(), "Pong");
        assertEquals(e.getSize(), new Dimension(500, 500));
    }
}