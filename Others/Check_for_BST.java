package Others;

import java.util.ArrayList;

public class Check_for_BST {
    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = null;
            right = null;
        }
    }

    void inOrder(Node node, ArrayList<Integer> a) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            inOrder(node.left, a);
        }
        a.add(node.data);
        if (node.right != null) {
            inOrder(node.right, a);
        }
    }

    boolean isBST(Node root) {
        ArrayList<Integer> tree = new ArrayList<>();
        inOrder(root, tree);
        for (int i = 0; i < tree.size() - 1; i++) {
            if (tree.get(i) >= tree.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
}
