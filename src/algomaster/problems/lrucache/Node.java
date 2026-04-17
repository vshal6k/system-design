package algomaster.problems.lrucache;

public class Node <K, V>{
    private Node<K, V> previous;
    private Node<K, V> next;
    private V value;
    private K key;

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
    }

    Node<K, V> getPrevious() {
        return previous;
    }

    void setPrevious(Node<K, V> previous) {
        this.previous = previous;
    }

    Node<K, V> getNext() {
        return next;
    }

    void setNext(Node<K, V> next) {
        this.next = next;
    }

    V getValue() {
        return value;
    }

    K getKey() {
        return key;
    }

    void setValue(V value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "(" + key + " -> " + value + ")";
    }
}
