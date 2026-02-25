import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TravelCalTest {


    @Test
    void speedWith50km1hour() {
        assertEquals(50, TravelCal.calSpeed(50, 1));
    }

    @Test
    void speedWith100km1hour() {
        assertEquals(100, TravelCal.calSpeed(100, 1));
    }

    @Test
    void speedWith100km6hour() {
        assertEquals(16.666666666666668, TravelCal.calSpeed(100, 6));
    }

    @Test
    void speedWith1km10hour() {
        assertEquals(0.1, TravelCal.calSpeed(1, 10));
    }

    @Test
    void speedWith1km1hour() {
        assertEquals(1.0, TravelCal.calSpeed(1, 1));
    }

    @Test
    void speedWith1km6hour() {
        assertEquals(0.16666666666666666, TravelCal.calSpeed(1, 6));
    }

}