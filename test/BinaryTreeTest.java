package test;

import src.BinaryTree;
import src.Tree;
import java.util.Random;

public class BinaryTreeTest {

    public static void main(String[] args) throws Exception {
        testAddBinaryTree();
        testRemoveBinaryTree();
        testIsBinaryTree();

    }

    public static void addRandomValuesForTesting(Tree tree) {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int value = random.nextInt(1000) + 1;
            tree.add(value);
        }
    }

    public static void testAddBinaryTree() throws Exception {
        BinaryTree root = new BinaryTree();
        addRandomValuesForTesting(root);
        if (!root.isBinaryTree())
            throw new Exception("Test failed: Not a binary tree");
        if (root.isRedBlackTree())
            throw new Exception("Test failed: Incorrect Red-Black tree check");
        if (!root.isExist(2) || !root.isExist(6) || !root.isExist(3) || !root.isExist(9))
            throw new Exception("Test failed: Element not found");
        System.out.println("Test passed successfully");
    }

    public static void testRemoveBinaryTree() throws Exception {
        BinaryTree root = new BinaryTree();
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
        BinaryTree root = new BinaryTree();
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

}
