package algomaster.problems.atm;

import java.math.BigDecimal;

import algomaster.problems.atm.domainmodel.Card;
import algomaster.problems.atm.enums.OperationType;
import algomaster.problems.atm.service.BankingService;
import algomaster.problems.atm.state.ATMState;

public class ATMSystem {
    private ATMState state;
    private Card card;
    private BankingService bankingService;

    void insertCard(Card card) {
        state.insertCard(card, this);
    }

    void enterPin(String pin) {
        state.enterPin(pin, this);
    }

    void chooseOperation(OperationType operationType, BigDecimal amount) {
        state.chooseOperation(operationType, amount, this);
    }

    void ejectCard() {
        state.ejectCard(this);
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public void setState(ATMState atmState) {
        this.state = atmState;
    }

    public boolean authenticate(String pin) {
        return card.isPinCorrect(pin);
    }

    public void checkBalance() {
        BigDecimal balance = bankingService.checkBalance(this.card);
        System.out.println("Account Balance: " + balance);
    }

    public void withdraw(BigDecimal amount) {
        bankingService.withdraw(this.card, amount);
    }

    public void deposit(BigDecimal amount){
        bankingService.deposit(this.card, amount);
    }

}
