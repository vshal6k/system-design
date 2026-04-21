package algomaster.problems.atm.system.state;

import algomaster.problems.atm.system.domainmodel.Card;
import algomaster.problems.atm.system.enums.OperationType;

public class HasCardATMState implements ATMState {

    @Override
    public void insertCard(Card card, ATMSystem atmSystem) {
        throw new IllegalStateException("Machine has a card already.");
    }

    @Override
    public void enterPin(String pin, ATMSystem atmSystem) {
        if (atmSystem.authenticate(pin)) {
            atmSystem.setState(new AuthenticatedATMState());
        } else
            throw new IllegalArgumentException("Pin is incorrect.");
    }

    @Override
    public void chooseOperation(OperationType operationType, int amount,  ATMSystem atmSystem) {
        throw new IllegalStateException("Please enter pin to choose an operation.");
    }

}
