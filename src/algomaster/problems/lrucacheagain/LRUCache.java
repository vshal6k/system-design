package algomaster.problems.lrucacheagain;

import java.util.HashMap;

public class LRUCache<K,V> {
    private int capacity;
    private int size;
    private DoublyLinkedList<CacheItem<K,V>> list = new DoublyLinkedList<>();
    private HashMap<K, Node<CacheItem<K,V>>> map = new HashMap<>();

    public LRUCache(int capacity){
        this.capacity = capacity;
        this.size = 0;
    }

    public V get(K k){
        if(map.get(k) == null){
            return null;
        }

        Node<CacheItem<K,V>> oldNode = map.get(k);
        CacheItem<K,V> cacheItem = oldNode.getValue();
        list.deleteNode(oldNode);
        Node<CacheItem<K,V>> newNode = list.insertNodeFront(cacheItem);
        map.put(k, newNode);
        return cacheItem.getValue();
    }

    public void put(K k, V v){
        CacheItem<K,V> cacheItem = new CacheItem<>(k, v);
        if(map.get(k) == null){
            if(size == capacity){
                Node<CacheItem<K,V>> lastNode = list.removeLastNode();
                map.remove(lastNode.getValue().getKey());
                size--;
            }
            Node<CacheItem<K,V>> newNode = list.insertNodeFront(cacheItem);
            map.put(k, newNode);
            size++;
            return;
        }

        Node<CacheItem<K,V>> oldNode = map.get(k);
        list.deleteNode(oldNode);
        Node<CacheItem<K,V>> newNode = list.insertNodeFront(cacheItem);
        map.put(k, newNode);
    }
}
