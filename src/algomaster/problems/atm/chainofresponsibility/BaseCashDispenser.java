package algomaster.problems.atm.chainofresponsibility;

public abstract class BaseCashDispenser implements DispenseChain {
    private DispenseChain next;
    private int noteValue;
    private int noteCount;

    public BaseCashDispenser(int noteValue, int noteCount) {
        this.noteValue = noteValue;
        this.noteCount = noteCount;
    }

    @Override
    public void setNext(DispenseChain chain) {
        this.next = chain;
    }

    @Override
    public boolean dispense(int amount) {
        if (amount < 0)
            throw new IllegalArgumentException("Amount cannot be less than zero");

        if (amount == 0)
            return true;

        int dispensableNoteCount = Math.min(amount / noteValue, noteCount);

        amount = amount - dispensableNoteCount * noteValue;

        if (next != null && next.dispense(amount)) {
            noteCount -= dispensableNoteCount;
            System.out.println("ATM: Dispense " + dispensableNoteCount + " notes of $" + noteValue);
            return true;
        }

        return false;

    }

    @Override
    public boolean canDispense(int amount) {
        if (amount < 0)
            return false;

        if (amount == 0)
            return true;

        int dispensableNoteCount = Math.min(amount / noteValue, noteCount);

        amount = amount - dispensableNoteCount * noteValue;

        if (next != null && next.dispense(amount)) {
            return true;
        }

        return false;
    }

}
