package medium_LL;

public class __remove_only_duplicates_from_sorted_LL {
    
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        ListNode temp = head;
        while (temp.next != null) {
            if (temp.val == temp.next.val) {
                temp.next = temp.next.next;
            }
            else temp = temp.next;
        }
        return head;
    }
}
