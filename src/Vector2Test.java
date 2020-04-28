import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Vector2Test {

    /**
     * Tests that vectors are multiplied by a given number
     */
    @Test
    public void times() {

        Vector2 v2 = new Vector2(5,10);
        Vector2 doubleV2 = v2.times(2);

        assertEquals(doubleV2.x, 10);
        assertEquals(doubleV2.y, 20);
    }
}