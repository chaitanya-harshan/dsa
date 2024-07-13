/*
 * Given the head of a linked list of integers, delete the middle node of the linked list and return the modified head. However, 
 * if the linked list has an even number of nodes, delete the second middle node.
 * 
    Input: head = [1,3,4,7,1,2,6]
    Output: [1,3,4,1,2,6]

    Input: head = [1,2,3,4]
    Output: [1,2,4]
 */
package medium_LL;

public class _10_remove_middle_node {
    
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode slow = head, fast = head.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}


// when we increase the starting point of 'fast' then effectively the lenght of the LL reduced by 1
/*
 * this way odd length which used to have a perfect fit for 'fast' before - 12 34 5
 * now have one less element so therfore the count of jumps to comepletely traverse the list reduces by 1
 *  so this makes the 'slow' index one less.
 * 
 * IN the even length LL since it's alraedy not using 1 element (the last element) - 12 34 5(6)
 * now since one elment (last) is useless regardless, eventhough it is reduced it doesn't matter 
 * and it still gives the same index for slow.
 */