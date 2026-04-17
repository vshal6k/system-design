package algomaster.problems.doublylinkedlist;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheManager<K, V> {
    private Node<K, V> head;
    private Node<K, V> tail;
    private Map<K, Node<K, V>> keyNodeMapping = new HashMap<>();
    private int size;
    private int capacity;

    private void addFront(Node<K, V> node){
        node.setNext(null);
        node.setPrevious(null);
        if (head == null) {
            // empty linked list
            head = node;
            tail = node;
        } else {
            // filled linked list
            Node<K, V> newNode = node;
            newNode.setNext(head);
            head.setPrevious(newNode);
            head = newNode;
        }
        size++;
    }

    // Removes the given node from the list
    private void removeNode(Node<K, V> node) {
        if (node == null || size == 0)
            return;

        if (size == 1) {
            head = null;
            tail = null;
            size--;
            return;
        }

        if (node == head) {
            head = node.getNext();
            head.setPrevious(null);
        } else if (node == tail) {
            tail = node.getPrevious();
            tail.setNext(null);
        } else {
            node.getNext().setPrevious(node.getPrevious());
            node.getPrevious().setNext(node.getNext());
        }
        size--;
    }

    //Removes the last element from the list
    private void removeTail(){
        removeNode(tail);
    }

    public LRUCacheManager(int capacity){
        this.capacity = capacity;
    }

    public V get(K key){
        //key does not exist in the cache
        if(keyNodeMapping.get(key) == null) return null;

        Node<K, V> node = keyNodeMapping.get(key);
        removeNode(node);
        addFront(node);
        return node.getValue();

    }

    public void put(K key, V v){
        if(keyNodeMapping.get(key) != null){
            //key exists, update the value and recency
            Node<K, V> node = keyNodeMapping.get(key);
            node.setValue(v);
            removeNode(node);
            addFront(node);
        }else{
            //key does not exists
            Node<K, V> node = new Node<K, V>(key, v);
            keyNodeMapping.put(key, node);
            if(size < capacity){
                //cache is not full so insert at the front of the list
                addFront(node);
            }else{
                //cache is full, so remove the tail and insert in front
                keyNodeMapping.remove(tail.getKey());
                removeTail();
                addFront(node);
            }
        }
    }

    public void print(){
        Node<K, V> curr = head;
        while(curr != null){
            System.out.print(curr.toString() + " ");
            curr = curr.getNext();
        }
        System.out.println();
    }

}
