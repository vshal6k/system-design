package algomaster.problems.atm.state;

import java.math.BigDecimal;

import algomaster.problems.atm.ATMSystem;
import algomaster.problems.atm.domainmodel.Card;
import algomaster.problems.atm.enums.OperationType;

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
    public void chooseOperation(OperationType operationType, BigDecimal amount,  ATMSystem atmSystem) {
        throw new IllegalStateException("Please enter pin to choose an operation.");
    }

}
