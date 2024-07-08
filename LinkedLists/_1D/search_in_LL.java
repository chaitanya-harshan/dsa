package _1D;

public class search_in_LL {

    public static int searchInLinkedList(Node head, int k) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == k) {
                return 1;
            }
            temp = temp.next;
        }
        return 0;
    }
}
