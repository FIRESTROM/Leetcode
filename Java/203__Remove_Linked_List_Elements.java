/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode cur = head, prev = new ListNode(-1), result = null;
        prev.next = head;
        if (head == null || (head.val == val && head.next == null)) {
            return null;
        }
        while (cur != null) {
            if (cur.val == val) {
                prev.next = cur.next;
                cur = cur.next;
            } else {
                if (result == null) {
                    result = cur;
                }
                prev = cur;
                cur = cur.next;
            }
        }
        return result;
    }
}
