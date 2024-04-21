package src;

public class BinaryTree implements Tree {

    TreeNode root;

    public TreeNode add(int val) {
        if (root == null) {
            root = new TreeNode(val);
            return root;
        }
        return addRecursive(root, val);
    }

    private TreeNode addRecursive(TreeNode current, int val) {
        if (current == null) {
            return new TreeNode(val);
        }

        if (val < current.value) {
            current.left = addRecursive(current.left, val);
        } else {
            current.right = addRecursive(current.right, val);
        }

        return current;
    }

    @Override
    public TreeNode remove(int val) {
        return null;
    }

    @Override
    public boolean isBinaryTree() {
        return true;
    }

    @Override
    public boolean isRedBlackTree() {
        return false;
    }

    public boolean isExist(int val) {
        return isExistRecursive(root, val);
    }

    private boolean isExistRecursive(TreeNode current, int val) {
        if (current == null) {
            return false;
        }
        if (val == current.value) {
            return true;
        }

        if (val < current.value) {
            return isExistRecursive(current.left, val);
        } else {
            return isExistRecursive(current.right, val);
        }
    }

}
