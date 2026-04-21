package algomaster.problems.atm.system.chainofresponsibility;


public interface DispenseChain {
    void setNext(DispenseChain chain);
    boolean dispense(int amount);
    boolean canDispense(int amount);
}
