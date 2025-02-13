import java.util.Scanner;
public class SquareRoot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number to calculate its square root: ");

        try {
            double number = Double.parseDouble(scanner.nextLine());

            if (number < 0) {
                throw new IllegalArgumentException("Cannot calculate the square root of a negative number.");
            }

            double squareRoot = Math.sqrt(number);
            System.out.printf("The square root of %.2f is %.2f%n", number, squareRoot);

        } catch (NumberFormatException e) {
            System.out.println("Invalid input!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}