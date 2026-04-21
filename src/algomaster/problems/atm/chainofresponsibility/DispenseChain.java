package algomaster.problems.atm.chainofresponsibility;


public interface DispenseChain {
    void setNext(DispenseChain chain);
    boolean dispense(int amount);
    boolean canDispense(int amount);
}
