import java.util.*;

public class LRUCache {

    private static final int CACHE_SIZE = 3;
    private static Map<String, Node> cache = new HashMap<>();
    private static DoublyLinkedList linkedList = new DoublyLinkedList();
    private static ArrayDeque queue = new ArrayDeque();


    public static void main(String[] args) {
    }

    private static void addElement(String key, String value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            Node insertNode = new Node(key, value);
            linkedList.setHeadTo(insertNode);

            if (node != null && node.value == value) {
                // Do nothing just mark element as head
            } else {
                if (cache.size() < CACHE_SIZE) {
                    // Simple addition
                } else {
                    // Just add the element and make it the head
                }
            }
        } else {
            // check size if < CACHE_SIZE
            // If yes then add element and make it the head
            // else just remove the
        }
    }

    private static String fetchValue(String key) {
        // If found return else null
        if (cache.containsKey(key)) {

        } else {

        }
        return null;
    }
}

class DoublyLinkedList {
    Node head;
    Node tail;

    public void setHeadTo(Node node) {
        if (head == node) {
            // Nothing to do here
            return;
        } else if (head == null) {
            head = node;
            tail = node;
        } else if (head == tail) {
            tail.previousNode = node;
            head = node;
            head.nextNode = tail;
        } else {
            if (tail == node) {
                removeTail();
            }
            node.removeBindings();
            node.nextNode = head;
            head.previousNode = node;
            head = node;
        }

    }

    public void removeTail() {
        if (tail == null) {
            return;
        }
        if (tail == head) {
            tail = null;
            head = null;
            return;
        }
        tail = tail.previousNode;
        tail.nextNode = null;
    }
}

class Node {
    String key;
    String value;
    Node previousNode = null;
    Node nextNode = null;

    public Node(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public void removeBindings() {
        if (previousNode != null) {
            previousNode.nextNode = nextNode;
        }
        if (nextNode != null) {
            nextNode.previousNode = previousNode;
        }
        previousNode = null;
        nextNode = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return key.equals(node.key) && value.equals(node.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value, previousNode, nextNode);
    }
}
