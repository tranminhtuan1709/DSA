package BT10;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Exercise5 {
    static class Node {
        int data;
        Node left;
        Node right;
    }

    void inOrder(Node root, ArrayList<Integer> a) {
        if (root == null) {
            return;
        }
        inOrder(root.left, a);
        a.add(root.data);
        inOrder(root.right, a);
    }

    boolean checkBST(Node root) {
        ArrayList<Integer> a = new ArrayList<>();
        inOrder(root, a);
        for (int i = 0; i < a.size() - 1; i++) {
            if (a.get(i) >= a.get(i + 1)) {
                return false;
            }
        }
        
        return true;
    }
}
