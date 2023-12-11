package Others;

public class Diameter_of_a_Binary_Tree {
    int res = 0;
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    int dia(Node node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = dia(node.left);
        int rightHeight = dia(node.right);
        int height = Math.max(leftHeight, rightHeight) + 1;
        res = Math.max(res, leftHeight + rightHeight + 1);
        return height;
    }

    /**
     * Diameter = max(sum(leftHeight + rightHeight)).
     * @param root root
     * @return diameter of a given binary tree
     */
    int diameter(Node root) {
        dia(root);
        return res;
    }
}
