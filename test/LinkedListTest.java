package test;

import src.LinkedList;

public class LinkedListTest {

    public static void main(String[] args) {
        testAddLast();
        testAddFirst();
    }

    public static void testAddLast() {
        LinkedList list = new LinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);

        System.out.println("Linked List after adding elements at last: ");
        list.printLinkedList();
        System.out.println();
    }

    public static void testAddFirst() {
        LinkedList list = new LinkedList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);

        System.out.println("Linked List after adding elements at first: ");
        list.printLinkedList();
        System.out.println();
    }
}
