package algomaster.problems.splitwise.observerpattern;

import algomaster.problems.splitwise.entities.Expense;

public interface ExpenseObserver {
    public void onExpenseAddition(Expense expense);
}
