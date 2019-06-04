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

    int result;

    public int diameterOfBinaryTree(TreeNode root) {
        result = 1;
        helper(root);
        return result - 1;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;
        int depth_l = helper(root.left);
        int depth_r = helper(root.right);
        result = Math.max(result, depth_l + depth_r + 1);
        return 1 + Math.max(depth_l, depth_r);
    }
}
