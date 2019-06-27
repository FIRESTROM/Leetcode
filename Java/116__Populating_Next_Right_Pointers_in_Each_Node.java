/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    public Node connect(Node root) {
        if (root == null) return root;
        Queue<Node> visited = new LinkedList<>();
        visited.add(root);
        int levelNodesCount = visited.size();
        while (!visited.isEmpty()) {
            Node node = visited.poll();
            if (levelNodesCount > 1) node.next = visited.peek();
            if (node.left != null) visited.add(node.left);
            if (node.right != null) visited.add(node.right);
            levelNodesCount--;
            if (levelNodesCount == 0)levelNodesCount = visited.size();
        }
        return root;
    }
}
