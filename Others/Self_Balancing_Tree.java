package Others;

public class Self_Balancing_Tree {
    static class Node {
		int val;
		int ht;
		Node left;
		Node right;
	}

	/**
	 * Perform a left rotation.
	 * @param node node to be rotated
	 */
	static Node rotateLeft(Node node) {
		if (node.right == null) {
			return node;
		}
		Node right = node.right;
		Node childLeft = right.left;
		right.left = node;
		node.right = childLeft;
		node.ht = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
		right.ht = Math.max(getHeight(right.left), getHeight(right.right) + 1);
		return right;
	}

	/**
	 * Perform a right rotation.
	 * @param node nod to be rotated
	 */
	static Node rotateRight(Node node) {
		if (node.left == null) {
			return node;
		}
		Node left = node.left;
		Node childRight = left.right;
		left.right = node;
		node.left = childRight;
		node.ht = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
		left.ht = Math.max(getHeight(left.left), getHeight(left.right)) + 1;
		return left;
	}

	/**
	 * Get height of a specific node in tree.
	 * @param node get height of this given node
	 * @return a positive integer representing the height if given node is not null and -1 in opposite
	 */
	static int getHeight(Node node) {
		return node == null ? -1 : node.ht;
	}

	/**
	 * Get Balance Factor of given node.
	 * IF BF > 1 => tree is left - heavy.
	 * IF BF < -1 => tree is right - heavy.
	 * @param node get BF of this given node
	 * @return height(left subtree) - height(right subtree)
	 */
	static int getBF(Node node) {
		if (node == null) {
			return 0;
		} else {
			return getHeight(node.left) - getHeight(node.right);
		}
	}

	/**
	 * Perform insertion and balance.
	 * @param root source node in AVL tree
	 * @param val the value to be added
	 * @return a node that refers to the head of new inserted tree
	 */
	static Node insert(Node root, int val)
	{
		if (root == null) {
			root = new Node();
			root.ht = 0;
			root.val = val;
			return root;
		}
		if (val < root.val) {
			root.left = insert(root.left, val);
		} else if (val > root.val) {
			root.right = insert(root.right, val);
		} else {
			return root;
		}
		root.ht = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
		if (getBF(root) > 1) {
            if (getBF(root.left) < 0) {
                root.left = rotateLeft(root.left);
            }
            return rotateRight(root);
        }
		if (getBF(root) < -1) {
            if (getBF(root.right) > 0) {
                root.right = rotateRight(root.right);
            }
            return rotateLeft(root);
        }
		return root;
	}
}
