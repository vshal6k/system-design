package algomaster.problems.lrucacheagain;

public class Client {
    public static void main(String[] args) {
        LRUCache<Integer, String> lru = new LRUCache<>(3);
        lru.put(1, "Vishal");
        lru.put(2, "Kanan");
        lru.put(3, "Het");
        lru.get(1);
        lru.get(2);

        System.out.println(lru.get(1));
        System.out.println(lru.get(2));
        System.out.println(lru.get(3));
        System.out.println(lru.get(4));

    }
}
