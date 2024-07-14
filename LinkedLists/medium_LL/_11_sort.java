package medium_LL;
import _1D.*;

/*
 * time complexity:   log N (N + N/2) ≈ N Log N
 */
public class _11_sort {
    public static void main(String[] args) {
        int[] arr = {3,7,2,9,4,6,1,5,8,10};
        Node head = arr_to_LL.constructLL(arr);
        print_LL.print(head);
        head = mergeSortList(head);
        print_LL.print(head);
    }

    public static Node mergeSortList(Node head) {
        if (head.next == null) return head;

        // spliting in middle
        Node slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node secondHead = slow.next;
        slow.next = null;

        // sorting 2 halves
        Node left = mergeSortList(head);
        Node right = mergeSortList(secondHead);
        head = mergeTwoLists(left, right);

        return head;
    }

    private static Node mergeTwoLists(Node list1, Node list2) {
        Node dummy = new Node(-1, null);
        Node t1 = list1, t2 = list2;
        Node tail = dummy;

        while (t1 != null && t2 != null) {
            if (t1.data <= t2.data) {
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
