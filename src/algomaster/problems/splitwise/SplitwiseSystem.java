package algomaster.problems.splitwise;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import algomaster.problems.splitwise.entities.Expense;
import algomaster.problems.splitwise.entities.Group;
import algomaster.problems.splitwise.entities.Split;
import algomaster.problems.splitwise.entities.Transaction;
import algomaster.problems.splitwise.entities.User;

public class SplitwiseSystem {
    private static SplitwiseSystem instance;
    private final Map<String, Group> groups = new ConcurrentHashMap<>();
    private final Map<String, User> users = new ConcurrentHashMap<>();

    private SplitwiseSystem() {
    }

    public static synchronized SplitwiseSystem getInstance() {
        if (instance == null) {
            instance = new SplitwiseSystem();
        }
        return instance;
    }

    // Setup Function
    public User addUser(String name, String email, String phone) {
        User user = new User(name, email, phone);
        users.put(user.getUserId(), user);
        return user;
    }

    // Setup Function
    public Group addGroup(String groupName, List<User> users) {
        for (User user : users) {
            if (this.users.get(user.getUserId()) == null)
                throw new IllegalArgumentException("User is not registered in the system.");
        }

        Group group = new Group(groupName, users);
        groups.put(group.getGroupId(), group);
        return group;
    }

    // Core Function
    public void createExpense(Expense expense) {
        User paidBy = expense.getPaidBy();
        List<User> pariticipants = expense.getParticipants();
        List<Split> splits = expense.getSplits();

        for (int i = 0; i < pariticipants.size(); i++) {
            User participant = pariticipants.get(i);
            if (participant.getUserId().equals(paidBy.getUserId()))
                continue;
            paidBy.getBalanceSheet().adjutsBalance(participant, splits.get(i).getAmount());
            participant.getBalanceSheet().adjutsBalance(paidBy, splits.get(i).getAmount().negate());
        }

    }

    // Core Function
    public void settleUp(String payerId, String payeeId, BigDecimal amount) {
        if (payeeId.equals(payerId))
            throw new IllegalArgumentException("User cannot pay to itself");
        User payer = users.get(payerId);
        User payee = users.get(payeeId);

        payee.getBalanceSheet().adjutsBalance(payer, amount.negate());
        payer.getBalanceSheet().adjutsBalance(payee, amount);
    }

    public void showBalanceSheet(String userId) {
        User user = users.get(userId);
        user.getBalanceSheet().showBalances();
    }

    public List<Transaction> simplifyGroupDebts(String groupId) {
        Group group = groups.get(groupId);
        if (group == null)
            throw new IllegalArgumentException("Group not found");

        // Calculate net balance for each member within the group context
        Map<User, BigDecimal> netBalances = new HashMap<>();
        for (User member : group.getMembers()) {
            BigDecimal balance = BigDecimal.ZERO;
            for (Map.Entry<User, BigDecimal> entry : member.getBalanceSheet().getBalances().entrySet()) {
                // Consider only balances with other group members
                if (group.getMembers().contains(entry.getKey())) {
                    balance = balance.add(entry.getValue());
                }
            }
            netBalances.put(member, balance);
        }

        // Separate into creditors and debtors
        List<Map.Entry<User, BigDecimal>> creditors = netBalances.entrySet().stream()
                .filter(e -> e.getValue().compareTo(BigDecimal.ZERO) > 0).collect(Collectors.toList());

        List<Map.Entry<User, BigDecimal>> debtors = netBalances.entrySet().stream()
                .filter(e -> e.getValue().compareTo(BigDecimal.ZERO) < 0).collect(Collectors.toList());

        creditors.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        debtors.sort(Map.Entry.comparingByValue());

        List<Transaction> transactions = new ArrayList<>();
        int i = 0, j = 0;
        while (i < creditors.size() && j < debtors.size()) {
            Map.Entry<User, BigDecimal> creditor = creditors.get(i);
            Map.Entry<User, BigDecimal> debtor = debtors.get(j);

            BigDecimal creditorAmount = creditor.getValue();
            BigDecimal debtorAmount = debtor.getValue().negate();

            BigDecimal amountToSettle = creditorAmount.compareTo(debtorAmount) <= 0 ? creditorAmount : debtorAmount;

            transactions.add(new Transaction(debtor.getKey(), creditor.getKey(), amountToSettle));

            creditor.setValue(creditor.getValue().subtract(amountToSettle));
            debtor.setValue(debtor.getValue().add(amountToSettle));

            if (creditor.getValue().compareTo(BigDecimal.ZERO) <= 0)
                i++;
            if (debtor.getValue().compareTo(BigDecimal.ZERO) >= 0)
                j++;
        }
        return transactions;
    }

}
