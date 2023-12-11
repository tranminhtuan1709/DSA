package Others;

public class Check_If_Circular_Linked_List {
    static class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }

    boolean isCircular(Node head) {
        if (head == null) {
            return true;
        }
        Node temp = head.next;
        while (temp != null && temp != head) {
            temp = temp.next;
        }
        return temp == head;
    }
}
