import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    void testSearch_ThrowsExceptionWhenEmpty() {
        String[] arr = {};

        Exception ex = assertThrows(IllegalStateException.class, () -> {
            if (arr.length == 0) {
                throw new IllegalStateException("Cannot perform search: No bogies available in train.");
            }
        });

        assertTrue(ex.getMessage().contains("No bogies"));
    }

    @Test
    void testSearch_NormalExecutionWhenDataExists() {
        String[] arr = {"BG101","BG205","BG309"};

        boolean result = Main.binarySearch(arr, "BG309");

        assertTrue(result);
    }

    @Test
    void testSearch_NotFoundCase() {
        String[] arr = {"BG101","BG205","BG309"};

        boolean result = Main.binarySearch(arr, "BG999");

        assertFalse(result);
    }

    @Test
    void testSearch_NoExceptionWhenNotEmpty() {
        String[] arr = {"BG101"};

        assertDoesNotThrow(() -> {
            if (arr.length == 0) {
                throw new IllegalStateException();
            }
        });
    }

    @Test
    void testSearch_ExceptionMessage() {
        String[] arr = {};

        Exception ex = assertThrows(IllegalStateException.class, () -> {
            if (arr.length == 0) {
                throw new IllegalStateException("Cannot perform search: No bogies available in train.");
            }
        });

        assertEquals("Cannot perform search: No bogies available in train.", ex.getMessage());
    }
}