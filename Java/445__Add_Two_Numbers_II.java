/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node1 = reverse(l1), node2 = reverse(l2);
        int incre = 0, old_v1;
        ListNode result = new ListNode(-1), ptr = result;

        while (node1 != null && node2 != null) {
            ptr.next = new ListNode((node1.val + node2.val + incre) % 10);
            incre = (node1.val + node2.val + incre) / 10;
            node1 = node1.next;
            node2 = node2.next;
            ptr = ptr.next;
        }
        if (node1 == null) {
            while (node2 != null) {
                ptr.next = new ListNode((node2.val + incre) % 10);
                incre = (node2.val + incre) / 10;
                node2 = node2.next;
                ptr = ptr.next;
            }
        } else {
            while (node1 != null) {
                ptr.next = new ListNode((node1.val + incre) % 10);
                incre = (node1.val + incre) / 10;
                node1 = node1.next;
                ptr = ptr.next;
            }
        }
        if (incre == 1) {
            ptr.next = new ListNode(1);
        }
        return reverse(result.next);
    }

    private ListNode reverse(ListNode node) {
        ListNode rest = node, temp = null, result = null;
        while (rest != null) {
            temp = rest.next;
            rest.next = result;
            result = rest;
            rest = temp;
        }
        return result;
    }

}
