package medium_LL;

public class __remove_duplicates_from_sorted_LL {
    
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        ListNode dummy = new ListNode(-1,null);
        dummy.next = head;
        head = dummy;

        while (dummy.next != null) {
            ListNode newNext = dummy.next;
            while (newNext.next != null && newNext.val == newNext.next.val) {
                newNext = newNext.next;
            }

            if (dummy.next == newNext) dummy = dummy.next; // no inner loop
            else dummy.next = newNext.next; // for only when it pases throught the inner loop
        }
        return head.next;
    }
}
