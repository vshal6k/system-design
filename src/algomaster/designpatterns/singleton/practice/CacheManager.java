package algomaster.designpatterns.singleton.practice;

import java.time.Instant;
import java.util.concurrent.ConcurrentHashMap;

public enum CacheManager {
    INSTANCE();

    private static long timeToLiveSeconds = 5L;

    private record CacheEntry(String value, Instant expiry) {
        public boolean isExpired() {
            return expiry != null && Instant.now().isAfter(expiry);
        }
    }

    private ConcurrentHashMap<String, CacheEntry> cacheEntries = new ConcurrentHashMap<>();

    public void put(String key, String value) {
        if (key == null)
            throw new IllegalArgumentException("Key is null");
        cacheEntries.put(key, new CacheEntry(value, Instant.now().plusSeconds(timeToLiveSeconds)));
    }

    public void put(String key, String value, long ttlSeconds) {
        if (key == null)
            throw new IllegalArgumentException("Key is null");

        Instant expiry = ttlSeconds > 0
                ? Instant.now().plusSeconds(ttlSeconds)
                : null;
        cacheEntries.put(key, new CacheEntry(value, expiry));

        cacheEntries.put(key, new CacheEntry(value, Instant.now().plusSeconds(timeToLiveSeconds)));
    }

    public String get(String key) {
        if (key == null)
            throw new IllegalArgumentException("Key is null");

        CacheEntry cacheEntry = cacheEntries.get(key);

        if (cacheEntry != null && !cacheEntry.isExpired())
            return cacheEntry.value();
        else
            return null;
    }

    public int size(){
        return cacheEntries.size();
    }

    public static void main(String[] args) {
        // Both references point to the same CacheManager instance
        CacheManager cache1 = CacheManager.INSTANCE;
        CacheManager cache2 = CacheManager.INSTANCE;

        System.out.println("Same instance? " + (cache1 == cache2)); // true

        // Component A caches data
        cache1.put("user:42", "{name: 'Alice'}", 5); // 5-second TTL
        cache1.put("config:theme", "dark"); // no expiry

        // Component B reads from the same cache
        System.out.println("user:42 = " + cache2.get("user:42")); // {name: 'Alice'}
        System.out.println("config:theme = " + cache2.get("config:theme")); // dark
        System.out.println("Cache size: " + cache2.size());
    }

}
