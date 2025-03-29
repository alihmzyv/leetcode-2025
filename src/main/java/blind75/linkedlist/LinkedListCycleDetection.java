package blind75.linkedlist;

import java.util.LinkedList;
import java.util.List;

public class LinkedListCycleDetection {
    public static void main(String[] args) {
        ListNode head = Helper.build(List.of(3, 2, 0, -4));
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = head;
        new LinkedListCycleDetection().hasCycle(head);
    }

    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }
}
