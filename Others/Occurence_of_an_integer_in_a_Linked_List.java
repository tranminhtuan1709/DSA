package Others;

public class Occurence_of_an_integer_in_a_Linked_List {
    static class Node {
        int data;
        Node next;
        Node(int key) {
            data = key;
            next = null;
        }
    }

    public static int count(Node head, int search_for) {
        int count = 0;
        while (head != null) {
            if (head.data == search_for) {
                count++;
            }
            head = head.next;
        }
        return count;
    }
}
