/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        ArrayList<Integer> result = new ArrayList<>();
        ListNode ptr = head, cur = head;
        while (cur != null) {
            ptr = cur.next;
            while (ptr != null) {
                if (cur.val < ptr.val) {
                    result.add(ptr.val);
                    break;
                }
                ptr = ptr.next;
                if (ptr == null) {
                    result.add(0);
                }
            }
            cur = cur.next;
        }
        result.add(0);
        int[] result_array = new int[result.size()];
        int i = 0;
        for (int val : result) {
            result_array[i] = val;
            i++;
        }
        return result_array;
    }
}
