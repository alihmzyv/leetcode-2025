package blind75.linkedlist;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class RemoveNodeFromEndOfLinkedList {
    public static void main(String[] args) {
        ListNode listNode = new RemoveNodeFromEndOfLinkedList().removeNthFromEndRecursively(Helper.build(List.of(1)), 1);
        Helper.traverse(listNode);
    }

    //time - O(n), space - O(1)
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode right = head;
        while (n > 0) {
            right = right.next;
            n--;
        }

        ListNode left = dummy;
        while (right != null) {
            left = left.next;
            right = right.next;
        }

        left.next = left.next.next;
        return dummy.next;
    }

    //time - O(n), space - O(n)
    public ListNode removeNthFromEndRecursively(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        countRecursively(dummy, new AtomicInteger(n + 1));
        return dummy.next;
    }

    private void countRecursively(ListNode node, AtomicInteger count) {
        if (node == null) {
            count.decrementAndGet();
        } else {
            countRecursively(node.next, count);
            if (count.get() == 0) {
                node.next = node.next.next;
            }
            count.decrementAndGet();
        }
    }
}
