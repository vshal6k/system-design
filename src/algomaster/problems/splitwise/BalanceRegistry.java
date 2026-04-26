package algomaster.problems.splitwise;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import algomaster.problems.splitwise.entities.Expense;
import algomaster.problems.splitwise.entities.Settlement;
import algomaster.problems.splitwise.entities.User;
import algomaster.problems.splitwise.observerpattern.ExpenseObserver;
import algomaster.problems.splitwise.observerpattern.SettlementObserver;

public class BalanceRegistry implements SettlementObserver, ExpenseObserver {
    // stores if a particular key owes something, and to who it owes, and how much
    // vishal owes het 200
    // vishal -> (het, 200)
    // het -> (vishal, -200)
    private final Map<String, Map<String, BigDecimal>> balances = new ConcurrentHashMap<>();

    // Update balances as per the expense addition
    @Override
    public void onExpenseAddition(Expense expense) {
        User payer = expense.getPayer();
        Map<String, BigDecimal> amountToReceive = expense.split();

        for (String receiverId : amountToReceive.keySet()) {
            if (receiverId == payer.getUserId())
                continue;
            updateBalances(payer.getUserId(), receiverId, amountToReceive.get(receiverId));
        }

    }

    @Override
    public void onSettlement(Settlement settlement) {
        // Update balances as per the settlement done
        // payer has paid amount to receiver, receiver owes amount to payer
        User payer = settlement.getPayer();
        User receiver = settlement.getReceiver();
        BigDecimal amount = settlement.getAmount();
        updateBalances(payer.getUserId(), receiver.getUserId(), amount);
    }

    private void updateBalances(String payer, String receiver, BigDecimal amount) {
        // payer has paid amount to receiver, receiver owes amount to payer
        if (amount.compareTo(BigDecimal.ZERO) == 0)
            return;

        Map<String, BigDecimal> receiverOwedMap = balances.get(receiver);
        if (receiverOwedMap == null) {
            balances.put(receiver, new HashMap<>());
            receiverOwedMap = balances.get(receiver);
        }

        Map<String, BigDecimal> payerOwedMap = balances.get(payer);
        if (payerOwedMap == null) {
            balances.put(payer, new HashMap<>());
            payerOwedMap = balances.get(payer);
        }

        if (receiverOwedMap.get(payer) != null && payerOwedMap.get(receiver) != null) {
            receiverOwedMap.put(payer, receiverOwedMap.get(payer).add(amount));
            payerOwedMap.put(receiver, payerOwedMap.get(receiver).subtract(amount));
        } else {
            receiverOwedMap.put(payer, amount);
            payerOwedMap.put(receiver, amount.negate());
        }

        if (BigDecimal.ZERO.compareTo(receiverOwedMap.get(payer)) == 0
                && BigDecimal.ZERO.compareTo(payerOwedMap.get(receiver)) == 0) {
            receiverOwedMap.remove(payer);
            if (receiverOwedMap.size() == 0)
                balances.remove(receiver);
            payerOwedMap.remove(receiver);
            if (payerOwedMap.size() == 0)
                balances.remove(payer);
        }
    }

    public Map<String, BigDecimal> getBalance(User user) {
        if (balances.get(user.getUserId()) == null) {
            return null;
        }
        Map<String, BigDecimal> userOwedMap = balances.get(user.getUserId());
        return Map.copyOf(userOwedMap);
    }

}
