package algomaster.problems.atm.domainmodel;

public class Card {
    private final String pin;

    public Card(String pin) {
        this.pin = pin;
    }

    public boolean isPinCorrect(String pin) {
        return this.pin.equals(pin);
    }

}
