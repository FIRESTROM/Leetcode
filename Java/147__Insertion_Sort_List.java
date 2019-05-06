/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode cur = head.next, prev = head, next;

        while (cur != null) {
            next = cur.next;
            if (cur.val >= prev.val) {
                prev = cur;
            } else if (cur.val < head.val) {
                cur.next = head;
                prev.next = next;
                head = cur;
            } else {
                ListNode ptr = head;
                while (cur.val > ptr.next.val) {
                    ptr = ptr.next;
                }
                cur.next = ptr.next;
                ptr.next = cur;
                prev.next = next;
            }
            cur = next;
        }
        return head;
    }
}
