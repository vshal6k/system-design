package algomaster.problems.atm.system.state;

import java.math.BigDecimal;

import algomaster.problems.atm.system.chainofresponsibility.CashDispenser100;
import algomaster.problems.atm.system.chainofresponsibility.CashDispenser20;
import algomaster.problems.atm.system.chainofresponsibility.CashDispenser50;
import algomaster.problems.atm.system.chainofresponsibility.DispenseChain;
import algomaster.problems.atm.system.domainmodel.Card;
import algomaster.problems.atm.system.domainmodel.CashDispenser;
import algomaster.problems.atm.system.enums.OperationType;
import algomaster.problems.atm.system.service.BankingService;

public class ATMSystem {
    private ATMState state;
    private Card card;
    private final BankingService bankingService;
    private final CashDispenser cashDispenser;

    public ATMSystem() {
        state = new IdleATMState();
        bankingService = new BankingService();

        DispenseChain c1 = new CashDispenser100(10); // 10 x $100 notes
        DispenseChain c2 = new CashDispenser50(20); // 20 x $50 notes
        DispenseChain c3 = new CashDispenser20(30); // 30 x $20 notes0)

        c1.setNext(c2);
        c2.setNext(c3);

        cashDispenser = new CashDispenser(c1);
    }

    public void insertCard(Card card) {
        state.insertCard(card, this);
    }

    public void enterPin(String pin) {
        state.enterPin(pin, this);
    }

    public void chooseOperation(OperationType operationType, int amount) {
        state.chooseOperation(operationType, amount, this);
    }

    public void ejectCard() {
        state.ejectCard(this);
    }

    Card getCard() {
        return card;
    }

    void setCard(Card card) {
        this.card = card;
    }

    void setState(ATMState atmState) {
        this.state = atmState;
    }

    boolean authenticate(String pin) {
        return card.isPinCorrect(pin);
    }

    void checkBalance() {
        BigDecimal balance = bankingService.checkBalance(this.card);
        System.out.println("ATM: Account Balance: " + balance);
    }

    void withdraw(int amount) {
        BigDecimal balance = bankingService.checkBalance(card);
        BigDecimal amountBigDecimal = BigDecimal.valueOf(amount);

        if (balance.compareTo(amountBigDecimal) < 0)
            throw new IllegalStateException("Insufficient cash in the bank account.");

        if (!cashDispenser.canDispense(amount))
            throw new IllegalStateException("Insufficient cash in the atm");

        bankingService.withdraw(card, amountBigDecimal);
        cashDispenser.dispense(amount);
    }

    void deposit(int amount) {
        bankingService.deposit(card, BigDecimal.valueOf(amount));
    }

}
