/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        Node firstNode = null, prev = null;
        Stack<Node> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (firstNode == null) {
                firstNode = root;
            }
            if (prev != null) {
                prev.right = root;
                root.left = prev;
            }
            prev = root;
            root = root.right;
        }
        prev.right = firstNode;
        firstNode.left = prev;
        return firstNode;
    }
}
