package blind75.linkedlist;

import java.util.List;

public class MergeTwoSortedLinkedLists {
    public static void main(String[] args) {
        ListNode head = new MergeTwoSortedLinkedLists().mergeTwoListsRecursively(Helper.build(List.of(0, 3, 5)),
                Helper.build(List.of(1, 2)));
        Helper.traverse(head);
    }

    //time - O(n + m), space - O(1)
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode node = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                node.next = list1;
                list1 = list1.next;
            } else {
                node.next = list2;
                list2 = list2.next;
            }
            node = node.next;
        }

        if (list1 != null) {
            node.next = list1;
        } else {
            node.next = list2;
        }
        return dummy.next;
    }

    public ListNode mergeTwoListsRecursively(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        mergeRecursively(dummy, list1, list2);
        return dummy.next;
    }

    //time - O(n + m), space - O(n + m)
    private void mergeRecursively(ListNode dummy, ListNode list1, ListNode list2) {
        if (list1 == null) {
            dummy.next = list2;
        } else if (list2 == null) {
            dummy.next = list1;
        } else {
            if (list1.val < list2.val) {
                dummy.next = list1;
                list1 = list1.next;
            } else {
                dummy.next = list2;
                list2 = list2.next;
            }
            mergeRecursively(dummy.next, list1, list2);
        }
    }
}
