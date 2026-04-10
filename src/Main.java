import java.util.*;

public class Main {

    // Goods Bogie Model
    static class GoodsBogie {
        String type;
        String cargo;

        GoodsBogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }
    }

    // Safety validation method (IMPORTANT for test cases)
    public static boolean isTrainSafe(List<GoodsBogie> bogies) {
        return bogies.stream().allMatch(b ->
                !b.type.equalsIgnoreCase("Cylindrical") ||
                        b.cargo.equalsIgnoreCase("Petroleum")
        );
    }

    public static void main(String[] args) {

        System.out.println("==============================================");
        System.out.println("UC12 - Safety Compliance Check for Goods Bogies");
        System.out.println("==============================================\n");

        // Create goods bogie list
        List<GoodsBogie> goodsBogies = new ArrayList<>();

        goodsBogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goodsBogies.add(new GoodsBogie("Open", "Coal"));
        goodsBogies.add(new GoodsBogie("Box", "Grain"));
        goodsBogies.add(new GoodsBogie("Cylindrical", "Coal")); // Invalid

        System.out.println("Goods Bogies in Train:");
        for (GoodsBogie b : goodsBogies) {
            System.out.println(b.type + " -> " + b.cargo);
        }

        boolean isSafe = isTrainSafe(goodsBogies);

        System.out.println("\nSafety Compliance Status: " + isSafe);

        if (isSafe) {
            System.out.println("Train formation is SAFE.");
        } else {
            System.out.println("Train formation is NOT SAFE.");
        }

        System.out.println("\nUC12 safety validation completed...");
    }
}