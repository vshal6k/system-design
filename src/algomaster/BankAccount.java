package algomaster;
public class BankAccount {
    private int accountNumber;
    private String ownerName;
    private int balance;

    public BankAccount(int accountNumber, String ownerName) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = 0;
    }

    public void deposit(int amount){
        if(amount > 0){
            balance += amount;
        }
    }

    public boolean withdraw(int amount){
        if(amount > 0 && balance >= amount){
            balance -= amount;
            return true;
        }else return false;
    }

    public int getBalance(){
        return balance;
    }

    public static void main(String args[]){

        BankAccount bankAccount = new BankAccount(1, "Vishal");

        bankAccount.deposit(100);

        System.out.println(bankAccount.withdraw(200));

        System.out.println(bankAccount.withdraw(40));

        System.out.println(bankAccount.getBalance());

    }
    
}
