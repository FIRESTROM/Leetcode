/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {

    		ListNode less = new ListNode(-1);
    		ListNode more = new ListNode(-1);
    		ListNode less_ptr = less;
    		ListNode more_ptr = more;
    		ListNode cur = head;

    		while (cur != null) {
      			if (cur.val < x) {
        				less.next = cur;
        				less = less.next;
      			} else {
        				more.next = cur;
        				more = more.next;
      			}
      			cur = cur.next;
    		}
    		more.next = null;
    		less.next = more_ptr.next;
    		return less_ptr.next;
	  }
}
