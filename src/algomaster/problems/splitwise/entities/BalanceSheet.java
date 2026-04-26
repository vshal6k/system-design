package algomaster.problems.splitwise.entities;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BalanceSheet {
    private final User owner;
    private final Map<User, BigDecimal> balances = new ConcurrentHashMap<>();

    public BalanceSheet(User owner) {
        this.owner = owner;
    }

    public User getOwner() {
        return owner;
    }

    public Map<User, BigDecimal> getBalances() {
        return Map.copyOf(balances);
    }

    public void adjutsBalance(User otherUser, BigDecimal amount) {
        if (owner.getUserId().equals(otherUser.getUserId())) {
            throw new IllegalArgumentException("User cannot owe to itself.");
        }
        balances.merge(otherUser, amount, (a, b) -> a.add(b));
        if (BigDecimal.ZERO.equals(balances.get(otherUser)))
            balances.remove(otherUser);
    }

    public void showBalances() {
        System.out.println("--- Balance Sheet for " + owner.getName() + " ---");
        if (balances.isEmpty()) {
            System.out.println("All settled up!");
            return;
        }

        BigDecimal totalOwedToMe = BigDecimal.ZERO;
        BigDecimal totalIOwe = BigDecimal.ZERO;

        for (Map.Entry<User, BigDecimal> entry : balances.entrySet()) {
            User otherUser = entry.getKey();
            BigDecimal amount = entry.getValue();

            if (amount.compareTo(BigDecimal.ZERO) > 0) {
                System.out.println(
                        otherUser.getName() + " owes " + owner.getName() + " $" + String.format("%.2f", amount));

                totalOwedToMe = totalOwedToMe.add(amount);

            } else if (amount.compareTo(BigDecimal.ZERO) < 0) {
                System.out.println(owner.getName() + " owes " + otherUser.getName() + " $"
                        + String.format("%.2f", amount.negate()));

                totalOwedToMe = totalOwedToMe.add(amount.negate());
            }
        }
        System.out.println("Total Owed to " + owner.getName() + ": $" + String.format("%.2f", totalOwedToMe));
        System.out.println("Total " + owner.getName() + " Owes: $" + String.format("%.2f", totalIOwe));
        System.out.println("---------------------------------");
    }
}
