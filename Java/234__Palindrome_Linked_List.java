/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode mid = getMid(head);
        ListNode secondHalf = reverse(mid.next);

        return isEqual(head, secondHalf);
    }

    public ListNode getMid(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverse(ListNode rest) {

        ListNode newHead = null;
        while (rest != null){
            ListNode temp = rest.next;
            rest.next = newHead;
            newHead = rest;
            rest = temp;
        }
        return newHead;
    }

    public boolean isEqual(ListNode node1, ListNode node2) {
        while (node1 != null && node2 !=null){
            if (node1.val != node2.val){
                return false;
            }
            node1 = node1.next;
            node2 = node2.next;
        }
        return true;
    }
}
