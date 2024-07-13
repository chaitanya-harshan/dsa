/*
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 */
package medium_LL;

import java.util.HashSet;

public class _04_loop_in_LL {

    // Better approach - tortoise & rabbit\hare
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }



    
    // this method takes more space 
    public boolean hasCycle1(ListNode head) {
        HashSet<ListNode> map = new HashSet<>();
        ListNode temp = head;
        while (temp != null) {
            if (map.contains(temp)) return true;
            else map.add(temp);
            temp = temp.next;
        }
        return false;
    }
}
