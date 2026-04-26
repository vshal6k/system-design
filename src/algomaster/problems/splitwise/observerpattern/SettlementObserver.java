package algomaster.problems.splitwise.observerpattern;

import algomaster.problems.splitwise.entities.Settlement;

public interface SettlementObserver {
    public void onSettlement(Settlement settlement);
}
