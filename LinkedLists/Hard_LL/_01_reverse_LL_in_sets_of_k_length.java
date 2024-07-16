/*
 * Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

You may not alter the values in the list's nodes, only nodes themselves may be changed.

Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]

Input: head = [1,2,3,4,5], k = 3
Output: [3,2,1,4,5]
 */
package Hard_LL;

public class _01_reverse_LL_in_sets_of_k_length {
    
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode nextNode = temp, preNode = null;

        while (temp != null) {
            ListNode k_node = KthNode(temp, k);
            if (k_node == null) {
                if (preNode != null) preNode.next = temp;
                return head;
            }
            nextNode = k_node.next;
            k_node.next = null;

            ListNode newHead = reverse(temp); // new head = kth node

            if (preNode == null) head = newHead;
            else preNode.next = newHead;

            preNode = temp;
            temp = nextNode;
        }
        return head;
    }

    private static ListNode reverse(ListNode head) {
        ListNode previous = null, temp = head;
        while (temp != null) {
            ListNode nextNode = temp.next;
            temp.next = previous;
            previous = temp;
            temp = nextNode;
        }
        return previous;
    }

    private static ListNode KthNode(ListNode head, int k) {
        int cnt = 0;
        ListNode temp = head;
        while (temp != null) {
            cnt++;
            if (cnt == k) return temp;
            temp = temp.next;
        }
        return null;
    }
}
