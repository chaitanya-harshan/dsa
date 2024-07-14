/*
 * Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. 
 * If the two linked lists have no intersection at all, return null.
 * 
 * 
 * https://youtu.be/0DYoPz2Tpt4?si=UYE6E1g9qBjWhSGC&t=983 (time stamp included)
 * 
 * 
 * two lists pointing to the same LL means the first node is the colliding node
 */

package medium_LL;

public class _13_coincing_Lists_node {
    
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode t1 = headA, t2 = headB;
        while (t1 != t2) {
            t1 = (t1 != null) ? t1.next : headB;
            t2 = (t2 != null) ? t2.next : headA;

            if (t1 == t2) return t1; 
        }
        return t1; // this is for - if both are null (diff LL but same length) or both pointing to the same LL 
        // node 1 will the colloding point
    }
}
