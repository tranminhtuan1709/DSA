package Others;

import java.util.ArrayList;

public class Determine_if_Two_Trees_are_Identical {
    static class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    void preOrderTraverse(Node root, ArrayList<Integer> a) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            preOrderTraverse(root.left, a);
        }
        a.add(root.data);
        if (root.right != null) {
            preOrderTraverse(root.right, a);
        }
    }

    boolean isIdentical(Node root1, Node root2) {
        ArrayList<Integer> tree1 = new ArrayList<>();
        ArrayList<Integer> tree2 = new ArrayList<>();
        System.out.println(tree1.toString());
        System.out.println(tree2.toString());
        preOrderTraverse(root1, tree1);
        preOrderTraverse(root2, tree2);
        return tree1.equals(tree2);
    }
}
