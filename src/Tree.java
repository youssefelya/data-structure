package src;

class TreeNode {
    int value;
    TreeNode left, right;

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
