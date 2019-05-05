/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode ptr1 = headA, ptr2 = headB;
        while (ptr1 != null && ptr2 != null) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        if (ptr1 == null) {
            ptr1 = headB;
            while (ptr2 != null) {
                ptr1 = ptr1.next;
                ptr2 = ptr2.next;
            }
            ptr2 = headA;
            while (ptr1 != null && !ptr1.equals(ptr2)) {
                ptr1 = ptr1.next;
                ptr2 = ptr2.next;
            }
            return ptr1;
        } else {
            ptr2 = headA;
            while (ptr1 != null) {
                ptr1 = ptr1.next;
                ptr2 = ptr2.next;
            }
            ptr1 = headB;
            while (ptr1 != null && !ptr1.equals(ptr2)) {
                ptr1 = ptr1.next;
                ptr2 = ptr2.next;
            }
            return ptr1;
        }

    }
}
