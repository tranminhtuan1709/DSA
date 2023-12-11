package Others;

public class Delete_node_in_Doubly_Linked_List {
    static class Node {
        int data;
        Node next;
        Node prev;
        Node(int d) {
            data = d;
            next = prev = null;
        }
    }

    Node deleteNode(Node head, int x) {
        Node node = head;
        for (int i = 1; i < x; i++) {
            node = node.next;
        }
        if (node.prev == null) {
            head = head.next;
            head.prev = null;
            return head;
        } else if (node.next == null) {
            node.prev.next = null;
            return head;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            return head;
        }
    }
}
