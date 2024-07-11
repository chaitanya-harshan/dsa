package _2D;

public class insert_in_DLL {
    public static void main(String[] args) {
        Node head = arr_to_DLL.constructDLL(new int[]{1,2,3,4,5});
        // Node head = null;
        print_DLL.print(head);
        head = insertAtKth(head, 99, 1);
        print_DLL.print(head);
    }

    public static Node insertAtFront(Node head, int k) {
        if (head == null) return new Node(k);
        Node first = new Node(k, head, null);
        head.prev = first;
        return first;
    }

    public static Node insertBeforeEnd(Node head, int k) {
        if (head == null) return new Node(k);
        if (head.next == null) {
            return insertAtFront(head, k);
        }

        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        Node pre = tail.prev;
        Node temp = new Node(k, tail, pre);
        pre.next = temp;
        tail.prev = temp;
        return head;
    }

    public static Node insertAtKth(Node head, int val, int k) {
        if (head == null && k == 1) return new Node(val);
        else if (head == null) return null;

        if (k == 1) {
            Node newNode = new Node(val, head, null);
            head.prev = newNode;
            return newNode;
        }
        Node temp = head;
        int cnt = 1;
        while (temp.next != null) {
            cnt++;
            if (cnt == k) {
                Node newNode = new Node(val, temp.next, temp);
                temp.next.prev = newNode;
                temp.next = newNode;
            }
            temp = temp.next;
        }
        return head;
    }

    public static void insertBeforeNode(Node node, int val) {
        Node pre = node.prev;
        Node newNode = new Node(val,node, pre);
        pre.next = newNode;
        node.prev = newNode;
    }
}
