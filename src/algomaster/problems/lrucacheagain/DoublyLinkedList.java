package algomaster.problems.lrucacheagain;

public class DoublyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;

    public DoublyLinkedList(){
        this.head = new Node<T>(null);
        this.tail = new Node<T>(null);
        head.setNext(tail);
        tail.setPrevious(head);
    }

    public Node<T> insertNodeFront(T t){
        Node<T> node = new Node<T>(t);
        Node<T> headNext = head.getNext();
        node.setNext(headNext);
        head.setNext(node);
        headNext.setPrevious(node);
        node.setPrevious(head);
        return node;
    }

    public void deleteNode(Node<T> node){
        Node<T> nextNode = node.getNext();
        Node<T> previousNode = node.getPrevious();

        previousNode.setNext(nextNode);
        nextNode.setPrevious(previousNode);
    }

    public Node<T> removeLastNode(){
        Node<T> lastNode = tail.getPrevious();
        lastNode.getPrevious().setNext(tail);
        tail.setPrevious(lastNode.getPrevious());
        return lastNode;
    }
}
