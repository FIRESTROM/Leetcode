/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> result = new LinkedList();
        Stack<TreeNode> stack = new Stack();
        do {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                if (result.size() < k)
                    result.add(root.val);
                else {
                    if (Math.abs(result.get(0) - target) >= Math.abs(root.val - target)) {
                        result.remove(0);
                        result.add(root.val);
                    } else
                        return result;
                }
                root = root.right;
            }
        } while (!stack.isEmpty() || root != null);

        return result;
    }
}
