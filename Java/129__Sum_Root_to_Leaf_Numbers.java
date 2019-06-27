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

    int sum = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        helper(root, 0);
        return sum;
    }

    private void helper(TreeNode root, int prevVal) {
        int cur = prevVal * 10 + root.val;
        if (root.left == null && root.right == null) {
            sum += cur;
            return;
        }
        if (root.left != null) helper(root.left, cur);
        if (root.right != null) helper(root.right, cur);
    }
}
