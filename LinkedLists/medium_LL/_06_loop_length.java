/*
    * You’re given a linked list. The last node might point to null, or it might point to a node in the list,
 thus forming a cycle.
    * Find out whether the linked list has a cycle or not, and the length of the cycle if it does.
    * If there is no cycle, return 0, otherwise return the length of the cycle.
 */

package medium_LL;

public class _06_loop_length {
    
    public static int lengthOfLoop(ListNode head) {
        if (head == null) return 0;
        
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return length(slow);
            }
        }
        return 0;
    }

    private static int length(ListNode head) {
        ListNode temp = head.next;
        int count = 1;
        while (temp != head) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}
