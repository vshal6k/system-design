package algomaster.problems.atm.system.state;

import algomaster.problems.atm.system.domainmodel.Card;
import algomaster.problems.atm.system.enums.OperationType;

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
    public void chooseOperation(OperationType operationType, int amount, ATMSystem atmSystem) {
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
