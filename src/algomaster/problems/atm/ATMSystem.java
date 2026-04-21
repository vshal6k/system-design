package algomaster.problems.atm;

import java.math.BigDecimal;

import algomaster.problems.atm.chainofresponsibility.CashDispenser100;
import algomaster.problems.atm.chainofresponsibility.CashDispenser20;
import algomaster.problems.atm.chainofresponsibility.CashDispenser50;
import algomaster.problems.atm.chainofresponsibility.DispenseChain;
import algomaster.problems.atm.domainmodel.Card;
import algomaster.problems.atm.domainmodel.CashDispenser;
import algomaster.problems.atm.enums.OperationType;
import algomaster.problems.atm.service.BankingService;
import algomaster.problems.atm.state.ATMState;
import algomaster.problems.atm.state.IdleATMState;

public class ATMSystem {
    private ATMState state;
    private Card card;
    private BankingService bankingService;
    private CashDispenser cashDispenser;

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
        System.out.println("ATM: Account Balance: " + balance);
    }

    public void withdraw(int amount) {
        BigDecimal balance = bankingService.checkBalance(card);
        BigDecimal amountBigDecimal = BigDecimal.valueOf(amount);

        if (balance.compareTo(amountBigDecimal) < 0)
            throw new IllegalStateException("Insufficient cash in the bank account.");

        if (!cashDispenser.canDispense(amount))
            throw new IllegalStateException("Insufficient cash in the atm");

        bankingService.withdraw(card, amountBigDecimal);
        cashDispenser.dispense(amount);
    }

    public void deposit(int amount) {
        bankingService.deposit(card, BigDecimal.valueOf(amount));
    }

}
