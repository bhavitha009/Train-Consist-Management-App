import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    void testException_ValidCapacityCreation() throws Exception {
        Main.PassengerBogie b = new Main.PassengerBogie("Sleeper", 72);
        assertEquals("Sleeper", b.type);
        assertEquals(72, b.capacity);
    }

    @Test
    void testException_NegativeCapacityThrowsException() {
        Exception ex = assertThrows(Main.InvalidCapacityException.class, () -> {
            new Main.PassengerBogie("Sleeper", -10);
        });
        assertEquals("Capacity must be greater than zero", ex.getMessage());
    }

    @Test
    void testException_ZeroCapacityThrowsException() {
        Exception ex = assertThrows(Main.InvalidCapacityException.class, () -> {
            new Main.PassengerBogie("AC", 0);
        });
        assertEquals("Capacity must be greater than zero", ex.getMessage());
    }

    @Test
    void testException_ExceptionMessageValidation() {
        Exception ex = assertThrows(Main.InvalidCapacityException.class, () -> {
            new Main.PassengerBogie("AC", 0);
        });
        assertTrue(ex.getMessage().contains("greater than zero"));
    }

    @Test
    void testException_ObjectIntegrityAfterCreation() throws Exception {
        Main.PassengerBogie b = new Main.PassengerBogie("First Class", 24);
        assertEquals("First Class", b.type);
        assertEquals(24, b.capacity);
    }

    @Test
    void testException_MultipleValidBogiesCreation() throws Exception {
        Main.PassengerBogie b1 = new Main.PassengerBogie("Sleeper", 72);
        Main.PassengerBogie b2 = new Main.PassengerBogie("AC", 56);

        assertNotNull(b1);
        assertNotNull(b2);
    }
}