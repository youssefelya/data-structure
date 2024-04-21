package test;

import src.LinkedList;

public class LinkedListTest {

    public static void main(String[] args) {
        testAddLast();
        testAddFirst();
        testIn();
        testReverse();
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

    public static void testIn() {
        LinkedList list = new LinkedList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);

        System.out.println(list.in((-1)));
        System.out.println(list.in((2)));
        list.printLinkedList();
        System.out.println();
    }

    public static void testReverse() {
        LinkedList list = new LinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);

        System.out.println("Linked List before reversing: ");
        list.printLinkedList();
        System.out.println();

        list.reverse();

        System.out.println("Linked List after reversing: ");
        list.printLinkedList();
        System.out.println();
    }
}
