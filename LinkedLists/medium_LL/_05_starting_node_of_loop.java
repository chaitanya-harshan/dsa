// https://www.youtube.com/watch?v=2Kd0KKmmHFc

/*
 * Given the head of a linked list, return the node where the cycle begins. 
 * If there is no cycle, return null.
 */


package medium_LL;

public class _05_starting_node_of_loop {
    
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}
