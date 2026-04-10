import java.util.Scanner;
import java.util.regex.*;

public class Main {

    public static boolean isValidTrainId(String trainId) {
        return Pattern.matches("TRN-\\d{4}", trainId);
    }

    public static boolean isValidCargoCode(String cargoCode) {
        return Pattern.matches("PET-[A-Z]{2}", cargoCode);
    }

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println("UC11 - Validate Train ID and Cargo Code");
        System.out.println("======================================\n");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Train ID (Format: TRN-1234): ");
        String trainId = scanner.nextLine();

        System.out.print("Enter Cargo Code (Format: PET-AB): ");
        String cargoCode = scanner.nextLine();

        boolean isTrainValid = isValidTrainId(trainId);
        boolean isCargoValid = isValidCargoCode(cargoCode);

        System.out.println("\nValidation Results:");
        System.out.println("Train ID Valid: " + isTrainValid);
        System.out.println("Cargo Code Valid: " + isCargoValid);

        System.out.println("\nUC11 validation completed...");
    }
}