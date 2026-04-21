package algomaster.problems.atm.system.state;

import algomaster.problems.atm.system.domainmodel.Card;
import algomaster.problems.atm.system.enums.OperationType;

public class IdleATMState implements ATMState {

    @Override
    public void insertCard(Card card, ATMSystem atmSystem) {
        atmSystem.setCard(card);
        atmSystem.setState(new HasCardATMState());
    }

    @Override
    public void enterPin(String pin, ATMSystem atmSystem) {
        throw new IllegalStateException("Please enter a card before entering pin.");
    }

    @Override
    public void chooseOperation(OperationType operationType, int amount, ATMSystem atmSystem) {
        throw new IllegalStateException("Please enter a card first before choosing an operation.");
    }

}
