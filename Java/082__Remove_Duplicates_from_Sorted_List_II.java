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
        ListNode cur = head, ptr = head.next;
        ListNode prev = new ListNode(-1);
        prev.next = head;
        while (cur != null) {
            if (cur.next != null && cur.val == cur.next.val) {
                while (ptr != null && ptr.val == cur.val) {
                    ptr = ptr.next;
                }
                if (cur == head) {
                    head = ptr;
                }
                prev.next = ptr;
                cur = ptr;
            } else {
                prev = cur;
                cur = cur.next;
                ptr = cur;
            }
        }
        return head;
    }
}
