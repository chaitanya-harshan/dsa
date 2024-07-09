package _2D;

public class arr_to_DLL {
    public static void main(String[] args) {
        int[] arr = {87,23,2,98,74};
        System.out.println(constructDLL(arr).data + ", " + constructDLL(arr).next);
    }

    public static Node constructDLL(int []arr) {
        Node head = new Node(arr[0]);
        Node prev = head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i], null, prev);
            prev.next = temp;
            prev = temp;
        }
        return head;
    }
}
