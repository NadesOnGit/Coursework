import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import com.napier.sem.App;

/*
 * Purpose: These are the unit tests for the App.java File.
 * Author: Jack Iain Bryce.
 * Last Date of Modification: 09/03/2020
 */
public class AppTest {
    /*
     * Purpose: This tests checkString method.
     * Parameters: N/A
     */
    @Test
    void checkStringTest() {
        assertEquals(true, App.checkString("H3LL0"));
        assertEquals(false, App.checkString("0123456789"));
    }

    /*
     * Purpose: This tests checkString method.
     * Parameters: N/A
     */
    @Test
    void checkWithinRangeTest() {
        assertEquals(true, App.checkWithinRange(5, 10));
        assertEquals(false, App.checkWithinRange(5, 5));
        assertEquals(false, App.checkWithinRange(5, 3));
    }

    /*
     * Purpose: This tests checkString method.
     * Parameters: N/A
     */
    @Test
    void checkToBreakTest() {
        assertEquals(true, App.checkToBreak("-1"));
        assertEquals(false, App.checkToBreak("20"));
    }
}