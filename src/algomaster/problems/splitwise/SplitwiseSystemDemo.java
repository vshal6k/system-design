package algomaster.problems.splitwise;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import algomaster.problems.splitwise.entities.Expense;
import algomaster.problems.splitwise.entities.Group;
import algomaster.problems.splitwise.entities.Transaction;
import algomaster.problems.splitwise.entities.User;
import algomaster.problems.splitwise.splitstrategy.EqualSplitStrategy;
import algomaster.problems.splitwise.splitstrategy.ExactAmountSplitStrategy;
import algomaster.problems.splitwise.splitstrategy.PercentageSplitStrategy;

public class SplitwiseSystemDemo {
    public static void main(String[] args) {
        // 1. Setup the service
        SplitwiseSystem service = SplitwiseSystem.getInstance();

        // 2. Create users and groups
        User alice = service.addUser("Alice", "alice@a.com", "123");
        User bob = service.addUser("Bob", "bob@b.com", "123");
        User charlie = service.addUser("Charlie", "charlie@c.com", "123");
        User david = service.addUser("David", "david@d.com", "123");

        Group friendsGroup = service.addGroup("Friends Trip", List.of(alice, bob, charlie, david));

        System.out.println("--- System Setup Complete ---\n");

        // 3. Use Case 1: Equal Split
        System.out.println("--- Use Case 1: Equal Split ---");
        service.createExpense(new Expense.ExpenseBuilder()
                .setDescription("Dinner")
                .setAmount(BigDecimal.valueOf(1000))
                .setPaidBy(alice)
                .setParticipants(Arrays.asList(alice, bob, charlie, david))
                .setSplitStrategy(new EqualSplitStrategy()).build());

        service.showBalanceSheet(alice.getUserId());
        service.showBalanceSheet(bob.getUserId());
        System.out.println();

        // 4. Use Case 2: Exact Split
        System.out.println("--- Use Case 2: Exact Split ---");
        service.createExpense(new Expense.ExpenseBuilder()
                .setDescription("Movie Tickets")
                .setAmount(BigDecimal.valueOf(370))
                .setPaidBy(alice)
                .setParticipants(Arrays.asList(bob, charlie))
                .setSplitStrategy(new ExactAmountSplitStrategy(
                        List.of(BigDecimal.valueOf(120.0), BigDecimal.valueOf(250.0))))
                .build());

        service.showBalanceSheet(alice.getUserId());
        service.showBalanceSheet(bob.getUserId());
        System.out.println();

        // 5. Use Case 3: Percentage Split
        System.out.println("--- Use Case 3: Percentage Split ---");
        service.createExpense(
                new Expense.ExpenseBuilder()
                        .setDescription("Groceries")
                        .setAmount(BigDecimal.valueOf(500))
                        .setPaidBy(david)
                        .setParticipants(Arrays.asList(alice, bob, charlie))
                        .setSplitStrategy(new PercentageSplitStrategy(
                                List.of(BigDecimal.valueOf(40.0), BigDecimal.valueOf(30.0), BigDecimal.valueOf(30.0))))
                        .build());

        System.out.println("--- Balances After All Expenses ---");
        service.showBalanceSheet(alice.getUserId());
        service.showBalanceSheet(bob.getUserId());

        service.showBalanceSheet(charlie.getUserId());
        service.showBalanceSheet(david.getUserId());

        System.out.println();

        // 6. Use Case 4: Simplify Group Debts
        System.out.println("--- Use Case 4: Simplify Group Debts for 'Friends Trip' ---");
        List<Transaction> simplifiedDebts = service.simplifyGroupDebts(friendsGroup.getGroupId());
        if (simplifiedDebts.isEmpty()) {
            System.out.println("All debts are settled within the group!");
        } else {
            simplifiedDebts.forEach(System.out::println);
        }
        System.out.println();

        service.showBalanceSheet(bob.getUserId());

        // 7. Use Case 5: Partial Settlement
        System.out.println("--- Use Case 5: Partial Settlement ---");
        // From the simplified debts, we see Bob should pay Alice. Let's say Bob pays
        // 100.
        service.settleUp(bob.getUserId(), alice.getUserId(), BigDecimal.valueOf(100));

        System.out.println("--- Balances After Partial Settlement ---");
        service.showBalanceSheet(alice.getUserId());
        service.showBalanceSheet(bob.getUserId());

    }
}
