package linkedList;

public class LinkedList {
    Node startNode;

    LinkedList() {
    }

    LinkedList(int data) {
        // Linked list initialised
        startNode = new Node(data);
    }

    public void addElement(int data) {
        if (startNode == null) {
            startNode = new Node(data);
            return;
        }
        Node currentNode = startNode;
        while (currentNode.getNextNode() != null) {
            currentNode = currentNode.getNextNode();
        }
        currentNode.setNextNode(new Node(data));
    }

    public void printLinkedList() {
        Node currentNode = startNode;
        while (currentNode != null) {
            System.out.println(currentNode.data);
            currentNode = currentNode.getNextNode();
        }
    }

}

class Node {
    int data;
    Node nextNode;

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    public Node(int data) {
        this.data = data;
    }
}
