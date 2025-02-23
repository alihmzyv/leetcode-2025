package medium;

public class OddEvenLinkedList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode oddEvenList(ListNode head) {
        int count = 1;
        ListNode headTemp = head;
        ListNode oddTail = null;
        ListNode evenHead = null;
        ListNode evenTail = null;
        while (head != null) {
            if (count % 2 == 0) {
                if (evenHead == null) {
                    evenHead = head;
                    evenTail = head;
                } else {
                    evenTail.next = head;
                    evenTail = evenTail.next;
                }
            } else {
                if (oddTail == null) {
                    oddTail = head;
                } else {
                    oddTail.next = head;
                    oddTail = oddTail.next;
                }
            }
            count++;
            head = head.next;
        }
        if (oddTail != null) {
            oddTail.next = evenHead;
        }
        if (evenTail != null) {
            evenTail.next = null;
        }
        return headTemp;
    }
}
