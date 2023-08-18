import java.util.Scanner;

public class NumberSystemConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a decimal number: ");
        int decimalNumber = scanner.nextInt();

        System.out.println("Binary: " + convertToBase(decimalNumber, 2));
        System.out.println("Octal: " + convertToBase(decimalNumber, 8));
        System.out.println("Hexadecimal: " + convertToBase(decimalNumber, 16));
    }

    public static String convertToBase(int decimalNumber, int base) {
        StringBuilder result = new StringBuilder();

        while (decimalNumber > 0) {
            int remainder = decimalNumber % base;
            if (remainder < 10) {
                result.insert(0, remainder);
            } else {
                result.insert(0, (char) ('A' + remainder - 10));
            }
            decimalNumber /= base;
        }

        return result.toString();
    }
}
