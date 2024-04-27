package test;

import src.RedBlackTree;
import src.Tree;

import java.util.Random;

public class RedBlackTreeTest {

    public static void main(String[] args) throws Exception {
        testAddRedBlackTree();
        testRemoveRedBlackTree();
        testIsBinaryTree();
        testIsExist();
    }

    private static void addRandomValuesForTesting(Tree tree) {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int value = random.nextInt(1000) + 1;
            tree.add(value);
        }
    }

    public static void testAddRedBlackTree() throws Exception {
        RedBlackTree root = new RedBlackTree();
        addRandomValuesForTesting(root);
        root.add(2);
        root.add(3);
        root.add(9);
        if (!root.isBinaryTree())
            throw new Exception("Test failed: Not a binary tree");
        if (!root.isRedBlackTree())
            throw new Exception("Test failed: Not a Red-Black tree");
        if (!root.isExist(2) || !root.isExist(3) || !root.isExist(9))
            throw new Exception("Test failed: Element not found");
        System.out.println("Test passed successfully");
    }

    public static void testRemoveRedBlackTree() throws Exception {
        RedBlackTree root = new RedBlackTree();
        root.add(5);
        root.add(3);
        root.add(7);
        root.add(4);

        root.remove(3);
        root.remove(7);
        root.remove(5);

        if (root.isExist(3) || root.isExist(7) || root.isExist(5))
            throw new Exception("Test failed: Element not removed properly");
        if (!root.isExist(4))
            throw new Exception("Test failed: Incorrect node removed");
        System.out.println("Test passed successfully");
    }

    public static void testIsBinaryTree() throws Exception {
        RedBlackTree root = new RedBlackTree();
        root.add(5);
        root.add(3);
        root.add(7);
        root.add(2);
        root.add(4);
        root.add(6);
        root.add(8);

        if (!root.isBinaryTree())
            throw new Exception("Test failed: Binary tree is not balanced");
        System.out.println("Test passed successfully");
    }

    public static void testIsExist() throws Exception {
        RedBlackTree tree = new RedBlackTree();
        tree.add(5);
        tree.add(3);
        tree.add(7);
        tree.add(2);
        tree.add(4);
        tree.add(6);
        tree.add(8);

        if (!tree.isExist(5) || !tree.isExist(3) || !tree.isExist(7) || !tree.isExist(2) || !tree.isExist(4)
                || !tree.isExist(6) || !tree.isExist(8))
            throw new Exception("Test failed: Existing value not found");

        if (tree.isExist(10) || tree.isExist(1) || tree.isExist(9))
            throw new Exception("Test failed: Non-existing value found");

        System.out.println("Test passed successfully");
    }

}
