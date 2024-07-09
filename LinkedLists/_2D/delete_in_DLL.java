package _2D;

public class delete_in_DLL {
    public static void main(String[] args) {
        Node head = arr_to_DLL.constructDLL(new int[] {1,2,3,4,5});
        // head = removesHead(head);
        // head = removesTail(head);
        head = deleteNode(head, 4);
        print_DLL.print(head);
    }

    public static Node removesHead(Node head) {
        if (head == null || head.next == null) return null;
        Node temp = head;
        head = head.next;
        head.prev = null;
        
        temp.next = null; // for gabage collector
        return head;
    }
    
    public static Node removesTail(Node head) {
        if (head == null || head.next == null) return null;

        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        // last = temp.next
        temp.next.prev = null;
        temp.next = null;
        return head;
    }

    // Kth node
    public static Node deleteNode(Node head, int k) {
        if (head == null) return null;
        if (k == 1 && head.next == null) return null;
        if (k == 1 && head.next != null) {
            Node temp = head.next;
            head.next = null;
            temp.prev = null;
            return temp;
        }
        int cnt = 1;
        Node temp = head;
        while (temp.next != null) {
            cnt++;
            if (cnt == k) {
                Node element = temp.next;
                temp.next = temp.next.next;
                if (element.next != null) {
                    element.next.prev = element.prev;
                }
                element.next = null;
                element.prev = null;
                return head;
            }
            temp = temp.next;
        }
        return head;
    }

}

