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

    TreeNode result = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        result = null;
        helper(root, p, q);
        return result;
    }

    private boolean helper(TreeNode cur_node, TreeNode p, TreeNode q) {
        if (cur_node == null) return false;
        int left = helper(cur_node.left, p, q) ? 1 : 0;
        int right = helper(cur_node.right, p, q) ? 1 : 0;
        int mid = (cur_node == p || cur_node == q) ? 1 : 0;
        if (left + right + mid >= 2)
            result = cur_node;
        return left + right + mid > 0;
    }
}
