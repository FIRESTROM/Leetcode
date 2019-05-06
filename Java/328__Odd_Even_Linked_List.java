/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode first = head, second = head.next, begin = head.next;
        while (second != null && second.next != null) {
            first.next = second.next;
            second.next = second.next.next;
            first.next.next = begin;
            first = first.next;
            second = second.next;
        }
        return head;
    }
}
