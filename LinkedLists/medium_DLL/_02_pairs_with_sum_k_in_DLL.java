/*
 * You are given a sorted doubly linked list of size 'n', consisting of distinct positive integers, and a number 'k'.
 * 
Find out all the pairs in the doubly linked list with sum equal to 'k'.

Example :
Input: Linked List: 1 <-> 2 <-> 3 <-> 4 <-> 9 and 'k' = 5

Output: (1, 4) and (2, 3)

Explanation: There are 2 pairs in the linked list having sum 'k' = 5.
 */
package medium_DLL;
import _2D.*;
import java.util.ArrayList;
import java.util.Arrays;

public class _02_pairs_with_sum_k_in_DLL {
    public static void main(String[] args) {
        int[] arr = {1,4,5,6,10,11,12,13,14,15,19,20,21,22,25,26,27,31};
        Node head = arr_to_DLL.constructDLL(arr);
        System.out.println(findPairsWithGivenSum(31, head));
    }

    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node head) {
        ArrayList<ArrayList<Integer>> table = new ArrayList<>();
        if (head == null) return table;

        Node left = head, right = findTail(head);

        // while (left != right && left.prev != right) { // without using the sorted nature

        while (left.data < right.data ) { // using the sorted nature
            int sum = left.data + right.data;
            
            if (target == sum) {
                // ArrayList<Integer> pair = new ArrayList<>();
                // pair.add(left.data);
                // pair.add(right.data);
                ArrayList<Integer> pair = new ArrayList<>(Arrays.asList(left.data, right.data));
                table.add(pair);
                left = left.next;
                right = right.prev;
            }
            else if (sum > target) {
                right = right.prev;
            }
            else left = left.next;
        }
        return table;
    }
    
    private static Node findTail(Node head) {
        if (head == null) return null;
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        return temp;
    }
}
