package src;

import src.Color;

public class RedBlackTree implements Tree {

    private TreeNode root;

    public TreeNode add(int val) {
        TreeNode newNode = new TreeNode(val);
        newNode.color = Color.RED;
        if (root == null) {
            root = newNode;
        } else {
            TreeNode current = root;
            TreeNode parent = null;
            while (current != null) {
                parent = current;
                if (val < current.value) {
                    current = current.left;
                } else if (val > current.value) {
                    current = current.right;
                } else {
                    return root;
                }
            }
            if (val < parent.value) {
                parent.left = newNode;
            } else {
                parent.right = newNode;
            }
            newNode.parent = parent;
        }
        fixInsertion(newNode);
        return newNode;
    }

    @Override
    public TreeNode remove(int val) {
        root = remove(root, val);
        return root;
    }

    private TreeNode remove(TreeNode node, int val) {
        if (node == null) {
            return null;
        }
        if (val < node.value) {
            node.left = remove(node.left, val);
        } else if (val > node.value) {
            node.right = remove(node.right, val);
        } else {
            if (node.left == null || node.right == null) {
                TreeNode child = (node.left != null) ? node.left : node.right;
                if (node.color == Color.BLACK) {
                    if (child != null && child.color == Color.RED) {
                        child.color = Color.BLACK;
                    } else {
                        fixDeletion(node);
                    }
                }
                return child;
            }

            TreeNode successor = findMin(node.right);
            node.value = successor.value;
            node.right = remove(node.right, successor.value);
        }

        return node;
    }

    private TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    @Override
    public boolean isBinaryTree() {
        return isBinaryTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBinaryTree(TreeNode node, int min, int max) {
        if (node == null) {
            return true;
        }
        if (node.value < min || node.value > max) {
            return false;
        }

        return isBinaryTree(node.left, min, node.value) && isBinaryTree(node.right, node.value, max);
    }

    @Override
    public boolean isRedBlackTree() {
        if (!checkColors(root))
            return false;

        if (root != null && root.color != Color.BLACK)
            return false;

        return checkBlackHeight(root) != -1;
    }

    private boolean checkColors(TreeNode node) {
        if (node == null)
            return true;
        if (node.color != Color.RED && node.color != Color.BLACK)
            return false;
        return checkColors(node.left) && checkColors(node.right);
    }

    private int checkBlackHeight(TreeNode node) {
        if (node == null)
            return 0;
        int leftHeight = checkBlackHeight(node.left);
        int rightHeight = checkBlackHeight(node.right);

        if (node.color == Color.RED) {
            if (node.left != null && node.left.color != Color.BLACK)
                return -1;
            if (node.right != null && node.right.color != Color.BLACK)
                return -1;
        }
        if (leftHeight != -1 && rightHeight != -1 && leftHeight != rightHeight)
            return -1;

        return (node.color == Color.BLACK) ? leftHeight + 1 : leftHeight;
    }

    public boolean isExist(int val) {
        return isExist(root, val);
    }

    private boolean isExist(TreeNode node, int val) {
        if (node == null) {
            return false;
        }
        if (val == node.value) {
            return true;
        } else if (val < node.value) {
            return isExist(node.left, val);
        } else {
            return isExist(node.right, val);
        }
    }

    private void leftRotate(TreeNode node) {

    }

    private void rightRotate(TreeNode node) {

    }

    private void fixDeletion(TreeNode node) {
    }

    private void recolor(TreeNode node) {
    }

    private TreeNode sibling(TreeNode node) {
        return null;
    }

    private TreeNode uncle(TreeNode node) {
        return null;
    }

    private TreeNode grandparent(TreeNode node) {
        return null;

    }

    private void rotateCase(TreeNode node) {

    }

    // Method to fix double red violation
    private void fixDoubleRed(TreeNode node) {

    }

    // Method to fix black height violation
    private void fixBlackHeight(TreeNode node) {

    }

    private void fixInsertion(TreeNode node) {
        while (node != root && node.parent != null && node.parent.color == Color.RED) {
            if (node.parent == node.parent.parent.left) {
                TreeNode uncle = node.parent.parent.right;
                if (uncle != null && uncle.color == Color.RED) {
                    node.parent.color = Color.BLACK;
                    uncle.color = Color.BLACK;
                    node.parent.parent.color = Color.RED;
                    node = node.parent.parent;
                } else {
                    if (node == node.parent.right) {
                        node = node.parent;
                        leftRotate(node);
                    }
                    if (node.parent != null) {
                        node.parent.color = Color.BLACK;
                        if (node.parent.parent != null) {
                            node.parent.parent.color = Color.RED;
                            rightRotate(node.parent.parent);
                        }
                    }
                }
            } else {
                TreeNode uncle = node.parent.parent.left;
                if (uncle != null && uncle.color == Color.RED) {
                    node.parent.color = Color.BLACK;
                    uncle.color = Color.BLACK;
                    node.parent.parent.color = Color.RED;
                    node = node.parent.parent;
                } else {
                    if (node == node.parent.left) {
                        node = node.parent;
                        rightRotate(node);
                    }
                    if (node.parent != null) {
                        node.parent.color = Color.BLACK;
                        if (node.parent.parent != null) {
                            node.parent.parent.color = Color.RED;
                            leftRotate(node.parent.parent);
                        }
                    }
                }
            }
        }
        root.color = Color.BLACK;
    }

}
