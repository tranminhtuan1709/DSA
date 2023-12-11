package Others;

import java.util.ArrayList;

public class Finding_middle_element_in_a_linked_list {
    static  class Node {
        int data;
        Node next;
        Node(int d)  { data = d;  next = null; }
    }

    /**
     * There is another solution is that: create two pointer "fast" and "slow",
     * start from head at the same time, but "fast" go two times faster than "slow",
     * so when "fast" reach the end of linked list, "slow" is being the middle.
     * @param head the head of given linked list
     * @return the middle element of a given linked list
     */
    int getMiddle(Node head)
    {
        ArrayList<Integer> a = new ArrayList<>();
        while (head != null) {
            a.add(head.data);
            head = head.next;
        }
        return a.get(a.size() / 2);
    }
}
