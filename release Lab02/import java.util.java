import java.util.Scanner;

public class MathOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input from user
        System.out.print("Enter first number: ");
        String strNum1 = scanner.nextLine();
        System.out.print("Enter second number: ");
        String strNum2 = scanner.nextLine();

        // Convert to double
        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);

        // Perform operations
        double sum = num1 + num2;
        double difference = num1 - num2;
        double product = num1 * num2;
        
        // Check divisor for division
        Double quotient = null;
        if (num2 != 0) {
            quotient = num1 / num2;
        }

        // Output results
        System.out.println("Sum: " + sum);
        System.out.println("Difference: " + difference);
        System.out.println("Product: " + product);
        if (quotient != null) {
            System.out.println("Quotient: " + quotient);
        } else {
            System.out.println("Cannot divide by zero.");
        }

        // Close scanner
        scanner.close();
    }
}
