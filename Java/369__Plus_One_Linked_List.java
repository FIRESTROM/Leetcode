/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode plusOne(ListNode head) {
        if (head == null) {
            return null;
        }
        head = reverse(head);
        int incre = 1, old_val;
        ListNode ptr = head;
        while (ptr != null) {
            old_val = ptr.val;
            ptr.val = (old_val + incre) % 10;
            incre = (old_val + incre) / 10;
            ptr = ptr.next;
        }
        head = reverse(head);
        if (incre == 1) {
            ListNode result = new ListNode(1);
            result.next = head;
            return result;
        } else {
            return head;
        }
    }

    private ListNode reverse(ListNode head) {
        ListNode rest = head, temp = null, result = null;
        while (rest != null) {
            temp = rest.next;
            rest.next = result;
            result = rest;
            rest = temp;
        }
        return result;
    }
}
