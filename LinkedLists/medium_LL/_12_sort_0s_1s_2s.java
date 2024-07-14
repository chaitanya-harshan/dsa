package medium_LL;

import Node;

public class _12_sort_0s_1s_2s {
    
    public static Node sortList(Node head) {
        if (head == null || head.next == null) return head;
        
        Node h0 = new Node(-1), h1 = new Node(-1), h2 = new Node(-1);
        Node t0 = h0, t1 = h1, t2 = h2;
        Node temp = head;
        
        while (temp != null) {
            if (temp.data == 0) {
                t0.next = temp;
                t0 = t0.next;
                temp = temp.next;
            }
            else if (temp.data == 1) {
                t1.next = temp;
                t1 = t1.next;
                temp = temp.next;
            }
            else {
                t2.next = temp;
                t2 = t2.next;
                temp = temp.next;
            }
        }
        h0 = h0.next;
        h1 = h1.next;
        h2 = h2.next;
        // if (h2 != null) t2.next = null; 
        t2.next = null;

        if (h1 == null) h1 = h2;
        else t1.next = h2;

        if (h0 == null) h0 = h1;
        else t0.next = h1;
        
        return h0;
    }
}
