package algomaster.inheritance;

public class CheckingAccount extends BankAccount{
    private double overDraftLimit;

    public CheckingAccount(String ownerName, String accountNumber, double balance, double overDraftLimit) {
        super(ownerName, accountNumber, balance);
        this.overDraftLimit = overDraftLimit;
    }

    @Override
    public boolean withdraw(double amount){
        if(amount <= this.balance + overDraftLimit){
            this.balance -= amount;
            return true;
        }else return false;
    }
    
}
