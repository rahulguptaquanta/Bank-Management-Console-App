import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Bank Management Console App
 * Week 1 Java Fundamentals Mini Project
 *
 * Features:
 * - Create a simple account with an account holder's name
 * - Deposit money
 * - Withdraw money with balance validation
 * - Check current balance
 * - View transaction history
 * - Menu-driven interface using Scanner, loops, and conditional statements
 */
public class BankManagementApp {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final List<String> TRANSACTIONS = new ArrayList<>();

    private static String accountHolder;
    private static double balance = 0.0;

    public static void main(String[] args) {
        printWelcomeBanner();
        accountHolder = readNonEmptyText("Enter account holder name: ");

        System.out.println("\nAccount created successfully for " + accountHolder + ".");
        TRANSACTIONS.add("Account created. Opening balance: " + money(0));

        boolean running = true;
        while (running) {
            printMenu();
            int choice = readInt("Choose an option (1-6): ");

            switch (choice) {
                case 1:
                    depositMoney();
                    break;
                case 2:
                    withdrawMoney();
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    showTransactionHistory();
                    break;
                case 5:
                    showAccountDetails();
                    break;
                case 6:
                    running = false;
                    System.out.println("\nThank you for using the Bank Management Console App.");
                    System.out.println("Have a great day, " + accountHolder + "!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a number from 1 to 6.");
            }
        }

        SCANNER.close();
    }

    private static void printWelcomeBanner() {
        System.out.println("==========================================");
        System.out.println("       BANK MANAGEMENT CONSOLE APP");
        System.out.println("==========================================");
        System.out.println("A simple Java banking application");
        System.out.println("------------------------------------------");
    }

    private static void printMenu() {
        System.out.println("\n--------------- MAIN MENU ---------------");
        System.out.println("1. Deposit Money");
        System.out.println("2. Withdraw Money");
        System.out.println("3. Check Balance");
        System.out.println("4. Transaction History");
        System.out.println("5. Account Details");
        System.out.println("6. Exit");
        System.out.println("-----------------------------------------");
    }

    private static void depositMoney() {
        double amount = readPositiveAmount("Enter amount to deposit: ");
        balance += amount;
        TRANSACTIONS.add("Deposited " + money(amount) + " | Balance: " + money(balance));
        System.out.println("Deposit successful!");
        System.out.println("Updated balance: " + money(balance));
    }

    private static void withdrawMoney() {
        double amount = readPositiveAmount("Enter amount to withdraw: ");

        if (amount > balance) {
            System.out.println("Transaction failed: insufficient balance.");
            System.out.println("Available balance: " + money(balance));
            TRANSACTIONS.add("Failed withdrawal attempt of " + money(amount)
                    + " | Reason: insufficient balance");
        } else {
            balance -= amount;
            TRANSACTIONS.add("Withdrew " + money(amount) + " | Balance: " + money(balance));
            System.out.println("Please collect your cash.");
            System.out.println("Withdrawal successful!");
            System.out.println("Remaining balance: " + money(balance));
        }
    }

    private static void checkBalance() {
        System.out.println("\nCurrent balance: " + money(balance));
    }

    private static void showTransactionHistory() {
        System.out.println("\n------------- TRANSACTION HISTORY -------------");
        if (TRANSACTIONS.isEmpty()) {
            System.out.println("No transactions found.");
            return;
        }

        for (int i = 0; i < TRANSACTIONS.size(); i++) {
            System.out.println((i + 1) + ". " + TRANSACTIONS.get(i));
        }
        System.out.println("------------------------------------------------");
    }

    private static void showAccountDetails() {
        System.out.println("\n--------------- ACCOUNT DETAILS ---------------");
        System.out.println("Account holder : " + accountHolder);
        System.out.println("Account type   : Savings (demo)");
        System.out.println("Current balance: " + money(balance));
        System.out.println("Transactions   : " + TRANSACTIONS.size());
        System.out.println("------------------------------------------------");
    }

    private static String readNonEmptyText(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = SCANNER.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("Name cannot be empty. Please try again.");
        }
    }

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = SCANNER.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid whole number.");
            }
        }
    }

    private static double readPositiveAmount(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = SCANNER.nextLine().trim();
            try {
                double amount = Double.parseDouble(input);
                if (!Double.isFinite(amount)) {
                    System.out.println("Please enter a valid amount.");
                } else if (amount <= 0) {
                    System.out.println("Amount must be greater than zero.");
                } else {
                    return Math.round(amount * 100.0) / 100.0;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid amount. Example: 500 or 250.50");
            }
        }
    }

    private static String money(double amount) {
        return String.format("Rs. %.2f", amount);
    }
}
