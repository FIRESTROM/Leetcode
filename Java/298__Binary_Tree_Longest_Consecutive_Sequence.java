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
    public int longestConsecutive(TreeNode root) {
        return helper(root, null, 0);
    }

    private int helper(TreeNode node, TreeNode parent, int length) {
        if (node == null) return length;
        length = (parent != null && parent.val + 1 == node.val) ? length + 1 : 1;
        return Math.max(length, Math.max(helper(node.left, node, length), helper(node.right, node, length)));
    }
}
