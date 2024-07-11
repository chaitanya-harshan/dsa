package _1D;

public class delete_in_LL {
    public static void main(String[] args) {
        Node head = arr_to_LL.constructLL(new int[] {1,2,3,4,5});
        // print_LL.print(removesHead(head));
        head = removeByValue(head, 3);
        print_LL.print(head);

    }
    
    public static Node removesHead(Node head) {
        if (head == null) return head;
        Node temp = head;
        head = head.next;
        temp.next = null;
        return head;
    }

    public static Node removesTail(Node head) {
        if (head == null || head.next == null) return null;

        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }

    public static Node removeKthNode(Node head, int k) {
        if (head == null) return head;
        if (k == 1) return head.next;

        int count = 1;
        Node temp = head;
        while (temp != null) {
            count++;
            if (count == k) {
                temp.next = temp.next.next;
                return head;
            }
            temp = temp.next;
        }
        return head;
    }

    public static Node removeByValue(Node head, int val) {
        if (head == null) return head;
        if (head.data == val) return head.next;

        Node temp = head;
        while (temp.next != null) {
            if (temp.next.data == val) {
                temp.next = temp.next.next;
                return head;
            }
            temp = temp.next;
        }
        return head;
    }
}
