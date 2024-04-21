package src;

class Node {
    int value;
    Node left, right;

    Node(int v) {
        this.value = v;
    }
}

public interface Tree {
    Node add(int val);

    Node remove(int val);

    boolean isBinaryTree();

    boolean isRedBlackTree();

    boolean isExist(int val);
}
