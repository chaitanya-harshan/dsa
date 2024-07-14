package _1D;

public class Node{
    public int data;
    public Node next;

    public Node(int x){
        data = x;
        next = null;
    }

    public Node(int x, Node next){
        data = x;
        next = next;
    }
}


// class Node {

//     public int data;
//     public Node next;

//     Node() {
//         this.data = 0;
//         this.next = null;
//     }

//     Node(int data) {
//         this.data = data;
//         this.next = null;
//     }

//     Node(int data, Node next) {
//         this.data = data;
//         this.next = next;
//     }
// };