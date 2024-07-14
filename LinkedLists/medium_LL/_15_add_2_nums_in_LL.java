package medium_LL;
import _1D.*;

public class _15_add_2_nums_in_LL {
    public static void main(String[] args) {
        int[] arr1 = {2,4,3};
        int[] arr2 = {5,6,4};
        Node l1 = arr_to_LL.constructLL(arr1);
        Node l2 = arr_to_LL.constructLL(arr2);
        print_LL.print(l1);
        print_LL.print(l2);
        Node head = addTwoNumbers(l1, l2);
        print_LL.print(head);
    }

    public static Node addTwoNumbers(Node l1, Node l2) {
        Node sum = new Node(-1, null);
        Node head = sum;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int value = l1.data + l2.data + carry;
            if (value < 10) {
                carry = 0;
            }
            else {
                value = 0;
                carry = 1;
            }
            Node temp = new Node(value, null);
            sum.next = temp;

            l1 = l1.next;
            l2 = l2.next;
            sum = sum.next;
        }
        while (l1 != null) {
            int value = l1.data + carry;
            if (value < 10) {
                carry = 0;
            }
            else {
                value = 0;
                carry = 1;
            }
            Node temp = new Node(value, null);
            sum.next = temp;
            sum = sum.next;
        }
        while (l2 != null) {
            int value = l2.data + carry;
            if (value < 10) {
                carry = 0;
            }
            else {
                value = 0;
                carry = 1;
            }
            Node temp = new Node(value, null);
            sum.next = temp;
            sum = sum.next;
        }
        if ( carry == 1) {
            Node temp  = new Node(1, null);
            sum.next = temp;
        }
        return head.next;
    }
}
