
public class LinkedList {
    class Node {
        int value;
        Node next;

        Node(int v) {
            this.value = v;
        }
    }

    private Node root;

    public Node addLast(int val) {
        Node temp = root;
        while (temp != null) {
            temp = temp.next;
        }
        temp = new Node(val);
        return root;
    }

    public Node addFirst(int val) {
        Node temp = new Node(val);
        temp.next = root;
        root = temp;
        return root;
    }

    public void printLinkedList() {
        Node temp = root;
        while (temp != null) {
            System.out.print(" " + temp.value);
            temp = temp.next;
        }
    }

}