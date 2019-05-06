/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int numComponents(ListNode head, int[] G) {
        HashSet<Integer> set = new HashSet<>();
        for (int val : G) {
            set.add(val);
        }
        int result = 0;
        boolean prev = false;
        while (head != null) {
            if (set.contains(head.val)) {
                if (prev == false) {
                    prev = true;
                    result++;
                }
            } else {
                prev = false;
            }
            head = head.next;
        }
        return result;
    }
}
