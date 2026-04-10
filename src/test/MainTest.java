import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    void testBinarySearch_Found() {
        String[] arr = {"BG101","BG205","BG309","BG412","BG550"};
        Arrays.sort(arr);

        assertTrue(Main.binarySearch(arr, "BG309"));
    }

    @Test
    void testBinarySearch_NotFound() {
        String[] arr = {"BG101","BG205","BG309","BG412","BG550"};
        Arrays.sort(arr);

        assertFalse(Main.binarySearch(arr, "BG999"));
    }

    @Test
    void testBinarySearch_FirstElement() {
        String[] arr = {"BG101","BG205","BG309","BG412","BG550"};
        Arrays.sort(arr);

        assertTrue(Main.binarySearch(arr, "BG101"));
    }

    @Test
    void testBinarySearch_LastElement() {
        String[] arr = {"BG101","BG205","BG309","BG412","BG550"};
        Arrays.sort(arr);

        assertTrue(Main.binarySearch(arr, "BG550"));
    }

    @Test
    void testBinarySearch_SingleElement() {
        String[] arr = {"BG101"};
        Arrays.sort(arr);

        assertTrue(Main.binarySearch(arr, "BG101"));
    }
}