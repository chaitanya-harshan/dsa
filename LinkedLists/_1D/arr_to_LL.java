package _1D;

public class arr_to_LL {

    public static void main(String[] args) {
        int[] arr = {87,23,2,98,74};
        System.out.println(constructLL(arr).data + ", " + constructLL(arr).next);
    }

    public static Node constructLL(int[] arr) {
        // Write your code here
        Node head = new Node(arr[0]);
        Node last = head;

        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            last.next = temp;
            last = temp;
        }
        return head;
    }
}
