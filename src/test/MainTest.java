import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    // Helper method to create bogie
    Main.GoodsBogie bogie(String type, String cargo) {
        return new Main.GoodsBogie(type, cargo);
    }

    @Test
    void testSafety_AllBogiesValid() {
        List<Main.GoodsBogie> list = Arrays.asList(
                bogie("Cylindrical", "Petroleum"),
                bogie("Open", "Coal"),
                bogie("Box", "Grain")
        );

        assertTrue(Main.isTrainSafe(list));
    }

    @Test
    void testSafety_CylindricalWithInvalidCargo() {
        List<Main.GoodsBogie> list = Arrays.asList(
                bogie("Cylindrical", "Coal")
        );

        assertFalse(Main.isTrainSafe(list));
    }

    @Test
    void testSafety_NonCylindricalBogiesAllowed() {
        List<Main.GoodsBogie> list = Arrays.asList(
                bogie("Open", "Coal"),
                bogie("Box", "Grain")
        );

        assertTrue(Main.isTrainSafe(list));
    }

    @Test
    void testSafety_MixedBogiesWithViolation() {
        List<Main.GoodsBogie> list = Arrays.asList(
                bogie("Cylindrical", "Petroleum"),
                bogie("Cylindrical", "Coal") // violation
        );

        assertFalse(Main.isTrainSafe(list));
    }

    @Test
    void testSafety_EmptyBogieList() {
        List<Main.GoodsBogie> list = new ArrayList<>();

        assertTrue(Main.isTrainSafe(list));
    }
}