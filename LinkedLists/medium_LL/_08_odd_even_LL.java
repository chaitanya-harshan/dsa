/*
 * Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.

The first node is considered odd, and the second node is even, and so on.

Note that the relative order inside both the even and odd groups should remain as it was in the input.

You must solve the problem in O(1) extra space complexity and O(n) time complexity.
 */

package medium_LL;

public class _08_odd_even_LL {
    
    public ListNode oddEvenList(ListNode head) {

        ListNode temp = head;
        ListNode evenHead = new ListNode(-1, null), oddHead = new ListNode(-1,null);
        ListNode eventail = evenHead, oddtail = oddHead;
        int cnt = 1;

        while (temp != null) {

            if (cnt % 2 == 0) {
                eventail.next = temp;
                eventail = temp;
            }
            else {
                oddtail.next = temp;
                oddtail = temp;
            }
            temp = temp.next;
            cnt++;
        }
        oddtail.next = evenHead.next;
        eventail.next = null;

        return oddHead.next;
    }
}
