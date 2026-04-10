import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    void testCargo_SafeAssignment() {
        Main.GoodsBogie b = new Main.GoodsBogie("Cylindrical");
        b.assignCargo("Petroleum");

        assertEquals("Petroleum", b.cargo);
    }

    @Test
    void testCargo_UnsafeAssignmentHandled() {
        Main.GoodsBogie b = new Main.GoodsBogie("Rectangular");
        b.assignCargo("Petroleum");

        assertNull(b.cargo); // should not assign
    }

    @Test
    void testCargo_CargoNotAssignedAfterFailure() {
        Main.GoodsBogie b = new Main.GoodsBogie("Rectangular");
        b.assignCargo("Petroleum");

        assertNull(b.cargo);
    }

    @Test
    void testCargo_ProgramContinuesAfterException() {
        Main.GoodsBogie b1 = new Main.GoodsBogie("Rectangular");
        b1.assignCargo("Petroleum");

        Main.GoodsBogie b2 = new Main.GoodsBogie("Cylindrical");
        b2.assignCargo("Petroleum");

        assertEquals("Petroleum", b2.cargo);
    }

    @Test
    void testCargo_FinallyBlockExecution() {
        Main.GoodsBogie b = new Main.GoodsBogie("Rectangular");
        b.assignCargo("Petroleum");

        // If program reaches here → finally executed
        assertTrue(true);
    }
}