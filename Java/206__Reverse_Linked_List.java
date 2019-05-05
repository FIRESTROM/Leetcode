/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode rest = head;
        ListNode result = null;
        ListNode temp = null;
        while (rest != null) {
            temp = result;
            result = rest;
            rest = rest.next;
            result.next = temp;
        }
        return result;
    }
}
