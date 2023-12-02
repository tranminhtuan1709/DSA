package BT10;

import java.util.*;



class Exercise4 {
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

    public static Node lca(Node root, int v1, int v2) {
        int min = Math.min(v1, v2);
        int max = Math.max(v1, v2);
        while (root.data < min || root.data > max) {
            if (root.data < min) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return root;
    }

    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        int v1 = scan.nextInt();
        int v2 = scan.nextInt();
        scan.close();
        assert root != null;
        Node ans = lca(root,v1,v2);
        System.out.println(ans.data);
    }
}