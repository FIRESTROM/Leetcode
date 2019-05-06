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

// Another smarter Solution

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    private class Pair {
        int val;
        int idx;

        Pair (int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }

    public int[] nextLargerNodes(ListNode head) {
        Stack<Pair> stack = new Stack<>();
        ListNode cur = head;
        int index = 0;
        while (cur != null) {
            cur = cur.next;
            ++index;
        }
        cur = head;
        int[] result = new int[index];
        index = 0;
        while (cur != null) {
            while (!stack.isEmpty() && stack.peek().val < cur.val) {
                result[stack.pop().idx] = cur.val;
            }
            stack.push(new Pair(cur.val, index++));
            cur = cur.next;
        }
        return result;
    }
}
