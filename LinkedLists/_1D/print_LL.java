package _1D;

// class Node{
//     int data;
//     Node next;
//     Node(int x){
//         data = x;
//         next = null;
//     }
// }

public class print_LL {
    
    public static void print(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
