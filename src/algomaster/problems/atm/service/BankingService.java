package algomaster.problems.atm.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import algomaster.problems.atm.domainmodel.Account;
import algomaster.problems.atm.domainmodel.Card;

public class BankingService {
    private Map<String, Card> cards = new HashMap<>();
    private Map<String, Account> accounts = new HashMap<>();
    private Map<String, String> cardAccountMap = new HashMap<>();

    public BankingService() {
        // Create sample accounts and cards
        Account account1 = createAccount("1234567890", BigDecimal.valueOf(1000.0));
        Card card1 = createCard("1234-5678-9012-3456", "1234");
        linkCardToAccount(card1, account1);

        Account account2 = createAccount("9876543210", BigDecimal.valueOf(500.0));
        Card card2 = createCard("9876-5432-1098-7654", "4321");
        linkCardToAccount(card2, account2);
    }

    public Card createCard(String cardNumber, String pin) {
        Card card = new Card(pin, cardNumber);
        cards.put(cardNumber, card);
        return card;
    }

    public Account createAccount(String number, BigDecimal balance) {
        Account account = new Account(number, balance);
        accounts.put(number, account);
        return account;
    }

    public void linkCardToAccount(Card card, Account account) {
        cardAccountMap.put(card.getNumber(), account.getNumber());
    }

    public BigDecimal checkBalance(Card card) {
        String accountNumber = cardAccountMap.get(card.getNumber());
        Account account = accounts.get(accountNumber);
        if (account == null)
            throw new IllegalArgumentException("Card is not associated to any account");

        return account.getBalance();
    }

    public void withdraw(Card card, BigDecimal amount) {
        String accountNumber = cardAccountMap.get(card.getNumber());
        Account account = accounts.get(accountNumber);
        if (account == null)
            throw new IllegalArgumentException("Card is not associated to any account");

        BigDecimal balance = account.getBalance();
        if (balance.compareTo(amount) < 0)
            throw new IllegalArgumentException("Insufficient balance in account");

        account.withdraw(amount);
    }

    public void deposit(Card card, BigDecimal amount) {
        String accountNumber = cardAccountMap.get(card.getNumber());
        Account account = accounts.get(accountNumber);
        if (account == null)
            throw new IllegalArgumentException("Card is not associated to any account");

        account.deposit(amount);
    }

}
