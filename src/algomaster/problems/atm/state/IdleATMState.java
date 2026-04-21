package algomaster.problems.atm.state;


import java.math.BigDecimal;

import algomaster.problems.atm.ATMSystem;
import algomaster.problems.atm.domainmodel.Card;
import algomaster.problems.atm.enums.OperationType;

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
