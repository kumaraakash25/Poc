package linkedList;

public class MergeTwoLinkedList {
    public static void main(String[] args) {
        LinkedList list1 = new LinkedList(2);
        list1.addElement(6);
        list1.addElement(7);
        list1.printLinkedList();

        LinkedList list2 = new LinkedList(1);
        list2.addElement(3);
        list2.addElement(4);
        list2.printLinkedList();

        System.out.println("########################");

        mergeLinkedList(list1, list2);

    }

    private static void mergeLinkedList(LinkedList list1, LinkedList list2) {
        Node list1Current = list1.startNode;
        Node list2Current = list2.startNode;
        // 2 ->  6  -> 7
        // 1 ->  3  -> 4
        LinkedList list = new LinkedList();
        while (list1Current != null || list2Current != null) {
            Node shortestNode = null;
            if (list1Current == null) {
                shortestNode = list2Current;
                list2Current = list2Current.getNextNode();
            } else if (list2Current == null) {
                shortestNode = list1Current;
                list1Current = list1Current.getNextNode();
            } else if (list1Current.data < list2Current.data) {
                shortestNode = list1Current;
                list1Current = list1Current.getNextNode();
            } else {
                shortestNode = list2Current;
                list2Current = list2Current.getNextNode();
            }
            list.addElement(shortestNode.data);
        }
        list.printLinkedList();
    }
}
