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

// A more structure Solution
class Solution {
  public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        ListNode tempHead = head, trailer = null;
        int count = 0;
        while (head != null && count < k) {
            trailer = head;
            head = head.next;
            count++;
        }
        if (head == null && count < k) {
            return tempHead;
        }
        trailer.next = null;
        ListNode result = reverseList(tempHead);
        tempHead.next = reverseKGroup(head, k);

        return result;
    }


    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode second = head.next;
        head.next = null;
        ListNode rest = reverseList(second);
        second.next = head;
        return rest;
    }
}
