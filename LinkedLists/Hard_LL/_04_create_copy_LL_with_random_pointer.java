/*
 * Given a linked list where every node in the linked list contains two pointers:

‘next’ which points to the next node in the list.
‘random’ which points to a random node in the list or ‘null’.
Create a ‘deep copy’ of the given linked list and return it.

For example, if there are two nodes X and Y in the original list, where X.random --> Y, 
then for the corresponding two nodes x and y in the copied list, x.random --> y.
 */
package Hard_LL;

public class _04_create_copy_LL_with_random_pointer {

    static class Node {
        int val;
        Node next;
        Node random;
    
        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    
    public static Node copyRandomList(Node head) {
        if (head == null) return head;

        // creating new nodes and placing them in between 
        Node temp = head;
        while (temp != null) {
            Node newNode = new Node(temp.val);
            newNode.next = temp.next;
            temp.next = newNode;

            temp = temp.next.next;
        }

        // attaching ranodom pointers
        temp = head;
        while (temp != null) {
            temp.next.random = (temp.random != null) ? temp.random.next : null;
            temp = temp.next.next;
        }

        // seperating the copy nodes and linking them togeher and relinking the original LL
        Node dummy = new Node(-1);
        temp = head;
        Node t2 = dummy;
        
        while (temp != null) {
            // linking the nodesw of the duplicate LL
            t2.next = temp.next;
            t2 = t2.next;

            // relinking the original LL
            temp.next = temp.next.next;
            temp = temp.next;
        }

        return dummy.next;
    }
}
