/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head, next = head.next;
        while (next != null) {
            if (cur.val == next.val) {
                next = next.next;
            } else {
                cur.next = next;
                cur = next;
                next = next.next;
            }
        }
        cur.next = null;
        return head;
    }
}
