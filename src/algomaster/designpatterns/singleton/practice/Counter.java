package algomaster.designpatterns.singleton.practice;

import java.util.concurrent.atomic.AtomicInteger;

public enum Counter {
    INSTANCE;

    private volatile AtomicInteger value = new AtomicInteger(0);

    public void increment() {
        value.addAndGet(1);
    }

    public int get() {
        return value.intValue();
    }

    public static void main(String[] args) {
        // Counter instance1 = Counter.INSTANCE;

        // instance1.increment();
        // instance1.increment();

        // Counter instance2 = Counter.INSTANCE;

        // System.out.print("Is instance1 and instance2 equal? ");
        // System.out.println(instance1 == instance2);

        // System.out.println(instance2.get());

        Counter counter = Counter.INSTANCE;

        Runnable incrementValue = () -> {
            counter.increment();
        };

        Thread t1 = new Thread(incrementValue, "T1");
        Thread t2 = new Thread(incrementValue, "T2");
        Thread t3 = new Thread(incrementValue, "T3");

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println(counter.get());

    }
}
