package algomaster.problems.atm.state;

import java.math.BigDecimal;

import algomaster.problems.atm.ATMSystem;
import algomaster.problems.atm.domainmodel.Card;
import algomaster.problems.atm.enums.OperationType;

public interface ATMState {
    // Represents the capabilites of ATM at a praticular state

    // ATM should provide a user friendly method to insert card
    void insertCard(Card card, ATMSystem atmSystem);

    // ATM should provide a user friendly method to enter pin
    void enterPin(String pin, ATMSystem atmSystem);

    // ATM should provide a user friendly method to choose the operation
    void chooseOperation(OperationType operationType, BigDecimal amount, ATMSystem atmSystem);

    // ATM should choose a user friendly method to eject the card
    default void ejectCard(ATMSystem atmSystem) {
        atmSystem.setCard(null);
        atmSystem.setState(new IdleATMState());
    }
}
