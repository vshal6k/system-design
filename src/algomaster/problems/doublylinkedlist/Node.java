package algomaster.problems.doublylinkedlist;

public class Node <K, V>{
    private Node <K, V>previous;
    private Node<K, V> next;
    private V value;
    private K key;

    Node(K key, V value){
        this.key = key;
        this.value = value;
    }

    public Node<K, V> getPrevious() {
        return previous;
    }

    public void setPrevious(Node <K, V>previous) {
        this.previous = previous;
    }

    public Node <K, V>getNext() {
        return next;
    }

    public void setNext(Node<K, V> next) {
        this.next = next;
    }

    public V getValue() {
        return value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "(" + key + " -> " + value + ")";
    }
}
