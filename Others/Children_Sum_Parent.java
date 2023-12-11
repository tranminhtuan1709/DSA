package Others;

public class Children_Sum_Parent {
    static class Node {
        int data;
        Node left, right;

        Node(int key) {
            data = key;
            left = right = null;
        }
    }

    public static int isSumProperty(Node root) {
        if (root == null) {
            return 1;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int sumLeft = root.left == null ? 0 : root.left.data;
        int sumRight = root.right == null ? 0 : root.right.data;
        if (sumLeft + sumRight != root.data) {
            return 0;
        } else {
            if (isSumProperty(root.left) + isSumProperty(root.right) == 2) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}
