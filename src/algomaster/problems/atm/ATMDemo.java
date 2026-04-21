package algomaster.problems.atm;

import algomaster.problems.atm.domainmodel.Card;
import algomaster.problems.atm.enums.OperationType;

public class ATMDemo {
    public static void main(String[] args) {
        ATMSystem atmSystem = new ATMSystem();

        Card validCard = new Card("1234", "1234-5678-9012-3456");
        Card inValidCard = new Card("1234", "1234-5678-9012-345");

        // Happy flow, Valid Card, Valid Pin, Sufficient Cash, Sufficient ATM Cash
        atmSystem.insertCard(validCard);
        atmSystem.enterPin("1234");
        atmSystem.chooseOperation(OperationType.CHECK_BALANCE, 0);
        atmSystem.chooseOperation(OperationType.WITHDRAW_CASH, 100);
        atmSystem.chooseOperation(OperationType.DEPOSIT_CASH, 500);
        atmSystem.chooseOperation(OperationType.CHECK_BALANCE, 0);

        // Unhappy flow, Valid Card, Invalid Pin, Sufficient Cash, Sufficient ATM Cash
        // atmSystem.insertCard(validCard);
        // atmSystem.enterPin("12345");
        // atmSystem.chooseOperation(OperationType.WITHDRAW_CASH, 100);
        // atmSystem.chooseOperation(OperationType.DEPOSIT_CASH, 500);

        // Unhappy flow, Valid Card, Valid Pin, Insufficient Cash, Sufficient ATM Cash
        // atmSystem.insertCard(validCard);
        // atmSystem.enterPin("1234");
        // atmSystem.chooseOperation(OperationType.WITHDRAW_CASH, 2000);
        // atmSystem.chooseOperation(OperationType.DEPOSIT_CASH, 1000);

        // Happy flow, Valid Card, Valid Pin, Insufficient Cash, Sufficient ATM Cash
        // atmSystem.insertCard(validCard);
        // atmSystem.enterPin("1234");
        // atmSystem.chooseOperation(OperationType.DEPOSIT_CASH, 1000);
        // atmSystem.chooseOperation(OperationType.WITHDRAW_CASH, 2000);

        // Unhappy flow state checks
        // atmSystem.enterPin("1234");
        // atmSystem.ejectCard();
        // atmSystem.chooseOperation(OperationType.CHECK_BALANCE, 100);

        // Unhappy flow, Invalid Card, Invalid Pin, Sufficient Cash, Sufficient ATM Cash
        // atmSystem.insertCard(inValidCard);
        // atmSystem.enterPin("1234");
        // atmSystem.chooseOperation(OperationType.WITHDRAW_CASH, 100);
        // atmSystem.chooseOperation(OperationType.DEPOSIT_CASH, 500);

    }
}
