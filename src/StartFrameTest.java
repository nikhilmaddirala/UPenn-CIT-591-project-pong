import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StartFrameTest {

    @Test
    void init() {
        StartFrame sf = new StartFrame();
        sf.init();

        assertTrue(sf.isVisible());
    }
}