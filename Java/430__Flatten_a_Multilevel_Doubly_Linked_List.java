/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};
*/
class Solution {
    public Node flatten(Node head) {
        Stack<Node> stack = new Stack<>();
        Node cur = head;
        while (cur != null) {
            if (cur.child != null) {
                stack.add(cur.next);
                cur.next = cur.child;
                cur.child = null;
            }
            Node next = (cur.next == null && !stack.isEmpty()) ? stack.pop() : cur.next;
            if (next != null) {
                next.prev = cur;
                cur.next = next;
            }
            cur = cur.next;
        }
        return head;
    }
}
