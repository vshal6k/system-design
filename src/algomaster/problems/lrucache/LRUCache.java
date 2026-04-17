package algomaster.problems.lrucache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V> implements Cache<K,V>{
    private int capacity;
    private DoublyLinkedList<K, V> dll = new DoublyLinkedList<>();
    private Map<K, Node<K, V> > keyNodeMapping = new HashMap<>();

    public LRUCache(int capacity){
        this.capacity = capacity;
    }

    public synchronized V get(K key){
        //key does not exist in the cache
        if(keyNodeMapping.get(key) == null) return null;

        Node<K, V> node = keyNodeMapping.get(key);
        dll.moveToFront(node);
        return node.getValue();
    }

    public synchronized void put(K key, V v){
        if(keyNodeMapping.get(key) != null){
            //key exists, update the value and recency
            Node<K, V> node = keyNodeMapping.get(key);
            node.setValue(v);
            dll.moveToFront(node);
        }else{
            //key does not exists
            Node<K, V> node = new Node<K, V>(key, v);
            keyNodeMapping.put(key, node);
            if(dll.getSize() < capacity){
                //cache is not full so insert at the front of the list
                dll.addInFront(node);
            }else{
                //cache is full, so remove the tail and insert in front
                keyNodeMapping.remove(dll.getLastNode().getKey());
                dll.removeTail();
                dll.addInFront(node);
            }
        }
    }

    public synchronized void print(){
        dll.print();
    }

}
