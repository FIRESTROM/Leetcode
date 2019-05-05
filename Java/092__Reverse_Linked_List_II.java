/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {

        if (head == null) {
            return null;
        }
        ListNode rest = head, prev = null;
        while (m > 1) {
            prev = rest;
            rest = rest.next;
            m--;
            n--;
        }

        ListNode unchanged_end = prev, changed_end = rest;

        // Iteratively reverse the nodes until n becomes 0.
        ListNode temp = null;
        while (n > 0) {
            temp = rest.next;
            rest.next = prev;
            prev = rest;
            rest = temp;
            n--;
        }

        if (unchanged_end != null) {
            unchanged_end.next = prev;
        } else {
            head = prev;
        }

        changed_end.next = rest;
        return head;
    }
}
