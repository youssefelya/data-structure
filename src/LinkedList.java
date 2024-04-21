package src;

import java.util.Stack;

class Node {
    int value;
    Node next;

    Node(int v) {
        this.value = v;
    }
}

public class LinkedList {

    private Node root;

    public Node addLast(int val) {

        return null;
    }

    public Node addFirst(int val) {

        return null;
    }

    public boolean in(int target) {
        return false;
    }

    public Node reverse() {
        return null;
    }

    public void printLinkedList() {
        Node temp = root;
        while (temp != null) {
            System.out.print(" " + temp.value);
            temp = temp.next;
        }
        System.out.println();
    }

}