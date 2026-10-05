import org.example.Complex;
import org.example.SpatialPoint;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SpatialPointTest {

    @Test
    public void testDistanceToOrigin() {
        Complex c1 = new Complex(3, 4);
        Complex c2 = new Complex(5, 0);
        SpatialPoint point = new SpatialPoint(c1, c2);

        double expected = Math.sqrt(50);
        assertEquals(expected, point.distanceToOrigin(), 0.0001);
    }

    @Test
    public void testDistanceToAnotherPoint() {
        SpatialPoint pointA = new SpatialPoint(new Complex(3, 4), new Complex(5, 0));
        SpatialPoint pointB = new SpatialPoint(new Complex(0, 0), new Complex(0, 0));

        assertEquals(pointA.distanceToOrigin(), pointA.distanceTo(pointB), 0.0001);
    }
}
