package medium_LL;

public class __merge_two_sorted_LL {
    
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1, null);
        ListNode t1 = list1, t2 = list2;
        ListNode tail = dummy;

        while (t1 != null && t2 != null) {
            if (t1.val <= t2.val) {
                tail.next = t1;
                tail = tail.next;
                t1 = t1.next;
            }
            else {
                tail.next = t2;
                tail = tail.next;
                t2 = t2.next;
            }
        }

        if (t1 == null) tail.next = t2;
        else if (t2 == null) tail.next = t1;

        return dummy.next;
    }
}
