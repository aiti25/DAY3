import java.util.Scanner;

class BankAccount {

    private double balance;

    // Constructor
    BankAccount(String name, double balance) {
        this.balance = balance;
    }

    public BankAccount() {
    }

    // Deposit method
    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid amount!");
        }
    }

    // Withdraw method
    void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    // Display balance
    void displayBalance() {
        System.out.println("Current Balance: " + balance);
    }
}

public class Main {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter Account Holder Name: ");
            String name = sc.nextLine();
            
            System.out.print("Enter Initial Balance: ");
            double balance = sc.nextDouble();
            
            BankAccount account = new BankAccount(name, balance);
            
            int choice;
            
            do {
                System.out.println("\n1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. Check Balance");
                System.out.println("4. Exit");
                System.out.print("Enter choice: ");
                
                choice = sc.nextInt();
                
                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter deposit amount: ");
                        double dep = sc.nextDouble();
                        account.deposit(dep);
                    }
                    
                    case 2 -> {
                        System.out.print("Enter withdraw amount: ");
                        double wit = sc.nextDouble();
                        account.withdraw(wit);
                    }
                    
                    case 3 -> account.displayBalance();
                    
                    case 4 -> System.out.println("Thank you!");
                    
                    default -> System.out.println("Invalid choice!");
                }
                
            } while (choice != 4);
        }
    }
}