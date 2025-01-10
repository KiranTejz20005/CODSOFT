import java.util.*;
class BankAccount {
    private double balance;
    public BankAccount(double intBalance) {
        this.balance = intBalance;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        } else {
            return false;
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    public double checkBalance() {
        return balance;
    }
}

class ATM {
    private BankAccount bankAccount;

    public ATM(BankAccount account) {
        this.bankAccount = account;
    }

    public void display() {
        System.out.println("\n---- ATM Interface ----");
        System.out.println("1. Withdraw\n");
        System.out.println("2. Deposit\n");
        System.out.println("3. Check Balance\n");
        System.out.println("4. Exit\n");
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            display();
            System.out.println("Please select an option (1-4):");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Enter the amount to withdraw:");
                    double withdrawAmt = scanner.nextDouble();
                    if (bankAccount.withdraw(withdrawAmt)) {
                        System.out.println("Withdrawal of " + withdrawAmt + " is successful!");
                    } else {
                        System.out.println("Withdrawal failed: Insufficient balance or invalid amount.");
                    }
                    break;

                case 2:
                    System.out.println("Enter the amount to deposit:");
                    double depositAmt = scanner.nextDouble();
                    if (bankAccount.deposit(depositAmt)) {
                        System.out.println("Deposit of " + depositAmt + " is successful!");
                    } else {
                        System.out.println("Deposit failed: Invalid amount.");
                    }
                    break;

                case 3:
                    double currentBalance = bankAccount.checkBalance();
                    System.out.println("Your current balance is: " + currentBalance);
                    break;

                case 4:
                    System.out.println("Thanks for using the ATM. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

public class Main{
    public static void main(String[] args) {
        BankAccount myAccount = new BankAccount(10000);
        ATM atm = new ATM(myAccount);
        atm.run();
    }
}

