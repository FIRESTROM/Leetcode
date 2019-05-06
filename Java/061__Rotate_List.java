/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }
        k = k % length;

        tail = head;
        for (int i = 0; i < k; i++) {
            tail = tail.next != null ? tail.next : head;
        }
        // k == size of list, to be head finally.
        if (tail == head) {
            return head;
        }

        ListNode prev = head;
        while (tail.next != null) {
            tail = tail.next;
            prev = prev.next;
        }
        ListNode newHead = prev.next;
        prev.next = null;
        tail.next = head;
        return newHead;
    }
}
