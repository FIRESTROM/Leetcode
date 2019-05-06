/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        int len = 0;
        ListNode ptr = root;
        while (ptr != null) {
            ptr = ptr.next;
            len++;
        }
        int avg = len / k, more = len % k;
        ListNode[] result = new ListNode[k];
        ptr = root;
        for (int i = 0; i < k; i++) {
            int num_node = 0;
            ListNode prev = ptr;
            if (i < more) {
                result[i] = ptr;
                while (num_node < avg + 1) {
                    prev = ptr;
                    ptr = ptr.next;
                    num_node++;
                }
                if (prev != null) {
                    prev.next = null;
                }
            } else {
                result[i] = ptr;
                while (num_node < avg) {
                    prev = ptr;
                    ptr = ptr.next;
                    num_node++;
                }
                if (prev != null) {
                    prev.next = null;
                }
            }
        }
        return result;
    }
}
