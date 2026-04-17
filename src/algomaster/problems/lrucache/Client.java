package algomaster.problems.lrucache;

public class Client {
    public static void main(String[] args) {
        LRUCache<String, String> myCache;

        System.out.println("Test Case 1: Elements are stored in MRU to LRU");
        myCache = new LRUCache<>(3);
        myCache.put("Deeptanshu", "Sandy");
        myCache.put("Himanshu", "Diksha");
        myCache.put("Gauresh", "Akansha");
        myCache.print();

        System.out.println("Test Case 2: LRU is removed when capacity is full");
        myCache = new LRUCache<>(3);
        myCache.put("Deeptanshu", "Sandy");
        myCache.put("Himanshu", "Diksha");
        myCache.put("Gauresh", "Akansha");
        myCache.put("Vishal", "Kanan");
        myCache.print();

        System.out.println("Test Case 3: LRU is updated when a key is updated");
        myCache = new LRUCache<>(3);
        myCache.put("Deeptanshu", "Sandy");
        myCache.put("Himanshu", "Diksha");
        myCache.put("Gauresh", "Akansha");
        myCache.put("Deeptanshu", "Ruru");
        myCache.print();

        System.out.println("Test Case 3: LRU is updated when a key is fetched");
        myCache = new LRUCache<>(3);
        myCache.put("Deeptanshu", "Sandy");
        myCache.put("Himanshu", "Diksha");
        myCache.put("Gauresh", "Akansha");
        myCache.get("Himanshu");
        myCache.print();
    }
}
