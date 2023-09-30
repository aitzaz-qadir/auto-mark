import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class PointTest {

    @Test
    public void testIntegerPoint() {
        Point<Integer> point = new Point<Integer>(10, 20);
        String expectedOutput = "XPOS: 10    YPOS: 20";
        assertEquals(expectedOutput, point.toString());
    }

    @Test
    public void testDoublePoint() {
        Point<Double> point = new Point<Double>(14.5, 15.6);
        String expectedOutput = "XPOS: 14.5  YPOS: 15.6";
        assertEquals(expectedOutput, point.toString());
    }

    @Test
    public void testStringPoint() {
        Point<String> point = new Point<String>("topleftx", "toplefty");
        String expectedOutput = "XPOS: topleftx  YPOS: toplefty";
        assertEquals(expectedOutput, point.toString());
    }
}
