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
        ListNode result = new ListNode(0);
        ListNode temp = result;
        int val = 0;
        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int cur = val + x + y;
            val = cur / 10;
            temp.next = new ListNode(cur % 10);
            temp = temp.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (val == 1) {
            temp.next = new ListNode(1);
        }
        return result.next;
    }
}



// Another really smart solution.
class Solution {
    public int trap(int[] height) {
        int[] water = new int[height.length];

        int max_height = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > max_height)
                max_height = height[i];
            water[i] = max_height - height[i];
        }

        max_height = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            if (height[i] > max_height)
                max_height = height[i];
            water[i] = Math.min(water[i], max_height - height[i]);
        }

        int result = 0;
        for (int i = 0; i < water.length; i++)
            result += water[i];
        return result;
    }
}
