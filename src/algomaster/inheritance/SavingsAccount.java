package algomaster.inheritance;

public class SavingsAccount extends BankAccount{

    private double interestRate;

    public SavingsAccount(String ownerName, String accountNumber, double balance, double interestRate) {
        super(ownerName, accountNumber, balance);
        this.interestRate = interestRate;
    }

    public void applyInterest(){
        this.balance += this.balance*interestRate/100;
    }

    @Override
    public boolean withdraw(double amount){
        if(this.balance - amount >= 100){
            return super.withdraw(amount);
        }else return false;
    }
    
}
