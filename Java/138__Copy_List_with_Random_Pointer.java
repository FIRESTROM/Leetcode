/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {
    HashMap<Node, Node> node_map = new HashMap<>();
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        if (node_map.containsKey(head)) {
            return node_map.get(head);
        }
        Node result = new Node(head.val, null, null);
        node_map.put(head, result);
        result.next = this.copyRandomList(head.next);
        result.random = this.copyRandomList(head.random);
        
        return result;
    }
}
