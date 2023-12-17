package Tree;

public class BST {
    static class Node {
        public int data;
        public Node left;
        public Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node insert(Node root, int x) {
        if (root == null) {
            return new Node(x);
        }
        if (x < root.data) {
            root.left = insert(root.left, x);
        } else {
            root.right = insert(root.right, x);
        }
        return root;
    }

    public static Node delete(Node root, int x) {
        if (root == null) {
            return null;
        }
        if (x < root.data) {
            root.left = delete(root.left, x);
        } else if (x > root.data) {
            root.right = delete(root.right, x);
        } else {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            Node temp = root;
            root = getMinRight(root.right);
            root.right = deleteMinRight(temp.right);
            root.left = temp.left;
        }
        return root;
    }

    public static boolean search(Node root, int x) {
        if (root == null) {
            return false;
        } else if (x < root.data) {
            return search(root.left, x);
        } else if (x > root.data) {
            return search(root.right, x);
        } else {
            return true;
        }
    }

    public static Node getMinRight(Node root) {
        if (root.left == null) {
            return root;
        } else {
            return getMinRight(root.left);
        }
    }

    public static Node deleteMinRight(Node root) {
        if (root.left == null) {
            return root;
        } else {
            root.left = deleteMinRight(root.left);
        }
        return root;
    }

    public static void print(Node root) {
        if (root == null) {
            return;
        } else {
            System.out.println(root.data);
            print(root.left);
            print(root.right);
        }
    }

    public static int countNode(Node root) {
        if (root == null) {
            return 0;
        } else {
            return countNode(root.left) + countNode(root.right) + 1;
        }
    }

    public static void main(String[] args) {
        Node s = new Node(8);

        print(s);
    }
}
