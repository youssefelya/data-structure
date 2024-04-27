package src;

enum Color {
    RED,
    BLACK
}

class TreeNode {
    int value;
    TreeNode left, right, parent;
    Color color;

    TreeNode(int v) {
        this.value = v;
    }
}

public interface Tree {
    TreeNode add(int val);

    TreeNode remove(int val);

    boolean isBinaryTree();

    boolean isRedBlackTree();

    boolean isExist(int val);
}
