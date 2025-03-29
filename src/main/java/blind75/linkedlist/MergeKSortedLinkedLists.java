package blind75.linkedlist;

import java.util.List;

public class MergeKSortedLinkedLists {
    public static void main(String[] args) {
        ListNode result = new MergeKSortedLinkedLists().mergeKListsIteratively(new ListNode[] {
                Helper.build(List.of(1, 2, 4)),
                Helper.build(List.of(1, 3, 5)),
                Helper.build(List.of(3, 6))
        });
        Helper.traverse(result);
    }

    //iterative
    //time - O(k * n) - k = num of lists, n = num of all nodes, space = O(1)
    public ListNode mergeKListsIteratively(ListNode[] lists) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        boolean notAllAreNull = true;
        while (notAllAreNull) {
            notAllAreNull = false;
            ListNode minValNode = new ListNode(Integer.MAX_VALUE);
            int minValNodeIndex = 0;
            for (int index = 0; index < lists.length; index++) {
                ListNode node = lists[index];
                if (node != null) {
                    notAllAreNull = true;
                    if (node.val <= minValNode.val) {
                        minValNode = node;
                        minValNodeIndex = index;
                    }
                }
            }
            if (notAllAreNull) {
                lists[minValNodeIndex] = lists[minValNodeIndex].next;
                tail.next = minValNode;
                tail = tail.next;
            }
        }

        return dummy.next;
    }

    //time - O(k * n), space = O(1)
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        int length = lists.length;
        for (int i = 1; i < length; i++) {
            lists[i] = mergeTwoLists(lists[i], lists[i - 1]);
        }
        return lists[length - 1];
    }

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
}
