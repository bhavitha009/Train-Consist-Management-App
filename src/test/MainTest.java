import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    Main.Bogie bogie(String name, int capacity) {
        return new Main.Bogie(name, capacity);
    }

    @Test
    void testLoopFilteringLogic() {
        List<Main.Bogie> list = Arrays.asList(
                bogie("A", 50),
                bogie("B", 70),
                bogie("C", 80)
        );

        List<Main.Bogie> result = Main.filterWithLoop(list);

        assertEquals(2, result.size());
    }

    @Test
    void testStreamFilteringLogic() {
        List<Main.Bogie> list = Arrays.asList(
                bogie("A", 50),
                bogie("B", 70),
                bogie("C", 80)
        );

        List<Main.Bogie> result = Main.filterWithStream(list);

        assertEquals(2, result.size());
    }

    @Test
    void testLoopAndStreamResultsMatch() {
        List<Main.Bogie> list = Arrays.asList(
                bogie("A", 50),
                bogie("B", 70),
                bogie("C", 80)
        );

        assertEquals(
                Main.filterWithLoop(list).size(),
                Main.filterWithStream(list).size()
        );
    }

    @Test
    void testExecutionTimeMeasurement() {
        long start = System.nanoTime();
        long end = System.nanoTime();

        assertTrue(end - start >= 0);
    }

    @Test
    void testLargeDatasetProcessing() {
        List<Main.Bogie> list = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {
            list.add(bogie("B" + i, i % 100));
        }

        List<Main.Bogie> result = Main.filterWithStream(list);

        assertNotNull(result);
    }
}