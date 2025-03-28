package blind75.linkedlist;

import java.util.List;

public class Helper {
    public static ListNode build(List<Integer> vals) {
        ListNode node = new ListNode(vals.get(0), null);
        ListNode head = node;
        int size = vals.size();
        for (int i = 1; i < size; i++) {
            node.next = new ListNode(vals.get(i));
            node = node.next;
        }
        return head;
    }

    public static void traverse(ListNode node) {
        StringBuilder result = new StringBuilder();
        result.append("[");
        while (node != null) {
            result.append(node.val);
            if (node.next != null) {
                result.append(",");
            }
            node = node.next;
        }
        result.append("]\n");
        System.out.println(result);
    }
}
