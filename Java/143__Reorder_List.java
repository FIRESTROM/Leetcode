/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode first = head, second = head;
        while (second.next != null && second.next.next != null) {
            first = first.next;
            second = second.next.next;
        }
        second = first.next;
        ListNode reversed = null, temp = null, rest = second;
        while (rest != null) {
            temp = rest.next;
            rest.next = reversed;
            reversed = rest;
            rest = temp;
        }
        first.next = reversed;
        while (head != first) {
            first.next = reversed.next;
            reversed.next = head.next;
            head.next = reversed;
            head = reversed.next;
            reversed = first.next;
        }


    }
}
