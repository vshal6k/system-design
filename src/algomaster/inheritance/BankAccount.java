package algomaster.inheritance;

public class BankAccount {
    protected String ownerName;
    protected String accountNumber;
    protected double balance;

    public BankAccount(String ownerName, String accountNumber, double balance) {
        this.ownerName = ownerName;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0)
            balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && this.balance - amount >= 0) {
            balance -= amount;
            return true;
        } else
            return false;
    }

    public void displayAccount() {
        System.out.printf("Owner Name: %s Account Number: %s Balance: %.2f\n", this.ownerName, this.accountNumber,
                this.balance);
    }
}
