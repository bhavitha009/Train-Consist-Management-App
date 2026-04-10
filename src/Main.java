public class Main {

    // Linear Search method
    public static boolean linearSearch(String[] bogies, String key) {
        for (String b : bogies) {
            if (b.equals(key)) {
                return true; // found
            }
        }
        return false; // not found
    }

    public static void main(String[] args) {

        System.out.println("=======================================");
        System.out.println("UC18 - Linear Search for Bogie ID");
        System.out.println("=======================================\n");

        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        System.out.println("Available Bogie IDs:");
        for (String id : bogieIds) {
            System.out.println(id);
        }

        String searchKey = "BG309";

        boolean found = linearSearch(bogieIds, searchKey);

        if (found) {
            System.out.println("\nBogie " + searchKey + " found in train consist.");
        } else {
            System.out.println("\nBogie " + searchKey + " NOT found.");
        }

        System.out.println("\nUC18 search completed...");
    }
}