/*
 * Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.
 */
package medium_LL;

public class __remove_nodes_with_value_k {

    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;

        ListNode dummy = new ListNode(-1, head);
        ListNode temp = dummy;
        while (temp.next != null) {
            if (temp.next.val == val) {
                temp.next = temp.next.next;
            }
            else temp = temp.next;
        }
        return dummy.next;
    }
    
    // not so nice code but same logic
    public ListNode removeElements1(ListNode head, int val) {
        if (head == null) return null;

        ListNode previous = null;
        ListNode temp = head;
        while (temp != null) {
            
            ListNode newNode = temp.next;
            if (temp.val == val && previous != null) {
                previous.next = temp.next;
                temp.next = null;
            }
            else if (temp.val == val && previous == null) {
                head = head.next;
                temp.next = null;
            }
            else previous = temp;
            temp = newNode;
        }
        return head;
    }
}
