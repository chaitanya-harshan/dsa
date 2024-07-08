package _1D;

// class Node{
//     int data;
//     Node next;
//     Node(int x){
//         data = x;
//         next = null;
//     }
// }


public class insert_in_LL {
    public static void main(String[] args) {
        int[] arr = {1,3,5,2,6};
        Node head = arr_to_LL.constructLL(arr);
        print_LL.print(head);

        // insertAtEnd(head, 7);
        head = insertBeforeValue(head, 77, 3);
        print_LL.print(head);
    }

    // Insert at START
    public static Node insertAtStart(Node head, int x) {
        Node temp = new Node(x);
        if (head == null) return temp;
        temp.next = head;
        return temp;
    }

    // Insert at END
    public static Node insertAtEnd(Node head, int x) {
        if (head == null) return new Node(x);

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(x);
        return head;
    }

    // Insert at k
    public static Node insert(Node head, int x, int k) {
        if (head == null) {
            if (k == 1) {
                Node start = new Node(x);
                start.next = head;
                return start;
            }
            else return head;
        }
        if (k == 1) {
            Node start = new Node(x);
            start.next = head;
            return start;
        }
        
        Node temp = head;
        Node element = new Node(x);
        int cnt = 1;
        while (temp != null) {
            if (cnt == k-1) {
                element.next = temp.next;
                temp.next = element;
                return head;
            }
            cnt++;
            temp = temp.next;
        }
        return head;
    }

    // Insert before value
    public static Node insertBeforeValue(Node head, int x, int val) {
        if (head == null) return head;
        if (head.data == val) {
            Node start = new Node(x);
            start.next = head;
            return start;
        }
        
        Node temp = head;
        Node element = new Node(x);
        while (temp.next != null) {
            if (temp.next.data == val) {
                element.next = temp.next;
                temp.next = element;
                return head;
            }
            temp = temp.next;
        }
        return head;
    }
}
