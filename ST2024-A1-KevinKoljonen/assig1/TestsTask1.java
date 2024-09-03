import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestsTask1 {

    /*
    @BeforeEach
    public void setUp() {
        Calendar calendar = new Calendar();
    }
    */

    @Test
    public void calculateDaysInMonth1(){
        assertEquals(30, Calendar.calculateDaysInMonth(11, 16));
        assertEquals(31, Calendar.calculateDaysInMonth(12, 981));
        assertEquals(28, Calendar.calculateDaysInMonth(2,2002));
        assertEquals(29, Calendar.calculateDaysInMonth(2, 2024));
        assertEquals(-1, Calendar.calculateDaysInMonth(3, -200));
        assertEquals(-1, Calendar.calculateDaysInMonth(15, 1984));
        assertEquals(28, Calendar.calculateDaysInMonth(2, 300));
    }


}