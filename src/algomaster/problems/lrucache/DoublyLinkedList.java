package algomaster.problems.lrucache;

public class DoublyLinkedList<K, V> {
    private Node<K, V> head;
    private Node<K, V> tail;
    private int size;

    public DoublyLinkedList() {
        head = new Node<K, V>(null, null);
        tail = new Node<K, V>(null, null);
        head.setNext(tail);
        tail.setPrevious(head);
    }

    public Node<K, V> getLastNode() {
        return tail.getPrevious();
    }

    // Adds a node at the front of the linked list
    public void addInFront(Node<K, V> node) {
        node.setNext(head.getNext());
        node.setPrevious(head);
        head.getNext().setPrevious(node);
        head.setNext(node);
        size++;
    }

    // Removes the given node from the list
    private void removeNode(Node<K, V> node) {
        node.getNext().setPrevious(node.getPrevious());
        node.getPrevious().setNext(node.getNext());
        size--;
    }

    // Removes the last element from the list
    public void removeTail() {
        removeNode(tail.getPrevious());
    }

    public int getSize() {
        return size;
    }

    public void moveToFront(Node<K, V> node) {
        removeNode(node);
        addInFront(node);
    }

    public void print() {
        Node<K, V> curr = head.getNext();
        while (curr != tail) {
            System.out.println(curr.getKey() + ", " + curr.getValue() + " ");
            curr = curr.getNext();
        }
    }

}
