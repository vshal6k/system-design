package algomaster.problems.atm.system.domainmodel;

public class Card {
    private final String pin;
    private final String number;

    public Card(String pin, String number) {
        this.pin = pin;
        this.number = number;
    }

    public boolean isPinCorrect(String pin) {
        return this.pin.equals(pin);
    }

    public String getNumber() {
        return number;
    }

}
