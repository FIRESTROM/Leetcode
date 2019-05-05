/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode result = null;
        if (head == null) {
            return result;
        } else if (head.next == null) {
            return head;
        }
        ListNode first = head, second = head.next, prev = new ListNode(-1);

        while (first != null && second != null) {
            first.next = second.next;
            second.next = first;
            prev.next = second;
            if (result == null) {
                result = second;
            }
            prev = first;
            first = first.next;
            if (first == null) {
                break;
            }
            second = first.next;
        }
        return result;
    }
}
