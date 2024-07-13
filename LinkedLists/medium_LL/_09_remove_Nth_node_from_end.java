/*
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 */
package medium_LL;

public class _09_remove_Nth_node_from_end {
    
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        for (int i=1; i<n; i++) {
            fast = fast.next;
        }
        if (fast.next == null) return head.next;
        
        ListNode previous = null;
        while (fast.next != null) {
            previous = slow;
            slow = slow.next;
            fast = fast.next;
        }
        previous.next = slow.next;
        slow.next = null;
        return head;
    }
}
