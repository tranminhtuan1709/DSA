package Others;

public class Check_for_Balanced_Tree {
    static class Node {
        int data;
        Node left,right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    int height(Node node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        node.data = Math.max(leftHeight, rightHeight) + 1;
        return node.data;
    }

    int getHeight(Node node) {
        if (node == null) {
            return -1;
        } else {
            return node.data;
        }
    }

    boolean check(Node node) {
        if (node == null) {
            return true;
        }
        if (Math.abs(getHeight(node.left) - getHeight(node.right)) <= 1) {
            return check(node.left) && check(node.right);
        } else {
            return false;
        }
    }

    boolean isBalanced(Node root) {
        if (root == null) {
            return true;
        }
        height(root);
        return check(root);
    }
}
