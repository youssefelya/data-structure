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
        return temp;
    }

    public void printLinkedList() {
        Node temp = root;
        while (temp != null) {
            System.out.print(" " + temp.value);
            temp = temp.next;
        }
        System.out.println();
    }

    public boolean in(int target) {
        Node temp = this.root;
        while (temp != null) {
            if (temp.value == target)
                return true;
            temp = temp.next;
        }
        return false;
    }

    public Node reverse() {
        if (root == null || root.next == null) {
            return root;
        }

        Stack<Node> stack = new Stack<>();
        Node temp = root;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }

        Node newRoot = stack.pop();
        temp = newRoot;
        while (!stack.isEmpty()) {
            temp.next = stack.pop();
            temp = temp.next;
        }
        temp.next = null;

        root = newRoot;
        return newRoot;
    }

}