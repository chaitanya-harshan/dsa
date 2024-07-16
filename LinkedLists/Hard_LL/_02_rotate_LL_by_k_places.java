/*
 * Given the head of a linked list, rotate the list to the right by k places.
 */
package Hard_LL;

public class _02_rotate_LL_by_k_places {
    
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        
        int length = 1;
        ListNode temp = head;
        // fiding length 
        while (temp.next != null) {
            length++;
            temp = temp.next;
        }
        temp.next = head; // Looping the LL so that all we need to find is the new tail <break point> based on k & length

        int n = length - (k % length); // finding the breakpoint/new_Tail index

        int cnt = 1;
        temp = head;
        while (cnt != n) {
            cnt++;
            temp = temp.next;
        }
        head = temp.next;
        temp.next = null;
        
        return head;
    }
}
