package src;

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
        if (root == null) {
            Node newNode = new Node(val);
            root = newNode;
            return root;
        }
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(val);
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