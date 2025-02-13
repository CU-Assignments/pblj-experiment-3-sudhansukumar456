import java.util.Scanner;
public class ATMwithdrawlSystem {
    private static final int CORRECT_PIN = 1010;
    private static double balance = 50000.0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Enter your PIN: ");
            int pin = Integer.parseInt(scanner.nextLine());
            
            if (pin != CORRECT_PIN) {
                throw new InvalidPINException("Invalid PIN!");
            }
            
            System.out.print(" withdrawal amount: ");
            double amount = Double.parseDouble(scanner.nextLine());
            
            if (amount > balance) {
                throw new InsufficientBalanceException("Insufficient balance!");
            }
            
            balance -= amount;
            System.out.println("Withdrawal successful!");
            
        } catch (NumberFormatException e) {
            System.out.println("Invalid input format!");
        } catch (InvalidPINException | InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Remaining balance: " + balance);
            scanner.close();
        }
    }

    static class InvalidPINException extends RuntimeException {
        InvalidPINException(String message) {
            super(message);
        }
    }
    static class InsufficientBalanceException extends RuntimeException {
        InsufficientBalanceException(String message) {
            super(message);
        }
    }
}