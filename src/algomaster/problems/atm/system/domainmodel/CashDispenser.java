package algomaster.problems.atm.system.domainmodel;

import algomaster.problems.atm.system.chainofresponsibility.DispenseChain;

public class CashDispenser {
    private DispenseChain chain;

    public CashDispenser(DispenseChain chain) {
        this.chain = chain;
    }

    public boolean dispense(int amount) {
        if (amount <= 0)
            throw new IllegalArgumentException("Amount cannot be zero");

        return chain.dispense(amount);
    }

    public boolean canDispense(int amount) {
        return chain.canDispense(amount);
    }

}
