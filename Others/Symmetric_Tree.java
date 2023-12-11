package Others;

public class Symmetric_Tree {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left=null;
            right=null;
        }
    }

    static boolean check(Node node1, Node node2) {
        if (node1 == null && node2 == null) {
            return true;
        } else if (node1 != null && node2 != null) {
            if (node1.data != node2.data) {
                return false;
            } else {
                return check(node1.left, node2.right) && check(node1.right, node2.left);
            }
        } else {
            return false;
        }
    }

    public static boolean isSymmetric(Node root) {
        if (root == null) {
            return true;
        }
        return check(root.left, root.right);
    }
}
