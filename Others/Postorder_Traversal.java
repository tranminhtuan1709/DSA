package Others;

public class Postorder_Traversal {
    static class Node {
        int data;
        Node left;
        Node right;
    }

    public static void postOrder(Node root) {
        if (root.left != null) {
            postOrder(root.left);
        }
        if (root.right != null) {
            postOrder(root.right);
        }
        System.out.print(root.data + " ");
    }
}
