package blind75.linkedlist;

import java.util.List;

public class ReorderLinkedList {
    public static void main(String[] args) {
        ListNode head = Helper.build(List.of(1, 2, 4, 5));
        new ReorderLinkedList().reorderList(head);
        Helper.traverse(head);
    }

    //time - O(n), space - O(1)
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode tail = reverseList(slow.next);
        slow.next = null;
        ListNode tempHead = head;
        while (tail != null) {
            ListNode tailNext = tail.next;
            ListNode headNext = tempHead.next;

            tail.next = headNext;
            tempHead.next = tail;
            tempHead = headNext;
            tail = tailNext;
        }
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode tempNext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tempNext;
        }
        return prev;
    }
}
