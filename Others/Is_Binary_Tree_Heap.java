package Others;

public class Is_Binary_Tree_Heap {
    static class Node {
        int data;
        Node left,right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    int countNodes(Node node) {
        if (node == null) {
            return 0;
        }
        int left = countNodes(node.left);
        int right = countNodes(node.right);
        return left + right + 1;
    }

    boolean isCompleted(Node node, int n, int index) {
        if (node == null) {
            return true;
        }
        if (index > n) {
            return false;
        }
        boolean left = isCompleted(node.left, n, index * 2);
        boolean right = isCompleted(node.right, n, index * 2 + 1);
        return left && right;
    }

    boolean isMaxHeap(Node node) {
        if (node == null) {
            return true;
        }
        if (node.left == null && node.right == null) {
            return true;
        } else if (node.left != null && node.right == null) {
            return node.data >= node.left.data;
        } else if (node.left == null) {
            return node.data >= node.right.data;
        } else {
            if (node.data >= node.left.data && node.data >= node.right.data) {
                return isMaxHeap(node.left) && isMaxHeap(node.right);
            } else {
                return false;
            }
        }
    }

    boolean isHeap(Node node) {
        return isMaxHeap(node) && isCompleted(node, countNodes(node), 1);
    }
}
