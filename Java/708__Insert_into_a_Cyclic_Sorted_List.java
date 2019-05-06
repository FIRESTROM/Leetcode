/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val,Node _next) {
        val = _val;
        next = _next;
    }
};
*/
class Solution {
    public Node insert(Node head, int insertVal) {
        if (head == null) {
            Node node = new Node(insertVal);
            node.next = node;
            return node;
        }

        Node cur = head;
        while (true) {
            if ((cur.val <= insertVal && insertVal <= cur.next.val) || (cur.next == head) ||
                    (cur.next.val < cur.val && (cur.val < insertVal || insertVal < cur.next.val))) {
                Node next = cur.next;
                cur.next = new Node(insertVal);
                cur.next.next = next;
                return head;
            }
            cur = cur.next;
        }
    }
}
