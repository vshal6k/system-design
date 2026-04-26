package algomaster.problems.splitwise;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

import algomaster.problems.splitwise.entities.Expense;
import algomaster.problems.splitwise.entities.Settlement;
import algomaster.problems.splitwise.entities.User;
import algomaster.problems.splitwise.observerpattern.ExpenseObserver;
import algomaster.problems.splitwise.observerpattern.SettlementObserver;

// vishal owes het 200
// vishal -> (het, 200)
// het -> (vishal, -200)
public class BalanceRegistry implements SettlementObserver, ExpenseObserver {
    private final Map<String, Map<String, BigDecimal>> balances = new ConcurrentHashMap<>();
    private final ReentrantReadWriteLock balanceLock = new ReentrantReadWriteLock();
    private final ReadLock balanceReadLock = balanceLock.readLock();
    private final WriteLock balanceWriteLock = balanceLock.writeLock();

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

    private synchronized void updateBalances(String payer, String receiver, BigDecimal amount) {
        // payer has paid amount to receiver, receiver owes amount to payer
        if (amount.compareTo(BigDecimal.ZERO) == 0)
            return;

        try {
            balanceWriteLock.lock();
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
        } finally {
            balanceWriteLock.unlock();
        }
    }

    public Map<String, BigDecimal> getBalance(User user) {
        try {
            balanceReadLock.lock();
            if (balances.get(user.getUserId()) == null) {
                return null;
            }
            Map<String, BigDecimal> userOwedMap = balances.get(user.getUserId());
            return Map.copyOf(userOwedMap);
        } finally {
            balanceReadLock.unlock();
        }
    }

}
