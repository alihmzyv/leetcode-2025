package blind75.linkedlist;

public class ReverseLinkedList {
    //time - O(n), space - O(1)
    public ListNode reverseList(ListNode head) {
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

    //time - O(n), space - O(n)
    public ListNode reverseListRecursive(ListNode head) {
        return reverseRecursively(head, null);
    }

    private ListNode reverseRecursively(ListNode node, ListNode next) {
        if (node != null) {
            ListNode temp = node.next;
            node.next = next;
            return reverseRecursively(temp, node);
        } else {
            return next;
        }
    }
}
