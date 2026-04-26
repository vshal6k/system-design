package algomaster.problems.splitwise;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import algomaster.problems.splitwise.entities.Group;
import algomaster.problems.splitwise.entities.User;
import algomaster.problems.splitwise.splitstrategy.EqualSplitStrategy;
import algomaster.problems.splitwise.splitstrategy.ExactAmountSplitStrategy;
import algomaster.problems.splitwise.splitstrategy.PercentageSplitStrategy;

public class SplitwiseSystemDemo {
    public static void main(String[] args) throws InterruptedException {

        SplitwiseSystem system = new SplitwiseSystem();
        User vishal = system.addUser("Vishal", "vshal6k@gmail.com", "8770556229");
        User kanan = system.addUser("Kanan", "skanan096@gmail.com", "9098752170");
        User het = system.addUser("Het", "het1236@gmail.com", "9098234170");

        List<User> users = List.of(vishal, kanan, het);

        Group myGroup = system.createGroup("My Group", users);

        Thread t1 = new Thread(() -> {
            system.addGroupExpense(vishal, myGroup, BigDecimal.valueOf(60), new EqualSplitStrategy());
        });

        Thread t2 = new Thread(() -> {
            system.addGroupExpense(het, myGroup, BigDecimal.valueOf(30), new EqualSplitStrategy());
        });

        Thread t3 = new Thread(() -> {
            system.addGroupExpense(kanan, myGroup, BigDecimal.valueOf(30), new EqualSplitStrategy());
        });

        Thread t5 = new Thread(() -> {
            system.displayAmountOwed(kanan);
            system.displayAmountOwed(het);
            system.displayAmountOwed(vishal);
        });

        Thread t6 = new Thread(() -> {
            system.addGroupExpense(vishal, myGroup, BigDecimal.valueOf(30), new EqualSplitStrategy());
        });

        Thread t7 = new Thread(() -> {
            system.settleFull(kanan, vishal);
        });

        // Add Group Expenses Simulataneously
        t1.start();
        t2.start();
        t3.start();
        t5.start();
        t6.start();

        t7.start();

        // try {
        // // wait for expenses to get added
        // t1.join();
        // t2.join();
        // t3.join();
        // } catch (InterruptedException e) {
        // e.printStackTrace();
        // }

        // // Check if simulataneous expense addition works
        // system.displayAmountOwed(kanan);
        // system.displayAmountOwed(het);
        // system.displayAmountOwed(vishal);

        // User aman = system.addUser("Aman", "aman@gmail.com", "8770556229");
        // User anshit = system.addUser("Anshit", "anshit@gmail.com", "9098752170");
        // User harsh = system.addUser("Harsh", "harsh@gmail.com", "9098234170");

        // Map<String, BigDecimal> userPercentMap = new HashMap<>();
        // userPercentMap.put(aman.getUserId(), BigDecimal.valueOf(0.249));
        // userPercentMap.put(anshit.getUserId(), BigDecimal.valueOf(0.250));
        // userPercentMap.put(harsh.getUserId(), BigDecimal.valueOf(0.500000000));

        // List<User> friends = List.of(aman, anshit, harsh);

        // Group friendGroup = system.createGroup("Friends", friends);

        // system.addGroupExpense(aman, friendGroup, BigDecimal.valueOf(20), new
        // PercentageSplitStrategy(userPercentMap));

        // system.displayAmountOwed(aman);
        // system.displayAmountOwed(anshit);
        // system.displayAmountOwed(harsh);

        // User soumya = system.addUser("soumya", "soumya@gmail.com", "8770556229");
        // User vaidehi = system.addUser("vaidehi", "vaidehi@gmail.com", "9098752170");
        // User apeksha = system.addUser("apeksha", "apeksha@gmail.com", "9098234170");

        // Map<String, BigDecimal> userPercentMap = new HashMap<>();
        // userPercentMap.put(soumya.getUserId(), BigDecimal.valueOf(1.99));
        // userPercentMap.put(vaidehi.getUserId(), BigDecimal.valueOf(1.46));
        // userPercentMap.put(apeksha.getUserId(), BigDecimal.valueOf(3.55));

        // List<User> friends = List.of(soumya, vaidehi, apeksha);

        // Group friendGroup = system.createGroup("Friends", friends);

        // system.addGroupExpense(soumya, friendGroup, BigDecimal.valueOf(7), new
        // ExactAmountSplitStrategy(userPercentMap));

        // system.displayAmountOwed(soumya);
        // system.displayAmountOwed(vaidehi);
        // system.displayAmountOwed(apeksha);

        // User katy = system.addUser("katy", "vshal6k@gmail.com", "8770556229");
        // User hary = system.addUser("hary", "skanan096@gmail.com", "9098752170");
        // User john = system.addUser("john", "het1236@gmail.com", "9098234170");

        // List<User> foreignUsers = List.of(katy, hary, john);

        // Group foreignGroup = system.createGroup("The Group", foreignUsers);

        // system.addGroupExpense(katy, foreignGroup, BigDecimal.valueOf(30), new
        // EqualSplitStrategy());

        // system.displayAmountOwed(katy);
        // system.displayAmountOwed(hary);
        // system.displayAmountOwed(john);

        // system.addIndividualExpense(katy, john, BigDecimal.valueOf(10));

        // System.out.println("==========");

        // system.displayAmountOwed(katy);
        // system.displayAmountOwed(hary);
        // system.displayAmountOwed(john);

    }
}
