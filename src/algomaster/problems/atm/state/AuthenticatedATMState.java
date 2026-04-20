package algomaster.problems.atm.state;

import java.math.BigDecimal;

import algomaster.problems.atm.ATMSystem;
import algomaster.problems.atm.domainmodel.Card;
import algomaster.problems.atm.enums.OperationType;

public class AuthenticatedATMState implements ATMState {

    @Override
    public void insertCard(Card card, ATMSystem atmSystem) {
        throw new IllegalStateException("Machine has a card already.");
    }

    @Override
    public void enterPin(String pin, ATMSystem atmSystem) {
        throw new IllegalStateException("User is already authenticated.");
    }

    @Override
    public void chooseOperation(OperationType operationType, BigDecimal amount, ATMSystem atmSystem) {
        switch (operationType) {
            case CHECK_BALANCE:
                atmSystem.checkBalance();
                break;
            case WITHDRAW_CASH:
                atmSystem.withdraw(amount);
                break;

            case DEPOSIT_CASH:
                atmSystem.deposit(amount);
                break;
            default:
                break;
        }
    }

}
