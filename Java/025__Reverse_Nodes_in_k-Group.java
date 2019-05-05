/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode rest = head;
        ListNode result = new ListNode(0);
        ListNode temp = null;
        ListNode prev_end = result;
        while (rest != null) {
            ListNode temp_result = null;
            ListNode cur_end = rest;
            int index = 0;
            temp = rest;
            while (temp != null) {
                temp = temp.next;
                index++;
            }
            if (index < k) {
                prev_end.next = rest;
                break;
            }
            index = 0;
            while (rest != null && index < k) {
                temp = temp_result;
                temp_result = rest;
                rest = rest.next;
                temp_result.next = temp;
                index++;
            }
            prev_end.next = temp_result;
            prev_end = cur_end;
        }

        return result.next;

    }
}
