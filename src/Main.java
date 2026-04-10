public class Main {

    // Binary Search (reuse from UC19)
    public static boolean binarySearch(String[] arr, String key) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            int cmp = key.compareTo(arr[mid]);

            if (cmp == 0) return true;
            else if (cmp > 0) low = mid + 1;
            else high = mid - 1;
        }

        return false;
    }

    public static void main(String[] args) {

        System.out.println("=======================================");
        System.out.println("UC20 - Exception Handling During Search");
        System.out.println("=======================================\n");

        // Try with EMPTY array (to trigger exception)
        String[] bogieIds = {};

        String searchKey = "BG309";

        try {
            // Defensive check (Fail-Fast)
            if (bogieIds.length == 0) {
                throw new IllegalStateException("Cannot perform search: No bogies available in train.");
            }

            boolean found = binarySearch(bogieIds, searchKey);

            if (found) {
                System.out.println("Bogie " + searchKey + " found.");
            } else {
                System.out.println("Bogie " + searchKey + " NOT found.");
            }

        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nUC20 validation completed...");
    }
}