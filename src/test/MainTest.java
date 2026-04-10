import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    // VALID TESTS
    @Test
    void testValidTrainId() {
        assertTrue(Main.isValidTrainId("TRN-1234"));
    }

    @Test
    void testValidCargoCode() {
        assertTrue(Main.isValidCargoCode("PET-AB"));
    }

    // INVALID TESTS
    @Test
    void testInvalidTrainId() {
        assertFalse(Main.isValidTrainId("TRN-123"));   // less digits
        assertFalse(Main.isValidTrainId("TRN1234"));   // missing hyphen
        assertFalse(Main.isValidTrainId("TRAIN-1234")); // wrong format
    }

    @Test
    void testInvalidCargoCode() {
        assertFalse(Main.isValidCargoCode("PET-ab"));  // lowercase
        assertFalse(Main.isValidCargoCode("PET123"));  // wrong format
        assertFalse(Main.isValidCargoCode("AB-PET"));  // wrong order
    }
}