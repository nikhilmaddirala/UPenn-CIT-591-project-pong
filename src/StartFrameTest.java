import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StartFrameTest {

    /**
     * Test that window is visible after init function is called
     */
    @Test
    void init() {
        StartFrame sf = new StartFrame();
        sf.init();

        assertTrue(sf.isVisible());
    }
}