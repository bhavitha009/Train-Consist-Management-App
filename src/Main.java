public class Main {

    // Custom Runtime Exception
    static class CargoSafetyException extends RuntimeException {
        public CargoSafetyException(String message) {
            super(message);
        }
    }

    // Goods Bogie
    static class GoodsBogie {
        String type;
        String cargo;

        GoodsBogie(String type) {
            this.type = type;
        }

        // Assign cargo with validation
        public void assignCargo(String cargo) {
            try {
                // Rule: Rectangular cannot carry Petroleum
                if (type.equalsIgnoreCase("Rectangular") && cargo.equalsIgnoreCase("Petroleum")) {
                    throw new CargoSafetyException("Unsafe cargo assignment!");
                }

                this.cargo = cargo;
                System.out.println("Cargo assigned successfully -> " + cargo);

            } catch (CargoSafetyException e) {
                System.out.println("Error: " + e.getMessage());

            } finally {
                System.out.println("Cargo validation completed for " + type + " bogie\n");
            }
        }
    }

    public static void main(String[] args) {

        System.out.println("====================================");
        System.out.println("UC15 - Safe Cargo Assignment");
        System.out.println("====================================\n");

        // Safe case
        GoodsBogie b1 = new GoodsBogie("Cylindrical");
        b1.assignCargo("Petroleum");

        // Unsafe case
        GoodsBogie b2 = new GoodsBogie("Rectangular");
        b2.assignCargo("Petroleum");

        System.out.println("UC15 runtime handling completed...");
    }
}