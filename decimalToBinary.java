import java.util.Random;

public class DecimalToBinaryConverter {
    public static void main(String[] args) {
        Random random = new Random();

        System.out.println("S/No. Decimal Number Binary Number Remarks");
        for (int i = 1; i <= 50; i++) {
            double decimalNumber = random.nextDouble() * 1000; // Generate a random number up to 3 decimal places
            String binaryNumber = convertToBinary(decimalNumber);
            String remarks = isExactConversion(decimalNumber, binaryNumber) ? "Exactly" : "Approximate";

            System.out.printf("%d. %.3f %s %s%n", i, decimalNumber, binaryNumber, remarks);
        }
    }

    public static String convertToBinary(double decimalNumber) {
        long integerValue = (long) decimalNumber;
        double fractionalPart = decimalNumber - integerValue;
        StringBuilder binaryIntegerPart = new StringBuilder(Long.toBinaryString(integerValue));
        StringBuilder binaryFractionalPart = new StringBuilder();

        while (fractionalPart > 0 && binaryFractionalPart.length() < 12) {
            fractionalPart *= 2;
            binaryFractionalPart.append((int) fractionalPart);
            fractionalPart -= (int) fractionalPart;
        }

        return binaryIntegerPart.toString() + "." + binaryFractionalPart.toString();
    }

    public static boolean isExactConversion(double decimalNumber, String binaryNumber) {
        String[] binaryParts = binaryNumber.split("\\.");

        long integerValue = Long.parseLong(binaryParts[0], 2);
        double fractionalValue = 0.0;

        if (binaryParts.length > 1) {
            String binaryFractionalPart = binaryParts[1];
            for (int i = 0; i < binaryFractionalPart.length(); i++) {
                fractionalValue += (binaryFractionalPart.charAt(i) - '0') / Math.pow(2, i + 1);
            }
        }

        double reconstructedDecimal = integerValue + fractionalValue;
        return Math.abs(decimalNumber - reconstructedDecimal) < 0.00001; // Tolerance for comparison
    }
}
