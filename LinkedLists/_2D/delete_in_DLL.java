package _2D;

public class delete_in_DLL {
    public static void main(String[] args) {
        Node head = arr_to_DLL.constructDLL(new int[] {1,2,3,4,5});
        // head = removesHead(head);
        // head = removesTail(head);
        head = deleteKthNode(head, 4);
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
    public static Node deleteKthNode(Node head, int k) {
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
        while (temp != null) {
            if (cnt == k) {
                Node pre = temp.prev;
                pre.next = temp.next;
                if (temp.next != null) {
                    temp.next.prev = temp.prev;
                }
                temp.next = null;
                temp.prev = null;
                return head;
            }
            cnt++;
            temp = temp.next;
        }
        return head;
    }

    // remove my value
    // public static Node removeNodeByValue(Node head, Node ) 
}

