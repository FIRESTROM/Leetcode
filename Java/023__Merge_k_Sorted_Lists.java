/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode> ((n1, n2) -> n1.val - n2.val);
        if (lists == null || lists.length == 0) {
            return null;
        }
        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }
        ListNode result = new ListNode(-1);
        ListNode temp = result;
        while (!queue.isEmpty()) {
            ListNode cur = queue.poll();
            temp.next = cur;
            cur = cur.next;
            if (cur != null) {
                queue.add(cur);
            }
            temp = temp.next;
        }
        return result.next;
    }
}

// Another solution
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return helper(lists, 0, lists.length - 1);
    }

    private ListNode helper(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }
        int mid = start + (end - start) / 2;
        ListNode l = helper(lists, start, mid);
        ListNode r = helper(lists, mid + 1, end);
        return merge(l, r);
    }

    private ListNode merge(ListNode l, ListNode r) {
        ListNode dummy = new ListNode(0), head = dummy;
        while (l != null && r != null) {
            if (l.val <= r.val) {
                head.next = l;
                l = l.next;
            } else {
                head.next = r;
                r = r.next;
            }
            head = head.next;
        }
        if (l != null) {
            head.next = l;
        } else {
            head.next = r;
        }
        return dummy.next;
    }
}
