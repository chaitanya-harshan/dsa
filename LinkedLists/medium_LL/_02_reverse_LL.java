package medium_LL;

public class _02_reverse_LL {
    public static ListNode reverseList(ListNode head) {
        ListNode temp = head, previous = null;
        while (temp != null) {
            ListNode nextNode = temp.next;
            temp.next = previous;
            previous = temp;
            temp = nextNode;
        }
        return previous;
    }

    /**
     * _03 _reverse LL using recursion
    */

    // recursion
    public static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode newHead = reverseList2(head.next);
        ListNode front = head.next;
        front.next = head;
        head.next = null;

        return newHead;
    }
}
