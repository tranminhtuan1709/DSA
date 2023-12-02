package BT10;

import java.util.*;

class Exercise3 {
    static class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static void preOrder( Node root ) {

        if( root == null)
            return;

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);

    }

    public static Node insert(Node root,int data) {
        Node head = root;
        if (root == null) {
            root = new Node(data);
            return root;
        }
        Node temp = new Node(data);
        while (true) {
            if (data < root.data) {
                if (root.left != null) {
                    root = root.left;
                } else {
                    root.left = temp;
                    break;
                }
            } else {
                if (root.right != null) {
                    root = root.right;
                } else {
                    root.right = temp;
                    break;
                }
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        preOrder(root);
    }
}