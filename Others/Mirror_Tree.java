package Others;

import java.util.ArrayList;

public class Mirror_Tree {
    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    void mirror(Node node) {
        if (node == null) {
            return;
        }
        Node temp = node.left;
        node.left = node.right;
        node.right = temp;
        mirror(node.left);
        mirror(node.right);
    }
}
