package _2D;

public class reverse_DLL {
    public static void main(String[] args) {
        Node head = arr_to_DLL.constructDLL(new int[]{1,2,3,4,5});
        print_DLL.print(head);
        head = reverseDLL(head);
        print_DLL.print(head);
    }

    public static Node reverseDLL(Node head) {
        if (head == null || head.next == null) return head;

        Node temp = head;
        Node previous = null;
        while (temp != null) {
            Node buffer = temp.next;
            temp.next = previous;
            temp.prev = buffer;

            previous = temp;
            temp = temp.prev;
        }
        return previous;
    }
}
